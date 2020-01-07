package com.anson;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2020/1/7 21:21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class application
{
    public  static void main(String[] args)
    {
        SpringApplication.run(application.class);
    }

}