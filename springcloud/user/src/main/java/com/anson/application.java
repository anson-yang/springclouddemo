package com.anson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/20 23:46
 */
@SpringBootApplication
@EnableEurekaClient
public class application
{
    public  static void main(String[] args)
    {
        SpringApplication.run(application.class);
    }

}
