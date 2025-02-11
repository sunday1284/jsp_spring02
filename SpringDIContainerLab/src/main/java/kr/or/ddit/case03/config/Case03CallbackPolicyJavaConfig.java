package kr.or.ddit.case03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kr.or.ddit.case01.config.Case01BeanRegistJavaConfig;
import kr.or.ddit.case01.objs.ObjectWithDefaultConstructor;
import kr.or.ddit.case02.config.Case02DependencyInjectionJavaConfig;
import kr.or.ddit.case02.objs.Case02DummyDAO;
import kr.or.ddit.case03.objs.ManagedObject;

/**
 * 스프링 DI 컨테이너의 콜백 호출 구조.
 * 		@Bean(initMethod, destroyMethod) 설정을 통한 콜백 메서드 호출
 * 		initMethod : 객체 생성 후 필요한 모든 객체의 주입이 완료된 후 호출되는 메서드
 * 		destroyMethod : 객체 소멸 전 호출되는 메서드, Scope 정책에 따라 다른 시점에 호출됨. 
 */
@Configuration
@Import({Case01BeanRegistJavaConfig.class, Case02DependencyInjectionJavaConfig.class})
public class Case03CallbackPolicyJavaConfig {
	
	@Bean(initMethod = "initCustom", destroyMethod = "destroyCustom")
	public ManagedObject managedObject(
		ObjectWithDefaultConstructor owdc
		, Case02DummyDAO dao
	) {
		ManagedObject mngd = new ManagedObject(owdc);
		mngd.setDao(dao);
		return mngd;
	}
}
