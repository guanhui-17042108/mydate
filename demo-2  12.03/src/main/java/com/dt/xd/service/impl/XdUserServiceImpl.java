package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdBoughtUserMapper;
import com.dt.xd.dao.mapper.XdEuserMapper;
import com.dt.xd.dao.mapper.XdOrder1Mapper;
import com.dt.xd.dao.mapper.XdOrderMapper;
import com.dt.xd.dao.mapper.XdProductMapper;
import com.dt.xd.dao.mapper.XdProviderProductMapper;
import com.dt.xd.dao.mapper.XdServiceUserMapper;
import com.dt.xd.dao.mapper.XdStoreMapper;
import com.dt.xd.dao.mapper.XdUserMapper;
import com.dt.xd.service.XdUserService;
import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;
import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdOrder1.XdOrder1Example;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdProduct.XdProductExample;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;
import com.dt.xd.xdStore.XdStore;
import com.dt.xd.xdUser.XdUser;
import com.dt.xd.xdUser.XdUserExample;

@Service
public class XdUserServiceImpl implements XdUserService{
	@Resource
	XdUserMapper xdUserMapper;
	@Resource
	XdProductMapper xdProductMapper;
	@Resource 
	XdServiceUserMapper xdServiceUserMapper;
	@Resource 
	XdStoreMapper xdStoreMapper;
	@Resource 
	XdOrder1Mapper xdOrder1Mapper;
	@Resource 
	XdEuserMapper xdEuserMapper;
	@Resource 
	XdBoughtUserMapper xdBoughtUserMapper;
	@Override
	public List<XdUser> ope_login(String phone) {
		XdUserExample xdUserExample=new XdUserExample();
		XdUserExample.Criteria criteria=xdUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		return xdUserMapper.selectByExample(xdUserExample);
	}

	
	  @Override public List<XdServiceUser> ser_login(String servicePhone){
	  XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
	  XdServiceUserExample.Criteria criteria=xdServiceUserExample.createCriteria();
	  criteria.andServicePhoneEqualTo(servicePhone); return
	  xdServiceUserMapper.selectByExample(xdServiceUserExample); }
	  
	  @Override public int ope_repassword(XdUser user) { XdUserExample
	  xdUserExample=new XdUserExample(); XdUserExample.Criteria
	  criteria=xdUserExample.createCriteria(); return
	  xdUserMapper.updateByExample(user, xdUserExample); }
	  
	  @Override public int ser_repassword(XdServiceUser serviceUser) {
	  XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
	  XdServiceUserExample.Criteria criteria=xdServiceUserExample.createCriteria();
	  return xdServiceUserMapper.updateByExample(serviceUser,
	  xdServiceUserExample); 
	  }
	 
	@Override
	public int insert(XdUser record) {
		return xdUserMapper.insert(record);
	}
	@Override
	public List<XdProduct> selectByExample(int pageStart, int pageSize, String username) {
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setDistinct(true);
		xdProductExample.setPageSize(pageSize);
		xdProductExample.setPageStart(pageStart);
		return xdProductMapper.selectByExample(xdProductExample,username);
	}
	@Override
	public long getCount() {
		XdProductExample xdProductExample=new XdProductExample();
		return xdProductMapper.countByExample();
	}
	@Override
	public int getCount(String username) {
		return xdProductMapper.getCount(username);
	}
	@Override
	public List<XdProduct> selectByName(int pageStart, int pageSize, String username) {
		XdProductExample xdProductExample=new XdProductExample();
		xdProductExample.setUsername(username);
		xdProductExample.setPageSize(pageSize);
		xdProductExample.setPageStart(pageStart);
		return xdProductMapper.selectByName(xdProductExample);
	}

	public int delete(XdProduct record) {
		
		return xdProductMapper.delete(record);
	}
	@Override
	public int updateImg(XdProduct xdProduct) {
		// TODO Auto-generated method stub
	 return xdProductMapper.updateByPrimaryKey(xdProduct);
	}
	@Override
	public XdProduct selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return xdProductMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(XdProduct record) {
		// TODO Auto-generated method stub
		return xdProductMapper.insert(record);
	}
	@Override
	public int deleteByPrimaryKey(String id) {
	//	List<> userList = deleteByPrimaryKey(id);
		int i= 0;
		//if(userList.size() !=0) {
			i=  xdProductMapper.deleteByPrimaryKey(id);
		//}
		return i;
	}
	@Override
	public int updateByPrimaryKeySelective(XdProduct record) {
		// TODO Auto-generated method stub
		return xdProductMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int insert(XdServiceUser record) {
		return xdServiceUserMapper.insert(record);
	}
	@Override
	public List<XdServiceUser> selectByExample(XdServiceUserExample example) {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		xdServiceUserExample.setDistinct(true);
		return xdServiceUserMapper.selectByExample(xdServiceUserExample);
	}
	@Override
	public List<XdServiceUser> getSystemUserById(String sysid) {
			XdServiceUserExample xdServiceExample = new XdServiceUserExample();
			XdServiceUserExample.Criteria criteria = xdServiceExample.createCriteria();
			criteria.andIdEqualTo(sysid);
			return xdServiceUserMapper.selectByExample(xdServiceExample);
		}
	@Override
	public int insert(XdStore xdStore) {
		// TODO Auto-generated method stub
		return xdStoreMapper.insert(xdStore);
	}
	@Override
	public List<XdServiceUser> selectByPhone(String servicePhone) {
		XdServiceUserExample xdServiceExample = new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria = xdServiceExample.createCriteria();
		criteria.andServicePhoneEqualTo(servicePhone);
		return xdServiceUserMapper.selectByPhone(xdServiceExample);
	}
	@Override
	public int updateByPrimaryKeySelective(XdServiceUser record) {
		// TODO Auto-generated method stub
		return xdServiceUserMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public XdServiceUser selectByPrimaryKeyS(String id) {
		// TODO Auto-generated method stub
		return xdServiceUserMapper.selectByPrimaryKeyS(id);
	}
	@Override
	public int updateById(XdServiceUser record) {
		// TODO Auto-generated method stub
		return xdServiceUserMapper.updateById(record);
	}
	@Override
	public long countByExampleO() {
		XdOrder1Example xdOrderExample=new XdOrder1Example();
		return xdOrder1Mapper.countByExampleO();
	}
	@Override
	public int getCountO(String orderNumber) {
		// TODO Auto-generated method stub
		return xdOrder1Mapper.getCountO(orderNumber);
	}
	@Override
	public List<XdOrder1> selectByNameO(int pageStart, int pageSize, String orderNumber) {
		XdOrder1Example xdOrderExample=new XdOrder1Example();
		xdOrderExample.setOrderNumber(orderNumber);;
		xdOrderExample.setPageSize(pageSize);
		xdOrderExample.setPageStart(pageStart);
			return xdOrder1Mapper.selectByExampleO(xdOrderExample, orderNumber);
	}
	@Override
	public List<XdOrder1> selectByExampleO(int pageStart, int pageSize, String orderNumber) {
		    XdOrder1Example xdOrderExample=new XdOrder1Example();
		    xdOrderExample.setDistinct(true);
		    xdOrderExample.setPageSize(pageSize);
		    xdOrderExample.setPageStart(pageStart);
			return xdOrder1Mapper.selectByExampleO(xdOrderExample, orderNumber);
	}
	@Override
	public int getCountU(String id) {
		// TODO Auto-generated method stub
		return xdBoughtUserMapper.getCountU(id);
	}
	@Override
	public List<XdBoughtUser> selectByNameU(int pageStart, int pageSize, String id) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		xdBoughtUserExample.setid(id);;
		xdBoughtUserExample.setPageSize(pageSize);
		xdBoughtUserExample.setPageStart(pageStart);
			return xdBoughtUserMapper.selectByExampleU(xdBoughtUserExample, id);
	}
	@Override
	public List<XdBoughtUser> selectByExampleU(int pageStart, int pageSize, String id) {
		// TODO Auto-generated method stub
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
	    xdBoughtUserExample.setDistinct(true);
	    xdBoughtUserExample.setPageSize(pageSize);
	    xdBoughtUserExample.setPageStart(pageStart);
		return xdBoughtUserMapper.selectByExampleU(xdBoughtUserExample, id);
	}
	@Override
	public long countByExampleU() {
		// TODO Auto-generated method stub
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		return xdBoughtUserMapper.countByExampleU();
	}
	@Override
	public long countByExampleS() {
		// TODO Auto-generated method stub
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		return xdServiceUserMapper.countByExampleS();
	}
	@Override
	public int getCountS(String serviceName) {
		// TODO Auto-generated method stub
		return xdServiceUserMapper.getCountS(serviceName);
	}
	@Override
	public List<XdServiceUser> selectByNameS(int pageStart, int pageSize, String serviceName) {
		// TODO Auto-generated method stub
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		xdServiceUserExample.setServiceName(serviceName);
		xdServiceUserExample.setPageSize(pageSize);
		xdServiceUserExample.setPageStart(pageStart);
			return xdServiceUserMapper.selectByNameS(xdServiceUserExample);
	}
	@Override
	public List<XdServiceUser> selectByExampleS(int pageStart, int pageSize, String serviceName) {
		// TODO Auto-generated method stub
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
	    xdServiceUserExample.setDistinct(true);
	    xdServiceUserExample.setPageSize(pageSize);
	    xdServiceUserExample.setPageStart(pageStart);
		return xdServiceUserMapper.selectByExampleS(xdServiceUserExample, serviceName);
	}
	@Override
	public List<XdOrder1> selectByExample9(int pageStart, int pageSize, String boughtUser) {
		// TODO Auto-generated method stub
		XdOrder1Example xdOrderExample=new XdOrder1Example();
	    xdOrderExample.setDistinct(true);
	    xdOrderExample.setPageSize(pageSize);
	    xdOrderExample.setPageStart(pageStart);
		return xdServiceUserMapper.selectByExample9(xdOrderExample, boughtUser);
	}
	@Override
	public int getCount9(String boughtUser) {
		// TODO Auto-generated method stub
		return xdOrder1Mapper.getCount9(boughtUser);
	}
	@Override
	public List<XdOrder1> selectByName9(int pageStart, int pageSize, String boughtUser) {
		// TODO Auto-generated method stub
		XdOrder1Example xdOrderExample=new XdOrder1Example();
		xdOrderExample.setBoughtUser(boughtUser);
		xdOrderExample.setPageSize(pageSize);
		xdOrderExample.setPageStart(pageStart);
			return xdOrder1Mapper.selectByExample9(xdOrderExample, boughtUser);
	}
	@Override
	public long countByExample9() {
		// TODO Auto-generated method stub
		XdOrder1Example xdOrderExample=new XdOrder1Example();
		return xdOrder1Mapper.countByExample9();
	}


	@Override
	public int updateById(XdStore record) {
		// TODO Auto-generated method stub
		return xdStoreMapper.updateById(record);
	}


	@Override
	public XdStore selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return xdStoreMapper.selectByPrimaryKey(id);
	}
	

	}
	
	
