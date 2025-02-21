<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<table class="table datatable">
	<thead class="table-light">
		<tr>
			<th>일련번호</th>
			<th>제조사명</th>
			<th>분류</th>
			<th>소재재</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>담당자</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty buyerList }">
			<c:forEach items="${buyerList }" var="buyer">
				<tr>
					<td>${buyer.rnum }</td>
					<td>${buyer.buyerName }</td>
					<td>${buyer.lprod.lprodNm }</td>
					<td>${buyer.buyerAdd1 }</td>
					<td>${buyer.buyerComtel }</td>
					<td>${buyer.buyerMail }</td>
					<td>${buyer.buyerCharger }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty buyerList }">
			<tr>
				<td colspan="7">
					등록된 제조사가 없음.
				</td>
			</tr>
		</c:if>
	</tbody>
</table>