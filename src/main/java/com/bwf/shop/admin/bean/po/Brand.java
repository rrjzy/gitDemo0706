package com.bwf.shop.admin.bean.po;

import java.util.Date;

public class Brand {
    private Integer id ;
    private String brand_name; //品牌名称
    private String brand_introduction;  // 品牌介绍
    private String brand_logourl; //品牌logo
    private Integer sortno; // 品牌排序
    private Date createtime;
    private Date updatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }

    public String getBrand_logourl() {
        return brand_logourl;
    }

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
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
