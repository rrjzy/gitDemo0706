package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.po.Brand;

import java.util.List;

public interface IBrandService {
    /**
     * 获取所有品牌列表
     * */
    List<Brand> getAllBrandList();

}
