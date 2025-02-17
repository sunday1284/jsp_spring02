<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<!-- 모든 에러를 한번에 처리해줌  -->
<form:form method="post" modelAttribute="lprod">
	<input type="number" name="lprodId" value="${lprod.lprodId }"/>
	<form:errors path="lprodId" />
	<input type="text" name="lprodGu"  value="${lprod.lprodGu }"/>
	<form:errors path="lprodGu" />
	<input type="text" name="lprodNm" value="${lprod.lprodNm }"/>
	<form:errors path="lprodNm" />
	<button type="submit">전송</button>
</form:form>
