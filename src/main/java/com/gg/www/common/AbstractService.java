package com.gg.www.common;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年01月19日 16:05:04  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/ 
public abstract class AbstractService<T extends Serializable> implements IServiceOperations<T> {

	protected abstract IOperations<T> getMapper();
	
	protected String tableName = "";

	public abstract void setTableName(String tableName);
	
	protected String getTableName() {
		return this.tableName;
	}
	
	@Override
	public void insert(T entity) {
		getMapper().insert(entity, this.getTableName());
	}

	@Override
	public int insertByBatch(List<T> list) {
		return getMapper().insertByBatch(list, this.getTableName());
	}

	@Override
	public int update(List<T> list) {
		return getMapper().update(list, this.getTableName());
	}
	
	@Override
	public int updateByBatch(LinkedHashMap<String, String> condition, String field) {
		return getMapper().updateByBatch(condition, field, this.getTableName());
	}

	@Override
	public T getById(int id) {
		return getMapper().getById(id, this.getTableName());
	}

	@Override
	public T getOne(LinkedHashMap<String, String> condition) {
		String field = null;
		return this.getOne(condition, field, this.getTableName());
	}

	@Override
	public T getOne(LinkedHashMap<String, String> condition, String field) {
		return getMapper().getOne(condition, field, this.getTableName());
	}

	@Override
	public int getCount(LinkedHashMap<String, String> condition, String field) {
		return getMapper().getCount(condition, field, this.getTableName());
	}

	@Override
	public List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize, String order, String field) {
		int offset = (pageNo - 1) * pageSize;
		int limit = pageSize;
		return getMapper().getList(condition, offset, limit, order, field, this.getTableName());
	}
	
	@Override
	public List<T> getAllList(LinkedHashMap<String, String> condition) {
		return this.getAllList(condition, null);
	}
	
	@Override
	public List<T> getAllList(LinkedHashMap<String, String> condition, String order) {
		if(order == null || order.trim().length() == 0) {
			order = null;
		}
		return getMapper().getList(condition, 0, 0, order, null, this.getTableName());
	}

	@Override
	public List<T> getList(int pageNo, int pageSize) {
		String order = null;
		return this.getList(pageNo, pageSize, order);
	}

	@Override
	public List<T> getList(int pageNo, int pageSize, String order) {
		String field = null;
		return this.getList(pageNo, pageSize, order, field);
	}

	@Override
	public List<T> getList(int pageNo, int pageSize, String order, String field) {
		LinkedHashMap<String, String> condition = new LinkedHashMap<String, String>();
		return this.getList(condition, pageNo, pageSize, order, field);
	}

	@Override
	public List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize) {
		String order = null;
		return this.getList(condition, pageNo, pageSize, order);
	}

	@Override
	public List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize, String order) {
		String field = null;
		return this.getList(condition, pageNo, pageSize, order, field);
	}

	@Override
	public int existTable(String tableName) {
		return getMapper().existTable(tableName);
	}

	@Override
	public int createTable(String tableName) {
		return getMapper().createTable(tableName);
	}

	// 以下暂时没有场景用到，留在这里，需要时候根据实际情况进行修改即可。
	@Override
	public void insert(T entity, String tableName) {
		this.getMapper().insert(entity, tableName);
	}

	@Override
	public int insertByBatch(List<T> list, String tableName) {
		return this.getMapper().insertByBatch(list, tableName);
	}

	@Override
	public int update(List<T> list, String tableName) {
		return this.update(list, tableName);
	}
	
	@Override
	public int updateByBatch(LinkedHashMap<String, String> condition, String field, String tableName) {
		return this.getMapper().updateByBatch(condition, field, this.getTableName());
	}

	@Override
	public T getById(int id, String tableName) {
		return this.getMapper().getById(id, tableName);
	}

	@Override
	public T getOne(LinkedHashMap<String, String> condition, String field, String tableName) {
		return this.getMapper().getOne(condition, field, tableName);
	}

	@Override
	public int getCount(LinkedHashMap<String, String> condition, String field, String tableName) {
		return this.getMapper().getCount(condition, field, tableName);
	}

	@Override
	public List<T> getList(LinkedHashMap<String, String> condition, int offset, int limit, String order, String field, String tableName) {
		return this.getMapper().getList(condition, offset, limit, order, field, tableName);
	}

}



