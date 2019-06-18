package com.gg.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gg.www.interceptor.BackUserInterceptor;

/**
 * 这里可以配置拦截器拦截那些资源，还有加载哪些拦截器
 * 
 * @author bingoWu
 *
 */

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	BackUserInterceptor backUserInterceptor;


	// 这里处理跨域，增加这个方法，就可以实现跨域访问了。
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowCredentials(true).allowedHeaders("*").allowedOrigins("*").allowedMethods("*");

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addInterceptors(registry);
//		这里开启后台权限验证，需要用户系统，configCenter 系统上线，这个才可以启用
//		如果开启全部过滤，可以在后面加上过滤 API 的 HTML ，这个只在内网有效  .excludePathPatterns("/**/swagger-resources", "/doc.html", "/**/webjars/**/**.css", "/**/webjars/**/**.js")
//		registry.addInterceptor(backUserInterceptor).addPathPatterns("/**/base/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}

