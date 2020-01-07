package com.anson.controller;

import com.anson.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/20 23:48
 */
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private ServiceUtil serviceUtil;

    @RequestMapping("/hello")
    public  String Hello()
    {
        return  ("hello world" +serviceUtil.getPort());
    }
}
