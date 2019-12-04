package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdOrder1Mapper;
import com.dt.xd.service.XdOrder1Service;
import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdOrder1.XdOrder1Example;

@Service
public class XdOrder1ServiceImpl implements XdOrder1Service{
	@Resource
	XdOrder1Mapper xdOrder1Mapper;
	
	@Override
	public int updateByExample() {
		return xdOrder1Mapper.updateByExample();
	}

	@Override
	public long countByExample() {
		XdOrder1Example xdOrderExample=new XdOrder1Example();
		return xdOrder1Mapper.countByExample();
	}

	@Override
	public int getCount(String orderNumber) {
		return xdOrder1Mapper.getCount(orderNumber);
	}

	@Override
	public List<XdOrder1> selectByNumber(int pageStart,int pageSize,String orderNumber) {
		XdOrder1Example xdOrderExample= new XdOrder1Example();;
		xdOrderExample.setOrderNumber(orderNumber);
		xdOrderExample.setPageSize(pageSize);
		xdOrderExample.setPageStart(pageStart);
		return xdOrder1Mapper.selectByNumber(xdOrderExample);
	}
	
	

}
