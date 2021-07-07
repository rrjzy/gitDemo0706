package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.mapper.AdminMapper;
import com.bwf.shop.admin.mapper.RoleMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService implements UserDetailsService {

    @Resource
    private AdminMapper adminMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //调用数据访问层 根据账户名称 查询 用户对象
        Admin admin = adminMapper.getAdminByName(s);

        //判断 查询到的用户对象
        if (admin == null) {
            throw  new UsernameNotFoundException("账户名称填写错误");
        }

        return admin;
    }
}
