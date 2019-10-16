package io.spring.alipay.config;


import io.spring.alipay.bean.AlipayConfigInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AliPayConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "alipay.cfg")
    public AlipayConfigInfo alipayConfigInfo() {
        return new AlipayConfigInfo();
    }
}
