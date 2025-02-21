package kr.or.ddit.buyer.vo;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.ToString;

@Data
public class BuyerVO implements Serializable{
	private int rnum;
	
	@NotBlank(groups = UpdateGroup.class)
	private String buyerId;
	@NotBlank
	private String buyerName;
	@NotBlank(groups = InsertGroup.class)
	@Size(min = 4, max = 4, groups = InsertGroup.class)
	private String lprodGu;
	private String buyerBank;
	private String buyerBankno;
	private String buyerBankname;
	private String buyerZip;
	private String buyerAdd1;
	private String buyerAdd2;
	@NotBlank
	private String buyerComtel;
	@NotBlank
	private String buyerFax;
	@NotBlank
	@Email
	private String buyerMail;
	private String buyerCharger;
	@Size(max = 2)
	private String buyerTelext;
	
	//제조사와의 거래 품목[들!] 
	private List<ProdVO> prodList;
	// 제조사의 분류 정보 
	private LprodVO lprod; // Has A 
	
	//사업자 등록증
	private String buyerImg; //DB 데이터 수신용 
	
	private MultipartFile buyerImage; // 클라이언트가 업로드한 사업자등록증 파일 수신용
	
	public void setBuyerImage(MultipartFile buyerImage) {
		if(buyerImage==null || buyerImage.isEmpty()) return;
		
		this.buyerImage = buyerImage;
		this.buyerImg = UUID.randomUUID().toString();
		
	}
	
	
}
