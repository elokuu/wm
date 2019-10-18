package io.spring.alipay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import io.spring.alipay.bean.AlipayConfigInfo;
import io.spring.mapper.GoodsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Service
public class AliPagePayServiceImpl implements AliPagePayService {
    private static final Logger logger = LoggerFactory.getLogger(AliPagePayServiceImpl.class);
    @Autowired
    private AlipayClient alipayClient;
    @Autowired
    private AlipayConfigInfo aliPayConfig;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public AlipayTradePagePayResponse executePagePay(HttpServletRequest servletRequest, HttpServletResponse response)
            throws AlipayApiException, IOException {
        //在数据库中创建订单
        Integer id_goods = Integer.parseInt(servletRequest.getParameter("id_goods"));
        Integer id_purchaser = Integer.parseInt(servletRequest.getParameter("id_purchaser"));
        Map<String,Object> map = new HashMap<>();
        map.put("id_goods",id_goods);
        map.put("id_purchaser",id_purchaser);
        map.put("time_create",new java.sql.Date(System.currentTimeMillis()));
        goodsMapper.createRecord(map);
        BigInteger out_trade_no = (BigInteger) map.get("id");

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+out_trade_no+"\"," +
                "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "\"total_amount\":"+servletRequest.getParameter("price")+"," +
                "\"subject\":\""+servletRequest.getParameter("name")+"\"," +
                "\"body\":\""+servletRequest.getParameter("describe")+"\"}");

        request.setReturnUrl("http://3fhhvg.natappfree.cc/order?id="+id_goods);
        request.setNotifyUrl("http://3fhhvg.natappfree.cc/api/pay/alipay/page-pay/sync/notify");
        // 正式调起 支付宝的电脑网站支付API请求
        AlipayTradePagePayResponse pagePayResponse = alipayClient.pageExecute(request);
        // 获取支付宝响应的Form表单
        String form = "";
        if (java.util.Objects.nonNull(pagePayResponse)) {
            form = pagePayResponse.getBody();
        }
        // 直接将完整的html表单输出至页面
        response.setContentType("text/html;charset=" + aliPayConfig.getCharset());
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
        if (pagePayResponse.isSuccess()) { // StringUtils.isEmpty(subCode);
            logger.info("=========== 支付宝网站支付请求成功 =========== ");
        } else {
            logger.info("=========== 支付宝网站支付请求失败 =========== ");
        }
        return null;
    }

    @Override
    public String receiveSyncNotify(HttpServletRequest request, HttpServletResponse response)
            throws AlipayApiException, IOException {
        //将异步通知中收到的所有参数都存放到map中
        Map<String, String> paramsMap = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            paramsMap.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, aliPayConfig.getPublicKey(),
                aliPayConfig.getCharset(), aliPayConfig.getSignType());

        if (signVerified) {
            Integer out_trade_no = Integer.parseInt(request.getParameter("out_trade_no"));
            String trade_no = request.getParameter("trade_no");
            Map<String,Object> map = new HashMap<>();
            map.put("id",out_trade_no);
            map.put("trade_no",trade_no);
            goodsMapper.updateRecordPaymentStatus(map);
            System.out.println("success");
            return "success";
        } else {
            System.out.println("failure");
            return "failure";
        }
    }
}