package com.jspmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "start")
public class TestController {

    @RequestMapping(value = "first",method = RequestMethod.GET)
    public String getString(){

        return "hi i am from Test Controller";
    }
}
