package kr.or.ddit.case11.objs.vo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *  데이터 매퍼를 이용해서 두개 이상의 테이블 조회 방법
 *  1. 각 테이블을 대상으로 vo 정의.
 *  2. 테이블 간의 관계 파악 : 메인 엔터티를 중심(1)으로 관계 정의
 *  	PROD (1) : LPROD (1)
 *  	LPROD (1) : PROD (N)
 *  	PROD (1) : BUYER (1)
 *  	BUYER (1) : PROD  (N)
 *  3. 각 테이블을 대상으로 한 vo 사이에 동일한 관계를 반영(	Has ).
 *  	ProdVO has a LprodVO 1:1
 *  	LprodVO has many ProdVO 1:n
 *  	ProdVO has a BuyerVO
 *  	BuyerVO has many ProdVO
 *  4. resultType 대신 resultMap 사용.
 *  	Has a : association propery="lprod" javaType="LprodVO" ==> ProdMapper.xml
 *  	Has Many : collection property="prodList" ofType="ProdVO"
 *  			여러개의 자식으로 인해 전체 레코드가 중복되는 경우 발생, --> id 프로퍼티에 대한 수동 설정 필요. ==> LprodMapper.xml
 */
@Data
@EqualsAndHashCode(of="prodId")
//@ToString(exclude = {"prodDetail"})
public class ProdVO implements Serializable{
	private int rnum;
	
	private String prodId;
	private String prodName;
	private String lprodGu;
	private String buyerId;
	private long prodCost;
	private long prodPrice;
	private long prodSale;
	private String prodOutline;
	@ToString.Exclude
	private String prodDetail;
	@ToString.Exclude
	private String prodImg;
	private long prodTotalstock;
	private LocalDate prodInsdate;
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























