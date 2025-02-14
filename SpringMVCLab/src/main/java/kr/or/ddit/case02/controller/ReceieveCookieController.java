package kr.or.ddit.case02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case02")
public class ReceieveCookieController {
	
	//cookie의 value 값만 꺼내오고 싶을 때 
	@RequestMapping("cookie02")
	public void handler2(@CookieValue(name="mycookie", required = false, defaultValue = "기본값") String myCookie) {
		log.info("cookie header : {}" , myCookie);
	}
	@RequestMapping("cookie01")
	public void handler1(@RequestHeader("cookie") String cookieHeader) {
		log.info("cookie header : {}" , cookieHeader);
	}
}
