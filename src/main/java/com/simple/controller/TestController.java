package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create By S I M P L E On 2018/12/23 16:16:52
 */
@Controller
@RequestMapping(value = "/user/")
public class TestController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String a(){
        return "index";
    }
}
