package com.hr.ddit.spring.config;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import com.hr.ddit.CustomRootContextConfig;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@CustomRootContextConfig
class RootContextJavaConfigTest {
	
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	void test() {
		log.info("sqlSessionFactory :  {} ",sqlSessionFactory);
	}

}
