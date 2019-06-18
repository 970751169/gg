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
public interface IServiceOperations<T extends Serializable> extends IOperations<T> {

	void setTableName(String tableName);
	
	void insert(final T entity);
	
	int insertByBatch(List<T> list);

	int update(List<T> list);
	
	int updateByBatch(LinkedHashMap<String, String> condition, String field);

	T getById(final int id);

	T getOne(LinkedHashMap<String, String> condition, String field);

	int getCount(LinkedHashMap<String, String> condition, String field);

	List<T> getList(int pageNo, int pageSize);

	List<T> getList(int pageNo, int pageSize, String order);

	List<T> getList(int pageNo, int pageSize, String order, String field);

	List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize);

	List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize, String order);
	
	public List<T> getAllList(LinkedHashMap<String, String> condition);
	
	public List<T> getAllList(LinkedHashMap<String, String> condition, String order);

	T getOne(LinkedHashMap<String, String> condition);

	List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize, String order, String field);
}



