package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.SpuBannerAddBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuBannerMapper {

    /* 添加商品相册列表  */
    int addSpuBannerList(@Param("spu_id") Integer spu_id,
                         @Param("spuBannerAddBoList")List<SpuBannerAddBo> spuBannerAddBoList);

}
