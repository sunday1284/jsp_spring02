package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.paging.PaginationInfo;

public interface BuyerService {
	
	public default List<BuyerVO> readBuyerList(){
		return readBuyerList(null);
	}
	public void createBuyer(BuyerVO buyer);
	public void modifyBuyer(BuyerVO buyer);
	public List<BuyerVO> readBuyerList(PaginationInfo<BuyerVO> paging);
	public BuyerVO readBuyer(String buyerId);
}
