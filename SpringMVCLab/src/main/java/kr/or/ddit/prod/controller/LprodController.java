package kr.or.ddit.prod.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.prod.service.LprodService;
import kr.or.ddit.vo.LprodVO;
import lombok.Data;

@Controller
@Data
public class LprodController {
	private final LprodService service;
	
	@GetMapping("/prod/lprodDetail.do")
	public ModelAndView lprodDetail(
			@RequestParam(value="what", required = true) String what
//			, Model model
	) {
		ModelAndView mav = new ModelAndView();
		LprodVO lprod = service.readLprod(what);
		mav.addObject("lprod", lprod);
		mav.setViewName("tiles:prod/lprodDetail");
		return mav;
	}
	
	// Model -> setAttribute랑 같음 @RequestMapping -> 클라이언트 사용할 주소 
	@RequestMapping("/prod/lprodList.do")
	public String lprodList(Model model) {
		List<LprodVO> lprodList = service.readLprodList();
		model.addAttribute("lprodList", lprodList);
		return "tiles:prod/lprodList";
	}
}
