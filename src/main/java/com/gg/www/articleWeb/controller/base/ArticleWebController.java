package com.gg.www.articleWeb.controller.base;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import java.math.BigDecimal;

import com.gg.www.common.JsonResult;
import com.gg.www.articleWeb.service.IArticleWebService;
import com.gg.www.articleWeb.domain.ArticleWeb;
import com.gg.www.articleWeb.vo.ArticleWebVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年06月17日 14:30:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  


@Api(tags="ArticleWebController")
@RestController
@RequestMapping("/articleWeb/base/articleWeb")
public class ArticleWebController {

private static Logger logger = LoggerFactory.getLogger("programLog");

	@Autowired
	protected JsonResult jsonResult;


	@Resource
	protected IArticleWebService articleWebService;

	@ApiOperation(value="添加或修改", notes="添加或修改ArticleWeb" ,httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token",value="token",required=true,paramType="header"),
		@ApiImplicitParam(name="articleWebId",value="增长ID",required=false,paramType="query",dataType="String"),
		@ApiImplicitParam(name="title",value="标题",required=false,paramType="query",dataType="String"),
		@ApiImplicitParam(name="categoryName",value="分类名称",required=false,paramType="query",dataType="String"),
		@ApiImplicitParam(name="summary",value="简介",required=false,paramType="query",dataType="String"),
		@ApiImplicitParam(name="content",value="内容",required=false,paramType="query",dataType="String"),
		@ApiImplicitParam(name="tbStatus",value="状态",required=false,paramType="query",dataType="String")
	})
	@RequestMapping(value = "/aeArticleWeb", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String aeArticleWeb(HttpServletRequest request, String articleWebId,
							   @RequestParam(required = false) String title,
							   @RequestParam(required = false) String categoryName,
							   @RequestParam(required = false) String summary,
							   @RequestParam(required = false) String content,
							   @RequestParam(required = false) String tbStatus) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("articleWebId", articleWebId);
		paramMap.put("title", title);
		paramMap.put("categoryName", categoryName);
		paramMap.put("summary", summary);
		paramMap.put("content", content);
		paramMap.put("tbStatus", tbStatus);
		if (articleWebId == null || articleWebId.trim().length() == 0) {
			if (title == null || "".equals(title.trim()) || categoryName == null || "".equals(categoryName.trim()) || summary == null || "".equals(summary.trim()) || content == null || "".equals(content.trim())) {
				return this.jsonResult.error(201, "参数为空错误！！！！", paramMap);
			}
			if (title.length() > 255 || categoryName.length() > 50 ) {
				return this.jsonResult.error(201, "参数长度过长错误！！！！", paramMap);
			}
			tbStatus = "正常";
			ArticleWeb articleWeb = new ArticleWeb();

			boolean isAdd = true;
			return this.aeArticleWeb(request, articleWeb,title,categoryName,summary,content,tbStatus, isAdd);
		} else {
			Integer articleWebIdNumeri = articleWebId.matches("^[0-9]*$") ? Integer.parseInt(articleWebId) : 0;
			if (articleWebIdNumeri == 0) {
				return this.jsonResult.error(201, "主键不为数字错误！！！！");
			}
			ArticleWeb articleWeb = this.articleWebService.getById(articleWebIdNumeri);
			boolean isAdd = false;
			return this.aeArticleWeb(request, articleWeb,title,categoryName,summary,content,tbStatus, isAdd);
		}
	}

private String aeArticleWeb(HttpServletRequest request, ArticleWeb articleWeb, String title, String categoryName, String summary, String content, String tbStatus, boolean isAdd) {
		if (title != null && !("".equals(title.trim()))) {
			if(title.length() > 255) {
				return this.jsonResult.error(201, "参数长度过长错误！！！！title");
			} 
			articleWeb.setTitle(title);
		}
		if (categoryName != null && !("".equals(categoryName.trim()))) {
			if(categoryName.length() > 50) {
				return this.jsonResult.error(201, "参数长度过长错误！！！！categoryName");
			} 
			articleWeb.setCategoryName(categoryName);
		}
		if (summary != null && !("".equals(summary.trim()))) {
//			if(summary.length() > 0) {
//				return this.jsonResult.error(201, "参数长度过长错误！！！！summary");
//			}
			articleWeb.setSummary(summary);
		}
		if (content != null && !("".equals(content.trim()))) {
//			if(content.length() > 0) {
//				return this.jsonResult.error(201, "参数长度过长错误！！！！content");
//			}
			articleWeb.setContent(content);
		}
		if (tbStatus != null && !("".equals(tbStatus.trim()))) {
			if(tbStatus.length() > 50) {
				return this.jsonResult.error(201, "参数长度过长错误！！！！tbStatus");
			} 
			articleWeb.setTbStatus(tbStatus);
		}
		if (isAdd) {
			this.articleWebService.insert(articleWeb);
			if (articleWeb.getArticleWebId() > 0) {
				return this.jsonResult.ok();
			} else {
				return this.jsonResult.error(202, "insert false");
			} 
		}
		List<ArticleWeb> list = new ArrayList<>();
		list.add(articleWeb);
		int num = this.articleWebService.update(list);
		if (num > 0) {
			return this.jsonResult.ok();
		} else {
			return this.jsonResult.error(202, "update false");
		}
	}


	@ApiOperation(value="批量添加或修改，参数自定义", notes="批量添加或修改，参数自定义ArticleWeb" ,httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token",value="token",required=true,paramType="header"),
	})
	@RequestMapping(value = "/addArticleWebList", produces = "application/json;charset=UTF-8")
	public String addArticleWebList(@RequestParam(defaultValue = "正常", required = false) String tbStatus) {
		List<ArticleWeb> list = new ArrayList<>();
		ArticleWeb articleWeb = new ArticleWeb();
		for (int i = 0; i < 10; i++) {
			articleWeb = new ArticleWeb();
			// 这里添加想要新增的内容 
			list.add(articleWeb);
		}
		// num 返回插入的条数
		int num = this.articleWebService.insertByBatch(list);
		for (ArticleWeb obj : list) {
			// 列表新增会返回所有的ID，演示获取ID方式 
			System.out.println("ArticleWebController|addArticleWebList|" + obj.getArticleWebId());
		}
		return this.jsonResult.ok(num);
	}

	@ApiOperation(value="条件修改，多条数据", notes="条件修改，多条数据ArticleWeb" ,httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token",value="token",required=true,paramType="header"),
	})
	@RequestMapping(value = "/editArticleWebByBatch", produces = "application/json;charset=UTF-8")
	public String editArticleWebByBatch(@RequestParam(defaultValue = "正常", required = false) String tbStatus) {
		LinkedHashMap<String, String> condition = new LinkedHashMap<String, String>();
		if (tbStatus != null && tbStatus.trim().length() > 0) {
			condition.put("tb_status='" + tbStatus + "'", "and");
		}
		if (condition.size() > 0) {
			condition.put(condition.entrySet().iterator().next().getKey(), "");
		}
		StringBuffer fieldBuf = new StringBuffer();
		fieldBuf.append("tb_status='正常' ");
		// 可以这样写，这个是例子 
		//fieldBuf.append(",");
		//fieldBuf.append("nickname='").append(nickname).append("'");
		String field = fieldBuf.toString();
		int num = this.articleWebService.updateByBatch(condition, field);
		// num 返回的是成功更新的条数 
		return this.jsonResult.ok(num);
	}

	@ApiOperation(value="根据ID获得一条数据", notes="根据ID获得一条数据ArticleWeb" ,httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token",value="token",required=true,paramType="header"),
	})
	@RequestMapping(value = "/getArticleWebById", produces = "application/json;charset=UTF-8")
	public String getArticleWebById(String articleWebId) {
		if (articleWebId == null || articleWebId.length() == 0 || articleWebId.length() > 11) {
			return this.jsonResult.parameterError("参数为空或参数过长错误！！！", null);
		}
		Integer articleWebIdNumNumeri = articleWebId.matches("^[0-9]*$") ? Integer.parseInt(articleWebId) : 0;
		if (articleWebIdNumNumeri == 0 ) {
			return this.jsonResult.parameterError("参数数字型错误！！！！", null);
		}
		ArticleWeb articleWeb = this.articleWebService.getById(articleWebIdNumNumeri);
		if (articleWeb != null && articleWeb.getArticleWebId() > 0) {
			return this.jsonResult.ok(articleWeb);
		} else {
			return this.jsonResult.noRecord();
		}
	}


	@ApiOperation(value="根据条件获得一条数据", notes="条件获得一条数据ArticleWeb" ,httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token",value="token",required=true,paramType="header"),
	})
	@RequestMapping(value = "/getOneArticleWeb", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String getOneArticleWeb(@RequestParam(defaultValue = "正常", required = false) String tbStatus) {
		LinkedHashMap<String, String> condition = new LinkedHashMap<String, String>();
		condition.put("tb_status='" + tbStatus + "'", "");
		ArticleWeb articleWeb = this.articleWebService.getOne(condition);
		if (articleWeb != null && articleWeb.getArticleWebId() > 0) {
			return this.jsonResult.ok(articleWeb);
		} else {
			return this.jsonResult.noRecord();
		}
	}

	@ApiOperation(value="分页获得数据List", notes="分页获得数据ListArticleWeb" ,httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token",value="token",required=true,paramType="header"),
		@ApiImplicitParam(name="pageNo",value="页数",required=false,paramType="query",dataType="Integer", defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页条数",required=false,paramType="query",dataType="Integer", defaultValue="10"),
		@ApiImplicitParam(name="keyword",value="关键字",required=false,paramType="query",dataType="String", defaultValue=""),
		@ApiImplicitParam(name="tbStatus",value="状态",required=false,paramType="query",dataType="String", defaultValue="正常"),
		@ApiImplicitParam(name="order",value="排序",required=false,paramType="query",dataType="String", defaultValue="article_web_id"),
		@ApiImplicitParam(name="desc",value="倒序",required=false,paramType="query",dataType="String", defaultValue="desc")
	})
	@RequestMapping(value = "/getArticleWebList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String getArticleWebList(HttpServletRequest request,
		@RequestParam(defaultValue = "1", required = false) Integer pageNo,  
		@RequestParam(defaultValue = "10", required = false) Integer pageSize, 
		@RequestParam(defaultValue = "正常", required = false) String tbStatus, 
		@RequestParam(required = false) String startTime, 
		@RequestParam(required = false) String endTime, 
		@RequestParam(required = false) String keyword, 
		@RequestParam(defaultValue = "article_web_id", required = false) String order,
		@RequestParam(defaultValue = "desc", required = false) String desc ) {
		LinkedHashMap<String, String> condition = new LinkedHashMap<String, String>();
		if (tbStatus != null && tbStatus.trim().length() > 0) {
			condition.put("tb_status='" + tbStatus + "'", "and");
		}
		if (startTime != null && startTime.trim().length() > 0) {
			condition.put("create_time >= '" + startTime + "'", "and");
		}
		if (endTime != null && endTime.trim().length() > 0) {
			condition.put("create_time < '" + endTime + "'", "and");
		}
		if (keyword != null && keyword.trim().length() > 0) {
			StringBuffer buf = new StringBuffer();
			buf.append("(");
			buf.append("title like '%").append(keyword).append("%'");
			buf.append(" or ");
			buf.append("category_name like '%").append(keyword).append("%'");
			buf.append(" or ");
			buf.append("summary like '%").append(keyword).append("%'");
			buf.append(" or ");
			buf.append("content like '%").append(keyword).append("%'");
			buf.append(")");
			condition.put(buf.toString(), "and");
		}
		String field = null;
		if (condition.size() > 0) {
			condition.put(condition.entrySet().iterator().next().getKey(), "");
		}
		int count = this.articleWebService.getCount(condition, field);
		if (order != null && order.length() > 0 && "desc".equals(desc)) {
			order = order + " desc";
		}
		List<ArticleWeb> list = this.articleWebService.getList(condition, pageNo, pageSize, order, field);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", count);
		int size = list.size();
		if (size > 0) {
			List<ArticleWebVo> listVo = new ArrayList<ArticleWebVo>();
			ArticleWeb articleWeb;
			ArticleWebVo vo = new ArticleWebVo(); 
			for (int i = 0; i < size; i++) {
				articleWeb = list.get(i);
				BeanUtils.copyProperties(articleWeb, vo);
				listVo.add(vo);
				vo = new ArticleWebVo();
			}
			map.put("list", listVo);
				return this.jsonResult.ok(map);
		} else {
			return this.jsonResult.noRecord();
		}
	}

}

