package com.bwf.shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @RequestMapping("login")
    public String login(){
        return null;
    }


    @RequestMapping("logindo")
    public String logindo(String username ,String userpass){
        return null;
    }

}
