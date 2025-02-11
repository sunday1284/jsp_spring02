package kr.or.ddit.case06;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case04.objs.service.Case04DummyService;
import kr.or.ddit.case06.admin.objs.AdminController;
import kr.or.ddit.case06.config.ParentJavaConfig;
import kr.or.ddit.case06.user.objs.UserController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case06HierarchyConfigPlayground {
	//제네릭 타입 -> 실행 시점에 동적으로 타입 결정 <T> 
	public static void main(String[] args) {
		try(
			ConfigurableApplicationContext parent = 
				new AnnotationConfigApplicationContext(ParentJavaConfig.class);
			ConfigurableApplicationContext adminChild =
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case06/admin/config/admin-context.xml");
			ConfigurableApplicationContext userChild =
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case06/user/config/user-context.xml");
		){
			//상속 관계
			adminChild.setParent(parent);
			userChild.setParent(parent);
			
			parent.registerShutdownHook();
			adminChild.registerShutdownHook();
			userChild.registerShutdownHook();
			
			log.info("{}",adminChild.getBean(AdminController.class));
			log.info("{}",adminChild.getBean(Case04DummyService.class));
			log.info("{}",userChild.getBean(UserController.class));
			
		}
	}
}
