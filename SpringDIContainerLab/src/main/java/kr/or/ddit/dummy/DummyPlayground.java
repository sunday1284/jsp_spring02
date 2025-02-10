package kr.or.ddit.dummy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.dummy.config.DummySpringJavaConfig;
import kr.or.ddit.dummy.dao.DummyDAO;
import kr.or.ddit.dummy.dao.DummyDAOImplForMariaDB;
import kr.or.ddit.dummy.dao.DummyDAOImplForOracle;
import kr.or.ddit.dummy.service.DummyServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyPlayground {
	public static void main(String[] args) {
		//스프링 최상위 컨테이너 생성 ->  DummySpringJavaConfig 설정파일을 참조하여 객체 생성
		ApplicationContext context =
				new AnnotationConfigApplicationContext(DummySpringJavaConfig.class);
		DummyServiceImpl service = context.getBean(DummyServiceImpl.class);
		log.info("service : {}", service);
	}
}
