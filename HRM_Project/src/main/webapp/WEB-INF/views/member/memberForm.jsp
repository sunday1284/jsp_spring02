<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<form:form method="post" modelAttribute="member">
	<table class="table">
		<tr>
			<th>회원아이디</th>
			<td><input type="text" name="memId" class="form-control"
				value="${member.memId}" />
				<!-- element 타입을 지정해줄 수 있음 -->
				<form:errors path="memId"  class="text-danger" element="span"/>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="memPass" class="form-control"/>
				<form:errors path="memPass" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>회원명</th>
			<td><input type="text" name="memName" class="form-control"
				value="${member.memName}" /><form:errors path="memName" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>주민번호1</th>
			<td><input type="text" name="memRegno1" class="form-control"
				value="${member.memRegno1}" /><form:errors path="memRegno1" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>주민번호2</th>
			<td><input type="text" name="memRegno2" class="form-control"
				value="${member.memRegno2}" /><form:errors path="memRegno2" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><input type="date" name="memBir" class="form-control"
				value="${member.memBir}" /><form:errors path="memBir" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><input type="text" name="memZip" class="form-control"
				value="${member.memZip}" /><form:errors path="memZip" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><input type="text" name="memAdd1" class="form-control"
				value="${member.memAdd1}" /><form:errors path="memAdd1" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><input type="text" name="memAdd2" class="form-control"
				value="${member.memAdd2}" /><form:errors path="memAdd2" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>집전화번호</th>
			<td><input type="text" name="memHometel" class="form-control"
				value="${member.memHometel}" /><form:errors path="memHometel" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>회사번호</th>
			<td><input type="text" name="memComtel" class="form-control"
				value="${member.memComtel}" /><form:errors path="memComtel" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td><input type="text" name="memHp" class="form-control"
				value="${member.memHp}" /><form:errors path="memHp" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="memMail" class="form-control"
				value="${member.memMail}" /><form:errors path="memMail" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><input type="text" name="memJob" class="form-control"
				value="${member.memJob}" /><form:errors path="memJob" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><input type="text" name="memLike" class="form-control"
				value="${member.memLike}" /><form:errors path="memLike" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>기념일</th>
			<td><input type="text" name="memMemorial" class="form-control"
				value="${member.memMemorial}" /><form:errors path="memMemorial" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>기념일자</th>
			<td><input type="date" name="memMemorialday"
				class="form-control" value="${member.memMemorialday}" />
				<form:errors path="memMemorialday" class="text-danger" element="span" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
			</td>
		</tr>
	</table>
</form:form>
<!-- 프롬프트 예시 오라클의 "COLS", "USER_COL_COMMENTS" 의 스키마 뷰로 SELECT 쿼리를 만들어줘 ##레코드
조회 결과 예시##
<tr>
	<th>회원아이디</th>
	<td><input type="text" name="memId" class="form-control" /></td>
</tr> -->