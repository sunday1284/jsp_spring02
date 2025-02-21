package kr.or.ddit.buyer.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.buyer.dao.BuyerMapper;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.paging.PaginationInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {
	
	private final BuyerMapper mapper;
	
	
	@Override
	public List<BuyerVO> readBuyerList(PaginationInfo<BuyerVO> paging) {
		if(paging!=null) {
			int totalRecord = mapper.selectTotalRecord(paging);
			paging.setTotalRecord(totalRecord);
		}
		return mapper.selectBuyerList(paging);
	}


	@Override
	public BuyerVO readBuyer(String buyerId) {
		return mapper.selectBuyer(buyerId);
	}
	//스프링 el
	@Value("#{fileInfo.buyerImages}")
	private String buyerImagesUrl;
	@Value("#{fileInfo.buyerImages}")
	private Resource buyerImageRes;
	@Value("#{fileInfo.buyerImages}")
	private File saveImagesFolder;
	
	
	//이미지 처리 작업
	//adapter 패턴
	private void processBuyerImage(BuyerVO buyer) {
		
		try {
			MultipartFile buyerImage = buyer.getBuyerImage();
			if(buyerImage!=null && !buyerImage.isEmpty()) {
				String savename = buyer.getBuyerImg();
				File saveFile = new File(saveImagesFolder, savename);
				buyerImage.transferTo(saveFile);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	@Transactional
	@Override
	public void createBuyer(BuyerVO buyer) {
		if(mapper.insertBuyer(buyer)>0);
			processBuyerImage(buyer);
		
	}

	@Transactional
	@Override
	public void modifyBuyer(BuyerVO buyer) {
		if(mapper.updateBuyer(buyer)>0)
			processBuyerImage(buyer);
		
	}

}
