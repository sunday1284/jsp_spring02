package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.prod.dao.ProdMapper;
import kr.or.ddit.prod.exception.ProdNotExistException;
import kr.or.ddit.prod.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements ProdService {
	
	private final ProdMapper dao;
	@Override
	public List<ProdVO> readProdList(PaginationInfo<ProdVO> paging) {
		if(paging!=null) {
			int totalRecord = dao.selectTotalRecord(paging);
			// 총 레코드 개수 셋팅
			paging.setTotalRecord(totalRecord);
		}
		return dao.selectProdList(paging);
	}
	
	
	public ProdVO readProd(String prodId) throws ProdNotExistException{
		ProdVO prod = dao.selectProd(prodId);
		if(prod==null) {
			//prodId값이 존재하지 않으면 예외 발생 
			throw new ProdNotExistException(prodId);
		}
		return prod;
		
	}
	
	//알아서 파일 객체를 만들어줌
	@Value("#{fileInfo.prodImages}")
	private String prodImagesUrl;
	@Value("#{fileInfo.prodImages}")
	private Resource prodImagesRes;
	@Value("#{fileInfo.prodImages}")
	private File prodImagesFolder;
	
	//서비스에서 이미지 처리 작업 (업로드)
	public void processProdImage(ProdVO prod) 
	{
		try {
//			if(1==1)
//				throw new RuntimeException("트랜잭션 관리 여부를 확인하기 위한 강제 예외");
			
			MultipartFile prodImage = prod.getProdImage();
			//이미지가 업로드 됬으면 선택된상태
			if(prodImage==null) return;
			//2진 데이터 저장
			//파일이 저장될때
			String prodImg = prod.getProdImg();
			File destFile = new File(prodImagesFolder, prodImg);
			prodImage.transferTo(destFile);
			
		}catch(Exception e) {
			throw new RuntimeException(e);
			//rollback
		}
	}
	
	
	@Transactional // transaction 관리 작업 -> 선언자 프로그래밍(포인트컷 선언)
	@Override
	public boolean createProd(ProdVO prod) {
		//성공시
		if(dao.insertProd(prod) > 0) {
			processProdImage(prod);
			// commit 
			return true;
		}else {
			return false;
		}
	}

	@Transactional // transaction 관리 작업 -> 선언자 프로그래밍(포인트컷 선언)
	@Override
	public boolean modifyProd(ProdVO prod) {
		//트랜잭션관리 용이
		if(dao.updateProd(prod) > 0) {
			processProdImage(prod);
			//commit
			return true;
		}else {
			return false;
		}
	}
	
}
