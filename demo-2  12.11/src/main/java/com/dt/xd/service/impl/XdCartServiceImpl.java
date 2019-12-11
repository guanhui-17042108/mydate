package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdCartMapper;
import com.dt.xd.model.XdCart;
import com.dt.xd.model.XdCartExample;
import com.dt.xd.service.XdCartService;

@Service
public class XdCartServiceImpl  implements XdCartService{
	@Resource
	XdCartMapper xdCartMapper;
	//从点击所有的产品中得到id并存到购物车中

	@Override
	public int insertCart(HttpServletRequest request) {
					String id=request.getParameter("id");
				   	System.out.println(id);
				       XdCart xdcart=new XdCart();
				   	System.out.println("插入成功");
				   	xdcart.setProductId(id);
				   	xdcart.setBuyNum(1);
				   	xdcart.setUserId(request.getParameter("userid"));
					return xdCartMapper.insert(xdcart);
			
	}
	//通过id修改数量

	@Override
	public int updateBuynum(XdCart xdcart, String id) {
		
		XdCartExample xdCartExample = new XdCartExample();
		XdCartExample.Criteria criteria = xdCartExample.createCriteria();
			criteria.andProductIdEqualTo(id);
			return xdCartMapper.updateByExampleSelective(xdcart, xdCartExample);
		
	}
	//查询所有

	@Override
	public List<XdCart> getcartid(HttpServletRequest request) {
		XdCartExample xdCartExample = new XdCartExample();
		XdCartExample.Criteria criteria = xdCartExample.createCriteria();
			criteria.andUserIdEqualTo(request.getParameter("userid"));
			return xdCartMapper.selectByExample(xdCartExample);
	
	}
	//通过用户userid查

	@Override
	public List<XdCart> getuid(String userid) {

		XdCartExample xdCartExample = new XdCartExample();
		XdCartExample.Criteria criteria = xdCartExample.createCriteria();
			criteria.andUserIdEqualTo(userid);
			return xdCartMapper.selectByExample(xdCartExample);
	
	}
	//通过id删除商品

	@Override
	public int providerProductDelete(HttpServletRequest request) {
			String id=request.getParameter("id");
			
			XdCartExample xdCartExample=new XdCartExample();
			XdCartExample.Criteria criteria=xdCartExample.createCriteria();
			criteria.andProductIdEqualTo(id);
			return xdCartMapper.deleteByExample(xdCartExample);

		
	}
	//通过id修改数量

	@Override
	public int updateBuynum1(XdCart xdcart, HttpServletRequest request) {

		XdCartExample cartExample = new XdCartExample();
		XdCartExample.Criteria criteria = cartExample.createCriteria();
			criteria.andProductIdEqualTo(request.getParameter("id"));
			criteria.andUserIdEqualTo(request.getParameter("userid"));
			
			return xdCartMapper.updateByExampleSelective(xdcart, cartExample);
	
	}
	//通过商品id查

	@Override
	public List<XdCart> getcid(HttpServletRequest request) {
		XdCartExample cartExample = new XdCartExample();
		XdCartExample.Criteria criteria = cartExample.createCriteria();
			criteria.andProductIdEqualTo(request.getParameter("id"));
			criteria.andUserIdEqualTo(request.getParameter("userid"));
			System.out.println("用户名=="+request.getParameter("userid")+"=="+request.getParameter("id"));
			return xdCartMapper.selectByExample(cartExample);
		
	}
	
		
	
	
		
	

}
