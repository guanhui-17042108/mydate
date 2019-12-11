package com.dt.xd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;
import com.dt.xd.xdStore.XdStore;
import com.dt.xd.xdUser.XdUser;
import com.dt.xd.xdUser.XdUserExample;

public interface XdUserService {

	public List<XdUser> ope_login(String phone);
	public List<XdServiceUser> ser_login(String servicePhone);

	public int ope_repassword(XdUser user);
	public int ser_repassword(XdServiceUser serviceUser);

	int deleteByPrimaryKey(String id);
	
	int updateByPrimaryKeySelective(XdProduct record);
	
	int insert(XdUser record);
	
	List<XdProduct> selectByExample(int pageStart, int pageSize, String username);

	public long getCount();

	int getCount(String username);

	List<XdProduct> selectByName(int pageStart, int pageSize, String username);
	int insert(XdProduct record);
	int updateImg(XdProduct xdProduct);
	XdProduct selectByPrimaryKey(String id);

	int delete(XdProduct record);
	int insert(XdServiceUser record);
	 List<XdServiceUser> selectByExample(XdServiceUserExample example);

	public List<XdServiceUser> getSystemUserById(String sysid);
	public int insert(XdStore xdStore);
	List<XdServiceUser> selectByPhone(String servicePhone);
    int updateByPrimaryKeySelective(XdServiceUser record);
    XdServiceUser selectByPrimaryKeyS(String id);
    int updateById(XdServiceUser record);
    int updateById(XdStore record);
    XdStore selectByPrimaryKey(Integer id);
    
    long countByExampleO();
	int getCountO(@Param("orderNumber") String orderNumber);
	List<XdOrder1> selectByNameO(int pageStart, int pageSize, String orderNumber);
	List<XdOrder1> selectByExampleO(int pageStart, int pageSize, String orderNumber);

	long countByExampleU();
	int getCountU(@Param("id") String id);
	List<XdBoughtUser> selectByNameU(int pageStart, int pageSize, String id);
	List<XdBoughtUser> selectByExampleU(int pageStart, int pageSize, String id);

	long countByExampleS();
	int getCountS(@Param("serviceName") String serviceName);
	List<XdServiceUser> selectByNameS(int pageStart, int pageSize, String serviceName);
	List<XdServiceUser> selectByExampleS(int pageStart, int pageSize, String serviceName);

	long countByExample9();
	int getCount9(@Param("boughtUser") String boughtUser);
	List<XdOrder1> selectByName9(int pageStart, int pageSize, String boughtUser);
	List<XdOrder1> selectByExample9(int pageStart, int pageSize, String boughtUser);

}
