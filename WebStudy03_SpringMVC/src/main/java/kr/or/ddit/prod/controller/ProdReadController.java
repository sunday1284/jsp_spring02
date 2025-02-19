package kr.or.ddit.prod.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.prod.dao.LprodMapper;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.vo.BuyerVO;
import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * /prod/prodList.do GET 
 * /prod/prodDetail.do?what=P10100001 GET
 * /prod/prodInsert.do GET : form UI 제공 /prod/prodInsert.do POST : form data 처리
 * /prod/prodUpdate.do?what=P10100001 GET : form UI 제공
 * /prod/prodUpdate.do?what=P10100001 POST : form data 처리
 * 
 */
@Controller
@RequestMapping("/prod")
public class ProdReadController{
	@Inject
	private ProdService service;
	
	@GetMapping("prodList.do")
	public String list(
		Model model // lprodList, buyerList가 알아서 들어감
		,@RequestParam(name ="page", required =false, defaultValue = "1") int currentPage 
		,@ModelAttribute("condition") ProdVO condition //커맨드 오브젝트
	) {	
		//페이징 기법 	
		//상세 검색용 객체 생성
		PaginationInfo<ProdVO> paging = new PaginationInfo<>(5, 3);
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(condition);
		//2. 리스트에 서비스 담아줌
		List<ProdVO> prodList = service.readProdList(paging);
		//3. 스코프 값 설정
		model.addAttribute("prodList", prodList);
		// 페이징 처리된 값을 jsp로 보내줌
		PaginationRenderer renderer = new DefaultPaginationRenderer();
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML", pagingHTML);
		
		//4.logicalName 설정 
		return "tiles:prod/prodList";
	}
	
	
	@GetMapping("prodDetail.do")
	public String detail(
	   @RequestParam("what") String prodId
	   , Model model
	){		
		
		//5. 다오에서 설정한 작업을 서비스에 담아줌
		ProdVO prod = service.readProd(prodId);
		
		//6. scope에 작업한 내용을 담아줌
		model.addAttribute("prod", prod);
		//7. logicalName 설정 
		return "tiles:prod/prodDetail";

	}
	
}
