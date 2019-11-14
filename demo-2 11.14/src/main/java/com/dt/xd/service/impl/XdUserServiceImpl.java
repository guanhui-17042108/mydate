package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.dt.xd.dao.mapper.XdProductMapper;
import com.dt.xd.dao.mapper.XdServiceUserMapper;
import com.dt.xd.dao.mapper.XdUserMapper;
import com.dt.xd.service.XdUserService;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdProduct.XdProductExample;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdUser.XdUser;
import com.dt.xd.xdUser.XdUserExample;

@Service
public class XdUserServiceImpl implements XdUserService{
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
	public List<XdProduct> selectByExample(int pageStart, int pageSize, String username) {
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setDistinct(true);
		xdProductExample.setPageSize(pageSize);
		xdProductExample.setPageStart(pageStart);
		return xdProductMapper.selectByExample(xdProductExample,username);
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

	public int delete(XdProduct record) {
		
		return xdProductMapper.delete(record);
	}
	@Override
	public int updateImg(XdProduct xdProduct) {
		// TODO Auto-generated method stub
	 return xdProductMapper.updateByPrimaryKey(xdProduct);
	}
	@Override
	public XdProduct selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return xdProductMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(XdProduct record) {
		// TODO Auto-generated method stub
		return xdProductMapper.insert(record);
	}
	@Override
	public int deleteByPrimaryKey(String id) {
	//	List<> userList = deleteByPrimaryKey(id);
		int i= 0;
		//if(userList.size() !=0) {
			i=  xdProductMapper.deleteByPrimaryKey(id);
		//}
		return i;
	}
	@Override
	public int updateByPrimaryKeySelective(XdProduct record) {
		// TODO Auto-generated method stub
		return xdProductMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int insert(XdServiceUser xdServiceUser) {
		// TODO Auto-generated method stub
		return xdServiceUserMapper.insert(xdServiceUser);
	}
	
	
}
