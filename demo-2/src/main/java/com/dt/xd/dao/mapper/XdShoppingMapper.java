package com.dt.xd.dao.mapper;

import com.dt.xd.xdShopping.XdShopping;
import com.dt.xd.xdShopping.XdShoppingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XdShoppingMapper {
    long countByExample(XdShoppingExample example);

    int deleteByExample(XdShoppingExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdShopping record);

    int insertSelective(XdShopping record);

    List<XdShopping> selectByExample(XdShoppingExample example);

    XdShopping selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdShopping record, @Param("example") XdShoppingExample example);

    int updateByExample(@Param("record") XdShopping record, @Param("example") XdShoppingExample example);

    int updateByPrimaryKeySelective(XdShopping record);

    int updateByPrimaryKey(XdShopping record);
}