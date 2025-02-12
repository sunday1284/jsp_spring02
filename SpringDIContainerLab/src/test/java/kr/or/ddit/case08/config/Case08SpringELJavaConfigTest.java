package kr.or.ddit.case08.config;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case08.objs.Case08CopiedObj;
import kr.or.ddit.case08.objs.Case08OriginObj;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(Case08SpringELJavaConfig.class)
class Case08SpringELJavaConfigTest {
	
	@Inject
	Case08OriginObj origin;
	
	
	
//	@Resource(name = "copiedObj2")
	@Value("#{copiedObj2}")
	Case08CopiedObj copied2;
	
	@Value("#{copiedObj3}")
	Case08CopiedObj copied3;

	@Test
	void test() {
		log.info("original : {}",origin);
		log.info("copied2 : {}",copied2);
		log.info("copied3 : {}",copied3);
	}

}
