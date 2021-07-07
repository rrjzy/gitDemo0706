package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.po.Role;

import java.util.List;

/*角色业务 接口*/
public interface IRoleService {

    /*获取所有角色列表*/
    List<Role> getAllRoleList();


    //根据角色搜索模型业务 查询满足条件的角色列表

    List<Role> getRoleList(RoleSearchBo bo);
}
