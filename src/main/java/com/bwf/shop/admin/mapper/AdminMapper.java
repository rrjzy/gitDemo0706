package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    //根据 登录的账户名称 获取员工名称
    public Admin getAdminByName(String admin_name);


    /**
     * 根据业务模型对象 查询 员工列表
     * @param bo  查询业务模型对象
     * @return  满足条件的员工列表
     * */
    List<Admin> getAdminList(@Param("bo") AdminSearchBo bo);


    /** 添加员工对象
     * @param bo  添加员工的模型对象
     * @return  数据库变化的行数
     * */
    int addAdmin(@Param("bo") AdminAddBo bo);

    /**
     *  给员工对象添加角色
     * @param admin_id 员工编号
     * @param role_id 角色编号
     * */
    int addAdminRole (@Param("admin_id") Integer admin_id,
                      @Param("role_id") Integer role_id);


    /**
     * 根据员工编号查询员工对象
     * @return  返回查询员工对象
     * */
    Admin getAdminById(@Param("admin_id") Integer admin_id);


    int updateAdmin(@Param("bo") AdminUpdateBo bo);

    //单个删除
    int deleteOne(@Param("admin_id") Integer admin_id);

    // 多个删除
    int deleteList( @Param("ids") Integer [] ids);

    /**
     * 删除员工所有角色
     *
     * */
    int deleteAdminRoles(@Param("admin_id") Integer admin_id);



}
