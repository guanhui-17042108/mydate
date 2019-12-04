package com.dt.xd.dao.mapper;

import com.dt.xd.model.XdCart;
import com.dt.xd.model.XdCartExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdCartMapper {
    long countByExample(XdCartExample example);

    int deleteByExample(XdCartExample example);

    int insert(XdCart record);

    int insertSelective(XdCart record);

    List<XdCart> selectByExample(XdCartExample example);

    int updateByExampleSelective(@Param("record") XdCart record, @Param("example") XdCartExample example);

    int updateByExample(@Param("record") XdCart record, @Param("example") XdCartExample example);
}