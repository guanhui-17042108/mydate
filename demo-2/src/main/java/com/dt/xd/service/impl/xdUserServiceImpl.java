package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.dt.xd.dao.mapper.XdProductMapper;
import com.dt.xd.dao.mapper.XdServiceUserMapper;
import com.dt.xd.dao.mapper.XdUserMapper;
import com.dt.xd.service.xdUserService;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdProduct.XdProductExample;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;
import com.dt.xd.xdUser.XdUser;
import com.dt.xd.xdUser.XdUserExample;

@Service
public class xdUserServiceImpl implements xdUserService{
	@Resource
	XdUserMapper xdUserMapper;
	@Resource
	XdProductMapper xdProductMapper;
	@Resource
	XdServiceUserMapper xdServiceUserMapper;
	
	@Override
	public List<XdUser> ope_login(String phone) {
		XdUserExample xdUserExample=new XdUserExample();
		XdUserExample.Criteria criteria=xdUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		return xdUserMapper.selectByExample(xdUserExample);
	}
	@Override
	public int ope_repassword(XdUser user) {
		XdUserExample xdUserExample=new XdUserExample();
		XdUserExample.Criteria criteria=xdUserExample.createCriteria();
		return xdUserMapper.updateByExample(user, xdUserExample);
	}
	@Override
	public int insert(XdUser record) {
		return xdUserMapper.insert(record);
	}
	@Override
	public long getCount() {
		XdProductExample xdProductExample=new XdProductExample();
		return xdProductMapper.countByExample();
	}
	@Override
	public int getCount(String username) {
		return xdProductMapper.getCount(username);
	}
	@Override
	public List<XdProduct> selectByName(int pageStart, int pageSize, String username) {
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setUsername(username);
		xdProductExample.setPageSize(pageSize);
		xdProductExample.setPageStart(pageStart);
		return xdProductMapper.selectByName(xdProductExample);
	}
	@Override
	public int insert(XdProduct record) {
		
		return xdProductMapper.insert(record);
	}
	@Override
	public int updateImg(XdProduct xdProduct) {
		// TODO Auto-generated method stub
	 return xdProductMapper.updateByPrimaryKey(xdProduct);
	}
	@Override
	public XdProduct selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return xdProductMapper.selectByPrimaryKey(id);
	}
	@Override
	public XdServiceUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return xdServiceUserMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKey(XdServiceUser xdServiceUser) {
		
		return xdServiceUserMapper.updateByPrimaryKey(xdServiceUser);
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		return xdProductMapper.deleteByPrimaryKey(id);
	
}
	@Override
	public List<XdProduct> selectByExample(int pageStart,int pageSize,String username) {
		//对象初始化
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setDistinct(true);
		xdProductExample.setPageStart(pageStart);
		xdProductExample.setPageSize(pageSize);
		return xdProductMapper.selectByExample(xdProductExample, username);
	}
}