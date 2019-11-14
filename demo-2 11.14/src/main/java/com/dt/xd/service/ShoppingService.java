package com.dt.xd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dt.xd.xdShopping.XdShopping;

public interface XdShoppingService {
	List<XdShopping> selectByExample(int pageStart, int pageSize, String id);

	public long getCount();

	int getCount(String id);

	List<XdShopping> selectById(int pageStart, int pageSize, String id);
	
	int deleteByPrimaryKey(String id);
	
	List<XdShopping> getSystemUserById(String id);
	
	int insertShopping(XdShopping user);
	
	List<XdShopping> selectAll();
}
