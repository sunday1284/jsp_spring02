package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.paging.PaginationInfo;

@Mapper
public interface BuyerMapper {
//	insert
	public int selectTotalRecord(@Param("paging") PaginationInfo<BuyerVO> paging);
	
 	public List<BuyerVO> selectBuyerList(@Param("paging") PaginationInfo<BuyerVO> paging);
// 	selectBuyer
//	update
	
}
