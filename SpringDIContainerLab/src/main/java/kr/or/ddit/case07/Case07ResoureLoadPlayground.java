package kr.or.ddit.case07;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.management.RuntimeErrorException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import kr.or.ddit.case07.config.Case07ResouresJavaConfig;
import kr.or.ddit.case07.objs.Case07ObjectWithResources;
import lombok.extern.slf4j.Slf4j;

/**
 * 파일 형태의 자원(resource)의 종류 (파일의 위치와 접근 경로 표현에 따른 분류)
 * 1. filesystem resource : D:/00.medias/images/cat1.jpg(physical path) 진짜 경로
 * 
 * 2. classpath resource : kr/or/ddit/case06/admin/config/admin-context.xml(logical path) 논리 경로
 * 
 * 3. web resource(with url) : 
 * 		https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png(logical path)
 */
@Slf4j
public class Case07ResoureLoadPlayground {
	private static String staticProp = "스태틱 프로퍼티의 값";
	public static String staticMethod() {
		return "정적 메소드 반환값";
	}
	
	public static void main(String[] args) {
		
		
		try(
			ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case07ResouresJavaConfig.class);
		){
			context.registerShutdownHook();
			//id 값이 메서드
			log.info("{}", context.getBean("owr2",Case07ObjectWithResources.class));
		}
	} 
	
	private static void afterSpring() {
//		Resource : 스프링에서 모든 종류의 자원에 대한 추상화
//		ResourceLoader : 자원을 검색하고, 로딩하는 방법에 대한 추상화 
		ResourceLoader context = new AnnotationConfigApplicationContext();
		//file: 파일 시스템 경로 , classpath: classpath경로
		Resource fileSystemResource = context.getResource("file:D:/00.medias/images/cat1.jpg");
		Resource classpathResource = context.getResource("classpath:kr/or/ddit/case06/admin/config/admin-context.xml");
		Resource webResource = context.getResource("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		
		// folder를 표현할때 마지막에 / 를 붙여줌
		Resource copied = context.getResource("file:D:/00.medias/copied/");
		streamCopy(fileSystemResource, copied);
		streamCopy(classpathResource, copied);
		streamCopy(webResource, copied);
	}
	
	private static void streamCopy(Resource original, Resource copied) {
		try(
			InputStream is = original.getInputStream();
		) {
		    String filename = original.getFilename();
		    Resource copiedFileResource = copied.createRelative(filename);
		    Path copiedFilePath = copiedFileResource.getFile().toPath();
		    // StandardCopyOption.REPLACE_EXISTING :해당 파일이 존재할때 복사 안함
		    Files.copy(is, copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
		    
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	private static void beforeSpring() throws MalformedURLException {
//		1. filesystem resource
		File fileSystemResource = new File("D://00.medias//images//cat1.jpg");
		Path fileSystemRosourcePath = Paths.get("D://00.medias//images//cat1.jpg");
		
//		2. classpath resource
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		String physicalPath = cl.getResource("kr/or/ddit/case06/admin/config/admin-context.xml").getFile();
		log.info("물리 경로 : {}", physicalPath);
		
//		3. web resource
		
		URL webUrl = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
	}
}
