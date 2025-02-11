package kr.or.ddit.m1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.m1.config.Misson01JavaConfig;
import kr.or.ddit.m1.objs.Foo;
import lombok.extern.slf4j.Slf4j;

/**
 * objs.Foo, objs.Bar, objs.Baz
 * 
 * Foo has a required bar (Bar) 
 * Foo has a optional baz (Baz)
 */
@Slf4j
public class Mission01Playground {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Misson01JavaConfig.class)
		){
			context.registerShutdownHook();
			log.info("foo: {}", context.getBean(Foo.class));
		}
	}
}
