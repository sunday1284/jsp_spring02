package kr.or.ddit.case05;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case05.objs.Case05DummyController;

public class Case05XmlConfigPlayground {
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("kr/or/ddit/case05/config/case05-context.xml");
		){
			//종료조건
			context.registerShutdownHook();
			
			context.getBean(Case05DummyController.class);
		}
	}
}
