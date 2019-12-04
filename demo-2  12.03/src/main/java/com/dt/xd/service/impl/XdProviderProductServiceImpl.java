package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdProviderProductMapper;
import com.dt.xd.model.XdProviderProduct;
import com.dt.xd.model.XdProviderProductExample;
import com.dt.xd.service.XdProviderProductService;

@Service
public class XdProviderProductServiceImpl implements XdProviderProductService{
	@Resource
	XdProviderProductMapper xdProviderProductMapper;
	//查询所有产品

	@Override
	public List<XdProviderProduct> getpp() {
			XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
			XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
			System.out.println("查询结果几条==="+xdProviderProductMapper.selectByExample(xdProviderProductExample).size());
			return xdProviderProductMapper.selectByExample(xdProviderProductExample);
		
	}
	//通过产品id查

	@Override
	public List<XdProviderProduct> getid(String id) {
		XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
		XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
			criteria.andIdEqualTo(id);
			return xdProviderProductMapper.selectByExample(xdProviderProductExample);
	}
	//修改状态为2下线
	@Override
	public int xx(XdProviderProduct pp, String id) {
		XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
		XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
			criteria.andIdEqualTo(id);
			pp.setStatus(2);
			return xdProviderProductMapper.updateByExampleSelective(pp, xdProviderProductExample);
	}
	//修改状态为1上线
	@Override
	public int sx(XdProviderProduct pp, String id) {
		XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
		XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
			criteria.andIdEqualTo(id);
			pp.setStatus(1);
			return xdProviderProductMapper.updateByExampleSelective(pp, xdProviderProductExample);
	
	}
	//查询所有商品

	@Override
	public List<XdProviderProduct> getProviderProductInfoById(HttpServletRequest request) {
			
		XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
		XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
		xdProviderProductExample.setOrderByClause(request.getParameter("index"));
			//System.out.println("查询结果几条==="+xdProviderProductMapper.selectByExample(xdProviderProductExample).size());
			return xdProviderProductMapper.selectByExample(xdProviderProductExample);
	}
	//模糊查询
	@Override
	public List<XdProviderProduct> select(HttpServletRequest request) {

		
				List<XdProviderProduct> pp=xdProviderProductMapper.selectByLike(request.getParameter("name"));
				return pp;
			}
		
		

	@Override
	public List<XdProviderProduct> selectAll(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XdProviderProduct> selectpaging(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int check1(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int check2(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(HttpServletRequest request) {
		XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
		XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
			System.out.println("1444");
			criteria.andIdEqualTo(request.getParameter("id"));
			return xdProviderProductMapper.deleteByExample(xdProviderProductExample);
	
	}

	@Override
	public XdProviderProduct getUserInfo(String id) {
			return xdProviderProductMapper.selectByPrimaryKey(id);
		
	}

	@Override
	public List<XdProviderProduct> select2(HttpServletRequest request) {
			XdProviderProductExample xdProviderProductExample = new XdProviderProductExample();
			XdProviderProductExample.Criteria criteria = xdProviderProductExample.createCriteria();
			xdProviderProductExample.setOrderByClause(request.getParameter("index"));
			System.out.println("cs"+xdProviderProductExample.getOrderByClause());
			xdProviderProductExample.setLikeName(request.getParameter("name"));
			return xdProviderProductMapper.selectByAll2(xdProviderProductExample);
		
	}
	

	@Override
	public void saveProductImg(XdProviderProduct providerProduct) throws Exception {
		int i = xdProviderProductMapper.saveProductImg(providerProduct);
		System.out.println("i==="+i);
		if(i!=1) {
			throw new Exception("失败");
		} 
	}



}
