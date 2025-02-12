package kr.or.ddit.case11.config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case11.objs.dao.LprodMapper;
import kr.or.ddit.case11.objs.dao.PersonMapper;
import kr.or.ddit.case11.objs.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(Case11MybatisSpringJavaConfig.class)
class Case11MybatisSpringJavaConfigTest {
	
	@Inject
	@Named("sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@Inject
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	PersonMapper proxy;
	
	
	@Disabled
	@Test
	void test5MapperProxy() {
		proxy.selectPersonList();
	}
	/**
	 * open 중복 코드 제거 
	 */
	@Disabled
	@Test
	void test4SessionTemplate() {
//		PersonMapper proxy = sqlSessionTemplate.getMapper(PersonMapper.class);
//		List<PersonVO> list = proxy.selectPersonList();
		sqlSessionTemplate.selectList("kr.or.ddit.case11.objs.dao.PersonMapper.selectPersonList");
	}
	
	@Disabled
	@Test
	void test3() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			PersonMapper proxy = sqlSession.getMapper(PersonMapper.class);
			List<PersonVO> list = proxy.selectPersonList();
			
		}
	}
	
	@Disabled
	@Test
	void test2() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			List<PersonVO> list = sqlSession.selectList("kr.or.ddit.case11.objs.dao.PersonMapper.selectPersonList");
			
		}
	}
	
	@Disabled
	@Test
	void test() {
		log.info("{}", sqlSessionFactory);
	}

}
