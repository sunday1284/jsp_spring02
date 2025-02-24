package kr.or.ddit.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@RestController
@RequestMapping("/api/members")
public class MemberRestController {
	@Autowired
	private MemberService service;
	
	@GetMapping
	public List<MemberVO> getMemberAll(){
		return service.readAll();
	}
	
	@GetMapping("{memId}")
	public MemberVO getMemberOne(@PathVariable("memId") String memId){
		return service.readOne(memId);
	}
	
	@PostMapping
	public MemberVO createMember(@RequestBody MemberVO member){
		service.create(member);
		return member;
	}
	
	@PutMapping
	public MemberVO modifyMember(@RequestBody MemberVO member){
		service.modify(member);
		return member;
	}
	
	@DeleteMapping("{memId}")
	public Map<String, Object> deleteMember(@PathVariable("memId") String memId){
		service.remove(memId);
		return Collections.singletonMap("deleted", memId);
	}
	
	
}
