package com.anson.controller;

import com.anson.service.feign.FUserService;
import com.anson.utils.ServiceUtil;
import com.anson.utils.StringHelper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/21 0:31
 */
@RestController
@RequestMapping("/order")
public class OrderController
{
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ServiceUtil serviceUtil;

    //@Autowired
    @Resource
    private FUserService fUserService;

    @RequestMapping("/order")
    public  String order()
    {
        String str = "11";
        String dates = StringHelper.getDate();
     //   str= restTemplate.getForObject("http://localhost:8763/user/hello",String.class);
        return  dates;
       // return  "hello world2";
    }

    @RequestMapping("/order2")
  // @HystrixCommand(fallbackMethod = "orderError")
    public  String order2()
    {
        return fUserService.hello();

    }

    public  String orderError()
    {

        return "对不起，服务不可达，请稍后再试！";

    }
}
