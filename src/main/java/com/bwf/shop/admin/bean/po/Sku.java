package com.bwf.shop.admin.bean.po;

import java.util.Date;

//商品规格模型对象
public class Sku {
    private Integer id; // 规格编号
    private Integer sku_spu_id; // 所属商品编号
    private String  sku_name; // 规格名称
    private String sku_spuattr; // 商品规格值json 字符串
    private Integer  sortno;
    private Date createtime;
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
