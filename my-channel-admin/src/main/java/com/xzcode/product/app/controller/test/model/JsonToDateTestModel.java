package com.xzcode.product.app.controller.test.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * json转时间格式化模型
 * 
 * 
 * @author zai
 * 2017-08-30
 */
public class JsonToDateTestModel {
	
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date createDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
