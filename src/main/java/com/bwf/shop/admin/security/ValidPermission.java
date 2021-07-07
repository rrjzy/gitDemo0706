package com.bwf.shop.admin.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/*
*  权限认证类
*
*   AccessDecisionManager 决策器
* */
@Component
public class ValidPermission  implements AccessDecisionManager {

    //认证策略
    @Override
    public void decide(Authentication authentication, Object o,
                       Collection<ConfigAttribute> collection) throws AccessDeniedException,
            InsufficientAuthenticationException {
        System.out.println("*********开始权限认证**********");
        // 遍历 当前请求的url授权的所有角色
        for(ConfigAttribute attr: collection){
            // 判断 当前登录的用户对象 是否为空
            if(authentication ==null){
                System.out.println("权限认证失败");
                throw new AccessDeniedException("权限认证失败");

            }
            // 获取当前迭代到授权角色的角色名称
            String grantName = attr.getAttribute();
            //判断是否有默认授权（公共资源，判断用户是否已经登录 ）
            if("ROLE_LOGIN".equals(grantName)){
              //判断用户是否已经登录
                if (authentication instanceof AnonymousAuthenticationToken) {
                    System.out.println("********** 用户还未登录");
                    throw  new BadCredentialsException("请先登录");
                }else {
                    // 当前用户已经登录，可以访问
                    System.out.println("********* 公共资源 已经登录用户认证通过");
                    return;
                }
            }

            //获取当前用户的角色列表
            Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();

            //遍历角色列表
            for(GrantedAuthority role :roleList){
                System.out.println("**授权角色:"+ grantName +"===> 用户角色："+ role.getAuthority());
                //当前迭代到的用户角色 是否就是迭代到授权角色
                if (grantName.equals(role.getAuthority())){
                    System.out.println("****权限认证成功！！！");
                    return;
                }

            }


        }
        System.out.println("********权限认证结束********");

        //当前没有用户 认证失败
        System.out.println("*******权限认证失败！！！");
        throw  new AccessDeniedException("权限认证失败");

    }

    // 是否支持配置属性
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    // 是否是支持配置类
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
