package kr.or.ddit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.spring.config.RootContextJavaConfig;



/**
 * 설정파일을 커스텀으로 불러오는 어노테이션
 */
@SpringJUnitWebConfig(RootContextJavaConfig.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomRootContextConfig {
	
}
