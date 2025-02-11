package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case03.config.Case03InitializationPolicyJavaConfig;
import kr.or.ddit.case03.objs.EagerObject;
import kr.or.ddit.case03.objs.LazyObject;

public class Case03InitializationPolicyPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case03InitializationPolicyJavaConfig.class);
		){
			context.registerShutdownHook();
//			context.getBean(EagerObject.class);
//			context.getBean(LazyObject.class);
			
		}
	}
}
