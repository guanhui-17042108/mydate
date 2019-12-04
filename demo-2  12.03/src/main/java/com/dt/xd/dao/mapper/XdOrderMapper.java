package com.dt.xd.dao.mapper;

import com.dt.xd.model.XdOrder;
import com.dt.xd.model.XdOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdOrderMapper {
	
	
	long countByExample();
    
	int getCount(@Param("orderNumber") String orderNumber);
	    
    List<XdOrder> selectByNumber(XdOrderExample example);
	long countByExample9();
	int getCount9(@Param("boughtUser") String boughtUser);
	List<XdOrder> selectByName9(XdOrderExample example);
	List<XdOrder> selectByExample9(@Param("example") XdOrderExample example, @Param("boughtUser") String boughtUser);
	long countByExampleO();
	int getCountO(@Param("orderNumber") String orderNumber);
	List<XdOrder> selectByNameO(XdOrderExample example);
	List<XdOrder> selectByExampleO(@Param("example") XdOrderExample example, @Param("orderNumber") String orderNumber);
	
	
	
	
	
	
    long countByExample(XdOrderExample example);

    int deleteByExample(XdOrderExample example);

    int deleteByPrimaryKey(String orderNo);

    int insert(XdOrder record);

    int insertSelective(XdOrder record);

    List<XdOrder> selectByExample(XdOrderExample example);

    XdOrder selectByPrimaryKey(String orderNo);

    int updateByExampleSelective(@Param("record") XdOrder record, @Param("example") XdOrderExample example);

    int updateByExample(@Param("record") XdOrder record, @Param("example") XdOrderExample example);

    int updateByPrimaryKeySelective(XdOrder record);

    int updateByPrimaryKey(XdOrder record);
    
    
    
List<XdOrder> selectByLike(String name);	//模糊查询
	
	List<XdOrder> selectByLike2(XdOrderExample example);	//模糊查询
	
	List<XdOrder> selectByLike5(XdOrderExample example);	//模糊查询
	
	List<XdOrder> selectBypaging(XdOrderExample example);	//分页模糊查询
	
	List<XdOrder> selectBytime(XdOrderExample example);	//
	
	List<XdOrder> selectBytimepage(XdOrderExample example);	//
	
	List<XdOrder> selectByorderform(XdOrderExample example);	//
	
	List<XdOrder> selectByorderformpage(XdOrderExample example);	//
}