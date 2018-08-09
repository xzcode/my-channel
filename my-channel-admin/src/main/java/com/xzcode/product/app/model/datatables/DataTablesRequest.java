package com.xzcode.product.app.model.datatables;

import java.util.List;
import java.util.Map;

/**
 * datatables ajax请求包装类
 * 
 * 
 * @author zai
 * 2018-05-08
 */
public class DataTablesRequest {
	
	
	/**
 	 * 请求标识，必须接收然后原路返回，否则datatables无法正常请求和刷新列表
 	 */
	private Integer draw;
	
	/**
	 * 开始记录位置
	 */
	private Integer start = 0;
	
	/**
	 * 分页长度
	 */
	private Integer length = 10;
	
	/**
	 * 排序集合
	 */
	private List<Order> order;
	
	
	private Search search;
	
	
	private Map<String, String> extra;
	
	
	
	/**
	 * 搜索对象封装
	 * 
	 * 
	 * @author zai
	 * 2018-05-08
	 */
	public static class Search {
		private String value;
		private String regex;
		
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getRegex() {
			return regex;
		}
		public void setRegex(String regex) {
			this.regex = regex;
		}
		
	}
	
	public String getKeyword() {
		if (this.search != null) {
			return this.search.getValue();			
		}
		return null;
	}
	
	/**
	 * 排序封装
	 * 
	 * 
	 * @author zai
	 * 2018-05-08
	 */
	public static class Order {
		/**
		 * 列名称
		 */
		private String column;
		
		/**
		 * 排序方式，asc，desc
		 */
		private String dir;

		public String getColumn() {
			return column;
		}

		public void setColumn(String column) {
			this.column = column;
		}

		public String getDir() {
			return dir;
		}

		public void setDir(String dir) {
			this.dir = dir;
		}
		
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
	public Search getSearch() {
		return search;
	}
	
	public void setSearch(Search search) {
		this.search = search;
	}
	
	public Map<String, String> getExtra() {
		return extra;
	}
	
	public void setExtra(Map<String, String> extra) {
		this.extra = extra;
	}
	
	
	public String getExtraForString(String key) {
		if (extra != null) {
			return extra.get(key);
		}
		return null;
	}
	
	public Integer getExtraForInteger(String key) {
		if (extra != null) {
			return Integer.valueOf(extra.get(key));
		}
		return null;
	}
	
	public Long getExtraForLong(String key) {
		if (extra != null) {
			return Long.valueOf(extra.get(key));
		}
		return null;
	}
	
	
}
