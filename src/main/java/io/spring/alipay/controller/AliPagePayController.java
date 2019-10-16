package io.spring.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePagePayResponse;
import io.spring.alipay.service.AliPagePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/pay/alipay/page-pay")
public class AliPagePayController {
    @Autowired
    private AliPagePayService aliPagePayService;

    @GetMapping
    public AlipayTradePagePayResponse aliPagePay(HttpServletRequest request, HttpServletResponse response)
            throws AlipayApiException, IOException {
        return aliPagePayService.executePagePay(request, response);
    }

    @PostMapping("/sync/notify")
    public String aliPagePaySyncNotify(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        return aliPagePayService.receiveSyncNotify(request, response);
    }
}
