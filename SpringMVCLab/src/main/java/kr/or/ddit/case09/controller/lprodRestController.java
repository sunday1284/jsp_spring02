package kr.or.ddit.case09.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.vo.LprodVO;

/**
 * RestFul Service 구현 (RestFul URI)
 * 
 * /lprod GET : 전체 상품 분류 조회
 * /lprod POST : 신규 등록 
 * /lprod/P101 GET : 분류 상세 조회 
 * /lprod/P101 PUT : 분류 수정 
 * /lprod/P101 DELETE : 분류 삭제 
 * 
 * 
 */
@RestController //json 응답만 
@RequestMapping(value="/lprod", produces = MediaType.APPLICATION_JSON_VALUE)
public class lprodRestController {
	
	@GetMapping
	public List<LprodVO> list(){
		return null;
	}
	
	@GetMapping("{lprodGu}")
	public LprodVO detail(
		@PathVariable("lprodGu") String lprodGu
	){
		return null;
	}
	
	// json형식으면 @RequestBody로 받는다.
	@PostMapping
	public Map<String, Object> insert(@RequestBody LprodVO lprod){
		Map<String, Object> resultMap = new HashMap<>();
		//성공 , 실패여부, 실패대상
		resultMap.put("success", false);
		resultMap.put("errors", "실패 원인");
		resultMap.put("target", lprod);
		return resultMap;
	}
	
	//수정
	@PutMapping("{lprodGu}")
	public Map<String, Object> update(
		@PathVariable("lprodGu") String lprodGu
		, @RequestBody LprodVO lprod 
	) {
		Map<String, Object> resultMap = new HashMap<>();
		//성공 , 실패여부, 실패대상
		resultMap.put("success", true);
		resultMap.put("target", lprod);
		return resultMap;
	}
	
	//삭제
	@DeleteMapping("{lprodGu}")
	public Map<String, Object> delete(@PathVariable("lprodGu") String lprodGu) {
		//성공여부
		return Collections.singletonMap("success", true);
	}
}
