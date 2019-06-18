package com.gg.www.common;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年01月19日 16:05:04  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/ 
public interface IOperations<T extends Serializable> {

	void insert(@Param("entity") final T entity, @Param("tableName") String tableName);

	int insertByBatch(@Param("list") List<T> list, @Param("tableName") String tableName);

	int update(@Param("list") List<T> list, @Param("tableName") String tableName);
	
	int updateByBatch(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);

	T getById(@Param("id") final int id, @Param("tableName") String tableName);

	T getOne(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);

	int getCount(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);

	List<T> getList(@Param("condition") LinkedHashMap<String, String> condition, @Param("offset") int offset, @Param("limit") int limit, @Param("order") String order,
			@Param("field") String field, @Param("tableName") String tableName);

	// 以下方法特殊，为判断表是否存在，批量和创建表

	int existTable(@Param("tableName") String tableName);

	int createTable(@Param("tableName") String tableName);

}



