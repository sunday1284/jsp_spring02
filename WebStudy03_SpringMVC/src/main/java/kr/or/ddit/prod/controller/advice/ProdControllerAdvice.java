package kr.or.ddit.prod.controller.advice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.prod.dao.LprodMapper;
import kr.or.ddit.prod.vo.LprodVO;

//aspect
//하위컨테이너에 등록된 advice를 꺼내옴 -> 부가데이터 
@ControllerAdvice(basePackages = {"kr.or.ddit.prod.controller", "kr.or.ddit.buyer.controller"} )
public class ProdControllerAdvice {
	@Inject
	private LprodMapper lprodDao;
	
	@ModelAttribute("lprodList")
	public List<LprodVO> lprodList(){
		return lprodDao.selectLprodList();
	}
	@ModelAttribute("buyerList")
	public List<BuyerVO> buyerList(){
		List<LprodVO> lprodList = lprodDao.selectLprodList();
		List<BuyerVO> buyerList = new ArrayList<>();
		
		for(LprodVO lp : lprodList) {
		  List<BuyerVO> innerList =	lp.getBuyerList();
		  if(innerList.isEmpty()) continue;
		  else buyerList.addAll(innerList);
		}
		return buyerList;
	}
}
