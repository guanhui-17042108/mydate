package com.dt.xd.dao.mapper;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;
import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdOrder1.XdOrder1Example;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdServiceUserMapper {
int updateBy(String servicePassword1,String servicePhone);
	
    long countByExample();
    
    int getCount(@Param("serviceName") String serviceName);
    
    List<XdServiceUser> selectByName(XdServiceUserExample example);
	long countByExampleS();
	int getCountS(@Param("serviceName") String serviceName);
	List<XdServiceUser> selectByNameS(XdServiceUserExample example);
	List<XdServiceUser> selectByExampleS(@Param("example") XdServiceUserExample example, @Param("serviceName") String serviceName);
	List<XdOrder1> selectByExample9(XdBoughtUserExample xdBoughtUserExample, String boughtUser);
	List<XdOrder1> selectByExample9(XdOrder1Example xdOrderExample, String boughtUser);
	List<XdServiceUser> selectByPhone(XdServiceUserExample example);
    long countByExample(XdServiceUserExample example);

    int deleteByExample(XdServiceUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdServiceUser record);

    int insertSelective(XdServiceUser record);

    List<XdServiceUser> selectByExample(XdServiceUserExample example);

    XdServiceUser selectByPrimaryKeyS(String id);

    int updateByExampleSelective(@Param("record") XdServiceUser record, @Param("example") XdServiceUserExample example);

    int updateByExample(@Param("record") XdServiceUser record, @Param("example") XdServiceUserExample example);

    int updateByPrimaryKeySelective(XdServiceUser record);

    int updateByPrimaryKey(XdServiceUser record);
    int updateById(XdServiceUser record);
    int updateForImg(XdServiceUser record);
    XdServiceUser selectByPrimaryKey(String id);
    List<XdServiceUser> select();


}