package com.anson.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer() {
        /*
         * 参数说明：
         * 第一个> 重试间隔为100毫秒
         * 第二个> 最大重试时间为1秒
         * 第三个> 最大重试次数为5次
         */
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}