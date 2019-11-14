package com.dt.xd.xdProduct;

import java.util.Date;

public class XdProduct {
    private String id;

    private String serviceProduct;

    private String productImg;

    private String productName;

    private String productInstruction;
    private String  productPrice;

    private String status;

    private Date ts;

    private Integer salesVolume;

    private String serviceName;

    private String recommend;

    private String highQuality;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getServiceProduct() {
        return serviceProduct;
    }

    public void setServiceProduct(String serviceProduct) {
        this.serviceProduct = serviceProduct == null ? null : serviceProduct.trim();
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductInstruction() {
        return productInstruction;
    }

    public void setProductInstruction(String productInstruction) {
        this.productInstruction = productInstruction == null ? null : productInstruction.trim();
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }

    public String getHighQuality() {
        return highQuality;
    }

    public void setHighQuality(String highQuality) {
        this.highQuality = highQuality == null ? null : highQuality.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}