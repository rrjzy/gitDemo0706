package com.bwf.shop.admin.bean.po;


import org.springframework.security.core.GrantedAuthority;

//角色类
public class Role  implements GrantedAuthority {

    private Integer role_id;
    private String role_name;

    //得到授权的角色名称
    @Override
    public String getAuthority() {
        return getRole_name();
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }


}
