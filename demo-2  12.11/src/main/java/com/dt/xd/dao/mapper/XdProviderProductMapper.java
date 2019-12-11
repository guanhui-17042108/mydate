package com.dt.xd.dao.mapper;

import com.dt.xd.model.XdProviderProduct;
import com.dt.xd.model.XdProviderProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdProviderProductMapper {
    long countByExample(XdProviderProductExample example);

    int deleteByExample(XdProviderProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdProviderProduct record);

    int insertSelective(XdProviderProduct record);

    List<XdProviderProduct> selectByExampleWithBLOBs(XdProviderProductExample example);

    List<XdProviderProduct> selectByExample(XdProviderProductExample example);

    XdProviderProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdProviderProduct record, @Param("example") XdProviderProductExample example);

    int updateByExampleWithBLOBs(@Param("record") XdProviderProduct record, @Param("example") XdProviderProductExample example);

    int updateByExample(@Param("record") XdProviderProduct record, @Param("example") XdProviderProductExample example);

    int updateByPrimaryKeySelective(XdProviderProduct record);

    int updateByPrimaryKeyWithBLOBs(XdProviderProduct record);

    int updateByPrimaryKey(XdProviderProduct record);
    
    
	
	  List<XdProviderProduct> selectByLike(String name); //模糊查询
	  
	  
	  List<XdProviderProduct> selectByAll(XdProviderProductExample example); //排序
	  
	  List<XdProviderProduct> selectByAll2(XdProviderProductExample example); //排序
	  
	  List<XdProviderProduct> selectBypaging(XdProviderProductExample example);
	  //排序分页
	  
	 
	int saveProductImg(XdProviderProduct providerProduct);

}