package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.RoleSearchBo;
import com.bwf.shop.admin.bean.po.Role;
import com.bwf.shop.admin.mapper.RoleMapper;
import com.bwf.shop.admin.service.IRoleService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoleList() {
        return roleMapper.getAllRoleList();
    }

    @Override
    public List<Role> getRoleList(RoleSearchBo bo) {
        return roleMapper.getRoleList(bo);
    }
}








