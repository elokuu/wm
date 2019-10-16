package io.spring.alipay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePagePayResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AliPagePayService {
    AlipayTradePagePayResponse executePagePay(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException;
    String receiveSyncNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException;
}
