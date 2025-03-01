<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<table>
	<thead>
		<tr>
			<th>분류코드</th>
			<th>분류명</th>
		</tr>
	</thead>
	<tbody id="listBody">
		<c:choose>
			<c:when test="${not empty lprodList}">
				<c:forEach items="${lprodList}" var="lprod">
					<c:url value="/prod/lprodDetail.do" var="detailUrl">
						<c:param name="what" value="${lprod.lprodGu}"></c:param>
					</c:url>
					<tr>
						<td>${lprod.lprodGu}</td>
						<td><a href="${detailUrl}">${lprod.lprodNm}</a></td>
					</tr>		
				</c:forEach>
			</c:when> 	
			<c:otherwise>
				<tr>
					<td colspan="2">분류 x</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<table id="detail-table">


</table>

<script src="<c:url value='/resources/js/prod/lprodList.js'/>"></script>
