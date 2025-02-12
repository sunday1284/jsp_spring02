package kr.or.ddit.case11.objs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.case11.objs.vo.LprodVO;

@Mapper // mapper proxy 생성(MapperScanner)을 위해
public interface LprodMapper {
	
	public List<LprodVO> selectLprodList();
	public LprodVO selectLprod(String lprodGu);
	
}
