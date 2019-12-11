package com.dt.xd.service;

import java.util.List;

import com.dt.xd.xdProduct.XdProduct;

public interface XdProductService {

	// 电子商务产品表的查询，分页
	List<XdProduct> selectByExample(int pageStart, int pageSize, String username);

	// 电子商务产品表的获取页面的记录总数
	public long getCount();

	// 电子商务产品表的获取页面的记录总数
	int getCount(String username);

	// 电子商务产品页面的分页，查询，按照产品名称查询
	List<XdProduct> selectByName(int pageStart, int pageSize, String username);

	// 上传头像，按照id上传头像，修改了.xml文件
	int updateImg(XdProduct xdProduct);

	// 按照主键查询
	XdProduct selectByPrimaryKey(String id);
	
	int deleteByPrimaryKey(Integer id);
}
