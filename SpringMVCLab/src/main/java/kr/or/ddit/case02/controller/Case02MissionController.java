package kr.or.ddit.case02.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case02/mission")
public class Case02MissionController {
	
	/**
	 * 1. /case02/mission 수신
	 * 2. GET 수신
	 * 3. accept 필수 헤더 확인 
	 * 4. user-agent 부가 헤더 확인 : 없는 경우, "dummy-machine" 기본값 확인. 
	 * @return
	 */
	@GetMapping
	public String handler1(
		@RequestHeader(name ="accept") String accept,
		@RequestHeader(name="user-agent", required = false, defaultValue = "dummy-machine")
		String userAgent
	){
		log.info("accept: {}, user-agent : {}",accept,userAgent);
		return "case02/mission";
	}
	/**
	 * 1. /case02/mission 수신
	 * 2. POST 수신 
	 * 3. content-type 이 json인 경우만 수신
	 * 4. content-length 헤더 확인 
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String handler2(
		@RequestHeader(name="content-length",required = false,defaultValue = "-1") long contentLength
	){
		log.info("content-length : {}", contentLength);
		return "case02/mission";
	}
}
