package kr.or.ddit.case03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case03.objs.NonSigletonObject;
import kr.or.ddit.case03.objs.SingletonObject;

/**
 * 스프링 DI 컨테이너 설정의 빈 관리 정책
 * 1. Scope : 기본 scoper 는 singleton 정책으로 운영됨. 어노테이션으로 설정 가능.
 *     - singleton : 한 개의 객체만 등록해서 관리함.
 *     - prototype : 주입할 때마다 객체를 생성해서 반환함.
 *     - request : HTTP 요청 당 한 개의 객체를 생성해서 반환함.
 *     - session : HTTP 세션 당 한 개의 객체를 생성해서 반환함. -> 인증객체
 * 2. Intialization 
 * 3. Callback
 */
@Configuration
public class Case03ScopePolicyJavaConfig {
	@Bean
//	@Scope("singleton")
	public SingletonObject singletonObject() {
		return new SingletonObject();
	}
	
	@Bean
	@Scope("prototype")
	public NonSigletonObject nonsigletonObject() {
		return new NonSigletonObject();
	}
}
