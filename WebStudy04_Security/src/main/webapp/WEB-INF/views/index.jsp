<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<h4>웰컴 페이지</h4>
<div>
<!--security:authorize 조건문  -->
<security:authorize access="isAuthenticated()">
	<pre>
		<security:authentication property="principal" var="principal"/>
		<security:authentication property="details"/>
		<security:authentication property="authorities"/>
	</pre>
	<h4>현재 사용자 : 
		<a href="<c:url value='/mypage'/>">${principal.realUser.memName}</a>
	</h4>	
	<a href="<c:url value='/Login/Logout'/>">로그아웃</a>
</security:authorize>
<security:authorize access="isAnonymous()">
		<a href='<c:url value='/login/loginForm.jsp'/>'>로그인</a>	
		<a href='<c:url value='/member/memberInsert.do'/>'>회원가입</a>	

</security:authorize>
</div>

