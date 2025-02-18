package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.prod.vo.LprodVO;

@Mapper
public interface LprodMapper {
	public LprodVO selectLprod(String lprodGu);
	
	public List<LprodVO> selectLprodList();
}
