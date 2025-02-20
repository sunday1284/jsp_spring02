package kr.or.ddit.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;

/**
 *  /buyer (GET) : 목록 조회
 *  /buyer/P10101 (GET) : 상세 조회
 *  
 *  /buyer/P10101/edit (GET) : 수정 form
 *  /buyer/P10101/edit (POST) : 수정
 *  
 *  /buyer/new (GET) : 신규 등록 form
 *  /buyer/new (POST) : 신규 등록
 * 
 */
@Controller
@RequestMapping("/buyer")
public class BuyerReadController {
	@Autowired
	private BuyerService service;
	
	@GetMapping(params = "datatable")
	public String buyerListWithDataTable(Model model) {
		List<BuyerVO> buyerList = service.readBuyerList();
		model.addAttribute("buyerList", buyerList);
		return "tiles:buyer/listDT";
	}
	
	@GetMapping
	public String buyerListWithoutDatatable(
		@RequestParam(name="page", required = false, defaultValue = "1") int currentPage	
		, @ModelAttribute("condition") BuyerVO detailCondition
		, Model model
	) {
		
		PaginationInfo<BuyerVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<BuyerVO> buyerList = service.readBuyerList(paging);
		model.addAttribute("buyerList", buyerList);
		PaginationRenderer renderer = new DefaultPaginationRenderer();
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "tiles:buyer/buyerList";
	}
}











