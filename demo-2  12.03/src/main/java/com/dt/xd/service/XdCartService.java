package com.dt.xd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dt.xd.model.XdCart;


public interface XdCartService {
	int insertCart(HttpServletRequest request);
	public int updateBuynum(XdCart xdcart,String id);
	List<XdCart> getcartid(HttpServletRequest request);
	List<XdCart> getuid(String userid);
	int providerProductDelete(HttpServletRequest request);
	public int updateBuynum1(XdCart xdcart,HttpServletRequest request);

	List<XdCart> getcid(HttpServletRequest request);


}
