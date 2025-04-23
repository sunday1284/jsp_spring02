package kr.or.ddit.case11.objs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.dao.ProdMapper;
import kr.or.ddit.case11.objs.paging.PaginationInfo;
import kr.or.ddit.case11.objs.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Case11ProdService {
	private final ProdMapper dao;
	
	public List<ProdVO> readProdList(PaginationInfo<ProdVO> paging){
		return dao.selectProdList(paging);
	}
}
