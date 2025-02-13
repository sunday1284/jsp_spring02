package kr.or.ddit.case01.controller;

//STATC 임포트 구문 
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @Controller
 * : 컨테이너에 빈으로 등록됨
 * : HandlerMapping 에게 핸드러 메소드를 소유하고 있음을 전달함.
 * 
 */
@Controller
@RequestMapping("/case01")
@Slf4j
public class Case01MissionController {
	
	/**
	 * 수신할 수 있는 요청의 조건 
	 * 1. /case01/mission01, (get, put, delete)
	 * 2. request parameter : who
	 * 3. 클라이언트가 json 컨텐츠를 요구하는 경우.
	 */
	@RequestMapping(value = "mission01", 
			method = {GET,PUT,DELETE}
			, params = "who", produces = MediaType.APPLICATION_JSON_VALUE
	)
	public void handler1(){
		log.info("미션 1 /case01/mission01 수신");
	}
	
	
	/**
	 * 1. /case01/mission02 (post)
	 * 2. form-data 수신 핸들러 (content-type)
	 * 3. 클라이언트가 html 컨텐츠를 요구하는 경우. 
	 */
	@PostMapping(value = "mission02", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
		, produces = MediaType.TEXT_HTML_VALUE
	)
	public void handler2() {
		log.info("미션 1 /case01/mission02 수신");
	}
}
