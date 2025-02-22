package com.hr.ddit.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.ddit.member.service.MemberService;
import com.hr.ddit.member.vo.MemberVO;
import com.hr.ddit.paging.DefaultPaginationRenderer;
import com.hr.ddit.paging.PaginationInfo;
import com.hr.ddit.paging.PaginationRenderer;
import com.hr.ddit.paging.SimpleCondition;

@Controller
@RequestMapping("/member")
public class MemberReadController{
	
	@Inject
	private MemberService service;
	
	
	@GetMapping("memberList.do")
	public String memberList(
		@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
		, @ModelAttribute("condition") SimpleCondition condition
		, Model model
	){
			
		PaginationInfo<MemberVO> paging = new PaginationInfo<>(3, 3); //스크린,블럭 사이즈
		//startRow, endRow 결정을 위한 셋팅 
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(condition);
		
		List<MemberVO> memberList = service.readMemberList(paging);
		//scope 저장
		model.addAttribute("memberList", memberList);
		
		//페이지 랜더링 작업 
		PaginationRenderer render = new DefaultPaginationRenderer();
		String pagingHtml = render.renderPagination(paging);
		model.addAttribute("pagingHTML", pagingHtml);
		
		
//		tiles
		return "tiles:member/memberList";
		
		
	}
	
	@GetMapping("memberDetail.do")
	public String MemberDetail(
		@RequestParam("who") String memId
		,Model model
	) {

//		4. model 확보(logic 사용 - readMember) 
		MemberVO member = service.readMember(memId);
//		5. scope 에 저장 : member (attribute name)
		model.addAttribute("member", member);
		
//		6. view layer 선택(/WEB-INF/views/member/memberDetail.jsp)
		//단일 jsp 응답
		return "member/memberDetail";
		
	}
}
