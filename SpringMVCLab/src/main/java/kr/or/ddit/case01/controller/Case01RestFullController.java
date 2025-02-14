package kr.or.ddit.case01.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//주소는 하나로 고정된다. RESTFUL
@RequestMapping(value = "/case01/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class Case01RestFullController {
	
	//조회 
	@GetMapping
	public void readHandler(){
	}
	//추가
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createHandler(){
	}
	//수정
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyHandler() {
	}
	//삭제
	@DeleteMapping
	public void removeHandler() {
	}
}
