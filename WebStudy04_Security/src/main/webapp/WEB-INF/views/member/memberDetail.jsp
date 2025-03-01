<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<h4>${member.memName}님의정보</h4>
<table class="table">
	<tr>
		<th>회원아이디</th>
		<td>${member.memId}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${member.memPass}</td>
	</tr>
	<tr>
		<th>회원명</th>
		<td>${member.memName}</td>
	</tr>
	<tr>
		<th>주민번호1</th>
		<td>${member.memRegno1}</td>
	</tr>
	<tr>
		<th>주민번호2</th>
		<td>${member.memRegno2}</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>${member.memBir}</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td>${member.memZip}</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${member.memAdd1}</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${member.memAdd2}</td>
	</tr>
	<tr>
		<th>집전화번호</th>
		<td>${member.memHometel}</td>
	</tr>
	<tr>
		<th>회사번호</th>
		<td>${member.memComtel}</td>
	</tr>
	<tr>
		<th>휴대폰</th>
		<td>${member.memHp}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${member.memMail}</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>${member.memJob}</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>${member.memLike}</td>
	</tr>
	<tr>
		<th>기념일</th>
		<td>${member.memMemorial}</td>
	</tr>
	<tr>
		<th>기념일자</th>
		<td>${member.memMemorialday}</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${member.memMileage}</td>
	</tr>
	<tr>
		<th>탈퇴여부</th>
		<td>${member.memDelete}</td>
	</tr>
	
	<!-- vo에서 해쉬코드값을 id로 해놨기때문에 따로 받기x  -->
	<!-- 	선택적 랜더링 구조  -->
	<security:authorize access="isAuthenticated()">
	<security:authentication property="principal" var="principal"/>
	<c:set value="${principal.realUser }" var="authMember"/>
	<c:if test="${member eq authMember}">
		<tr>
			<td colspan="2">
				<a class="btn btn-primary" href="<c:url value='/member/memberUpdate.do'/>">회원정보 수정</a>
				<!--비밀번호 입력창에 뜨고 입력한 후 탈퇴처리  -->
				<button id="delBtn" class="btn btn-danger" data-target-form="#deleteForm">회원탈퇴</button>
				<form method="post" id="deleteForm" action="<c:url value='/member/memberDelete.do'/>">
					<input type="text" name="password" /> 
					<!--자동으로 csrf 토큰 생성  -->
<%-- 					<security:csrfInput /> --%>
				</form>
			</td>
		</tr>
		<script src="${pageContext.request.contextPath}/resources/js/member/memberDetail.js"></script>
	</c:if>
	</security:authorize>
</table>

