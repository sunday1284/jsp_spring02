package kr.or.ddit.prod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.vo.LprodVO;

public interface LprodService {
	public List<LprodVO> readLprodList();
	
	public LprodVO readLprod(String lprodGu);
	
	// void -> false를 고려할 필요 x
	public void createLprod(LprodVO lprod);
	
	public void modifyLprod(LprodVO lprod);
}
