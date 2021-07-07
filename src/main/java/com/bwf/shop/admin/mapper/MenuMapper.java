package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/* 菜单数据访问接口*/
@Repository
public interface MenuMapper {

    /**
     *  根据员工编号 查询相应权限菜+
     * */
    List<Menu> getMenuListByAdminId(@Param("admin_id") Integer admin_id);

}
