package com.dt.xd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;

public interface XdBoughtUserService {
//	List<XdBoughtUser> getBoughtUserByPhone(String phone);

	// 电子商务的登录
	public List<XdBoughtUser> e_login(String phone);

	// 电子商务的修改密码
	public int e_repassword(XdBoughtUser user);

	// 电子商务注册调用insert
	int insert(XdBoughtUser user);

	public int update(XdBoughtUser user);

	long countByExample();

	int getCount(@Param("userName") String userName);

	List<XdBoughtUser> selectByUserName(int pageSize,int pageStart,String userName);
}
