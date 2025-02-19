package kr.or.ddit.person.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.person.dao.PersonMapper;
import kr.or.ddit.person.vo.PersonVO;


/**
 *	/person GET
 *	/person/a001 GET
 *	/person/a001 DELETE {}
 *	/person POST
 */
@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRestController {
	@Inject
	private PersonMapper dao;
	
	@GetMapping
	public List<PersonVO> getPersonList() {
		return dao.selectPersonList();
	}
	
	@GetMapping("{personId}")
	public PersonVO getPerson(@PathVariable("personId") String personId) {
		PersonVO person = dao.selectPerson(personId);
		return person;
	}

	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> InsertForm(@RequestBody PersonVO person){
		
		dao.insertPerson(person);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("success", true);
		//성공했을 때 person담음
		resultMap.put("target", person);
		
		
		return resultMap;
	}
	
	@DeleteMapping("{personId}")
	public Map<String, Object> deletePerson(@PathVariable("personId") String personId) {
		//PRG패턴 -> Put Delete는 안됨..
//		Post Redirect Get 
//		Put Redirect Put 
//		Delete Redirect Delete
		
		dao.deletePerson(personId);
		
		return Collections.singletonMap("success", true);
	}
	//수정 작업 ->putMapping
	@PutMapping("{personId}")
	public Map<String, Object> updatePerson(
		@PathVariable String personId
		 , @RequestBody PersonVO person
	){
		dao.updatePerson(person);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("success", true);
		resultMap.put("target", person);
		return resultMap;
	}
}


