package kr.or.ddit.case08.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import kr.or.ddit.case08.objs.Case08CopiedObj;
import kr.or.ddit.case08.objs.Case08OriginObj;

/**
 * Spring EL(Expression Language, spEL)
 * 	: 빈이 가진 프로퍼티와 메소드들에 접근하는 방법을 정의하고 있는 언어.
 * 	dot notation (.), associative array([''])
 * 	 #{beanId.propertyName}, #{beanId['propertyName']} 
 * 	산술연산자 : + - *//*
 *		+ : 피연산자의 타입이 문자열인 경우, concat 연산 수행.
 *		+ : 피연산자의 타입이 문자열인 경우, 우측 피연산자가 숫자인 경우, 해당 숫자만큼의 배수로 문자열의 길이를 늘림.
 *  논리연산자 
 *  비교연산자
 *  3항 연산자 조건?참:거짓
 *  
 *  정적 구성요소에 접근하는 방법
 *  #{T(kr.or.ddit.case07.Case07ResoureLoadPlayground).staticProp}
 *		 
 */
@Configuration
public class Case08SpringELJavaConfig {
	
	@Bean
	public Case08CopiedObj copiedObj3(
		@Value("#{T(kr.or.ddit.case07.Case07ResoureLoadPlayground).staticMethod()}") String str	
		//+''로 붙일수 있음 -> 타입  -> el타입의 타입을 따라감
		,@Value("#{copiedObj2['num'] + 23}") int num
		, @Value("#{copiedObj2.flag}") boolean flag
		, @Value("#{copiedObj2.webRes}") Resource webRes
	) {
		Case08CopiedObj copied = new Case08CopiedObj();
		copied.setStr(str);
		copied.setNum(num);
		copied.setFlag(flag);
		copied.setWebRes(webRes);
		return copied;
	}
	@Bean
	public Case08CopiedObj copiedObj2(
		@Value("#{original.str}") String str	
		//+''로 붙일수 있음 -> 타입  -> el타입의 타입을 따라감
		,@Value("#{original['numStr'] * 2}") int num
		, @Value("#{original.flagStr}") boolean flag
		, @Value("#{original.webRes}") Resource webRes
	) {
		Case08CopiedObj copied = new Case08CopiedObj();
		copied.setStr(str);
		copied.setNum(num);
		copied.setFlag(flag);
		copied.setWebRes(webRes);
		return copied;
	}
	@Bean
	public Case08CopiedObj copiedObj1(
			@Value("#{original}") Case08OriginObj origin
	) {
		Case08CopiedObj copied = new Case08CopiedObj();
		copied.setStr(origin.getStr());
		String numStr = origin.getNumStr();
		int num = Integer.parseInt(numStr);
		copied.setNum(num);
		String flagStr = origin.getFlagStr();
		boolean flag = Boolean.parseBoolean(flagStr);
		copied.setFlag(flag);
		copied.setWebRes(origin.getWebRes());
		return copied;
	}
	
	
	@Bean
	public Case08OriginObj original(
		@Value("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png") Resource webRes		
	) {
		Case08OriginObj origin = new Case08OriginObj();
		origin.setStr("원본 텍스트");
		origin.setNumStr("34");
		origin.setFlagStr("true");
		
		origin.setWebRes(webRes);
		return origin;
	}
}
