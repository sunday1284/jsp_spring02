package kr.or.ddit.case11.objs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.dao.ProdMapper;
import kr.or.ddit.case11.objs.paging.PaginationInfo;
import kr.or.ddit.case11.objs.vo.ProdVO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Case11ProdService {
	
	@Autowired
	private final ProdMapper mapper;
	
	public List<ProdVO> readProdList(PaginationInfo<ProdVO> paging){
		return mapper.selectProdList(paging);
		
	}
}
