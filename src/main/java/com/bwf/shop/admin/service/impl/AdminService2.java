package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import com.bwf.shop.admin.mapper.AdminMapper;
import com.bwf.shop.admin.service.IAdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService2 implements IAdminService {
    @Resource
    private AdminMapper adminMapper;


    @Override
    public Admin getAdminByName(String admin_name) {
        return  adminMapper.getAdminByName(admin_name);
    }

    @Override
    public List<Admin> getAdminList(AdminSearchBo bo) {
        return adminMapper.getAdminList(bo);
    }

    @Override
    public Boolean addAdmin(AdminAddBo bo) {
        Admin admin = adminMapper.getAdminByName(bo.getAdmin_name());

        //判断账户是否存在
        if(admin==null){
            //该账户名不存在，可以添加
            bo.setAdmin_pass(new BCryptPasswordEncoder().encode("12345"));
            //将员工模型对象添加到数据库中
            int a = adminMapper.addAdmin(bo);

            //给新增的员工配置角色
            int b = adminMapper.addAdminRole(bo.getAdmin_id(), bo.getRole_id());

            return  a>0 && b>0;
        }else {
            return false; // 账户已经存在不可以添加
        }


    }

    @Override
    public Admin getAdminById(Integer admin_id) {
        return adminMapper.getAdminById(admin_id);
    }

    @Override
    public Boolean updateAdmin(AdminUpdateBo bo) {
        //将用户填写的密码进行加密
      /*  if(bo.getAdmin_pass() !=null && bo.getAdmin_pass().isEmpty()){
                bo.setAdmin_pass(new BCryptPasswordEncoder().encode(bo.getAdmin_pass()));
        }*/

        //修改员工数据表
        int a = adminMapper.updateAdmin(bo);

        //删除该员工的所有角色
        int b = adminMapper.deleteAdminRoles(bo.getAdmin_id());

        //重写添加 该员工的角色
        int c = adminMapper.addAdminRole(bo.getAdmin_id(), bo.getRole_id());

        return a>0 && b>0 && c>0;
    }

    @Override
    public Boolean deleteOne(Integer admin_id) {
        return adminMapper.deleteOne(admin_id)>0;
    }

    @Override
    public Boolean deleteList(Integer[] ids) {
        return adminMapper.deleteList(ids)>0;
    }
}
