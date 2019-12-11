package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdServiceUserMapper;
import com.dt.xd.service.XdServiceUserService;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;

@Service
public class XdServiceUserServiceImpl implements XdServiceUserService{

	@Resource
	XdServiceUserMapper xdServiceUserMapper;
	@Override
	public List<XdServiceUser> ser_login(String servicePhone) {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria=xdServiceUserExample.createCriteria();
		criteria.andServicePhoneEqualTo(servicePhone);
		return xdServiceUserMapper.selectByExample(xdServiceUserExample);
	}
	@Override
	public int ser_repassword(XdServiceUser user) {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria=xdServiceUserExample.createCriteria();
		return xdServiceUserMapper.updateBy(user.getServicePassword(), user.getServicePhone());
	}
	@Override
	public int insert(XdServiceUser record) {
		return xdServiceUserMapper.insert(record);
	}
	@Override
	public long countByExample() {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		return xdServiceUserMapper.countByExample();
	}
	@Override
	public int getCount(String serviceName) {
		return xdServiceUserMapper.getCount(serviceName);
	}
	@Override
	public List<XdServiceUser> selectByName(int pageSize,int pageStart,String serviceName) {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		xdServiceUserExample.setPageSize(pageSize);
		xdServiceUserExample.setPageStart(pageStart);
		xdServiceUserExample.setServiceName(serviceName);
		return xdServiceUserMapper.selectByName(xdServiceUserExample);
	}
	@Override
	public XdServiceUser selectByPrimaryKey(String id) {
		return xdServiceUserMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateImg(XdServiceUser xdServiceUser) {
		
		return xdServiceUserMapper.updateForImg(xdServiceUser);
	}
	@Override
	public List<XdServiceUser> select() {
		return xdServiceUserMapper.select();
	}

}
