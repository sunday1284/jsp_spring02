package kr.or.ddit.case11.objs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.dao.LprodMapper;
import kr.or.ddit.case11.objs.vo.LprodVO;

@Service
public class Case11LprodService {
	@Autowired
	private LprodMapper mapper;
	
	
	public List<LprodVO> readLprodList(){
		return mapper.selectLprodList();
	}
	
	public LprodVO readLprod(String lprodGu) {
		return mapper.selectLprod(lprodGu);
	}

}
