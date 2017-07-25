package com.huixin.web.model;

public class Banner {
    private Integer id;

    private String bannerImg1;

    private String bannerImg2;

    private String bannerLinkurl;

    private String imgDesc;

    private Byte sortOrder;

    private Integer enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannerImg1() {
        return bannerImg1;
    }

    public void setBannerImg1(String bannerImg1) {
        this.bannerImg1 = bannerImg1 == null ? null : bannerImg1.trim();
    }

    public String getBannerImg2() {
        return bannerImg2;
    }

    public void setBannerImg2(String bannerImg2) {
        this.bannerImg2 = bannerImg2 == null ? null : bannerImg2.trim();
    }

    public String getBannerLinkurl() {
        return bannerLinkurl;
    }

    public void setBannerLinkurl(String bannerLinkurl) {
        this.bannerLinkurl = bannerLinkurl == null ? null : bannerLinkurl.trim();
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}