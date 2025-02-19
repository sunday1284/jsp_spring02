package kr.or.ddit.case09.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

//restFullService
@Slf4j
@Controller
@RequestMapping(value= "/case09"
, consumes = MediaType.APPLICATION_JSON_VALUE
, produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonRequestController {
	
	/**
	 * consumes -> @ResponseBody
	 * produces -> @RequestBody
	 * @param lprod
	 * @return
	 */
	@PostMapping("json01")
	@ResponseBody
	public Map<String, Object> handler1(
		@RequestBody LprodVO lprod
	){
		log.info("lprod 신규 등록: {}", lprod);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("success", true);
		resultMap.put("target", lprod);
		return resultMap;
	}
}
