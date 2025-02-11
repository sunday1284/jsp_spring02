package kr.or.ddit.case03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case03.objs.EagerObject;
import kr.or.ddit.case03.objs.LazyObject;

/**
 * 스프링 DI 컨테이너의 빈 초기화 정책 
 * Eager Initialiation(default) :  컨테이너 객체가 생성되고 초기화될때 등록한 모든 빈을 일시에 생성하는 방식.
 * Lazy Initialiation : 주입이 될 때까지 빈을 생성 시점을 지연시키는 방식. @Lazy 어노테이션으로 설정 가능.
 * 
 */
@Configuration
//@Lazy
public class Case03InitializationPolicyJavaConfig {
	@Bean
	public EagerObject eagerObject() {
		return new EagerObject();
	}
	
	@Bean
//	@Lazy
	@Scope("prototype")
	public LazyObject lazyObject() {
		return new LazyObject();
	}
}
