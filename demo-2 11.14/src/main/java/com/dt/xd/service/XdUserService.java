package com.dt.xd.service;

import java.util.List;


import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdUser.XdUser;
import com.dt.xd.xdUser.XdUserExample;

public interface XdUserService {

	public List<XdUser> ope_login(String phone);

	public int ope_repassword(XdUser user);

	int deleteByPrimaryKey(String id);
	
	int updateByPrimaryKeySelective(XdProduct record);
	
	int insert(XdUser record);

	List<XdProduct> selectByExample(int pageStart, int pageSize, String username);

	public long getCount();

	int getCount(String username);

	List<XdProduct> selectByName(int pageStart, int pageSize, String username);
	int insert(XdProduct record);
	int updateImg(XdProduct xdProduct);
	XdProduct selectByPrimaryKey(String id);

	int delete(XdProduct record);
	int insert(XdServiceUser record);
}
