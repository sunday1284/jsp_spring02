package com.ddit.hr.prod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ddit.hr.vo.LprodVO;

@Service
public interface LprodService {
	public LprodVO readLprod(String lprodGu);
	
	public List<LprodVO> readLprodList();
	
}
