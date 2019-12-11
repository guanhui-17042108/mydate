package com.dt.xd.controller;

import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dt.xd.model.XdEuser;
import com.dt.xd.model.XdOrder;
import com.dt.xd.model.XdProviderProduct;
import com.dt.xd.service.XdEuserService;
import com.dt.xd.service.XdOrderService;
import com.dt.xd.service.XdProviderProductService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
public class XdEuserController2 {

	

		@Resource
		XdEuserService mService;
		
		@Resource
		XdOrderService soService;
		@Resource
		XdProviderProductService ppService;

	
		//用户头像
		@ResponseBody	
		@RequestMapping(value="/headImg", produces = MediaType.IMAGE_PNG_VALUE)
		public ResponseEntity<byte[]> headImg(String id) throws Exception{
			byte[] imageContent ;
			// 根据id获取当前用户的信息
			XdEuser user = mService.getUserInfo(id);
					        
			imageContent = user.getHeadImg();
					        
			// 设置http头部信息
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			// 返回响应实体
			return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
		}
		
		//账户设置
		@ResponseBody
		@RequestMapping(value = "/updatexx", method = RequestMethod.POST)
		public Map<String, Object> updatexx(HttpServletRequest request) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getParameter("sex").equals("0")) {
				map.put("msg","请选择性别");
				return map;
			}
			if(request.getParameter("name").isEmpty()) {
				map.put("msg","请输入姓名");
				return map;
			}
			if(request.getParameter("email").isEmpty()) {
				map.put("msg","请输入邮箱");
				return map;
			}
			int a= mService.updatexx(request);
			if(a==1) {
				map.put("msg","保存成功");
				return map;
			}
			map.put("msg","保存失败");
			return map;
		}
		//保存头像
		@ResponseBody
		@RequestMapping(value = "/saveUserImg")
		public Map<Object,Object> saveUserImg(MultipartFile file,String id) {
			Map<Object,Object> result = new HashMap<Object,Object>();
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
			XdEuser member = new XdEuser();
			member.setId(id);
			member.setHeadImg(data);
			mService.saveUserImg(member);
			result.put("code",1);
				result.put("msg", "保存头像成功");
			} catch (Exception e) {
				result.put("code",0);
				result.put("msg", "保存头像失败");
				return result;
			 }				
			return result;
		}
		
		
		
		
		@ResponseBody
		@RequestMapping(value = "/content", method = RequestMethod.POST)
		public Map<String, Object> content(HttpServletRequest request) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<XdOrder> soList=soService.content(request);
			List<XdOrder> setList=new ArrayList<XdOrder>();
			List<XdProviderProduct> ppList= ppService.select(request);	
			if(request.getParameter("content").equals("1")) {
				for(int i=0;i<soList.size();i++) {		//
				if(soList.get(i).getContent()==null) {
					String[] str = soList.get(i).getProductId().split(",");
					for(int j=0;j<str.length;j++) {
						String[] str2 = str[j].split("\\*"); // str2={00003,2} 00004,3
						List<XdProviderProduct> pp = ppService.getid(str2[0]); 
						for(int n=0;n<ppList.size();n++) {
						if(str2[0].equals(ppList.get(n).getId())) {
							XdOrder so=new XdOrder();
							so.setOrderNo(soList.get(i).getOrderNo());
							so.setProductId(pp.get(0).getProductContent());
							so.setPpId(ppList.get(n).getId());
							so.setProductName(pp.get(0).getProductName());
							so.setProviderName(pp.get(0).getProviderName());
							so.setEuserId(soList.get(i).getEuserId());
							so.setProductNum(Integer.valueOf(str2[1]));
							so.setTotalPrice(pp.get(0).getPrice()*Integer.valueOf(str2[1]));
							so.setCreateTime(soList.get(i).getCreateTime());
							setList.add(so);
						}
						}
					}
				}
				}
			}else {

				for(int i=0;i<soList.size();i++) {		//
					if(soList.get(i).getContent()!=null) {
						String[] str = soList.get(i).getProductId().split(",");	//00003*2 00004*3
						for(int j=0;j<str.length;j++) {
							String[] str2 = str[j].split("\\*"); // str2={00003,2} 00004,3
							List<XdProviderProduct> pp = ppService.getid(str2[0]); // 查询00003产品信息
							for(int n=0;n<ppList.size();n++) {
							if(str2[0].equals(ppList.get(n).getId())) {
								XdOrder so=new XdOrder();
								so.setOrderNo(soList.get(i).getOrderNo());
								so.setPpId(str2[0]);
								so.setProductId(pp.get(0).getProductContent());
								so.setProductName(pp.get(0).getProductName());
								so.setProviderName(pp.get(0).getProviderName());
								so.setPpId(ppList.get(n).getId());
								so.setEuserId(soList.get(i).getEuserId());
								so.setProductNum(Integer.valueOf(str2[1]));
								so.setTotalPrice(pp.get(0).getPrice()*Integer.valueOf(str2[1]));
								so.setCreateTime(soList.get(i).getCreateTime());
								setList.add(so);
							}
							}
						}
					}
					}
				
			}
			map.put("list", setList);
			return map;
		}

	}
