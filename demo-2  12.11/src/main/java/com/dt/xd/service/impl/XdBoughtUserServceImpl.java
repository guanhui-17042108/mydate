package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdBoughtUserMapper;
import com.dt.xd.service.XdBoughtUserService;
import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;
import com.dt.xd.xdServiceUser.XdServiceUser;

@Service
public class XdBoughtUserServceImpl implements XdBoughtUserService{

	@Resource
	XdBoughtUserMapper xdBoughtUserMapper;

//	@Override
//	public List<XdBoughtUser> getBoughtUserByPhone(String phone) {
//		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
//		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
//		criteria.andPhoneEqualTo(phone);
//		return xdBoughtUserMapper.selectByExample(xdBoughtUserExample);
//	}

	@Override
	public List<XdBoughtUser> e_login(String phone) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		return xdBoughtUserMapper.selectByExample(xdBoughtUserExample);
	}

	@Override
	public int e_repassword(XdBoughtUser user) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
		return xdBoughtUserMapper.updateBy(user.getPassword(), user.getPhone());
	}

	@Override
	public int insert(XdBoughtUser user) {
		return xdBoughtUserMapper.insert(user);
	}

//	@Override
//	public List<XdBoughtUser> select(String phone) {
//		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
//		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
//		criteria.andPhoneEqualTo(phone);
//		return xdBoughtUserMapper.selectByExample(xdBoughtUserExample);
//	}

	@Override
	public int update(XdBoughtUser user) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
		criteria.andPhoneEqualTo(user.getPhone());
		return xdBoughtUserMapper.updateByExampleSelective(user, xdBoughtUserExample);
	}

	@Override
	public long countByExample() {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		return xdBoughtUserMapper.countByExample();
	}

	@Override
	public int getCount(String userName) {
		return xdBoughtUserMapper.getCount(userName);
	}

	@Override
	public List<XdBoughtUser> selectByUserName(int pageSize,int pageStart,String userName) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		xdBoughtUserExample.setPageSize(pageSize);
		xdBoughtUserExample.setPageStart(pageStart);
		xdBoughtUserExample.setUserName(userName);
		return xdBoughtUserMapper.selectByUserName(xdBoughtUserExample);
	}


	

	
	
}
