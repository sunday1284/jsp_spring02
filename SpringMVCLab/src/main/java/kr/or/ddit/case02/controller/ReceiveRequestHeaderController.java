package kr.or.ddit.case02.controller;

import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case02")
public class ReceiveRequestHeaderController {
	
//	// HttpHeaders -> MultiValueMap하고 같은 구조임
//	@GetMapping("header05")
//	public void handler05(HttpHeaders headers) {
//		//향상된 FOR문으로 MAP의 entry셋 꺼내오기
//		for(Entry<String, List<String>> entry : headers.entrySet() ) {
//			String name = entry.getKey();
//			List<String> value = entry.getValue();
//			log.info("header name : {}, value : {} ", name, value);
//		}
//	}
	// MultiValueMap ->	Map의 value값을 List 형태로 받을 수 있음
	@GetMapping("header04")
	public void handler04(@RequestHeader MultiValueMap<String, String> headers) {
		//향상된 FOR문으로 MAP의 entry셋 꺼내오기
		for(Entry<String, List<String>> entry : headers.entrySet() ) {
			String name = entry.getKey();
			List<String> value = entry.getValue();
			log.info("header name : {}, value : {} ", name, value);
		}
	}
	
	//헤더가 null이면 defaultValue = "-1" 자동으로 기본값 셋팅
	@GetMapping("header03")
	public void handler3(
		@RequestHeader(name="my-numheader", required = false, defaultValue = "-1") int myNumHeader){
		log.info("header03 수신, contentType : {}", myNumHeader);
	}
	@GetMapping("header02")
	//accept 헤터를 어노테이션으로 꺼내는 방법 -> 검증을 자동으로 해줌
	public void handler2(@RequestHeader(name="content-type", required = false) String contentType){
		log.info("header02 수신, contentType : {}", contentType);
	}
	@GetMapping("header01")
	public void handler1(HttpServletRequest req){
		String accept = req.getHeader("accept");
		log.info("header01 수신, accept : {}", accept);
	}
}
