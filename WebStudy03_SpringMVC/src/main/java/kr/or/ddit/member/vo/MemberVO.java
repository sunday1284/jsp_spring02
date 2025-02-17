package kr.or.ddit.member.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

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
	@NotNull(groups = Default.class)
	private String memId;
	@NotNull(groups = Default.class)
	private transient String memPass;
	@NotNull(groups = Default.class)
	private String memName;
	private transient String memRegno1;
	private transient String memRegno2;
	private String memBir;
	@NotNull(groups = Default.class)
	private String memZip;
	@NotNull(groups = Default.class)
	private String memAdd1;
	@NotNull(groups = Default.class)
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	@NotNull(groups = Default.class)
	private String memHp;
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	private Long memMileage;
	private boolean memDelete;
}
