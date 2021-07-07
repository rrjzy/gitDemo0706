package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.SpuAddBo;

public interface ISpuService {

    /**添加商品
    * @param bo  添加商品模型对象
      @return  添加是否成功
    * */
    boolean addSpu(SpuAddBo bo);
}
