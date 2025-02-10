package kr.or.ddit.case02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case02.config.Case02DependencyInjectionJavaConfig;

public class Case02DependencyInjectionPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context = 
			    new AnnotationConfigApplicationContext(Case02DependencyInjectionJavaConfig.class);
		){
			
			context.registerShutdownHook();
			
		}
	}
}
