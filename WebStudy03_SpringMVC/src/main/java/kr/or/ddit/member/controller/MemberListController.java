package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.paging.SimpleCondition;
import kr.or.ddit.prod.vo.ProdVO;

@Controller
public class MemberListController{
	
	@Inject
	private MemberService service;
	
	
	@GetMapping("/member/memberList.do")
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
}
