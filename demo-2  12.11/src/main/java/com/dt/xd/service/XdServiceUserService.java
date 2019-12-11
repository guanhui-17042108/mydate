package com.dt.xd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;

public interface XdServiceUserService {
	// 服务商的登录
	public List<XdServiceUser> ser_login(String servicePhone);

	// 服务商的修改密码
	public int ser_repassword(XdServiceUser user);

	// 服务商的插入
	int insert(XdServiceUser record);

	long countByExample();

	int getCount(@Param("serviceName") String serviceName);

	List<XdServiceUser> selectByName(int pageSize,int pageStart,String serviceName);
	
	XdServiceUser selectByPrimaryKey(String id);
	
	int updateImg(XdServiceUser xdServiceUser);
	
	List<XdServiceUser> select();
}
