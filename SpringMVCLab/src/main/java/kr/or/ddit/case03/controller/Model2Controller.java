package kr.or.ddit.case03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/case03")
public class Model2Controller {
	
	/**
	 * accept 헤더를 판단하고,
	 * json : jsonView 가 사용되고,
	 * 그 외의 경우, tiles view 를 검색하고, 검색 실패하면, jsp 싱글 파일을 검색하고 응답을 전송함.
	 */
	@GetMapping(value = "view04")
	public void handler4(){
//		return "case04/view04";
	}
	
	
	/**
	 * 주소값하고 jsp 경로가 똑같으면 생략해도 logicalName 생성
	 * RequestToViewNameTranslator 가 기본 전략으로 등록되어 있고,
	 * 해당 전략 객체가 logical view name 이 없는 경우, url 부터 해당 logical view name 을 파싱함.
	 */
	@GetMapping("view03")
	public void handler3() {
//		return "case03/view03";
	}
	
	/**
	 * @return logical view name : InternalResourceViewResolver 에 의해 처리됨.
	 */
	@GetMapping("singleView02")
	public String handler2() {
//		*/*/*, */*, *
		return "case03/view02";	
	}
	
	/**
	 * @return logical view name : TilesViewResolver 에 의해 처리됨.
	 */
	@GetMapping("view01")
	public String handler1() {
		return "tiles:case03/view01";
	}
}








