package com.dt.xd.model;

import java.util.Date;

public class XdProviderProduct {
    private String id;

    private String providerId;

    private String productName;

    private String productContent;

    private Integer price;

    private Integer status;

    private Integer recommend;

    private Integer highQuality;

    private Date createTime;

    private Integer saleNum;

    private String providerName;

    private byte[] productImg;

    private int num2;

    public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent == null ? null : productContent.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getHighQuality() {
        return highQuality;
    }

    public void setHighQuality(Integer highQuality) {
        this.highQuality = highQuality;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    public byte[] getProductImg() {
        return productImg;
    }

    public void setProductImg(byte[] productImg) {
        this.productImg = productImg;
    }
}