package kr.or.ddit.case07.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import kr.or.ddit.case07.objs.Case07ObjectWithResources;

@Configuration
public class Case07ResouresJavaConfig {
//	1. 컨테이너는 내부에 등록된 빈들에 자기 자신에 대한 참조를 주입할 수 있음.
	@Autowired
	private ResourceLoader context;
	// 2. 수동 주입 방식
	@Bean
	public Case07ObjectWithResources owr1() {
		Resource fileSystemResource = context.getResource("file:D:/00.medias/images/cat1.jpg");
		Resource classpathResource = context.getResource("classpath:kr/or/ddit/case06/admin/config/admin-context.xml");
		Resource webResource = context.getResource("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		
		Case07ObjectWithResources owr =
				new Case07ObjectWithResources(fileSystemResource, classpathResource);
		owr.setWebRes(webResource);
		return owr;
	}
	
	//2. value 어노테이션으로 가져오는법
	@Bean
	public Case07ObjectWithResources owr2(
		@Value("file:D:/00.medias/images/cat1.jpg") Resource fsRes
		, @Value("classpath:kr/or/ddit/case06/admin/config/admin-context.xml") Resource cpRes
		, @Value("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png") Resource webRes
	) {
		Case07ObjectWithResources owr =
				new Case07ObjectWithResources(fsRes, cpRes);
		owr.setWebRes(webRes);
		return owr;
	}
}
