package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdShoppingMapper;
import com.dt.xd.service.XdShoppingService;
import com.dt.xd.xdShopping.XdShopping;
import com.dt.xd.xdShopping.XdShoppingExample;

@Service
public class XdShoppingServiceImpl implements XdShoppingService{
	@Resource
	XdShoppingMapper xdShoppingMapper;
	@Override
	public List<XdShopping> selectByExample(int pageStart, int pageSize, String id) {
		XdShoppingExample xdShoppingExample=new XdShoppingExample();
		xdShoppingExample.setDistinct(true);
		xdShoppingExample.setPageSize(pageSize);
		xdShoppingExample.setPageStart(pageStart);
		return xdShoppingMapper.selectByExample(xdShoppingExample, id);
	}

	@Override
	public long getCount() {
		XdShoppingExample xdShoppingExample=new XdShoppingExample();
		return xdShoppingMapper.countByExample();
	}

	@Override
	public int getCount(String id) {
		return xdShoppingMapper.getCount(id);
	}

	@Override
	public List<XdShopping> selectById(int pageStart, int pageSize, String id) {
		XdShoppingExample xdShoppingExample=new XdShoppingExample();
		xdShoppingExample.setId(id);
		xdShoppingExample.setPageSize(pageSize);
		xdShoppingExample.setPageStart(pageStart);
		return xdShoppingMapper.selectById(xdShoppingExample);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return xdShoppingMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<XdShopping> getSystemUserById(String id) {
		XdShoppingExample xdShoppingExample=new XdShoppingExample();
		XdShoppingExample.Criteria criteria=xdShoppingExample.createCriteria();
		criteria.andIdEqualTo(id);
		return null;
	}

	@Override
	public int insertShopping(XdShopping user) {
		// TODO Auto-generated method stub
		return xdShoppingMapper.insert(user);
	}

	@Override
	public List<XdShopping> selectAll() {
		// TODO Auto-generated method stub
		return xdShoppingMapper.selectByExample(null);
	}

}
