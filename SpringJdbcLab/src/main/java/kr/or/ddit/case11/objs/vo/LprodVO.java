package kr.or.ddit.case11.objs.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class LprodVO implements Serializable{
	private Long lprodId;
	private String lprodGu;
	private String lprodNm;
	
	private List<ProdVO> prodList; // Has Many
	private List<BuyerVO> buyerList; // Has Many
}
