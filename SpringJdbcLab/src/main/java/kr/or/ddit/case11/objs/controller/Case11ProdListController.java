package kr.or.ddit.case11.objs.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case11.objs.paging.PaginationInfo;
import kr.or.ddit.case11.objs.service.Case11ProdService;
import kr.or.ddit.case11.objs.vo.ProdVO;

@Controller
public class Case11ProdListController {
	@Autowired
	private Case11ProdService service;
	
	public String List(int currentPage, Map<String, Object> model) {
		PaginationInfo<ProdVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		List<ProdVO> prodList = service.readProdList(paging);
		model.put("prodList", prodList);
		return "prod/prodList";
	}
}
