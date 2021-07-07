package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryService {

    /**
     * 根据父类的编号 查询分类列表
     * */
    List<Category> getCategoryListByParentId(Integer parent_id);
}
