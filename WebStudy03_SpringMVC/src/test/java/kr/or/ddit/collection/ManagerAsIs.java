package kr.or.ddit.collection;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.collection.domain.People;
import kr.or.ddit.collection.domain.Student;
import kr.or.ddit.collection.domain.Teacher;

/**
 * 기존 배운대로
 */
public class ManagerAsIs {
	List<People> peopleList = new ArrayList<People>();

	public ManagerAsIs() {
		init();
	}

	public void init() {
		People student1 = new Student("김장철", 15, "남자", "3", "4", "10");
		People student2 = new Student("김삿갓", 15, "남자", "3", "4", "11");
		People student3 = new Student("홍근보", 15, "남자", "3", "6", "12");
		People student4 = new Student("유관순", 18, "여자", "1", "4", "15");

		People teacher2 = new Teacher("김여어", 35, "남자", "담임교사", "담임교사");
		People teacher3 = new Teacher("박과학", 35, "여자", "기간제교사", "담임교사");

		peopleList.add(student1);
		peopleList.add(student2);
		peopleList.add(student3);
		peopleList.add(student4);
//		peopleList.add(student5);

//		peopleList.add(teacher1);
		peopleList.add(teacher2);
		peopleList.add(teacher3);

	}

	public void printAllPeople() {
		for (People people : this.peopleList) {
			System.out.println(people);
		}
	}
	
	public void printAllStudent() {
		for (People people : this.peopleList) {
			if(people instanceof Student)
			System.out.println(people);
		}
	}
	
	public void printAllTeacher() {
		for (People people : this.peopleList) {
			if(people instanceof Teacher)
				System.out.println(people);
		}
	}
	
	
	

	// 등록 기능을 만들어 테스트하시오
	public void create(People people) {
		this.peopleList.add(people);
	}

	// 1건 조회를 만드시오. (조건 파라미터 people의 이름이 같은 사람을 리턴해주세요.즉 이름이 pk)
	public People retrieve(People people) {
		People result = null;
		// 단건 조회
		for (People listPeople : this.peopleList) {
			if (listPeople.getName().equals(people.getName())) {
				result = listPeople;
			}
		}

		return result;
	}

	// 1건 업데이트를 만드시오. (조건 이름이 pk)
	public int update(People people) {
		int cnt = 0;
		
		// 단건 조회
		for (People listPeople : this.peopleList) {
			if (listPeople.getName().equals(people.getName())) {
				cnt++;
				listPeople.setAge(people.getAge());
				listPeople.setSex(people.getSex());
				//선생님 학생인지 ? 어떻게
				if(listPeople instanceof Student) {
					((Student)listPeople).setGradeNo(((Student)people).getGradeNo());
					((Student)listPeople).setClassNo(((Student)people).getClassNo());
					((Student)listPeople).setNo(((Student)people).getNo());
				}else {
					((Teacher)listPeople).setManagerType(((Teacher)people).getManagerType());
					((Teacher)listPeople).setOperateType(((Teacher)people).getOperateType());
				}
				
			}
		}
		
		
		return cnt;

	}
	
	// 1건 삭제를 만드시오. (조건 이름이 pk)
	public int delete(People people) {
		int cnt = 0;
	
		People findPeople = null;
		
		for (People listPeople : this.peopleList) {
			if (listPeople.getName().equals(people.getName())) {
//				this.peopleList.remove(listPeople);
				findPeople = listPeople;
				cnt++;
			}
		}

		if(findPeople!=null) {
			this.peopleList.remove(findPeople);
		}
		
		return cnt;
	}
	

	public static void main(String[] args) {
		ManagerAsIs manager = new ManagerAsIs();
		System.out.println("초기 데이터 출력 시작!!");
		manager.printAllPeople();
		System.out.println("초기 데이터 출력 끝!!");
		People student = new Student("최전학", 14, "여자", "1", "4", "10");
		People teacher = new Teacher("신역사", 30, "남자", "정교사", "담임교사");
		manager.create(student);
		manager.create(teacher);
		System.out.println();
		System.out.println();
		System.out.println("2명 추가 후 데이터 출력 시작!!");
		manager.printAllPeople();
		System.out.println("2명 추가 후 데이터 출력 종료!!");

		// 단건 조회
		student = new Student();
		student.setName("홍근보");

		People retrievepeople = manager.retrieve(student);
		System.out.println("1건 조회 결과 : " + retrievepeople);

		//업데이트 
		
		student = new Student("최전학", 18, "남자", "3", "14", "110");
		
		int updateCnt = manager.update(student);
		System.out.println("updateCnt:" + updateCnt);
		
		
		System.out.println("## 학생 목록만 출력");
		
		manager.printAllStudent();
		
		
		// 단건 조회
		student = new Student();
		student.setName("홍근보");
		
		int deleteCnt = manager.delete(student);
		System.out.println("deleteCnt:" + deleteCnt);
		
		System.out.println("## 삭제 후 학생목록만 출력");
		
		manager.printAllStudent();
		
		
		
		
//		People student1 = new Student();
//		student1.setName("김창철");
//		student1.setSex("남자");
//		student1.setAge(15);
//		//타입 캐스팅
//		((Student)student1).setGradeNo("3");
//		((Student)student1).setClassNo("4");
//		((Student)student1).setNo("10");
//		
//		System.out.println(student1);
//		
//		People teacher1 = new Teacher();
//		teacher1.setName("이수학");
//		teacher1.setSex("여자");
//		teacher1.setAge(35);
//		((Teacher)teacher1).setManagerType("정교사");
//		((Teacher)teacher1).setOperateType("정교사");
//		
//		
//		System.out.println(teacher1);

	}
}
