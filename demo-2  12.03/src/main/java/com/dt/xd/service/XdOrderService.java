package com.dt.xd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.dt.xd.model.XdOrder;

public interface XdOrderService {
	public List<XdOrder> getso();

	public List<XdOrder> select(HttpServletRequest request);

	List<XdOrder> getuid(String userid);

	public int up(HttpServletRequest request);

	int insertServiceOrder(HttpServletRequest request);

	List<XdOrder> getll(String userid);

	public int pProductDelete(HttpServletRequest request);

	public int pProductup(HttpServletRequest request);

	List<XdOrder> getmm(String orderNo);

	List<XdOrder> getpay(HttpServletRequest request);

	List<XdOrder> getpaylist(HttpServletRequest request);

	List<XdOrder> gettime(HttpServletRequest request);

	List<XdOrder> gettimepage(HttpServletRequest request);

	List<XdOrder> getlist(HttpServletRequest request);

	List<XdOrder> getlist2(HttpServletRequest request);

	List<XdOrder> content(HttpServletRequest request);

	List<XdOrder> search(HttpServletRequest request);
	
	
	/*
	 * int updateByExample();
	 * 
	 * long countByExample();
	 * 
	 * int getCount(@Param("orderNumber") String orderNumber);
	 * 
	 * List<XdOrder> selectByNumber(int pageStart,int pageSize,String orderNumber);
	 */

}
