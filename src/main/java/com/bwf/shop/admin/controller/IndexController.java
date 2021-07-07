package com.bwf.shop.admin.controller;

import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ={"/","/index"})
public class IndexController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping(value ={"/","/index"})
    public String index(Authentication auth, Model model){

        Admin admin = adminService.getAdminByName(auth.getName());

        model.addAttribute("admin",admin);
        return "index/index";
    }

    @RequestMapping("/home")
    public String home(){
        return "index/home";
    }
}
