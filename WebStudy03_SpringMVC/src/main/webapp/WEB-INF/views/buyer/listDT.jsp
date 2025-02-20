<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
<table class="table datatable" >
	<thead class="table-dark">
		<tr>
			<th>일련번호</th>
			<th>제조사명</th>
			<th>분류이름</th>
			<th>소재재</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>구매자</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${not empty buyerList}">
			<c:forEach items="${buyerList}" var="buyer">
					<tr>
						<td>${buyer.rnum}</td>
						<td>${buyer.buyerName}</td>
						<td>${buyer.lprod.lprodNm}</td>
						<td>${buyer.buyerAdd1}</td>
						<td>${buyer.buyerComtel}</td>
						<td>${buyer.buyerMail}</td>
						<td>${buyer.buyerCharger}</td>
					</tr>
				</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="7">
					상품 없음.
				</td>
			</tr>
		</c:otherwise>
	</c:choose>	
	</tbody>
</table>