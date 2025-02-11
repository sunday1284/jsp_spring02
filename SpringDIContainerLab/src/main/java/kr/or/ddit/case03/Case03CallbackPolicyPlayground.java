package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case03.config.Case03CallbackPolicyJavaConfig;

public class Case03CallbackPolicyPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case03CallbackPolicyJavaConfig.class);
		){
			context.registerShutdownHook();
		}
	}
}
