package com.dt.xd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdOrder1.XdOrder1Example;
@Mapper
public interface XdOrder1Mapper {
	long countByExample();
	    
	int getCount(@Param("orderNumber") String orderNumber);
	    
    List<XdOrder1> selectByNumber(XdOrder1Example example);
	long countByExample9();
	int getCount9(@Param("boughtUser") String boughtUser);
	List<XdOrder1> selectByName9(XdOrder1Example example);
	List<XdOrder1> selectByExample9(@Param("example") XdOrder1Example example, @Param("boughtUser") String boughtUser);
	long countByExampleO();
	int getCountO(@Param("orderNumber") String orderNumber);
	List<XdOrder1> selectByNameO(XdOrder1Example example);
	List<XdOrder1> selectByExampleO(@Param("example") XdOrder1Example example, @Param("orderNumber") String orderNumber);
    long countByExample(XdOrder1Example example);

    int deleteByExample(XdOrder1Example example);

    int deleteByPrimaryKey(String id);

    int insert(XdOrder1 record);

    int insertSelective(XdOrder1 record);

    List<XdOrder1> selectByExample(XdOrder1Example example);

    XdOrder1 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdOrder1 record, @Param("example") XdOrder1Example example);

    int updateByExample(@Param("record") XdOrder1 record, @Param("example") XdOrder1Example example);

    int updateByPrimaryKeySelective(XdOrder1 record);

    int updateByPrimaryKey(XdOrder1 record);

    int updateByExample();
}