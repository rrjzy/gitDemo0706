package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.SpuAddBo;
import com.bwf.shop.admin.mapper.SkuMapper;
import com.bwf.shop.admin.mapper.SpuBannerMapper;
import com.bwf.shop.admin.mapper.SpuMapper;
import com.bwf.shop.admin.service.ISpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpuService implements ISpuService {
    //商品基本信息
    @Resource
    private SpuMapper spuMapper;

    //商品相册
    @Resource
    private SpuBannerMapper spuBannerMapper;

    //商品规格
    @Resource
    private SkuMapper skuMapper;

    @Override
    public boolean addSpu(SpuAddBo bo) {
        // 商品业务 模型对象添加spu表
        int a =spuMapper.addSpu(bo);

        //商品相册列表
        spuBannerMapper.addSpuBannerList(bo.getId(),bo.getSpuBannerAddBoList());

        //添加商品规格列表
        skuMapper.addSpuSkuList(bo.getId(),bo.getSkuAddBoList());


        return a>0;
    }
}
