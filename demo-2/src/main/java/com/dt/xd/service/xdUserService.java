package com.dt.xd.service;

import java.util.List;

import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdUser.XdUser;

public interface xdUserService {

	public List<XdUser> ope_login(String phone);

	public int ope_repassword(XdUser user);

	int insert(XdUser record);

	List<XdProduct> selectByExample(int pageStart, int pageSize, String username);

	public long getCount();

	int getCount(String username);

	List<XdProduct> selectByName(int pageStart, int pageSize, String username);
	
}
