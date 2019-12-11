package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdProductMapper;
import com.dt.xd.service.XdProductService;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdProduct.XdProductExample;

@Service
public class XdProductServiceImpl implements XdProductService{

	@Resource
	XdProductMapper xdProductMapper;
	
	@Override
	//以map为参数的模糊查询，这里没有用到
	public List<XdProduct> selectByExample(int pageStart, int pageSize, String username) {
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setDistinct(true);
		xdProductExample.setPageSize(pageSize);
		xdProductExample.setPageStart(pageStart);
		return xdProductMapper.selectByExample(xdProductExample,username);
	}
	@Override
	//获取页面的记录总数
	public long getCount() {
		XdProductExample xdProductExample=new XdProductExample();
		return xdProductMapper.countByExample();
	}
	@Override
	//获取页面的记录总数
	public int getCount(String username) {
		return xdProductMapper.getCount(username);
	}
	@Override
	//电子商务产品页面的分页和查询
	public List<XdProduct> selectByName(int pageStart, int pageSize, String username) {
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setUsername(username);
		xdProductExample.setPageSize(pageSize);
		xdProductExample.setPageStart(pageStart);
		return xdProductMapper.selectByName(xdProductExample);
	}
	@Override
	//上传头像
	public int updateImg(XdProduct xdProduct) {
		return xdProductMapper.updateByPrimaryKey(xdProduct);
	}
	@Override
	//电子商务的按照主键id查询
	public XdProduct selectByPrimaryKey(String id) {
		return xdProductMapper.selectByPrimaryKey(id);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return xdProductMapper.deleteByPrimaryKey(id);
	}
	
}
