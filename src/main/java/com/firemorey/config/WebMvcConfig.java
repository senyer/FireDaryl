package com.firemorey.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 重写 WebMvcConfigurationSupport
 * 
 * @author Senyer
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
  /**
   * 静态资源处理：如果重写WebMvcConfigurationSupport 则需要手动放行swagger，因为自动发配置此时失效了
   */
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    // 放行swagger
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("/v2/**").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/").addResourceLocations("classpath:/META-INF/resources/");
    // 和页面有关的静态目录都放在项目的static目录下
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static");
    registry.addResourceHandler("/csrf").addResourceLocations("classpath:/META-INF/resources/");
    super.addResourceHandlers(registry);
  }
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				// 表示允许那些原始域进行跨域访问，这里"*"表示允许任意网站，实际开发建议修改为配置项。
				.allowedOrigins("*")
				// 表示是否允许客户端发送Cookie等凭证信息，这里"true"表示支持发送，涉及登陆此处必须开启。
				.allowCredentials(true)
				// .allowedMethods("GET", "POST", "DELETE", "OPTIONS","PUT")
				// 表示允许原始域发起哪些请求方式，这里"*"表示支持GET/POST等全部提交方式。
				.allowedMethods("*")
				//
				.maxAge(3600)
				// 表示允许原始域携带哪些请求头 这里"*"表示支持全部请求头
				.allowedHeaders("*")
				// 表示允许暴露哪些响应头，这里特指那些非简单的头部信息，所以用"*"无效。
				.exposedHeaders(HttpHeaders.AUTHORIZATION);
		super.addCorsMappings(registry);
	}

}