package com.xzcode.product.app.service.impl;

import java.util.List;

import com.xzcode.product.app.dao.BaseMapper;
import com.xzcode.product.app.service.facade.IBaseService;


public class BaseService<T> implements IBaseService<T> {

	protected BaseMapper<T> mapper;
	
    public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.mapper = baseMapper;
	}
    
	@Override
	public int deleteByPrimaryKey(Long uid) {
		return this.mapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(T record) {
		return this.mapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return this.mapper.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(Long uid) {
		return this.mapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<T> list() {
		return this.mapper.list();
	}

	@Override
	public int count() {
		return this.mapper.count();
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return this.mapper.updateByPrimaryKey(record);
	}

	@Override
	public Integer updateEnabled(Long uid, Integer enabled) {
		return this.mapper.updateEnabled(uid, enabled);
	}


}
