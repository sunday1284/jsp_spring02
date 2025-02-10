package kr.or.ddit.case02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kr.or.ddit.case01.config.Case01BeanRegistJavaConfig;
import kr.or.ddit.case01.objs.ObjectWithDefaultConstructor;
import kr.or.ddit.case02.objs.Case02DummyDAO;
import kr.or.ddit.case02.objs.Case02DummyService;

/**
 * 컨테이너 내부에 등록된 객체(bean)들 간 의존관계 설정을 Java Config로 설정하는 방법
 * 의존관계 형성 : Dependency Injection(의존성 주입)
 * 1. 의존성 주입 방법 설정 
 *  - 생성자 주입(Constructor Injection) : 필수 주입 객체인 경우 주로 활용
 *  - setter 주입(Setter Injection)
 *  2. 설정된 주입 방식에 따라 빈을 주입하는 단계
 *   1) 객체가 등록되고 있는 메소드를 직접 호출할 수 있는 경우.
 *     ex) 생성자 주입 : 생성자의 아규먼트로 주입할 빈이 생성되는 메소드를 직접 호출.
 *     ex) setter 주입 : setter의 아규먼트로 주입할 빈이 생성되는 메소드를 직접 호출.
 *   2) **** 메소드를 직접 호출할 수 없는 경우, 빈을 등록하고 있는 메소드의 아규먼트로  가능하면 2번째 방식 선호
 *   	주입할 대상이 되는 객체(빈) 의 타입을 선언해서 주입받을 수 있음.
 *   3) 주입할 대상을 선별할 때 타입으로만 검색한다면, NoUniqueBeanDefinitionException 발생 가능
 *   	주입할 대상의 빈 아이디를 명시해서 주입받는 방법도 있음. 
 */
@Configuration
//외부에 있는 설정 파일을 불러올 때 쓰는 방법
@Import(Case01BeanRegistJavaConfig.class)
public class Case02DependencyInjectionJavaConfig {
	
	@Bean
	public Case02DummyDAO dummyDAO() {
		return new Case02DummyDAO();
	}
	
	//DAO 객체를 주입받는 방법
	// jdk23에서는 작동x
	@Bean
	public Case02DummyService dummyService(
		Case02DummyDAO dummyDAO
		,ObjectWithDefaultConstructor owdc
	) {
	
		Case02DummyService serivce = new Case02DummyService(dummyDAO); 
		serivce.setOwdc(owdc);
		return serivce;
	}
}
