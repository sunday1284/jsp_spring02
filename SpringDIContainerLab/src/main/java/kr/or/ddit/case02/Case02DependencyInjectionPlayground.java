package kr.or.ddit.case02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case01.objs.ObjectWithFinalProperty;
import kr.or.ddit.case02.config.Case02DependencyInjectionJavaConfig;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Case02DependencyInjectionPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context = 
			    new AnnotationConfigApplicationContext(Case02DependencyInjectionJavaConfig.class);
		){
			
			context.registerShutdownHook();
			ObjectWithFinalProperty owfp = context.getBean("withProperty1",ObjectWithFinalProperty.class);
			log.info("owfp : {}", owfp);
		}
	}
}
