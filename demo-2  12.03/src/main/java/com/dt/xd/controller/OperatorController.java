package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.service.XdUserService;
import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdOrder1.XdOrder1;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdUser.XdUser;

@Controller
public class OperatorController {
	@Resource
	XdUserService xdUserService;
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("phone"));
		System.out.println("getCommodity====" + request.getParameter("password"));
		int code1 = 0;
		String phone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(imgcode + "=====" + code + "===");
		if (imgcode.toUpperCase().equals(code)) {
			List<XdUser> loginList = xdUserService.ope_login(phone);
			XdUser password = loginList.get(0);
			if (password.getPassword().equals(request.getParameter("password"))) {
				code1 = 1;
				map.put("code", code1);
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/repassword", method = RequestMethod.POST)
	public Map<String, Object> repassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("phone"));
		String phone = request.getParameter("phone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<XdUser> loginList = xdUserService.ope_login(phone);
			XdUser password = loginList.get(0);
			XdUser user = new XdUser();
			user.setId(password.getId());
			user.setPhone(password.getPhone());
			user.setPassword(request.getParameter("password"));
			user.setHeadImg(password.getHeadImg());
			user.setEmail(password.getEmail());
			user.setName(password.getName());
			user.setStatus(password.getStatus());
			user.setTs(password.getTs());
			if (request.getParameter("password").equals(request.getParameter("password1"))) {
				xdUserService.ope_repassword(user);
				code1 = 1;
				map.put("code", code1);
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}
	@RequestMapping("/fenyelikeO")
	// @RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String fenyelikeO(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "") String username) {
		List<XdProduct> xdProductList = xdUserService.selectByName(pageStart, pageSize, username);
		long count = 0;
		if (username.equals("") || username == null)
			count = xdUserService.getCount();
		else
			count = xdUserService.getCount(username);
		map.put("count", count);
		map.put("xdProductList", xdProductList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("username", username);
		return "operator_product";
	}
	@RequestMapping("/fenyelikeT")
	// @RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String fenyelikeT(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "") String orderNumber) {
		List<XdOrder1> xdOrderList = xdUserService.selectByNameO(pageStart, pageSize, orderNumber);
		long count = 0;
		if (orderNumber.equals("") || orderNumber == null) {
			count = xdUserService.getCountO(orderNumber);
		}
		else 
			count = xdUserService.getCountO(orderNumber);
		map.put("count", count);
		map.put("xdOrderList", xdOrderList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("orderNumber", orderNumber);
		return "operator_orderform";
	}
	@RequestMapping("/fenyelikeU")
	public String fenyelikeU(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "") String id) {
		List<XdBoughtUser> xdBoughtUserList = xdUserService.selectByNameU(pageStart, pageSize, id);
		
		long count = 0;
		if (id.equals("") || id == null) {
			count = xdUserService.getCountU(id);
		}
		else 
			count = xdUserService.getCountU(id);
		map.put("count", count);
		map.put("xdBoughtUserList", xdBoughtUserList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("id", id);
		return "operator_user";
	}
	@RequestMapping("/fenyelikeH")
	public String fenyelikeS(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "") String serviceName) {
		List<XdServiceUser> xdServiceUserList = xdUserService.selectByNameS(pageStart, pageSize, serviceName);
		System.out.println(xdServiceUserList.get(0).getServiceName());
		long count = 0;
		if (serviceName.equals("") || serviceName == null) {
			count = xdUserService.getCountS(serviceName);
		}
		else 
			count = xdUserService.getCountS(serviceName);
		map.put("count", count);
		map.put("xdServiceUserList", xdServiceUserList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("serviceName", serviceName);
		return "operator_facilitator";
	} 
	@RequestMapping("/fenyelike9")
	public String fenyelike9(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "") String boughtUser) {
		List<XdOrder1> xdOrderList = xdUserService.selectByName9(pageStart, pageSize, boughtUser);
		
		long count = 0;
		if (boughtUser.equals("") || boughtUser == null) {
			count = xdUserService.getCount9(boughtUser);
		}
		else 
			count = xdUserService.getCount9(boughtUser);
		map.put("count", count);
		map.put("xdOrderList", xdOrderList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("boughtUser", boughtUser);
		return "operator_expenses";
	}
	@RequestMapping("/deleteO")
	  public String deleteByPrimaryKeyOperator(String id) {
		  int i=xdUserService.deleteByPrimaryKey(id);
		  System.out.println("i="+i+id);
		  if(i==1)
			  return "redirect:/fenyelikeO";
		  else
			  return "fail";
	  }
	@RequestMapping("/updateO")
	public String updateByPrimaryKey(XdProduct xdProduct) {
	  System.out.println("-----i----");
		int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		if (i == 1)
			return "redirect:/fenyelikeO";
		else
			return "fail";
	}
  @RequestMapping("/selectO")
	public String select(Model model ,String id)throws Exception {
		XdProduct xdProduct = xdUserService.selectByPrimaryKey(id);
		// int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		model.addAttribute("xdProduct",xdProduct);
		return "update_operator";
	}
  @RequestMapping("/findpassword")
  public String operatorFindpassword () {
  return "operator_findpassword";
}
  @RequestMapping("/recommend")
  public String operatorRecommend () {
  return "operator_recommend";
}
}
