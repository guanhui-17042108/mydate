package com.dt.xd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.model.XdCart;
import com.dt.xd.model.XdOrder;
import com.dt.xd.model.XdProviderProduct;
import com.dt.xd.service.XdCartService;
import com.dt.xd.service.XdOrderService;
import com.dt.xd.service.XdProviderProductService;

@Controller
@RequestMapping("/product")
public class XdCartController {

	@Resource
	XdCartService xdCartService;
	@Resource
	XdProviderProductService xdProviderProductService;
	@Resource
	XdOrderService xdOrderService;

	// 将网页查询到的id插入购物车
	@ResponseBody
	@RequestMapping(value = "/gwc", method = RequestMethod.POST)
	public Map<String, Object> ProductAdd(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdCart> cartInfo = xdCartService.getcid(request);
		if (cartInfo.isEmpty()) {
			int a = xdCartService.insertCart(request);
			map.put("msg", a);
			return map;
		}

		if (!cartInfo.isEmpty()) {
			map.put("msg", "id已存在");
			XdCart cart = new XdCart();
			cart.setBuyNum(cartInfo.get(0).getBuyNum() + 1);
			int a = xdCartService.updateBuynum(cart, request.getParameter("id"));
		}

		return map;
	}

	// 根据购物车里商品id返回商品信息
	@ResponseBody
	@RequestMapping(value = "/getproductinfo", method = RequestMethod.GET)
	public Map<String, Object> Provideproduct(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> product = new ArrayList<Map<String, Object>>();
		List<XdCart> cartInfo = xdCartService.getuid(request.getParameter("userid"));
		for (int i = 0; i < cartInfo.size(); i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();

			String id = cartInfo.get(i).getProductId();
			List<XdProviderProduct> providerProductInfo = xdProviderProductService.getid(id);
			providerProductInfo.get(0).setNum2(cartInfo.get(i).getBuyNum());
			if (product.size() == 0) {
				map1.put("name", providerProductInfo.get(0).getProviderName());
				map1.put("product", providerProductInfo);
				map1.put("num", cartInfo.get(i).getBuyNum());
				product.add(map1);
				map.put("product", product);
				continue;
			} else {
				int num = 0;
				for (Map<String, Object> map2 : product) {
					if (map2.get("name").equals(providerProductInfo.get(0).getProviderName())) {
						num = 1;
						break;
					}
				}

				for (Map<String, Object> map2 : product) {

					if (map2.get("name").equals(providerProductInfo.get(0).getProviderName())) {
						((List<XdProviderProduct>) map2.get("product")).add(providerProductInfo.get(0));
						break;
					} else if (num == 1) {
						continue;
					} else {
						map1.put("name", providerProductInfo.get(0).getProviderName());
						map1.put("product", providerProductInfo);
						map1.put("num", cartInfo.get(i).getBuyNum());
						product.add(map1);
						break;
					}
				}

			}

		}

		map.put("product", product);
		return map;
	}

	// 通过商品id删除商品
	@ResponseBody
	@RequestMapping(value = "/providerProductdelete", method = RequestMethod.POST)
	public Map<String, Object> Productdelete(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int cartInfo = xdCartService.providerProductDelete(request);
		map.put("msg", "恭喜删除成功");
		map.put("code", 1);
		return map;
	}

	// 通过商品【-】减少商品数量
	@ResponseBody
	@RequestMapping(value = "/reducenum", method = RequestMethod.POST)
	public Map<String, Object> Productreduce(HttpServletRequest request, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		XdCart cart = new XdCart();
		cart.setBuyNum(Integer.valueOf(request.getParameter("num")) - 1);

		cart.setProductId(id);
		int a = xdCartService.updateBuynum1(cart, request);

		map.put("code", 1);
		map.put("msg", a);

		return map;

	}

	// 通过商品【+】增加商品数量
	@ResponseBody
	@RequestMapping(value = "/addnum", method = RequestMethod.POST)
	public Map<String, Object> Productadd(HttpServletRequest request, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		XdCart cart = new XdCart();
		cart.setBuyNum(Integer.valueOf(request.getParameter("num")) + 1);
		cart.setProductId(id);
		int a = xdCartService.updateBuynum1(cart, request);
		map.put("code", 1);
		map.put("msg", a);
		return map;

	}

	// 通过改变商品数量进行改变
	@ResponseBody
	@RequestMapping(value = "/updatenum", method = RequestMethod.POST)
	public Map<String, Object> Productupdate(HttpServletRequest request, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		XdCart cart = new XdCart();
		cart.setBuyNum(Integer.valueOf(request.getParameter("num")));
		cart.setProductId(id);
		int a = xdCartService.updateBuynum1(cart, request);
		map.put("code", 1);
		map.put("msg", a);
		return map;

	}

	// 通过结算向serviceorder里插入订单编号等
	@ResponseBody
	@RequestMapping(value = "/ggg", method = RequestMethod.POST)
	public Map<String, Object> Productorder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdOrder> serviceOrderInfo = xdOrderService.getuid(request.getParameter("userid"));
		XdOrder serviceOrder = new XdOrder();
		String danhao = request.getParameter("nn");
		serviceOrder.setOrderNo(danhao);
		int a = xdOrderService.insertServiceOrder(request);
		map.put("product", serviceOrderInfo);

		map.put("code", 1);
		return map;

	}

	@ResponseBody
	@RequestMapping(value = "/mmm", method = RequestMethod.POST)
	public Map<String, Object> Productxiangqing(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdOrder> soList = xdOrderService.getll(request.getParameter("userid"));

		for (int j = 0; j < soList.size(); j++) {

			String[] str = soList.get(j).getProductId().split(",");// str={0003*1,0002*2}

			String[] str1 = new String[10];
			String[] str2 = new String[10];
			List<XdProviderProduct> pp;
			StringBuffer buf = new StringBuffer();
			// “0002”

			for (int i = 0; i < str.length; i++) {
				String[] str3 = str[i].split("\\*"); // str3={0003,1}
				pp = xdProviderProductService.getid(str3[0]); // 查询产品id
				str1[i] = pp.get(0).getProductContent(); // 产品名称存入str1

				str2[i] = str3[1]; // 数量存入str2
				buf.append(str1[i] + "*" + str2[i] + " ");
				soList.get(j).setProductId(buf.toString());
			}

		}
		map.put("list", soList);
		return map;

	}

	@ResponseBody
	@RequestMapping(value = "/mmm2", method = RequestMethod.POST)
	public Map<String, Object> Productxiangqing2(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdOrder> list = xdOrderService.search(request);
		map.put("list", list);
		return map;
	}
	// 电子商务删除订单
	@ResponseBody
	@RequestMapping(value = "/Productdelete", method = RequestMethod.POST)
	public Map<String, Object> Productdelete2(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceOrderInfo = xdOrderService.pProductDelete(request);
		map.put("msg", "恭喜删除成功");
		map.put("code", 1);
		return map;
	}

	// 通过订单编号查询订单信息
	@ResponseBody
	@RequestMapping(value = "/sss", method = RequestMethod.POST)
	public Map<String, Object> Product(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdOrder> soList = xdOrderService.getmm(request.getParameter("orderNo"));
		map.put("list", soList);
		for (int j = 0; j < soList.size(); j++) {
			String[] str = soList.get(j).getProductId().split(",");// str={0003*1,0002*2}
			String[] str1 = new String[10];
			String[] str2 = new String[10];
			List<XdProviderProduct> pp;
			StringBuffer buf = new StringBuffer();
			// “0002”
			for (int i = 0; i < str.length; i++) {
				String[] str3 = str[i].split("\\*"); // str3={0003,1}
				pp = xdProviderProductService.getid(str3[0]); // 查询产品id
				str1[i] = pp.get(0).getProductName(); // 产品名称存入str1

				str2[i] = str3[1]; // 数量存入str2
				buf.append(str1[i] + "*" + str2[i] + " ");
				soList.get(j).setProductId(buf.toString());
			}

		}

		return map;

	}

	// 修改订单状态
	@ResponseBody
	@RequestMapping(value = "/hhh", method = RequestMethod.POST)
	public Map<String, Object> Productfukuan(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XdOrder> list1 = xdOrderService.getmm(request.getParameter("nn"));
		int a = xdOrderService.up(request);
		map.put("code", 1);
		map.put("msg", "支付成功");
		return map;

	}

}
