<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>

<table>
	<tr>
		<th>분류명</th>
		<td>${lprod.lprodNm }</td>
	</tr>
		<c:set value="${lprod.prodList }" var="prodList"/>
		<c:if test="${not empty  prodList}">
	<tr>
		<th>상품목록</th>
		<td>
			<table>
				<thead>
					<tr>
						<th>상품명</th>
						<th>구매가</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${prodList  }" var="prod">
						<tr>
							<td>${prod.prodName }</td>
							<td>${prod.prodCost }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</td>
	</tr>
  </c:if>
</table>