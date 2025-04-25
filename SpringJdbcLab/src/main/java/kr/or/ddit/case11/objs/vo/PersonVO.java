package kr.or.ddit.case11.objs.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class PersonVO implements Serializable{
	private String id;
	private String name;
	private String gender;
	private int age;
	private String address;
}
