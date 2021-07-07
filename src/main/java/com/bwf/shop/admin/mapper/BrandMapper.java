package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

/* 品牌 模块访问接口*/
@Repository
public interface BrandMapper {

    /**
     * 获取所有品牌列表
     * */
    List<Brand> getAllBrandList();


}
