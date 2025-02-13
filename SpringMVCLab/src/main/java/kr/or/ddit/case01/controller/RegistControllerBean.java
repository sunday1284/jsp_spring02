package kr.or.ddit.case01.controller;

import javax.servlet.annotation.WebServlet;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * dispatcher-servlet.xml(하위 컨테이너 설정 파일)
 *  1. - component-scan 설정에 따른 어노테이션 사용.
 *  2. 사용자의 요청을 수신할 수 있는 매핑 정보 설정(핸들러 메소드 단위).
 */
//@WebServlet("/prod/prodList.do")
@Controller
// 가운데 /는 자동 생성
@RequestMapping("/case01")
@Slf4j
public class RegistControllerBean {
	//header가 있으면 body가 있으므로 post, consumes(content-type 제한) produces(accept헤더)
	//MediaType -> content-type 타입 설정 가능
	@PostMapping(value="request05",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void handler06(){
		log.info("/case01/request05 content-type(json) 수신");
	}
	@RequestMapping(value="request05",method = RequestMethod.POST)
	public void handler07(){
		log.info("/case01/request05 content-type(*) 수신");
	}
	@RequestMapping(value="request04",produces = "text/html")
	public void handler05(){
		log.info("/case01/request04 accept(html) 수신");
	}
	@RequestMapping(value="request04",produces = "application/json")
	public void handler04(){
		log.info("/case01/request04 accept(json) 수신");
	}
	@RequestMapping(value="request03", params = "what")
	public void handler03(){
		log.info("/case01/request03  수신");
	}
	
	@RequestMapping(value="request02", 
			method = { RequestMethod.GET, RequestMethod.POST })
	public void handler02(){
		log.info("/case01/request02 (GET, POST) 수신");
	}
	
	@RequestMapping("request01")
	public void handler01() {
		log.info("/case01/request01 수신");
	}
}
