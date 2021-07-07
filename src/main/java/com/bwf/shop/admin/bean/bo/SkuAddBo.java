package com.bwf.shop.admin.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//添加商品规格业务模型对象
public class SkuAddBo {
    private Integer sku_spu_id; // 所属商品编号
    private String  sku_name; // 规格名称
    private String sku_spuattr; // 商品规格值json 字符串
    private Integer  sortno;
    private Date createtime;
    private Date updatetime;

    //规格值列表
    private List<SkuValue> skuValueList =new ArrayList<>();

    public List<SkuValue> getSkuValueList() {
        return skuValueList;
    }

    public void setSkuValueList(List<SkuValue> skuValueList) {
        this.skuValueList = skuValueList;
    }

    public Integer getSku_spu_id() {
        return sku_spu_id;
    }

    public void setSku_spu_id(Integer sku_spu_id) {
        this.sku_spu_id = sku_spu_id;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public String getSku_spuattr() {
        return sku_spuattr;
    }

    public void setSku_spuattr(String sku_spuattr) {
        this.sku_spuattr = sku_spuattr;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
