package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.Brand;
import com.bwf.shop.admin.mapper.BrandMapper;
import com.bwf.shop.admin.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrandList() {
        return brandMapper.getAllBrandList();
    }
}
