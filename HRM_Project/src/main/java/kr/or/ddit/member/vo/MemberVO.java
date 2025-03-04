package kr.or.ddit.member.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kr.or.ddit.validate.InsertGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 회원관리를 위한 domain layer 
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"memPass","memRegno1","memRegno2"})
@EqualsAndHashCode(of = "memId")
@Data
public class MemberVO implements Serializable{
	//일련번호 
	private int rnum;
	
	@NotBlank(groups = InsertGroup.class)
	private String memId;
	@NotBlank
	@Size(min= 4, max= 12)
	private transient String memPass;
	@NotBlank(groups = InsertGroup.class)
	private String memName;
	@Size(min = 6, max = 6, groups = InsertGroup.class)
	private transient String memRegno1;
	@Size(min = 7, max = 7, groups = InsertGroup.class)
	private transient String memRegno2;
	private String memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	@NotBlank
	private String memHp;
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	private Long memMileage;
	private boolean memDelete;
	//권한관리를 위한 has many관계
	private List<String> authorities; //has many
}
