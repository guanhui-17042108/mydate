package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdOrderMapper;
import com.dt.xd.model.XdOrder;
import com.dt.xd.model.XdOrderExample;
import com.dt.xd.service.XdOrderService;

@Service
public class XdOrderServiceImpl implements  XdOrderService{
	@Resource
	XdOrderMapper xdOrderMapper;
	//查询服务订单
	@Override
	public List<XdOrder> getso() {
			XdOrderExample xdOrderExample = new XdOrderExample();
			XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
			return xdOrderMapper.selectByExample(xdOrderExample);
		
	}
	//模糊查询

	@Override
	public List<XdOrder> select(HttpServletRequest request) {
			List<XdOrder> so=xdOrderMapper.selectByLike(request.getParameter("name"));
			return so;
		
	}
	//通过用户userid查

	@Override
	public List<XdOrder> getuid(String userid) {
		
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
			criteria.andEuserIdEqualTo(userid);
			return xdOrderMapper.selectByExample(xdOrderExample);
		
	}
	//修改支付类型

	@Override
	public int up(HttpServletRequest request) {
			XdOrder serviceOrder=new XdOrder();
			serviceOrder.setOrderNo(request.getParameter("nn"));
			serviceOrder.setPayType(Integer.valueOf(request.getParameter("paytype")));
			serviceOrder.setStatus(2);
			int so=xdOrderMapper.updateByPrimaryKeySelective(serviceOrder);
			return so;
		
	}
	//将订单信息插入serviceorder表

	@Override
	public int insertServiceOrder(HttpServletRequest request) {


		   	XdOrder serviceOrder=new XdOrder();
		   	System.out.println("插入成功");
		   	serviceOrder.setOrderNo(request.getParameter("nn"));
		   	serviceOrder.setEuserId(request.getParameter("userid"));
		   	serviceOrder.setProductId(request.getParameter("str4")); 	
		   	serviceOrder.setTotalPrice(Integer.valueOf(request.getParameter("totalprice1")));
		   	serviceOrder.setStatus(1);
			serviceOrder.setPayType(0);
			java.sql.Date ctime = new java.sql.Date(new java.util.Date().getTime()); 
		   	serviceOrder.setCreateTime(ctime);
			return xdOrderMapper.insert(serviceOrder);
		
	}
	//通过用户userid查

	@Override
	public List<XdOrder> getll(String userid) {
		
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
				criteria.andEuserIdEqualTo(userid);
//				criteria.andStatusEqualTo(2);
				return xdOrderMapper.selectByExample(xdOrderExample);
		
	}
	//删除订单

	@Override
	public int pProductDelete(HttpServletRequest request) {

				String orderNo=request.getParameter("orderNo");
				System.out.println(1111111111+orderNo);
				XdOrderExample xdOrderExample=new XdOrderExample();
				XdOrderExample.Criteria criteria=xdOrderExample.createCriteria();
				criteria.andOrderNoEqualTo(orderNo);
				return xdOrderMapper.deleteByExample(xdOrderExample);
	}
	//通过订单serciceNo查

	@Override
	public List<XdOrder> getmm(String orderNo) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
			criteria.andOrderNoEqualTo(orderNo);
//			criteria.andStatusEqualTo(2);
			return xdOrderMapper.selectByExample(xdOrderExample);
	}
	//费用中心分页查询
	@Override
	public List<XdOrder> getpay(HttpServletRequest request) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setStatus(2);
		xdOrderExample.setPageSize((Integer.valueOf(request.getParameter("pageSize"))-1)*2);
		  System.out.println("getPageSize"+xdOrderExample.getPageSize());
		  xdOrderExample.setPageNum(Integer.valueOf(request.getParameter("pageNum")));
		  System.out.println("getPageNum"+xdOrderExample.getPageNum());
		  return xdOrderMapper.selectBypaging(xdOrderExample);
	
	}
	//费用中心查询
	@Override
	public List<XdOrder> getpaylist(HttpServletRequest request) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setStatus(2);
			return xdOrderMapper.selectByLike2(xdOrderExample);
	}
	//费用中心分页查询
	@Override
	public List<XdOrder> gettime(HttpServletRequest request) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setStatus(2);
		xdOrderExample.setTime(Integer.valueOf(request.getParameter("time")));
			return xdOrderMapper.selectBytime(xdOrderExample);
	}
	//费用中心分页查询
	@Override
	public List<XdOrder> gettimepage(HttpServletRequest request) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setStatus(2);
		xdOrderExample.setTime(Integer.valueOf(request.getParameter("time")));
		xdOrderExample.setPageSize((Integer.valueOf(request.getParameter("pageSize"))-1)*2);
			System.out.println("getPageSize"+xdOrderExample.getPageSize());
			xdOrderExample.setPageNum(Integer.valueOf(request.getParameter("pageNum")));
			System.out.println("getPageNum"+xdOrderExample.getPageNum());
			return xdOrderMapper.selectBytimepage(xdOrderExample);
	}
	///////////////////////////////////////////////////////////////////////////服务商订单

	@Override
	public List<XdOrder> getlist(HttpServletRequest request) {

		
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setStatus(Integer.valueOf(request.getParameter("status")));
			System.out.println("xdOrderExample"+xdOrderExample.getStatus());
			return xdOrderMapper.selectByorderform(xdOrderExample);
	
	}

	@Override
	public List<XdOrder> getlist2(HttpServletRequest request) {

		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setStatus(2);
		xdOrderExample.setPageSize((Integer.valueOf(request.getParameter("pageSize"))-1)*2);
			System.out.println("getPageSize"+xdOrderExample.getPageSize());
			xdOrderExample.setPageNum(Integer.valueOf(request.getParameter("pageNum")));
			System.out.println("getPageNum"+xdOrderExample.getPageNum());
			return xdOrderMapper.selectByorderformpage(xdOrderExample);
		
	}
	//////////////////////////////////////////////用户id查订单

	@Override
	public List<XdOrder> content(HttpServletRequest request) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
			criteria.andEuserIdEqualTo(request.getParameter("userid"));
			return xdOrderMapper.selectByExample(xdOrderExample);
	
	}

	@Override
	public List<XdOrder> search(HttpServletRequest request) {
		XdOrderExample xdOrderExample = new XdOrderExample();
		XdOrderExample.Criteria criteria = xdOrderExample.createCriteria();
		xdOrderExample.setLikeName(request.getParameter("name"));
		xdOrderExample.setMemberId(request.getParameter("userid"));
			if(!request.getParameter("data1").isEmpty()) {
				xdOrderExample.setData1(request.getParameter("data1"));
			}else {
				xdOrderExample.setData1("1970-01-01");
			}
			if(!request.getParameter("data2").isEmpty()) {
				xdOrderExample.setData2(request.getParameter("data2"));
			}else {
				xdOrderExample.setData2("3030-01-01");
			}
			List<XdOrder> so=xdOrderMapper.selectByLike5(xdOrderExample);
			return so;
		}
	
	
	
	
		//修改订单支付
		@Override
		public int pProductup(HttpServletRequest request) {
			return 0;
			
		}

	/*
	 * @Override public int updateByExample() { return
	 * xdOrderMapper.updateByExample(); }
	 * 
	 * @Override public long countByExample() { XdOrderExample xdOrderExample=new
	 * XdOrderExample(); return xdOrderMapper.countByExample(); }
	 * 
	 * @Override public int getCount(String orderNumber) { return
	 * xdOrderMapper.getCount(orderNumber); }
	 * 
	 * @Override public List<XdOrder> selectByNumber(int pageStart,int
	 * pageSize,String orderNumber) { XdOrderExample xdOrderExample= new
	 * XdOrderExample();; xdOrderExample.setOrderNumber(orderNumber);
	 * xdOrderExample.setPageSize(pageSize); xdOrderExample.setPageStart(pageStart);
	 * return xdOrderMapper.selectByNumber(xdOrderExample); }
	 * 
	 * 
	 */
		
		
		
	
		
	
	}

