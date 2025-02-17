package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import kr.or.ddit.case07.validate.DeleteGroup;
import kr.or.ddit.case07.validate.InsertGroup;
import kr.or.ddit.case07.validate.UpdateGroup;
import lombok.Data;

//부모를 중심으로 보면 Has Many
// 자식   			Has A
//기본 그룹 -> InsertGroup, UpdateGroup
@Data
public class LprodVO implements Serializable{ 
	@NotNull(groups = UpdateGroup.class)
	private Long lprodId; //필수
	@NotBlank(groups = {Default.class, DeleteGroup.class})
	@Size(min = 4, max = 4, groups = {Default.class, DeleteGroup.class} )
	private String lprodGu; // string -> @NotBlank
	@NotBlank(groups = InsertGroup.class)
	private String lprodNm;
	
	private List<ProdVO> prodList; // Has Many
	private List<BuyerVO> buyerList; // Has Many
}
