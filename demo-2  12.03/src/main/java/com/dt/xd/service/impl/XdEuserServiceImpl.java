package com.dt.xd.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdEuserMapper;
import com.dt.xd.model.XdEuser;
import com.dt.xd.model.XdEuserExample;
import com.dt.xd.service.XdEuserService;
import com.dt.xd.util1.MD5Util;

@Service
public class XdEuserServiceImpl implements XdEuserService {

	@Resource
	XdEuserMapper xdEuserMapper;

	@Override
	public List<XdEuser> getList() {
		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		return xdEuserMapper.selectByExample(xdEuserExample);
	}
	// 通过id查

	@Override
	public List<XdEuser> getXdEuser(String id) {
		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		criteria.andIdEqualTo(id);
		return xdEuserMapper.selectByExample(xdEuserExample);
	}
	// 注册插入用户

	@Override
	public int register(HttpServletRequest request) {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		System.out.println("id==" + uuid);
		XdEuser m = new XdEuser();
		System.out.println("手机号" + request.getParameter("cellphone"));
		System.out.println("密码" + request.getParameter("password"));

		java.sql.Date ctime = new java.sql.Date(new java.util.Date().getTime());

		m.setRegisterTime(ctime);
		m.setId(uuid);
		m.setEuserName(request.getParameter("cellphone"));
		m.setCellphone(request.getParameter("cellphone"));
		m.setPassword(MD5Util.getMD5(request.getParameter("password").getBytes()));
		m.setStatus(1);
		m.setBuyNum(0);
		m.setTotalPrice(0);
		// m.setRegionId(request.getParameter("qu"));
		return xdEuserMapper.insert(m);

	}
	// 通过手机号查

	@Override
	public List<XdEuser> getcellphone(String id) {
		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		criteria.andCellphoneEqualTo(id);
		return xdEuserMapper.selectByExample(xdEuserExample);

	}

	// 修改密码
	@Override
	public int updatepassword(XdEuser xdEuser, HttpServletRequest request) {
		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		return xdEuserMapper.updateByExampleSelective(xdEuser, xdEuserExample);
	}

	@Override
	public List<XdEuser> getXdEuserInfoById(HttpServletRequest request) {
		System.out.println("查询前");
		System.out.println("输入的手机号==" + request.getParameter("cellphone"));
		System.out.println("输入的密码==" + request.getParameter("password"));
		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		criteria.andCellphoneEqualTo(request.getParameter("cellphone"));
		criteria.andPasswordEqualTo(request.getParameter("password"));
		System.out.println("查询结束");
		return xdEuserMapper.selectByExample(xdEuserExample);
	}

	// 模糊查询分页

	@Override
	public List<XdEuser> selectpaging(HttpServletRequest request) {

		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		xdEuserExample.setLikeName(request.getParameter("euserName"));
		xdEuserExample.setPageSize((Integer.valueOf(request.getParameter("pageSize")) - 1) * 2);
		System.out.println("getPageSize" + xdEuserExample.getPageSize());
		xdEuserExample.setPageNum(Integer.valueOf(request.getParameter("pageNum")));
		System.out.println("getPageNum" + xdEuserExample.getPageNum());
		return xdEuserMapper.selectBypaging(xdEuserExample);
	}

	// 模糊查询

	@Override
	public List<XdEuser> select(HttpServletRequest request) {

		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		xdEuserExample.setLikeName(request.getParameter("euserName"));
		return xdEuserMapper.selectByLike(xdEuserExample);
	}

	// 修改旧密码
	@Override
	public int updatepassword1(XdEuser xdEuser, HttpServletRequest request) {

		XdEuserExample xdEuserExample = new XdEuserExample();
		XdEuserExample.Criteria criteria = xdEuserExample.createCriteria();
		criteria.andIdEqualTo(request.getParameter("userid"));
		criteria.andPasswordEqualTo(MD5Util.getMD5(request.getParameter("password").getBytes()));
		return xdEuserMapper.updateByExampleSelective(xdEuser, xdEuserExample);
	}
/////////////////////////////////////// 修改账户信息

	@Override
	public int updatexx(HttpServletRequest request) {
		XdEuser xdEuser = new XdEuser();
		xdEuser.setId(request.getParameter("userid"));
		xdEuser.setEuserName(request.getParameter("euserName"));
		xdEuser.setEmail(request.getParameter("email"));
		xdEuser.setGender(Integer.valueOf(request.getParameter("sex")));
		return xdEuserMapper.updateByPrimaryKeySelective(xdEuser);
	}

	///////////////////////////////// 保存头像

	@Override
	public void saveUserImg(XdEuser xdEuser) throws Exception {

		int i = xdEuserMapper.saveUserImg(xdEuser);
		if (i != 1) {
			throw new Exception("更新用户头像失败");
		}
	}

	////////////////////////// 显示图片用
	@Override
	public XdEuser getUserInfo(String id) {
		return xdEuserMapper.selectByPrimaryKey(id);
	}
	
	
	
	
	

}
