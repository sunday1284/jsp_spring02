package kr.or.ddit.m1.objs;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Data
public class Foo {
	private final Bar bar;
	
	@Autowired
	private Baz baz;
	
	@PostConstruct
	public void init() {
		log.info("init method 실행");
	}
	
//	//필수 의존객체
//	public Foo(Bar bar) {
//		super();
//		this.bar = bar;
//    }
//	
//	//setter 객체
//	
//	public void setBaz(Baz baz) {
//        this.baz = baz;
//    }
	
}
