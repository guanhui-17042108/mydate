package com.dt.xd.xdStore;

import java.util.Date;

public class XdStore {
    private Integer id;

    private String storeInfo;

    private Date workTime;

    private String qq;

    private String cellphone;
    private byte[] license;
    

    public byte[] getLicense() {
		return license;
	}

	public void setLicense(byte[] license) {
		this.license = license;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }
}