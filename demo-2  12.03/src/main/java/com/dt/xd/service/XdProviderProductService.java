package com.dt.xd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dt.xd.model.XdProviderProduct;


public interface XdProviderProductService {
	public List<XdProviderProduct> getpp();
	public List<XdProviderProduct> getid(String id);
	public int xx(XdProviderProduct pp,String id);	//修改状态下线
	public int sx(XdProviderProduct pp,String id);//修改状态上线
	public List<XdProviderProduct> getProviderProductInfoById(HttpServletRequest request);
	public List<XdProviderProduct> select(HttpServletRequest request); 	//模糊查询
	List<XdProviderProduct> selectAll(HttpServletRequest request);
	List<XdProviderProduct> selectpaging(HttpServletRequest request);
	int check1(HttpServletRequest request);
	int check2(HttpServletRequest request);
	public int del(HttpServletRequest request);
	XdProviderProduct getUserInfo(String id);
	public List<XdProviderProduct> select2(HttpServletRequest request);
	void saveProductImg(XdProviderProduct providerProduct) throws Exception;

	
	
	/*
	 * List<XdProviderProduct> selectByExample(int pageStart, int pageSize, String
	 * productName);
	 * 
	 * public long getCount();
	 * 
	 * int getCount(String productName);
	 * 
	 * List<XdProviderProduct> selectByName(int pageStart, int pageSize, String
	 * productName);
	 */}
