<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form method="post" action="<c:url value='/case07/formProcess1'/>">
	<input type="number" name="lprodId" value="${lprod.lprodId }"/>
	<form:errors path="lprod.lprodId" />
<%-- 	<label>${errors}</label> --%>
	<input type="text" name="lprodGu"  value="${lprod.lprodGu }"/>
	<form:errors path="lprod.lprodGu" />
	<input type="text" name="lprodNm" value="${lprod.lprodNm }"/>
	<form:errors path="lprod.lprodNm" />
	<button type="submit">전송</button>
</form>