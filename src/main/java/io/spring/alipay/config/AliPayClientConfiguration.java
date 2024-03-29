package io.spring.alipay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import io.spring.alipay.bean.AlipayConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AliPayClientConfiguration {
    @Autowired
    private AlipayConfigInfo aliPayConfig;

    @Bean
    @ConditionalOnMissingBean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(aliPayConfig.getGateway(), aliPayConfig.getAppid(),
                aliPayConfig.getPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(),
                aliPayConfig.getPublicKey(), aliPayConfig.getSignType());
    }
}
