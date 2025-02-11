package kr.or.ddit.m1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.m1.objs.Bar;
import kr.or.ddit.m1.objs.Baz;
import kr.or.ddit.m1.objs.Foo;

/**
 * 셋팅파일에서 Bean을 호출해야함
 */
@Configuration
public class Misson01JavaConfig {
	
	@Bean
	public Bar bar() {
		return new Bar();
	}
	
	@Bean
	public Baz baz() {
        return  new Baz();
	}
	
	@Bean
	public Foo foo(Bar bar, Baz baz) {
		Foo foo = new Foo(bar);
		foo.setBaz(baz);

		return foo;
		
	}
	
	
}
