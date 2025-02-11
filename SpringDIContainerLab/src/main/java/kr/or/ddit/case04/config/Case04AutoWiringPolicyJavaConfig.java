package kr.or.ddit.case04.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * 
 * 필요한 모든 빈을 등록하고, 의존성 주입 설정.
 * 모든 객체는 필요 시점 전까지는 객체 생성 지연됨.
 * Mapper, service, controller 구조 
 * 
 * Component scan 구조를 활용해 어노테이션 기반으로 빈을 등록하고 의존 관계를 형성하는 방법.
 * 
 * 1. scan 의 대상이 되는 패키지 결정 @ComponentScan(basePackage).
 * 2. 해당 패키지 내의 클래스 중 빈으로 등록될 수 있는 클래스를 선별하는 기준(@Component).
 * 		@Repository : persistence layer
 * 		@Service : business logic layer
 * 		@Controller : controller layer
 * 		@Component : 특정 레이어가 아닌 객체 등록시 -> object와 같은 개념
 * 		@Configuration : 스프링 컨테이너 설정 파일용
 * 3. 자동으로 등록된 빈들간의 의존 관계를 형성하기 위해 의존성 주입 방법
 * 		@Autowired : 컨테이너에 등록된 빈들중 타입을 조건으로 검색하고 일치하는 빈을 주입함.
 * 		@Inject : 자바 표준 어노테이션, @Autowired(required=true) : 필수 전략 객체를 주입받을 때 씀
 * 		@Named : 자바 표준 어노테이션, 등록된 빈의 id를 통해 검색하고 주입.
 * 		@Resource : 자바 표준 어노테이션, 주입할 대상 빈을 검색시 여러 검색 조건 설정 가능 (name, type...)
 * 		1) 생성자 주입 방식 
 * 		2) setter injection
 * 4. 콜백 메소드를 지정하는 방법 : @PostContruct, @PreDestroy 
 * useDefaultFilters -> 컴포넌트 annotation 자동 매핑 설정 false-> Component 매핑 설정 x 혹은 O일때 사용
 */
@Configuration
@ComponentScan(value="kr.or.ddit.case04.objs"
	, useDefaultFilters = true
	, excludeFilters = 
			{@ComponentScan.Filter(classes = {Controller.class})}
)
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
