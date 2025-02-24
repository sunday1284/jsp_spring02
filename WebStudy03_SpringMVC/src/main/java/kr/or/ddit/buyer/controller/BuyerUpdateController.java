package kr.or.ddit.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.validate.UpdateGroup;
import lombok.RequiredArgsConstructor;

/*
 * /buyer/P10101/edit (GET) : 수정 form
 *  /buyer/P10101/edit (POST) : 수정
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/buyer/{buyerId}/edit")
public class BuyerUpdateController {
	
	private final static String MODELNAME = "buyer";
	
	private final BuyerService service;
	
	@GetMapping
	public String updateForm(
		@PathVariable("buyerId") String buyerId
		,Model model
	) {
		BuyerVO buyer = service.readBuyer(buyerId);
		
		model.addAttribute(MODELNAME, buyer);
		
		return "tiles:buyer/buyerEdit";
	}
	
	@PostMapping
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) BuyerVO buyer
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		if(!errors.hasErrors()) {
			service.modifyBuyer(buyer);
			//수정 작업 완료 후 디테일화면으로 넘어감
			return "redirect:/buyer/"+buyer.getBuyerId();
		}else {
			redirectAttributes.addFlashAttribute(MODELNAME,buyer);
			String errorName = BindingResult.MODEL_KEY_PREFIX+MODELNAME;
			redirectAttributes.addAttribute(errorName, errors);
			//다시 업데이트 화면으로 돌림
			return "redirect:/buyer/"+buyer.getBuyerId()+"/edit";
		}
	}
	
	
}
