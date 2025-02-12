package kr.or.ddit.case10.config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(Case10JdbcJavaConfig.class)
class Case10JdbcJavaConfigTest {
	
	@Autowired
	DataSource dataSource;
	
	@Inject
	JdbcTemplate jdbcTemplate;
	
	
	/**
	 * query로 시작하면 select
	 * 단건 조회면 queryForObject
	 * 리스트 조회면 queryForList
	 * jdbcTemplate -> 커넥션 수립 작업을 알아서 해줌
	 */
	@Test
	void testJdbcTemplate3() {
		StringBuffer sql = new StringBuffer();
		//Spring    NamedParameterJdbcTemplate에서 인라인 파라미터를 하는법
		sql.append(" SELECT MEM_NAME         ");
		sql.append(" FROM MEMBER              ");
		sql.append(" WHERE MEM_ID = :memId AND MEM_PASS = :memPass ");
		
		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("memId", "a001");
		paramMap.put("memPass", "asdfasdf");
		
		String memName = npjt.queryForObject(
				sql.toString() 
				, paramMap
				, String.class	
		);
		log.info("memName : {} ",memName);
	}
	@Disabled
	@Test
	void testJdbcTemplate2() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MEM_NAME         ");
		sql.append(" FROM MEMBER              ");
		sql.append(" WHERE MEM_ID = ? AND MEM_PASS = ? ");
		
		String memName = jdbcTemplate.queryForObject(
				sql.toString() 
				, new Object[] {"asdfasdf","a001"}
				, String.class	
				);
		log.info("memName : {} ",memName);
	}
	@Disabled
	@Test
	void testJdbcTemplate1() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT LPROD_NM         ");
		sql.append(" FROM LPROD              ");
		sql.append(" WHERE LPROD_GU = ? ");
		
		String lprodNm = jdbcTemplate.queryForObject(
				sql.toString() 
				, new Object[] {"P101"}
				, String.class
				
				);
		log.info("lprodNm : {} ",lprodNm);
	}
	
	@Disabled
	@Test
	void test() {
		log.info("{}", dataSource);
		assertDoesNotThrow(()->dataSource.getConnection());
//		1. Connection 수립
//		2. 쿼리 객체 생성
//		3. 쿼리 파라미터 설정 
//		4. 쿼리 실행 
//		5. 실행 결과를 VO로 wrapping
//		6. close
	}

}
