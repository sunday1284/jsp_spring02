package kr.or.ddit.case04.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * 필요한 모든 빈을 등록하고, 의존성 주입 설정.
 * 모든 객체는 필요 시점 전까지는 객체 생성 지연됨.
 * Mapper, service, controller 구조 
 * 
 * Component scan 구조를 활용해 어노테이션 기반으로 빈을 등록하고 의존 관계를 형성하는 방법.
 * 
 * 1. scan 의 대상이 되는 패키지 결정 @ComponentScan(basePackage).
 * 2. 해당 패키지 내의 클래스 중 빈으로 등록될 수 있는 클래스를 선별하는 기준.
 */
@Configuration
@ComponentScan("kr.or.ddit.case04.objs")
//@Lazy
public class Case04AutoWiringPolicyJavaConfig {
	
//	@Bean
//	public Case04DummyMapperImpl mapper() {
//		return new Case04DummyMapperImpl();
//	}
//	
//	@Bean
//	public Case04DummyService service(Case04DummyMapper mapper) {
//		return new Case04DummyServiceImpl(mapper);
//	}
//	/** 매우 중요!! -> init는 주입이 완료된 후에 호출
//	 * @param service
//	 * @return
//	 */
//	@Bean(initMethod = "init")
//	public Case04DummyController controller(Case04DummyService service) {
//		Case04DummyController controller = new Case04DummyController();
//		controller.setService(service);
//		return controller;
//	}
	

	
	
}
