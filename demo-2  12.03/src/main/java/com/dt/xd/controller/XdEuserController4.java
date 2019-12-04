package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.model.XdEuser;
import com.dt.xd.service.XdEuserService;
import com.dt.xd.util1.MD5Util;

@Controller
@RequestMapping("/login")
public class XdEuserController4 {
	

	@Resource
	XdEuserService memberService;
	// 登录
	@ResponseBody
	@RequestMapping(value = "/dl", method = RequestMethod.POST)
	public Map<String, Object> memberLogin(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String cellphone = request.getParameter("cellphone");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		if (request.getParameter("cellphone").isEmpty()) {
			map.put("msg", "手机号为空");
			return map;
		}
		if (password.isEmpty()) {
			map.put("msg", "密码为空");
			return map;
		}
		if (request.getParameter("code").isEmpty()) {
			map.put("msg", "验证码为空");
			return map;
		}
		HttpSession session = request.getSession();
		if (!session.getAttribute("code").equals(request.getParameter("code").toUpperCase())) {
			map.put("msg", "验证码错误");
			return map;
		}

		List<XdEuser> memberInfo = memberService.getcellphone(request.getParameter("cellphone"));
		if (memberInfo.isEmpty()) {
			map.put("msg", "帐号不存在");
			return map;
		} else if (!memberInfo.get(0).getPassword()
				.equals(MD5Util.getMD5(request.getParameter("password").getBytes()))) {
			map.put("msg", "密码错误");
			return map;
		} else {
			map.put("code", 1);
			map.put("msg", "恭喜登录成功");
		}
		map.put("username", memberInfo.get(0).getEuserName());
		map.put("userid", memberInfo.get(0).getId());
		return map;
	}

	// 用户修改新密码
	@ResponseBody
	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public Map<String, Object> findPassword(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		XdEuser member = new XdEuser();
		if (request.getParameter("password").isEmpty()) {
			map.put("msg", "输入旧密码");
			return map;
		}

		if (request.getParameter("password1").isEmpty()) {
			map.put("msg", "输入密码");
			return map;
		}
		if (request.getParameter("password2").isEmpty()) {
			map.put("msg", "再输入密码");
			return map;
		}
		if (!request.getParameter("password1").equals(request.getParameter("password2"))) {
			map.put("msg", "两次密码不一致");
			return map;
		}

		member.setPassword(MD5Util.getMD5(request.getParameter("password1").getBytes()));
		int a = memberService.updatepassword1(member, request);
		map.put("data", a);
		if (a == 1) {
			map.put("code", 1);
			map.put("msg", "修改成功");
		} else {
			map.put("msg", "旧密码错误");
		}
		return map;
	}

}
