package kr.or.ddit.case10.config;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Case10JdbcJavaConfig {
	
	//스프링 컨테이너는 자동으로 예외 처리
	@Bean
	public Properties dbInfo(
		@Value("classpath:kr/or/ddit/db/DBInfo.properties") Resource propPath
	) throws IOException {
		return PropertiesLoaderUtils.loadProperties(propPath);
	}
	
	@Bean
	public DataSource dataSource(
		@Value("#{dbInfo.driverClassName}") String driverClassName
		,@Value("#{dbInfo['url']}") String url
		,@Value("#{dbInfo.user}") String user
		,@Value("#{dbInfo.password}") String password
		,@Value("#{dbInfo.initialSize}") int initialSize
		,@Value("#{dbInfo.maxWait}") long maxWait
		,@Value("#{dbInfo.maxTotal}") int maxTotal
	) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		//커넥션 여러개 생성 
		ds.setInitialSize(initialSize);
		ds.setMaxWait(Duration.of(maxWait/1000, ChronoUnit.SECONDS));
		ds.setMaxTotal(maxTotal);
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
