package com.dt.xd.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dt.xd.model.XdCart;
import com.dt.xd.model.XdProviderProduct;
import com.dt.xd.service.XdCartService;
import com.dt.xd.service.XdProviderProductService;

@Controller
@RequestMapping("/product")
public class XdProviderProductController {
	
		
		//显示所有商品
		 @Resource 
		 XdProviderProductService  xdProviderProductService;
		 @Resource 
		 XdCartService  cService;
		 
		 
		 
		 
		///产品头像
			@ResponseBody	
			@RequestMapping(value="/headImg2", produces = MediaType.IMAGE_PNG_VALUE)
			public ResponseEntity<byte[]> headImg2(String id) throws Exception{
				byte[] imageContent ;
				// 根据id获取当前用户的信息
				XdProviderProduct pp = xdProviderProductService.getUserInfo(id);
						        
				imageContent = pp.getProductImg();
						        
				// 设置http头部信息
				final HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.IMAGE_PNG);
				// 返回响应实体
				return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
			}
			
		 
		 
		 
	
		@ResponseBody
		@RequestMapping(value="/gmgm",method=RequestMethod.POST)
		public Map<String,Object> Provideproduct(HttpServletRequest request){
			Map<String,Object> map=new HashMap<String,Object>();
			List<XdCart> cart=cService.getcartid(request);
			map.put("cartnum", cart.size());
			List<XdProviderProduct> providerProductInfo=xdProviderProductService.getProviderProductInfoById(request);
			map.put("providerProductInfo",providerProductInfo);
			return map ;

		}
		
		@ResponseBody			//模糊查询
		@RequestMapping(value="/select",method = RequestMethod.GET)
		public Map <String,Object> selecte(HttpServletRequest request) {
			Map<String,Object> map = new HashMap<String,Object>();
			List<XdProviderProduct> providerProductInfo= xdProviderProductService.select2(request);
			map.put("providerProductInfo", providerProductInfo);
			return map;
		}
		

	}


