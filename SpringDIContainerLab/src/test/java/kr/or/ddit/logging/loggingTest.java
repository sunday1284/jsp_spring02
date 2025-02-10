package kr.or.ddit.logging;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class loggingTest {

	@Test
	void test() {
	
		log.info("logging test");
	}

}
