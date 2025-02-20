package kr.or.ddit.buyer.service;

import java.util.List;


import org.springframework.stereotype.Service;

import kr.or.ddit.buyer.dao.BuyerMapper;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.paging.PaginationInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {
	
	private final BuyerMapper dao;
	
	
	@Override
	public List<BuyerVO> readBuyerList(PaginationInfo<BuyerVO> paging) {
		if(paging!=null) {
			int totalRecord = dao.selectTotalRecord(paging);
			paging.setTotalRecord(totalRecord);
		}
		return dao.selectBuyerList(paging);
	}

}
