package kr.or.ddit;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
class JpaLab02BootApplicationTests {

	@Autowired
	DataSource dataSource;
	
	@Test
	void contextLoads() {
		log.info("=========>{}", dataSource);
	}

}
