package kr.or.ddit.case11.objs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.dao.LprodMapper;
import kr.or.ddit.case11.objs.vo.LprodVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data
public class Case11LprodService {
	
	//mapper를 자동 주입
	@Autowired
	private LprodMapper mapper;
	
	//service에서 수행해야할 작업들에서 mapper가 가지고 있는 db작업을 처리함
	public List<LprodVO> readLprodList(){
		return mapper.selectLprodList();
	};
	public LprodVO readLprod(String lprodGu) {
		return mapper.selectLprod(lprodGu);
	};
}
