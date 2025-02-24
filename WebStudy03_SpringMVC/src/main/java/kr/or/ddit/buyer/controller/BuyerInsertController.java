package kr.or.ddit.buyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.validate.InsertGroup;
import lombok.extern.slf4j.Slf4j;

//  /buyer/new    (GET) : 신규 등록 form
//  /buyer/new    (POST): 신규 등록 process

@Controller
@RequestMapping("/buyer/new")
@Slf4j
public class BuyerInsertController {
   
   @Autowired
   BuyerService service;
   
   @ModelAttribute("buyer")
   public BuyerVO buyer() {
      return new BuyerVO();
   }
   
   @GetMapping
   public String insertForm() {
      return "tiles:buyer/buyerForm";
   }
   
   @PostMapping
   public String insertBuyer(
      @Validated(InsertGroup.class) @ModelAttribute("buyer") BuyerVO buyer 
      ,Errors errors
      ,RedirectAttributes redirectAttributes
      ,Model model
   ) {
      if(!errors.hasErrors()) { 
         service.createBuyer(buyer);
         redirectAttributes.addFlashAttribute("message", "제조사 등록 완료");
         return "redirect:/buyer/"+buyer.getBuyerId();
         
      }else {
         redirectAttributes.addFlashAttribute("buyer", buyer);
         String errorsName = BindingResult.MODEL_KEY_PREFIX+"buyer"; 
         redirectAttributes.addFlashAttribute(errorsName, errors);
         return "redirect:/buyer/new";
      }
   }
   
}














