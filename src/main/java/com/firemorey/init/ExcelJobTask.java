package com.firemorey.init;

import com.firemorey.controller.PatriotController;
import com.firemorey.service.PatriotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
@Lazy(false) // 为了避免spring懒加载造成的定时任务失效，必须加上此注解@Lazy(false)//为了避免spring懒加载造成的定时任务失效，必须加上此注解
public class ExcelJobTask implements InitializingBean {
	@Resource
	private PatriotService patriotService;

	// 这个保证项目启动时会执行一次
	@Override
	public void afterPropertiesSet() throws Exception {
		int c = patriotService.count();
		PatriotController.count.set(c);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>用户数量统计已更新>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}
