package com.bwf.shop.admin.bean.bo;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//商品添加模型
public class SpuAddBo {
    private Integer id; //商品编号
    private String spu_name; //商品名称
    private String spu_thumburl; // 封面图片

    private MultipartFile spu_thumburl_img; // 上传时在temp临时目录下的文件
    private Double spu_price; //商品起价
    private Integer  spu_stock; // 商品库存
    private String  spu_title;// 商品标题
    private String spu_introduction;//商品介绍
    private Integer  spu_warningstock; // 预警库存
    private Integer spu_maxbuy; // 限购数量
    private String  spu_unit;// 商品单位
    private Integer spu_status;// 商品状态
    private Date createtime;
    private Date updatetime;
    private Integer  spu_brand_id;//品牌编号
    private Integer  spu_category_id;// 分类编号

    //商品相册图片
    private List<SpuBannerAddBo> spuBannerAddBoList =new ArrayList<>();

    //商品的规格列表
    private List<SkuAddBo> skuAddBoList =new ArrayList<>();

    public List<SkuAddBo> getSkuAddBoList() {
        return skuAddBoList;
    }

    public void setSkuAddBoList(List<SkuAddBo> skuAddBoList) {
        this.skuAddBoList = skuAddBoList;
    }

    public List<SpuBannerAddBo> getSpuBannerAddBoList() {
        return spuBannerAddBoList;
    }

    public void setSpuBannerAddBoList(List<SpuBannerAddBo> spuBannerAddBoList) {
        this.spuBannerAddBoList = spuBannerAddBoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_thumburl() {
        return spu_thumburl;
    }

    public void setSpu_thumburl(String spu_thumburl) {
        this.spu_thumburl = spu_thumburl;
    }

    public Double getSpu_price() {
        return spu_price;
    }

    public void setSpu_price(Double spu_price) {
        this.spu_price = spu_price;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public Integer getSpu_warningstock() {
        return spu_warningstock;
    }

    public void setSpu_warningstock(Integer spu_warningstock) {
        this.spu_warningstock = spu_warningstock;
    }

    public Integer getSpu_maxbuy() {
        return spu_maxbuy;
    }

    public void setSpu_maxbuy(Integer spu_maxbuy) {
        this.spu_maxbuy = spu_maxbuy;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Integer getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Integer spu_status) {
        this.spu_status = spu_status;
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

    public Integer getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(Integer spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }

    public Integer getSpu_category_id() {
        return spu_category_id;
    }

    public void setSpu_category_id(Integer spu_category_id) {
        this.spu_category_id = spu_category_id;
    }

    public Integer getSpu_stock() {
        return spu_stock;
    }

    public void setSpu_stock(Integer spu_stock) {
        this.spu_stock = spu_stock;
    }

    public MultipartFile getSpu_thumburl_img() {
        return spu_thumburl_img;
    }

    public void setSpu_thumburl_img(MultipartFile spu_thumburl_img) {
        this.spu_thumburl_img = spu_thumburl_img;
    }
}
