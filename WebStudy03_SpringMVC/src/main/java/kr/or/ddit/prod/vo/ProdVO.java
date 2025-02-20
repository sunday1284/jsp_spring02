package kr.or.ddit.prod.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 데이터 매퍼를 이용해서 두개 이상의 테이블 조회 방법 
 * 1. 각 테이블을 대상으로 vo 정의. 
 * 2. 테이블 간의 관계 파악 : 메인 엔터티를 중심(1)으로 관계 정의 
 * 		PROD (1) : LPROD (1) 
 * 		LPROD (1) : PROD (N)
 * 		PROD(1) :  BUYER (1)
 * 		BUYER (1) : PROD (N)
 * 3. 각 테이블을 대상으로 한 vo사이에 동일한 관계를 반영( Has ).
 * 	 자식 -> 부모(1 : 1)	ProdVO has a LprodVO 1:1
 * 	 부모 -> 자식(1 : N)	LProdVO has many ProdVO 1:n
 * 	 ProdVO has a BuyerVO 1:1
 * 	 BuyerVO has many ProdVO 1:n
 * 4. resultType 대신 resultMap 사용.
 * 		Has a : association property="lprod" javaType="lprodVO" ==> ProdMapper.xml
 * 		Has Many : collection property="prodList" ofType="ProdVO"
 * 				여러개의 자식으로 인해 전체 레코드가 중복되는 경우 발생, --> id 프로퍼티에 대한 수동 설정 필요. ==> LprodMapper.xml
 */
@Data
@EqualsAndHashCode(of="prodId")
//@ToString(exclude = {"prodDetail"})

public class ProdVO implements Serializable{
	private int rnum;
	
	@NotBlank(groups = UpdateGroup.class)
	private String prodId;
	@NotBlank
	private String prodName;
	@NotBlank(groups = InsertGroup.class)
	private String lprodGu;
	@NotBlank(groups = InsertGroup.class)
	private String buyerId;
	// 0미만으로는 x
	@Min(0)
	private long prodCost;
	@Min(0)
	private long prodPrice;
	@Min(0)
	private long prodSale;
	@NotBlank
	private String prodOutline;
	@ToString.Exclude
	private String prodDetail;
	@NotBlank(groups = InsertGroup.class)
	@ToString.Exclude
	private String prodImg;  //DB에 PROD 테이블 prod_img 컬럼을 위한 프로퍼티 
	
	//이미지가 비어있으면..
	@NotNull(groups = InsertGroup.class)
	@ToString.Exclude
	private MultipartFile prodImage; //클라이언트의 업로드 이미지를 받기 위한 프로퍼티 
	public void setProdImage(MultipartFile prodImage) {
		if(prodImage==null || prodImage.isEmpty()) return;
		else {
			this.prodImage = prodImage;
			this.prodImg = UUID.randomUUID().toString();
		}
	}
	
	private long prodTotalstock;
	//date 일때 형변환
	private LocalDate prodInsdate;
	@Min(0)
	private long prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Long prodQtyin;
	private Long prodQtysale;
	private Long prodMileage;
	
	private LprodVO lprod; // Has A 
	private BuyerVO buyer; // Has A 
}
