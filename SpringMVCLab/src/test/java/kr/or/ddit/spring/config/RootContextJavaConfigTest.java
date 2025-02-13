package kr.or.ddit.spring.config;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.CustomRootContextConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CustomRootContextConfig
class RootContextJavaConfigTest {

	@Autowired
	DataSource dataSource;
	
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	
	@Test
	void testSqlSessionFactory() {
		log.info("sqlSessionFactory : {}", sqlSessionFactory);
		
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			Map<String, Object> result = session.selectOne("Dummy.selectDummy");
			log.info("result : {}", result);
		}
	}
	
	@Disabled
	@Test
	void testDataSource() {
		log.info("datasource : {}", dataSource);
		assertDoesNotThrow(()->{
			log.info("connection : {}", dataSource.getConnection());
		});
	}

}
