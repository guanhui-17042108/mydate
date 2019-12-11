package com.dt.xd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dt.xd.model.XdEuser;


public interface XdEuserService {
	public List<XdEuser> getList();
	public List<XdEuser> getXdEuser(String id);
	public int register(HttpServletRequest request);
	List<XdEuser> getcellphone(String id);
	public int updatepassword(XdEuser xdEuser,HttpServletRequest request);
	public List<XdEuser> getXdEuserInfoById(HttpServletRequest request);
	List<XdEuser> selectpaging(HttpServletRequest request);
	List<XdEuser> select(HttpServletRequest request);

	public int updatepassword1(XdEuser xdEuser,HttpServletRequest request);

	public XdEuser getUserInfo(String id);
	int updatexx(HttpServletRequest request);
	public void saveUserImg(XdEuser xdEuser) throws Exception;


}
