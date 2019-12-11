package com.dt.xd.xdProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XdProductExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int pageStart;

	protected int pageSize;

	protected String username;
	protected String productName;
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public XdProductExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andServiceProductIsNull() {
			addCriterion("service_product is null");
			return (Criteria) this;
		}

		public Criteria andServiceProductIsNotNull() {
			addCriterion("service_product is not null");
			return (Criteria) this;
		}

		public Criteria andServiceProductEqualTo(String value) {
			addCriterion("service_product =", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductNotEqualTo(String value) {
			addCriterion("service_product <>", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductGreaterThan(String value) {
			addCriterion("service_product >", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductGreaterThanOrEqualTo(String value) {
			addCriterion("service_product >=", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductLessThan(String value) {
			addCriterion("service_product <", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductLessThanOrEqualTo(String value) {
			addCriterion("service_product <=", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductLike(String value) {
			addCriterion("service_product like", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductNotLike(String value) {
			addCriterion("service_product not like", value, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductIn(List<String> values) {
			addCriterion("service_product in", values, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductNotIn(List<String> values) {
			addCriterion("service_product not in", values, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductBetween(String value1, String value2) {
			addCriterion("service_product between", value1, value2, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andServiceProductNotBetween(String value1, String value2) {
			addCriterion("service_product not between", value1, value2, "serviceProduct");
			return (Criteria) this;
		}

		public Criteria andProductImgIsNull() {
			addCriterion("product_img is null");
			return (Criteria) this;
		}

		public Criteria andProductImgIsNotNull() {
			addCriterion("product_img is not null");
			return (Criteria) this;
		}

		public Criteria andProductImgEqualTo(String value) {
			addCriterion("product_img =", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgNotEqualTo(String value) {
			addCriterion("product_img <>", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgGreaterThan(String value) {
			addCriterion("product_img >", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgGreaterThanOrEqualTo(String value) {
			addCriterion("product_img >=", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgLessThan(String value) {
			addCriterion("product_img <", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgLessThanOrEqualTo(String value) {
			addCriterion("product_img <=", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgLike(String value) {
			addCriterion("product_img like", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgNotLike(String value) {
			addCriterion("product_img not like", value, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgIn(List<String> values) {
			addCriterion("product_img in", values, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgNotIn(List<String> values) {
			addCriterion("product_img not in", values, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgBetween(String value1, String value2) {
			addCriterion("product_img between", value1, value2, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductImgNotBetween(String value1, String value2) {
			addCriterion("product_img not between", value1, value2, "productImg");
			return (Criteria) this;
		}

		public Criteria andProductNameIsNull() {
			addCriterion("product_name is null");
			return (Criteria) this;
		}

		public Criteria andProductNameIsNotNull() {
			addCriterion("product_name is not null");
			return (Criteria) this;
		}

		public Criteria andProductNameEqualTo(String value) {
			addCriterion("product_name =", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameNotEqualTo(String value) {
			addCriterion("product_name <>", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameGreaterThan(String value) {
			addCriterion("product_name >", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameGreaterThanOrEqualTo(String value) {
			addCriterion("product_name >=", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameLessThan(String value) {
			addCriterion("product_name <", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameLessThanOrEqualTo(String value) {
			addCriterion("product_name <=", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameLike(String value) {
			addCriterion("product_name like", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameNotLike(String value) {
			addCriterion("product_name not like", value, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameIn(List<String> values) {
			addCriterion("product_name in", values, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameNotIn(List<String> values) {
			addCriterion("product_name not in", values, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameBetween(String value1, String value2) {
			addCriterion("product_name between", value1, value2, "productName");
			return (Criteria) this;
		}

		public Criteria andProductNameNotBetween(String value1, String value2) {
			addCriterion("product_name not between", value1, value2, "productName");
			return (Criteria) this;
		}

		public Criteria andProductInstructionIsNull() {
			addCriterion("product_instruction is null");
			return (Criteria) this;
		}

		public Criteria andProductInstructionIsNotNull() {
			addCriterion("product_instruction is not null");
			return (Criteria) this;
		}

		public Criteria andProductInstructionEqualTo(String value) {
			addCriterion("product_instruction =", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionNotEqualTo(String value) {
			addCriterion("product_instruction <>", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionGreaterThan(String value) {
			addCriterion("product_instruction >", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionGreaterThanOrEqualTo(String value) {
			addCriterion("product_instruction >=", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionLessThan(String value) {
			addCriterion("product_instruction <", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionLessThanOrEqualTo(String value) {
			addCriterion("product_instruction <=", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionLike(String value) {
			addCriterion("product_instruction like", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionNotLike(String value) {
			addCriterion("product_instruction not like", value, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionIn(List<String> values) {
			addCriterion("product_instruction in", values, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionNotIn(List<String> values) {
			addCriterion("product_instruction not in", values, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionBetween(String value1, String value2) {
			addCriterion("product_instruction between", value1, value2, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductInstructionNotBetween(String value1, String value2) {
			addCriterion("product_instruction not between", value1, value2, "productInstruction");
			return (Criteria) this;
		}

		public Criteria andProductPriceIsNull() {
			addCriterion("product_price is null");
			return (Criteria) this;
		}

		public Criteria andProductPriceIsNotNull() {
			addCriterion("product_price is not null");
			return (Criteria) this;
		}

		public Criteria andProductPriceEqualTo(Float value) {
			addCriterion("product_price =", value, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceNotEqualTo(Float value) {
			addCriterion("product_price <>", value, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceGreaterThan(Float value) {
			addCriterion("product_price >", value, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceGreaterThanOrEqualTo(Float value) {
			addCriterion("product_price >=", value, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceLessThan(Float value) {
			addCriterion("product_price <", value, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceLessThanOrEqualTo(Float value) {
			addCriterion("product_price <=", value, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceIn(List<Float> values) {
			addCriterion("product_price in", values, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceNotIn(List<Float> values) {
			addCriterion("product_price not in", values, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceBetween(Float value1, Float value2) {
			addCriterion("product_price between", value1, value2, "productPrice");
			return (Criteria) this;
		}

		public Criteria andProductPriceNotBetween(Float value1, Float value2) {
			addCriterion("product_price not between", value1, value2, "productPrice");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andTsIsNull() {
			addCriterion("ts is null");
			return (Criteria) this;
		}

		public Criteria andTsIsNotNull() {
			addCriterion("ts is not null");
			return (Criteria) this;
		}

		public Criteria andTsEqualTo(Date value) {
			addCriterion("ts =", value, "ts");
			return (Criteria) this;
		}

		public Criteria andTsNotEqualTo(Date value) {
			addCriterion("ts <>", value, "ts");
			return (Criteria) this;
		}

		public Criteria andTsGreaterThan(Date value) {
			addCriterion("ts >", value, "ts");
			return (Criteria) this;
		}

		public Criteria andTsGreaterThanOrEqualTo(Date value) {
			addCriterion("ts >=", value, "ts");
			return (Criteria) this;
		}

		public Criteria andTsLessThan(Date value) {
			addCriterion("ts <", value, "ts");
			return (Criteria) this;
		}

		public Criteria andTsLessThanOrEqualTo(Date value) {
			addCriterion("ts <=", value, "ts");
			return (Criteria) this;
		}

		public Criteria andTsIn(List<Date> values) {
			addCriterion("ts in", values, "ts");
			return (Criteria) this;
		}

		public Criteria andTsNotIn(List<Date> values) {
			addCriterion("ts not in", values, "ts");
			return (Criteria) this;
		}

		public Criteria andTsBetween(Date value1, Date value2) {
			addCriterion("ts between", value1, value2, "ts");
			return (Criteria) this;
		}

		public Criteria andTsNotBetween(Date value1, Date value2) {
			addCriterion("ts not between", value1, value2, "ts");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeIsNull() {
			addCriterion("sales_volume is null");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeIsNotNull() {
			addCriterion("sales_volume is not null");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeEqualTo(Integer value) {
			addCriterion("sales_volume =", value, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeNotEqualTo(Integer value) {
			addCriterion("sales_volume <>", value, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeGreaterThan(Integer value) {
			addCriterion("sales_volume >", value, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeGreaterThanOrEqualTo(Integer value) {
			addCriterion("sales_volume >=", value, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeLessThan(Integer value) {
			addCriterion("sales_volume <", value, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeLessThanOrEqualTo(Integer value) {
			addCriterion("sales_volume <=", value, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeIn(List<Integer> values) {
			addCriterion("sales_volume in", values, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeNotIn(List<Integer> values) {
			addCriterion("sales_volume not in", values, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeBetween(Integer value1, Integer value2) {
			addCriterion("sales_volume between", value1, value2, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andSalesVolumeNotBetween(Integer value1, Integer value2) {
			addCriterion("sales_volume not between", value1, value2, "salesVolume");
			return (Criteria) this;
		}

		public Criteria andServiceNameIsNull() {
			addCriterion("service_name is null");
			return (Criteria) this;
		}

		public Criteria andServiceNameIsNotNull() {
			addCriterion("service_name is not null");
			return (Criteria) this;
		}

		public Criteria andServiceNameEqualTo(String value) {
			addCriterion("service_name =", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameNotEqualTo(String value) {
			addCriterion("service_name <>", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameGreaterThan(String value) {
			addCriterion("service_name >", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
			addCriterion("service_name >=", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameLessThan(String value) {
			addCriterion("service_name <", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameLessThanOrEqualTo(String value) {
			addCriterion("service_name <=", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameLike(String value) {
			addCriterion("service_name like", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameNotLike(String value) {
			addCriterion("service_name not like", value, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameIn(List<String> values) {
			addCriterion("service_name in", values, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameNotIn(List<String> values) {
			addCriterion("service_name not in", values, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameBetween(String value1, String value2) {
			addCriterion("service_name between", value1, value2, "serviceName");
			return (Criteria) this;
		}

		public Criteria andServiceNameNotBetween(String value1, String value2) {
			addCriterion("service_name not between", value1, value2, "serviceName");
			return (Criteria) this;
		}

		public Criteria andRecommendIsNull() {
			addCriterion("recommend is null");
			return (Criteria) this;
		}

		public Criteria andRecommendIsNotNull() {
			addCriterion("recommend is not null");
			return (Criteria) this;
		}

		public Criteria andRecommendEqualTo(String value) {
			addCriterion("recommend =", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotEqualTo(String value) {
			addCriterion("recommend <>", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendGreaterThan(String value) {
			addCriterion("recommend >", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendGreaterThanOrEqualTo(String value) {
			addCriterion("recommend >=", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLessThan(String value) {
			addCriterion("recommend <", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLessThanOrEqualTo(String value) {
			addCriterion("recommend <=", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendLike(String value) {
			addCriterion("recommend like", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotLike(String value) {
			addCriterion("recommend not like", value, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendIn(List<String> values) {
			addCriterion("recommend in", values, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotIn(List<String> values) {
			addCriterion("recommend not in", values, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendBetween(String value1, String value2) {
			addCriterion("recommend between", value1, value2, "recommend");
			return (Criteria) this;
		}

		public Criteria andRecommendNotBetween(String value1, String value2) {
			addCriterion("recommend not between", value1, value2, "recommend");
			return (Criteria) this;
		}

		public Criteria andHighQualityIsNull() {
			addCriterion("high_quality is null");
			return (Criteria) this;
		}

		public Criteria andHighQualityIsNotNull() {
			addCriterion("high_quality is not null");
			return (Criteria) this;
		}

		public Criteria andHighQualityEqualTo(String value) {
			addCriterion("high_quality =", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityNotEqualTo(String value) {
			addCriterion("high_quality <>", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityGreaterThan(String value) {
			addCriterion("high_quality >", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityGreaterThanOrEqualTo(String value) {
			addCriterion("high_quality >=", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityLessThan(String value) {
			addCriterion("high_quality <", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityLessThanOrEqualTo(String value) {
			addCriterion("high_quality <=", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityLike(String value) {
			addCriterion("high_quality like", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityNotLike(String value) {
			addCriterion("high_quality not like", value, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityIn(List<String> values) {
			addCriterion("high_quality in", values, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityNotIn(List<String> values) {
			addCriterion("high_quality not in", values, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityBetween(String value1, String value2) {
			addCriterion("high_quality between", value1, value2, "highQuality");
			return (Criteria) this;
		}

		public Criteria andHighQualityNotBetween(String value1, String value2) {
			addCriterion("high_quality not between", value1, value2, "highQuality");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}