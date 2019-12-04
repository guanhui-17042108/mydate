package com.dt.xd.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.model.XdEuser;
import com.dt.xd.service.XdEuserService;
import com.dt.xd.util1.ImgCodeUtil;
import com.dt.xd.util1.MD5Util;


@Controller
public class XdEuserController {
	@Resource
	XdEuserService mService;
	@RequestMapping("/redirect")
	public String page(HttpServletRequest request) {
		String url = request.getParameter("page");
		return url;
	}

	@RequestMapping("/imgGetCode")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 调用工具类生成的验证码和验证码图片
		Map<String, Object> codeMap = ImgCodeUtil.generateCodeAndPic();

		// 将四位数字的验证码保存到Session中。
		HttpSession session = req.getSession();
		session.setAttribute("code", codeMap.get("code").toString());

		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no	-cache");
		resp.setDateHeader("Expires", -1);

		resp.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos;
		try {
			sos = resp.getOutputStream();
			ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
			sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@ResponseBody		//注册
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public Map<String,Object> register(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getParameter("cellphone").isEmpty()) {
			map.put("msg","输入手机号" );
			return map;
		}
		if(request.getParameter("password").isEmpty()) {
			map.put("msg","输入密码" );
			return map;
		}
		if(request.getParameter("code").isEmpty()) {
			map.put("msg","输入验证码" );
			return map;
		}
		HttpSession session = request.getSession();
		
	
		System.out.println("验证码"+session.getAttribute("code"));
		if(!session.getAttribute("code").equals(request.getParameter("code").toUpperCase())) {
			map.put("msg","验证码错误" );
			return map;
		}
		
		List<XdEuser> member=mService.getcellphone(request.getParameter("cellphone"));
		if(!member.isEmpty()) {
			map.put("msg","手机号已存在" );
			return map;
		}
		int a = mService.register(request);		
		map.put("msg", "注册成功");
		map.put("status", 1);
		return map;
	}
	
	//用户找回密码
	@ResponseBody
	@RequestMapping(value = "/findpassword",method = RequestMethod.POST)
	public Map <String,Object> findPassword(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		XdEuser member=new XdEuser();
		
		if(request.getParameter("cellphone").isEmpty()) {
			map.put("msg","输入手机号" );
			return map;
		}
		if(request.getParameter("code").isEmpty()) {
			map.put("msg","输入验证码" );
			return map;
		}
		if(request.getParameter("password1").isEmpty()) {
			map.put("msg","输入密码" );
			return map;
		}
		if(request.getParameter("password2").isEmpty()) {
			map.put("msg","再输入密码" );
			return map;
		}
		if(!request.getParameter("password1").equals(request.getParameter("password2"))) {
			map.put("msg","两次密码不一致");
			return map;
		}
		member.setCellphone(request.getParameter("cellphone"));
		member.setPassword(MD5Util.getMD5(request.getParameter("password1").getBytes()));
		int a=mService.updatepassword(member, request);
		map.put("stu", a);
		if(a==1) {
		map.put("msg", "修改成功");
		}else {
			map.put("msg", "账号不存在");
		}
		return map;
	}
	

}
