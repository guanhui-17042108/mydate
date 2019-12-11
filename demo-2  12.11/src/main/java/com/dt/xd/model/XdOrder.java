package com.dt.xd.model;

import java.util.Date;

public class XdOrder {
    private String orderNo;

    private String euserId;

    private String productId;

    private Integer totalPrice;

    private Integer status;

    private Date createTime;

    private Integer payType;

    private String content;
    private String XdEuserId;
    private String ProductNum;
    
public String getXdEuserId() {
		return XdEuserId;
	}

	public void setXdEuserId(String xdEuserId) {
		XdEuserId = xdEuserId;
	}

	public String getProductNum() {
		return ProductNum;
	}

	public void setProductNum(String productNum) {
		ProductNum = productNum;
	}

private String zt;
    
    private String providerName;
    
    private String serviceName;
    
    private String ppId;

    public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPpId() {
		return ppId;
	}

	public void setPpId(String ppId) {
		this.ppId = ppId;
	}

	public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getEuserId() {
        return euserId;
    }

    public void setEuserId(String euserId) {
        this.euserId = euserId == null ? null : euserId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public void setProductName(String productName) {
		// TODO Auto-generated method stub
		
	}

	public void setProductNum(Integer valueOf) {
		// TODO Auto-generated method stub
		
	}
}