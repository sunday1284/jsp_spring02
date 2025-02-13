package kr.or.ddit.prod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.vo.LprodVO;

@Service
public interface LprodService {
	public List<LprodVO> readLprodList();
	public LprodVO readLprod(String lprodGu);
	
}
