package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.vo.ProdVO;
import kr.or.ddit.validate.InsertGroup;

@Controller
@RequestMapping("/prod/prodInsert.do")
public class ProdInsertController{
	//AOP 방법론
	
	public static final String MODELNAME = "prod";
	
	//서비스 생성
	@Inject
	private ProdService service;
		

	
	@GetMapping
	public String FormUI(
		//controllerAdvice쪽으로 넘어가서 따로 선언 x
//		Model model //MODELATTRIBUTE로 넣은 리스트 값이 다 들어감
	) {
		return "tiles:prod/prodForm";
	}
	
	
	
	@PostMapping
	public String formProcess(
		@Validated(InsertGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) throws IllegalStateException, IOException {
		
		String lvn = null;
		
		if(!errors.hasErrors()) {
			
			service.createProd(prod);	
			
			lvn = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
		}else {
			
			redirectAttributes.addFlashAttribute(MODELNAME, prod);
			String errorName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorName, errors);
			lvn = "redirect:/prod/prodInsert.do";
		}
		
		
		
		return lvn;
		
	
	}
	
		
}

