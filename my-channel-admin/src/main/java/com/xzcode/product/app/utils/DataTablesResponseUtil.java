package com.xzcode.product.app.utils;

import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.model.datatables.DataTablesResponse;

public class DataTablesResponseUtil {
	
	/**
	 * 转换成datatables专用响应类
	 * @param jdbclinkPager
	 * @param draw
	 * @return
	 * 
	 * @author zai
	 * 2018-05-08
	 */
	public static DataTablesResponse parse(Pager<?> jdbclinkPager, Integer draw) {
		return DataTablesResponse.create()
				.setData(jdbclinkPager.getItems())
				.setDraw(draw)
				.setRecordsTotal(jdbclinkPager.getTotal())
				.setRecordsFiltered(jdbclinkPager.getTotal());
		
	}

}
