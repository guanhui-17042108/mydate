package com.dt.xd.dao.mapper;

import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdProduct.XdProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdProductMapper {
	long countByExample();

	int getCount(@Param("username") String username);

	List<XdProduct> selectByName(XdProductExample example);

	List<XdProduct> selectByExample(@Param("example") XdProductExample example, @Param("username") String username);

	int deleteByExample(XdProductExample example);

	int deleteByPrimaryKey(String id);

	int insert(XdProduct record);

	int insertSelective(XdProduct record);

	XdProduct selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") XdProduct record, @Param("example") XdProductExample example);

	int updateByExample(@Param("record") XdProduct record, @Param("example") XdProductExample example);

	int updateByPrimaryKeySelective(XdProduct record);
	
	int updateByPrimaryKey(XdProduct record);

	int delete(XdProduct record);
}