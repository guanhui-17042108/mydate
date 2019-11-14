package com.dt.xd.controller;

import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.InputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dt.xd.service.XdUserService;
import com.dt.xd.service.impl.XdUserServiceImpl;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdUser.XdUser;

@Controller
public class PublicController {
	@Resource
	XdUserService xdUserService;
/**
 * 三个模块中的登录
 * @param request
 * @return
 */
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
/**
 * 三个模块中的注册
 * @param request
 * @return
 */
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
/**
 * 三个模块中的忘记密码
 * @param request
 * @return
 */
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			XdUser user = new XdUser();
			user.setId(id);
			user.setPhone(phone);
			user.setPassword(password);
			xdUserService.insert(user);
			code1 = 1;
			map.put("code", code1);
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}
/**
 * 服务商中的service_product页面的模糊分页查询
 * @param map
 * @param pageStart
 * @param pageSize
 * @param username
 * @param id
 * @return
 */
	@RequestMapping("/fenyelike") // @RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String fenyelike(Map<String, Object> map,

			@RequestParam(defaultValue = "0") int pageStart,

			@RequestParam(defaultValue = "2") Integer pageSize,

			@RequestParam(defaultValue = "") String username, String id) {
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
		return "service_product";
	}
/**
 * 服务商中service_orderform页面的模糊分页查询
 * @param map
 * @param pageStart
 * @param pageSize
 * @param username
 * @param id
 * @return
 */
	@RequestMapping("/fenyelikeS") 
	public String fenyelikeS(Map<String, Object> map,

			@RequestParam(defaultValue = "0") int pageStart,

			@RequestParam(defaultValue = "2") Integer pageSize,

			@RequestParam(defaultValue = "") String username, String id) {
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
		return "service_orderform";
	}
/**
 * 电子商务中e-commerce_product页面的模糊分页查询
 * @param map
 * @param pageStart
 * @param pageSize
 * @param username
 * @return
 */
	@RequestMapping("/fenyelikeE")
	public String fenyelike(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
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
		return "e-commerce_product";
	}
@ResponseBody
	@RequestMapping(value = "/shoping", method = RequestMethod.POST)
	public Map<String, Object> shoping() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdShopping> xdShoppingList = xdShoppingService.selectAll();
		map.put("xdShoppingList", xdShoppingList);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/shop", method = RequestMethod.POST)
	public Map<String, Object> shop(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdShopping> xdShoppingList = xdShoppingService.selectAll();
		int str = Integer.parseInt(request.getParameter("coco"))+1;
		String st = Integer.toString(str);
		XdShopping user = new XdShopping();
		user.setId(st);
		user.setCount(2);
		user.setProId(Integer.parseInt(request.getParameter("id")));
		int i = xdShoppingService.insertShopping(user);
		map.put("code", i);
		map.put("xdShoppingList", xdShoppingList);
		return map;
	}
@RequestMapping("/loadimg")
	public String loadimg() {
		return "upfile";
	}
	@RequestMapping(value="/upfile")
	public ModelAndView saveUserImg(MultipartFile file,Integer id) {
		Map<Object,Object> result = new HashMap<Object,Object>();
//		HttpSession session = request.getSession();
//		Integer id = (Integer) session.getAttribute("id");
		try {
		// 获取客户端传图图片的输入流
		InputStream ins = file.getInputStream();
		byte[] buffer=new byte[1024];//bit---byte---1k---1m
		int len=0;
		 // 字节输出流
		 ByteArrayOutputStream bos=new ByteArrayOutputStream();
		while((len=ins.read(buffer))!=-1){
			bos.write(buffer,0,len);
		 }
		 bos.flush();
		byte data[] = bos.toByteArray();
		// 调用接口对图片进行存储
		XdProduct xdProduct = new XdProduct();
		xdProduct.setId(id);
		xdProduct.setImg(data);
		xdUserService.updateImg(xdProduct);
				            
		result.put("code",1);
		} catch (Exception e) {
			//return "error";
		 }				
		return new ModelAndView("redirect:/fenyelike");	
	}

	@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(Integer id) throws Exception{
		byte[] imageContent ;
		// 根据id获取当前用户的信息
		XdProduct xdUser = xdUserService.selectByPrimaryKey(id);
				        
		imageContent = xdUser.getImg();
				        
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	@RequestMapping("/e_shoppingcar")
	//@RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String e_shoppingcar(Map<String,Object> map,
			@RequestParam(defaultValue="0")int pageStart,
			@RequestParam(defaultValue="3") Integer pageSize,
			@RequestParam(defaultValue="")String id) {
		List<XdShopping> xdShoppingList = xdShoppingService.selectById(pageStart,pageSize,id);
		long count=0;
		if(id.equals("")||id==null)
			count=xdShoppingService.getCount();
		else 
			count=xdShoppingService.getCount(id);
		map.put("count", count);
		map.put("xdShoppingList", xdShoppingList);
		map.put("pageStart", pageStart);
		map.put("pageSize",pageSize);
		map.put("id", id);
		return  "e-commerce_shoping-car";
		}
        @ResponseBody
	@RequestMapping(value = "/e_delete"
/**
 * 运营商中operator_product得模糊查询分页
 * @param map
 * @param pageStart
 * @param pageSize
 * @param username
 * @return
 */
	@RequestMapping("/fenyelikeO")
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
	/**
	 * 服务商中service_product中添加服务产品
	 * @param map
	 * @param xdproduct
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(Map<String, Object> map, XdProduct xdproduct) {

		int i = xdUserService.insert(xdproduct);

		if (i == 1) {
			return "insert_success";
		} else {
			return "fail";
		}
	}
	/**
	 * 服务商中servcie_product页面的删除功能
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteByPrimaryKey(String id) {
		// xdUserService x = new xdUserServiceImpl();
		int i = xdUserService.deleteByPrimaryKey(id);
		if (i == 1)
			return "delete_success";
		else
			return "fail";
	}
	/**
	 * 运营商中operator_product中的删除功能
	 * @param id
	 * @return
	 */
	  @RequestMapping("/deleteO")
	  public String deleteByPrimaryKeyOperator(String id) {
		  int i=xdUserService.deleteByPrimaryKey(id);
		  if(i==1)
			  return "delete_success";
		  else
			  return "fail";
	  }
/**
 * 服务商中service_product中的修改功能
 * @param xdProduct
 * @return
 */
	@RequestMapping("/update")
	public String updateByPrimaryKey(XdProduct xdProduct) {
		int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		if (i == 1)
			return "update_success";
		else
			return "fail";
	}

	@RequestMapping("/select")
	public String select(Map<String, Object> map, String id) {
		XdProduct xdProduct = xdUserService.selectByPrimaryKey(id);
		// int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		if (xdProduct != null) {
			map.put("xdProduct", xdProduct);
			return "update_xdproduct";
		} else
			return "fail";
	}
	/**
	 * 服务商中service_store的插入公司信息的功能
	 * @param map
	 * @param xdServiceUser
	 * @return
	 */
	@RequestMapping("/insertStore")
	public String insertStore(Map<String, Object> map, XdServiceUser xdServiceUser) {

		int i = xdUserService.insert(xdServiceUser);

		if (i == 1) {
			return "insert_success";
		} else {
			return "fail";
		}
	}

	/**
	 * 从控制器跳转各个页面
	 * @return
	 */
	@RequestMapping("/expense")
	public String  expense(){
		return "service_expenses";
	}
	@RequestMapping("/store")
	public String store() {
		return "service_store";
	}
	@RequestMapping("/setting")
	public String setting() {
		return "service_setting";
	}
	  @RequestMapping("/product")
	  public String operatorProduct () {
	  return "operator_product";
    }
	  @RequestMapping("/expenses")
	  public String operatorExpenses () {
	  return "operator_expenses";
    }
	  @RequestMapping("/findpassword")
	  public String operatorFindpassword () {
	  return "operator_findpassword";
    }
	  @RequestMapping("/orderform")
	  public String operatorOrderform () {
	  return "operator_orderform";
    }
	  @RequestMapping("/recommend")
	  public String operatorRecommend () {
	  return "operator_recommend";
    }
	  @RequestMapping("/user")
	  public String operatorUser () {
	  return "operator_user";
    }
	  @RequestMapping("/facilitator")
	  public String facilitator() {
		  return"operator_facilitator";
	  }
}
