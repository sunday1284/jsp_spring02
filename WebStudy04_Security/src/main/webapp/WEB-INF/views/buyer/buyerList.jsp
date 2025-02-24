<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!-- 페이징과 검색(제조사분류, 제조사명) 기능 추가 -->
<table class="table table-bordered">
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
					<td>
					<a href="<c:url value='buyer/${buyer.buyerId}'/>">
						${buyer.buyerName }
					</a>
					</td>
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
	<tfoot>
		<tr>
			<td colspan="7">
				${pagingHTML }
				<div id="search-ui">
					<select name="lprodGu" data-init-value="${condition.lprodGu }">
						<option value>제조사분류</option>
						<c:forEach items="${lprodList }" var="lprod">
							<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
						</c:forEach>
					</select>
					<input type="text" name="buyerName" placeholder="상품명" value="${condition.buyerName }"/>
					<button type="button" id="search-btn">상세검색</button>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<form id="search-form">
	<input type="text" name="page"/>
	<input type="text" name="lprodGu" value="${condition.lprodGu }"/>
	<input type="text" name="buyerName" value="${condition.buyerName }"/>
</form>
<script src="${pageContext.request.contextPath }/resources/js/common/paging.js"></script>











