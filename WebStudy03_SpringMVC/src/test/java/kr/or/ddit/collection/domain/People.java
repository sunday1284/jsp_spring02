package kr.or.ddit.collection.domain;

import java.util.Objects;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class People {
	//상속관계 있을때 
	private String name;
	private int age;
	private String sex;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		People other = (People) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	
	
}
