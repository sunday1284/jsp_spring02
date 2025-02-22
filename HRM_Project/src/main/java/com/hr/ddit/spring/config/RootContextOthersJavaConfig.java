package com.hr.ddit.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class RootContextOthersJavaConfig {
	
	@Bean
	public PropertiesFactoryBean fileInfo(
		@Value("classpath:com/hr/ddit/FileInfo.properties") Resource location	
	) {
		PropertiesFactoryBean factory = new PropertiesFactoryBean();
		factory.setLocation(location);
		return factory;
	}
	
	@Bean
	public MultipartResolver filterMultipartResolver(
		@Value("#{fileInfo.maxFileSize}") long maxFileSize //byte 단위
		,@Value("#{fileInfo.maxRequestSize}") long maxRequestSize //byte 단위
	) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		//업로드 정책 
		//파일 모든 사이즈
		multipartResolver.setMaxUploadSize(maxRequestSize*1024*1024);
		//파일 한개의 사이즈
		multipartResolver.setMaxUploadSizePerFile(maxFileSize*1024*1024);
		
		return multipartResolver;
	}
}
