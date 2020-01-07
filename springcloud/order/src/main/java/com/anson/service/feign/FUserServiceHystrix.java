package com.anson.service.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 熔断器类
 * @author: anson
 * @Date: 2020/1/7 11:24
 */
@Component
public class FUserServiceHystrix implements FUserService
{
    @RequestMapping("/user/hello")
    @Override
    public  String hello()
    {
        return "对不起，user服务不可达，请稍后再试！";
    }
}
