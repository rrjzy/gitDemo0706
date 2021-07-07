package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.AdminAddBo;
import com.bwf.shop.admin.bean.bo.AdminSearchBo;
import com.bwf.shop.admin.bean.bo.AdminUpdateBo;
import com.bwf.shop.admin.bean.po.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*  员工业务接口
*
* */
public interface IAdminService {
    /**
     *  根据账户名称获取用户名称
     * */
    Admin getAdminByName(String admin_name);

    /**
     * 根据业务模型对象 查询 员工列表
     * @param bo  查询业务模型对象
     * @return  满足条件的员工列表
     * */
    List<Admin> getAdminList(AdminSearchBo bo);

    /** 添加员工对象
     * @param bo  添加员工的模型对象
     * @return  数据库变化的行数
     * */
    Boolean addAdmin(AdminAddBo bo);


    /**
     * 根据员工编号查询员工对象
     * @return  返回查询员工对象
     * */
    Admin getAdminById(Integer admin_id);


    Boolean updateAdmin(AdminUpdateBo bo);

    Boolean deleteOne(Integer admin_id);

    Boolean deleteList(Integer [] ids);
}
