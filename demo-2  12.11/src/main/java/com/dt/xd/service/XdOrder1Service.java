package com.dt.xd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdOrder1.XdOrder1Example;

public interface XdOrder1Service {

	int updateByExample();

	long countByExample();

	int getCount(@Param("orderNumber") String orderNumber);

	List<XdOrder1> selectByNumber(int pageStart,int pageSize,String orderNumber);
}
