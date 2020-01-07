package com.anson.service.feign;

import com.anson.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user",configuration = FeignConfig.class,fallback = FUserServiceHystrix.class)
//@FeignClient(name = "user")
public interface FUserService
{
    @RequestMapping("/user/hello")
    public  String hello();
}
