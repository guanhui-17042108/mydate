package com.dt.xd.controller;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.InputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.dt.xd.service.XdUserService;
import com.dt.xd.service.impl.XdUserServiceImpl;
import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;
import com.dt.xd.xdStore.XdStore;
import com.dt.xd.xdUser.XdUser;

@Controller
public class PublicController {
	@Resource
	XdUserService xdUserService;

	/*
	 * 服务商登录
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/loginService", method = RequestMethod.POST)
	public Map<String, Object> loginService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		int code1 = 0;
		String servicePhone = request.getParameter("servicePhone");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(imgcode + "=====" + code + "===");
		if (imgcode.toUpperCase().equals(code)) {
			List<XdServiceUser> loginServiceList = xdUserService.ser_login(servicePhone);
			XdServiceUser servicePassword = loginServiceList.get(0);
			session.setAttribute("serviceUser", servicePassword);
			if (servicePassword.getServicePassword().equals(request.getParameter("servicePassword"))) {
				code1 = 1;
				map.put("code", code1);
				map.put("id", servicePassword.getId());
				map.put("serviceName", servicePassword.getServiceName());
				map.put("cmbProvince", servicePassword.getCmbProvince());
				map.put("cmbCity", servicePassword.getCmbCity());
				map.put("cmbArea", servicePassword.getCmbArea());
				map.put("servicePhone", servicePassword.getServicePhone());
				map.put("qq", servicePassword.getQq());
				map.put("email", servicePassword.getEmail());
				map.put("wechat", servicePassword.getWechat());
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		return map;
	}

	/*
	 * 服务商忘记密码
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/repasswordService", method = RequestMethod.POST)
	public Map<String, Object> repasswordService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("servicePhone"));
		String servicePhone = request.getParameter("servicePhone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<XdServiceUser> loginServiceList = xdUserService.ser_login(servicePhone);
			XdServiceUser servicePassword = loginServiceList.get(0);
			XdServiceUser serviceUser = new XdServiceUser();
			serviceUser.setServicePhone(servicePassword.getServicePhone());
			serviceUser.setServicePassword(request.getParameter("servicePassword"));
			serviceUser.setIntroduction(servicePassword.getIntroduction());
			serviceUser.setStatus(servicePassword.getStatus());
			serviceUser.setEmail(servicePassword.getEmail());
			serviceUser.setTs(servicePassword.getTs());
			serviceUser.setSynopsis(servicePassword.getSynopsis());
			serviceUser.setWorktime(servicePassword.getWorktime());
			serviceUser.setQq(servicePassword.getQq());
			serviceUser.setWechat(servicePassword.getWechat());
			serviceUser.setCustomPhone(servicePassword.getCustomPhone());
			serviceUser.setLicense(servicePassword.getLicense());
			if (request.getParameter("servicePassword").equals(request.getParameter("servicePassword1"))) {
				xdUserService.ser_repassword(serviceUser);
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

	/*
	 * 服务商注册
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/registerService", method = RequestMethod.POST)
	public Map<String, Object> registerService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String id = request.getParameter("id");
		String servicePhone = request.getParameter("servicePhone");
		String servicePassword = request.getParameter("servicePassword");
		String cmbProvince = request.getParameter("cmbProvince");
		String cmbCity = request.getParameter("cmbCity");
		String cmbArea = request.getParameter("cmbArea");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			XdServiceUser xdServiceUser = new XdServiceUser();
			xdServiceUser.setId(id);
			xdServiceUser.setServicePhone(servicePhone);
			xdServiceUser.setServicePassword(servicePassword);
			xdServiceUser.setCmbProvince(cmbProvince);
			xdServiceUser.setCmbCity(cmbCity);
			xdServiceUser.setCmbArea(cmbArea);
			xdUserService.insert(xdServiceUser);
			code1 = 1;
			map.put("code", code1);
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}

	/*
	 * 对service_product(服务管理)的分页查询
	 * 
	 */
	@RequestMapping("/fenyelike") // @RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
	public String fenyelike(Map<String, Object> map,

			@RequestParam(defaultValue = "0") int pageStart,

			@RequestParam(defaultValue = "7") Integer pageSize,

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

	/*
	 * 对service_orderform(订单)的分页查询
	 * 
	 */
	@RequestMapping("/fenyelikeS") // @RequestParam 参数是基本数据类型，不赋初始置，容易报错，用此注解赋默认值
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

	/*
	 * 服务产品的插入
	 * 
	 */
	@RequestMapping("/insert")
	public String insert(Map<String, Object> map, XdProduct xdproduct) {

		int i = xdUserService.insert(xdproduct);

		if (i == 1) {
			return "redirect:/fenyelike";
		} else {
			return "fail";
		}
	}

	/*
	 * 服务商店铺的插入
	 * 
	 */
	@RequestMapping("/insertStore")
	public String insertStore(Map<String, Object> map, XdStore xdStore) {

		int i = xdUserService.insert(xdStore);

		if (i == 1) {
			return "redirect:/store";
		} else {
			return "fail";
		}
	}

	/*
	 * 服务产品的删除
	 * 
	 */
	@RequestMapping("/delete")
	public String deleteByPrimaryKey(String id) {
		// xdUserService x = new xdUserServiceImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		int i = xdUserService.deleteByPrimaryKey(id);
		if (i == 1) {
			map.put("msg", "删除成功");
			return "redirect:/fenyelike";
		}

		else {
			return "fail";
		}
	}

	/*
	 * 服务产品的修改（service_product页面）
	 * 
	 */
	@RequestMapping("/updateS")
	public String updateByPrimaryKey(XdProduct xdProduct) {
		int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		if (i == 1)
			return "redirect:/fenyelike";
		else
			return "fail";
	}

	@RequestMapping("/selectS")
	public String select(Model model, String id) throws Exception {
		XdProduct xdProduct = xdUserService.selectByPrimaryKey(id);
		// int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		model.addAttribute("xdProduct", xdProduct);
		return "update_xdproduct";
	}
	  @RequestMapping("/sysuserlist")
	  public String setting(String id) {
		  XdServiceUser xdServiceUser=xdUserService.selectByPrimaryKeyS(id);
		  
	  return "service_setting"; }
	 
	/*
	 * service_setting页面的修改
	 * 
	 */
	@RequestMapping("/setQ")
	public String updateByPrimaryKeyS(XdServiceUser xdServiceUser) {

		int i = 0;
		i = xdUserService.updateByPrimaryKeySelective(xdServiceUser);
		if (i == 1)
			return "redirect:/sysuserlist";
		else
			return "fail";
	}

	@RequestMapping(value="/selectQ")
	public String selectQ(Model model, String id) {
		XdServiceUser xdServiceUser = xdUserService.selectByPrimaryKeyS(id);
		// int i = xdUserService.updateByPrimaryKeySelective(xdProduct);
		model.addAttribute("xdServiceUser", xdServiceUser);
		return "service_update";
	}

	/*
	 * 图片上传(service_setting页面)
	 * 
	 */
	@RequestMapping("/loadimgS")
	public String loadImg1() {
		return "upfile";
	}

	@RequestMapping(value = "/upfileS", method = RequestMethod.POST)
	public String saveUserImg1(MultipartFile file, String id) {
		Map<Object, Object> result = new HashMap<Object, Object>();
		System.out.println("111111111");
		try {
			InputStream ins = (InputStream) file.getInputStream();
			byte[] buffer = new byte[32768];// bit---byte---1k---1m
			int len = 0;
			// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			System.out.println("222222222");
			while ((len = ins.read(buffer)) != -1) {
				System.out.println("333333333");
				bos.write(buffer, 0, len);
				System.out.println("44444444111111111");
			}
			bos.flush();
			byte data[] = bos.toByteArray();
			System.out.println("aaaaaaaaaaaa");
			// System.out.println(data);
			XdServiceUser xdServiceUser = new XdServiceUser();
			xdServiceUser.setId("1");
			xdServiceUser.setImg(data);
			xdUserService.updateById(xdServiceUser);
			// System.out.println("aaaaaaaaaaaa");
			result.put("code", 1);
			result.put("msg", "保存成");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "uploaderror";

		}
		return "redirect:/sysuserlist";
	}

	@RequestMapping(value = "/headImgS", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(String id) throws Exception {

		byte[] imageContent;
		XdServiceUser xdServiceUser = xdUserService.selectByPrimaryKeyS(id);
		System.out.println("aaaaaaa" + xdServiceUser.getServicePassword());
		imageContent = xdServiceUser.getImg();
		// System.out.println("图片==="+produt.getImg());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		System.out.println("bbbbbbbbbbbbb" + xdServiceUser.getServicePassword());
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

	@RequestMapping("/loadimg_store")

	public String loadImg2() {
		return "upfile_store";
	}

	@RequestMapping("/upfile_store")
	public String saveUserImg2(MultipartFile file) {
		Map<Object, Object> result = new HashMap<Object, Object>();
		System.out.println("111111111");
		try {
			InputStream ins = (InputStream) file.getInputStream();
			byte[] buffer = new byte[32768];
			// bit---byte---1k---1m
			int len = 0; // 字节输出流 ByteArrayOutputStream bos = new
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			System.out.println("222222222");
			while ((len = ins.read(buffer)) != -1) {
				System.out.println("333333333");
				bos.write(buffer, 0, len);
				System.out.println("44444444111111111");
			}
			bos.flush();
			byte data[] = bos.toByteArray();
			System.out.println("aaaaaaaaaaaa");
			// System.out.println(data);
			XdStore xdStore = new XdStore();
			xdStore.setId(1);
			xdStore.setLicense(data);
			xdUserService.updateById(xdStore);
			result.put("code", 1);
			result.put("msg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "uploaderror";

		}
		return "redirect:/store";
	}

	@RequestMapping(value = "/headImg_store", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg2(Integer id) throws Exception {

		byte[] imageContent;
		XdStore xdStore = xdUserService.selectByPrimaryKey(id);
		System.out.println("aaaaaaa" + xdStore.getCellphone());
		imageContent = xdStore.getLicense();
		System.out.println("图片===" + xdStore.getLicense());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// System.out.println("bbbbbbbbbbbbb"+xdServiceUser.getServicePassword());
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

	@RequestMapping("/findpasswordS")
	public String serviceFindpassword() {
		return "service_findpassword";
	}

	@RequestMapping("/registerService")
	public String RegisterService() {
		return "service_register";
	}

	@RequestMapping("/store")
	public String store() {
		return "service_store";
	}

}
