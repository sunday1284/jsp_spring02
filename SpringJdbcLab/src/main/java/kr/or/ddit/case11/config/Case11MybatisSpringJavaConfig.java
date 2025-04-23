package kr.or.ddit.case11.config;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import kr.or.ddit.case10.config.Case10JdbcJavaConfig;

@Configuration
@Import(Case10JdbcJavaConfig.class)
@ComponentScan(basePackages="kr.or.ddit.case11.objs")
public class Case11MybatisSpringJavaConfig {
	
	/**
	 * FactoryBean 의 특성
	 * FactoryBean 을 bean 으로 등록한 경우,
	 * 실제 bean 으로 등록되는 객체는 getObject 메소드의 반환 객체.
	 * @param dataSource
	 * @param configLocation
	 * @return
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(
		DataSource dataSource	
		, @Value("classpath:kr/or/ddit/mybatis/Configuration.xml") Resource configLocation
		, @Value("classpath:kr/or/ddit/mybatis/mappers/*.xml") Resource...mapperLocations
	) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(configLocation);
		factoryBean.setMapperLocations(mapperLocations);
		factoryBean.setTypeAliasesPackage("kr.or.ddit.**.vo");
		return factoryBean;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(
		SqlSessionFactory sqlSessionFactory	
	) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	
	@Bean
	public MapperScannerConfigurer mapperScanner() {
		MapperScannerConfigurer configurar = new MapperScannerConfigurer();
		configurar.setBasePackage("kr.or.ddit.case11.objs.dao");
		configurar.setAnnotationClass(Mapper.class);
		configurar.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return configurar;
	}
	
	@Bean
	public TransactionManager transactionManager(
			DataSource dataSource
	) {
		return new DataSourceTransactionManager(dataSource);
	}
}
















