package kr.or.ddit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LprodVO;

@Mapper
public interface LprodMapper {
	public LprodVO selectLprod(String lprodGu);
	
	public List<LprodVO> selectLprodList();
	
	public int insertLprod(LprodVO lprod);
	
	public int updateLprod(LprodVO lprod);
}
