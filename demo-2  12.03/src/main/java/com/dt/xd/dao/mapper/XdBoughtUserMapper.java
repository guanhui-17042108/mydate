package com.dt.xd.dao.mapper;

import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdBoughtUserMapper {
int updateBy(String password1, String phone);
	
	int updateByExample();

	long countByExample();
	
	int getCount(@Param("userName") String userName);
	
	List<XdBoughtUser> selectByUserName(XdBoughtUserExample example);
	long countByExampleU();
	int getCountU(@Param("id") String id);
	List<XdBoughtUser> selectByNameU(XdBoughtUserExample example);
	List<XdBoughtUser> selectByExampleU(@Param("example") XdBoughtUserExample example, @Param("id") String id);
	
	long countByExample(XdBoughtUserExample example);

    int deleteByExample(XdBoughtUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdBoughtUser record);

    int insertSelective(XdBoughtUser record);

    List<XdBoughtUser> selectByExample(XdBoughtUserExample example);

    XdBoughtUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdBoughtUser record, @Param("example") XdBoughtUserExample example);

    int updateByExample(@Param("record") XdBoughtUser record, @Param("example") XdBoughtUserExample example);

    int updateByPrimaryKeySelective(XdBoughtUser record);

    int updateByPrimaryKey(XdBoughtUser record);
}