package kr.or.ddit.case01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.case01.objs.ObjectWithDefaultConstructor;
import kr.or.ddit.case01.objs.ObjectWithFinalProperty;

/**
 * 스프링 DI 컨테이너 사용 단계
 * 1. spring-context 의존성 추가 (pom.xml)
 * 2. 컨테이너 내부에서 관리될 객체의 타입(class) 정의 (objs 패키지)
 * 3. 컨테이너 내부에 관리할 객체(bean) 등록하기 위한 설정 파일 작성 : case01
 * 		(java config [@Configuration], xml config)
 * 4. 등록된 빈들간의 관계 형성. (의존성 주입, Dependency Injection) : case02
 * 5. 어플리케이션의 엔트리 포인트에서 컨테이너 객체 생성 : ApplicationContext
 * 6. 컨테이너 객체를 통해 빈(객체)를 검색 및 사용
 *    검색 조건 : 빈의 타입, 빈의 id
 * 
 * 
 * ** 빈을 등록하는 방법 
 * 1. 객체를 생성하는 메소드 정의 
 * 2. 해당 메소드의 리턴 타입에 @Bean 어노테이션을 추가 
 * 3. 필요시 등록되는 빈의 식별자(id) 를 value 속성을 통해 설정함.
 *    - 해당 속성을 생략한 경우, 메소드명이 id로 설정됨.
 */

@Configuration
public class Case01BeanRegistJavaConfig {
	
	@Bean
	public ObjectWithDefaultConstructor owdc() {
		return new ObjectWithDefaultConstructor();
	}
	
	@Bean("withProperty1")
	public ObjectWithFinalProperty owfp1() {
		return new ObjectWithFinalProperty("테스트1");
	}
	
	@Bean("withProperty2")
	public ObjectWithFinalProperty owfp2() {
		return new ObjectWithFinalProperty("테스트2");
	}
}
