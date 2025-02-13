package kr.or.ddit.case11;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case11.config.Case11MybatisSpringJavaConfig;
import kr.or.ddit.case11.objs.controller.Case11ProdListController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case11Playground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context =
					new AnnotationConfigApplicationContext(Case11MybatisSpringJavaConfig.class);
		){
			context.registerShutdownHook();
			
			Case11ProdListController listController = 
					context.getBean(Case11ProdListController.class);
			int currentPage = 1;
			Map<String, Object> model = new HashMap<>();
			
			String logicalName = listController.List(currentPage, model);
			if(logicalName.startsWith("redirect:")) {
				String location = logicalName.replace("redirect:", "/ws2");
				log.info("{}를 가지고 {}로 redirect",model, location);
			}else {
				String prefix = "/WEB-INF/views/";
				String suffix = ".jsp";
				String path = prefix+logicalName+suffix;
				log.info("{}를 가지고 {}로 forward",model, path);
			}
		}
	}
}
