package com.xzcode.product.app.model.datatables;

import java.util.List;

/**
 * datatables ajax响应包装类
 * 
 * 
 * @author zai
 * 2018-05-08
 */
public class DataTablesResponse {
	
	/**
	 * 总记录数
	 */
	private Integer recordsTotal;
	
	/**
	 * 从总记录中过滤调的条数，默认可以和总记录数一样
	 */
	private Integer recordsFiltered;
	
	/**
	 * 列表数据
	 */
 	private List<?> data; 
 	
 	/**
 	 * 请求标识，必须接收然后原路返回，否则datatables无法正常请求和刷新列表
 	 */
	private Integer draw;
	
	public static DataTablesResponse create() {
		
		return new DataTablesResponse();
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public DataTablesResponse setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
		return this;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public DataTablesResponse setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
		return this;
	}

	public List<?> getData() {
		return data;
	}

	public DataTablesResponse setData(List<?> data) {
		this.data = data;
		return this;
	}

	public Integer getDraw() {
		return draw;
	}

	public DataTablesResponse setDraw(Integer draw) {
		this.draw = draw;
		return this;
	}
	
	
	
	
}
