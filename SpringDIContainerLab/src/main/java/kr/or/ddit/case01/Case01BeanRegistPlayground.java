package kr.or.ddit.case01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case01.config.Case01BeanRegistJavaConfig;
import kr.or.ddit.case01.objs.ObjectWithDefaultConstructor;
import kr.or.ddit.case01.objs.ObjectWithFinalProperty;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case01BeanRegistPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Case01BeanRegistJavaConfig.class);
		){
			context.registerShutdownHook();
			
			ObjectWithDefaultConstructor owdc =
					(ObjectWithDefaultConstructor) context.getBean("owdc");
			//여러 빈을 생성할 때, 빈의 이름를 통해 검색하는 방법
			ObjectWithFinalProperty owfp1 = 
					context.getBean("withProperty1", ObjectWithFinalProperty.class);
			ObjectWithFinalProperty owfp2 = 
					context.getBean("withProperty2", ObjectWithFinalProperty.class);
			log.info("owdc : {}", owdc);
			log.info("owfp1 : {}", owfp1);
			log.info("owfp2 : {}", owfp2);
		}
	}
}
