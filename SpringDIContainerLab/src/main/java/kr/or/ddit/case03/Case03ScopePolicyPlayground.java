package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case03.config.Case03ScopePolicyJavaConfig;
import kr.or.ddit.case03.objs.NonSigletonObject;
import kr.or.ddit.case03.objs.SingletonObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case03ScopePolicyPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case03ScopePolicyJavaConfig.class);
		){
			context.registerShutdownHook();
			
//			SingletonObject sigleton1 = context.getBean(SingletonObject.class);
//			SingletonObject sigleton2 = context.getBean(SingletonObject.class);
//			SingletonObject sigleton3 = context.getBean(SingletonObject.class);
//			log.info("singleton1 == singleton2 : {}", sigleton1 == sigleton2);
//			log.info("singleton2 == singleton3 : {}", sigleton2 == sigleton3);
//			
//			NonSigletonObject non1 = context.getBean(NonSigletonObject.class);
//			NonSigletonObject non2 = context.getBean(NonSigletonObject.class);
//			NonSigletonObject non3 = context.getBean(NonSigletonObject.class);
//			log.info("non1 == non2 : {}", non1 == non2);
//			log.info("non2 == non3 : {}", non2 == non3);
		}
	}
}
