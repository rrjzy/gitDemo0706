package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.Category;
import com.bwf.shop.admin.mapper.CategoryMapper;
import com.bwf.shop.admin.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryListByParentId(Integer parent_id) {
        return categoryMapper.getCategoryListByParentId(parent_id);
    }
}
