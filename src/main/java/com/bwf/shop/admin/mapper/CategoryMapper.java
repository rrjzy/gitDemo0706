package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 商品分类模块访问 */
public interface CategoryMapper {

    /**
     * 根据父类的编号 查询分类列表
     * */
    List<Category> getCategoryListByParentId(@Param("parent_id") Integer parent_id);
}
