package com.firemorey.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author sen
 * MybatisPlus配置类
 */
@Configuration
public class MybatisPlusConfig {

  /**
   * 分页
   *
   * @return PaginationInterceptor
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

  /**
   * SQL执行效率插件,很好用！值得推荐，可以在控制台查看执行的sql时间以及执行的语句！！！！！！！
   * 正式环境可以去掉
   */
  @Bean
  @Profile("dev")
  public PerformanceInterceptor performanceInterceptor() {
    return new PerformanceInterceptor();
  }
}
