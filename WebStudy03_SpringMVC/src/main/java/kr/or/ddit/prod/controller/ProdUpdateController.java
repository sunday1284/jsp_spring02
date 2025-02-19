package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.vo.ProdVO;
import kr.or.ddit.validate.UpdateGroup;

@Controller
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController{
	
	public static final String MODELNAME = "prod";
	@Inject
	private ProdService service;
	
	
	@GetMapping
	public String FormUI(
		@RequestParam("what") String prodId
		,Model model	
	) {
		
		//모델 안에 데이터가 없을때만 새로 들어감
		if(!model.containsAttribute(MODELNAME)) {
			//what에 해당하는 상품 정보를 조회
			ProdVO prod = service.readProd(prodId);
			
			//prod 속성명으로 reqeusqst scope에 저장
			model.addAttribute(MODELNAME, prod);
			
		}
		
		
		return "tiles:prod/prodEdit";
		
	}
	
	@PostMapping
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) throws IllegalStateException, IOException 
	{
		String logicalName = null;
		if(!errors.hasErrors()) {
			//3. 서비스에서 수정작업 시작
			service.modifyProd(prod);
			logicalName = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
		}else {
			redirectAttributes.addFlashAttribute(MODELNAME, prod);
			String errorName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorName, errors);
			
			logicalName = "redirect:/prod/prodUpdate.do?what="+prod.getProdId();
		}

		//4.수정이 됐으면 리스트로 보내줌
		return logicalName;

	}
	
	
	
}
