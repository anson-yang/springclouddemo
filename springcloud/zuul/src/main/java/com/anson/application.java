package com.anson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2020/1/6 15:02
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class application
{
    public  static void main(String[] args)
    {
        SpringApplication.run(application.class);
    }
}
