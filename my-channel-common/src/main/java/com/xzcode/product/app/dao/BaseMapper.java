package com.xzcode.product.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T> {
	/**
	 * 插入数据
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 插入并且注入ID
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 根据主键查询
	 * 
	 * @param uid
	 * @return
	 */
	T selectByPrimaryKey(Long uid);
	
	
	/**
	 * 根据主键删除
	 * 
	 * @param uid
	 * @return
	 */
	int deleteByPrimaryKey(Long uid);
	
	/**
	 * 根据uid更新，必须包含uid
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);


	/**
	 * 获取所有行数
	 * 
	 * @return 2016年1月8日 上午11:33:37
	 */
	int count();
	
	/**
	 * 更新删除标识
	 * @param uid
	 * @param enabled
	 * @return
	 * @author zai
	 * 2017-03-29 09:37:05
	 */
	Integer updateEnabled(@Param("uid") Long uid, @Param("enabled") Integer enabled);


	/**
	 * 无条件获取所有记录（慎用）
	 * @return
	 * @author zai
	 * 2017-03-29 09:39:20
	 */
	List<T> list();

}
