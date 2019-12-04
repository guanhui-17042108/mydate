package com.dt.xd.dao.mapper;

import com.dt.xd.model.XdEuser;
import com.dt.xd.model.XdEuserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdEuserMapper {
    long countByExample(XdEuserExample example);

    int deleteByExample(XdEuserExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdEuser record);

    int insertSelective(XdEuser record);

    List<XdEuser> selectByExampleWithBLOBs(XdEuserExample example);

    List<XdEuser> selectByExample(XdEuserExample example);

    XdEuser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdEuser record, @Param("example") XdEuserExample example);

    int updateByExampleWithBLOBs(@Param("record") XdEuser record, @Param("example") XdEuserExample example);

    int updateByExample(@Param("record") XdEuser record, @Param("example") XdEuserExample example);

    int updateByPrimaryKeySelective(XdEuser record);

    int updateByPrimaryKeyWithBLOBs(XdEuser record);

    int updateByPrimaryKey(XdEuser record);

	int saveUserImg(XdEuser record);
	
	List<XdEuser> selectByLike(XdEuserExample example);	//模糊查询
	
	List<XdEuser> selectBypaging(XdEuserExample example);	//分页模糊查询
}