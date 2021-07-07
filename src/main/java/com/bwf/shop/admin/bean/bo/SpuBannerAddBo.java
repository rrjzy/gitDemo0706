package com.bwf.shop.admin.bean.bo;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

//商品相册模型对象
public class SpuBannerAddBo {

    private String  spu_banner_name; // 图片名称
    private String spu_banner_urls; // 图片路径

    private MultipartFile spu_banner_img;
    private Date createtime;
    private Date updatetime;

    public MultipartFile getSpu_banner_img() {
        return spu_banner_img;
    }

    public void setSpu_banner_img(MultipartFile spu_banner_img) {
        this.spu_banner_img = spu_banner_img;
    }

    public String getSpu_banner_name() {
        return spu_banner_name;
    }

    public void setSpu_banner_name(String spu_banner_name) {
        this.spu_banner_name = spu_banner_name;
    }

    public String getSpu_banner_urls() {
        return spu_banner_urls;
    }

    public void setSpu_banner_urls(String spu_banner_urls) {
        this.spu_banner_urls = spu_banner_urls;
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
