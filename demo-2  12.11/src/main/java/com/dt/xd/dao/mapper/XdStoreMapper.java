package com.dt.xd.dao.mapper;

import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdStore.XdStore;
import com.dt.xd.xdStore.XdStoreExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdStoreMapper {
    long countByExample(XdStoreExample example);

    int deleteByExample(XdStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XdStore record);

    int insertSelective(XdStore record);

    List<XdStore> selectByExample(XdStoreExample example);

    XdStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XdStore record, @Param("example") XdStoreExample example);

    int updateByExample(@Param("record") XdStore record, @Param("example") XdStoreExample example);

    int updateByPrimaryKeySelective(XdStore record);

    int updateByPrimaryKey(XdStore record);
    int updateById(XdStore record);

}