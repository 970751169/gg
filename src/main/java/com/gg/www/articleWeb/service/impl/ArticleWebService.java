package com.gg.www.articleWeb.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gg.www.common.AbstractService;
import com.gg.www.common.IOperations;
import com.gg.www.articleWeb.mapper.IArticleWebMapper;
import com.gg.www.articleWeb.domain.ArticleWeb;
import com.gg.www.articleWeb.service.IArticleWebService;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年06月17日 14:30:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

@Service("articleWebService")
public class ArticleWebService extends AbstractService<ArticleWeb> implements IArticleWebService {

	public ArticleWebService() {
		this.setTableName("article_web");
	}
	@Resource
	private IArticleWebMapper articleWebMapper;

	@Override
	protected IOperations<ArticleWeb> getMapper() {
		return articleWebMapper;
	}
	@Override
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
}

