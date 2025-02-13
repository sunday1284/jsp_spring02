package kr.or.ddit.prod.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.service.LprodService;
import kr.or.ddit.vo.LprodVO;
import lombok.Data;

@Controller
@Data
public class LprodController {
	private final LprodService service;
	
	@GetMapping("/prod/lprodDetail.do")
	public String lprodDetail(
			@RequestParam(value="what", required = true) String what
			, Model model
	) {
		LprodVO lprod = service.readLprod(what);
		model.addAttribute("lprod", lprod);
		return "prod/lprodDetail";
	}
	
	// Model -> setAttribute랑 같음 @RequestMapping -> 클라이언트 사용할 주소 
	@RequestMapping("/prod/lprodList.do")
	public String lprodList(Model model) {
		List<LprodVO> lprodList = service.readLprodList();
		model.addAttribute("lprodList", lprodList);
		return "prod/lprodList";
	}
}
