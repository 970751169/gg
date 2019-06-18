/**  
 * <p>Title: ShiroLoginFilter.java</p>  
 * <p>Description: </p>   
 * @author zengqinghua  
 * @date 2018年9月17日  
 * @version 1.0  
 */
package com.gg.www.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
 * @ClassName: ShiroLoginFilter  
 * @Description: TODO  
 * @author zengqinghua
 * @date 2018年9月17日  
 */
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

@Component("originFilter")
@ServletComponentScan
@WebFilter(urlPatterns = "/*", filterName = "shiroLoginFilter")
public class OriginFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		//指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许请求的方法
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT");
		// 多少秒内，不需要再发送预检验请求，可以缓存该结果
		response.setHeader("Access-Control-Max-Age", "3600");
		// 表明它允许跨域请求包含xxx头
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires,userAgent,User-Agent,version, " +
				" Content-Type, content-type,X-E4M-With,Authorization,Token,authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(200);
			response.getWriter().write("OPTIONS returns OK");
			return;
		}
		filterChain.doFilter(servletRequest, response);
	}
}

