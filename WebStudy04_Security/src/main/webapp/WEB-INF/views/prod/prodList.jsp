<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<style type="text/css">
	tr[data-prod-id]{
		cursor: pointer;
	}
</style>
<table class="table table-bordered" data-detail-url="<c:url value='/prod/prodDetail.do'/>">
	<thead class="table-dark">
		<tr>
			<th>일련번호</th>
			<th>상품명</th>
			<th>상품분류명</th>
			<th>제조사명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>총재고량</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${not empty prodList}">
			<c:forEach items="${prodList}" var="prod">
				<tr data-prod-id="${prod.prodId}">
					<td>${prod.rnum }</td>
					<td>${prod.prodName}</td>
					<td>${prod.lprod.lprodNm}</td>
					<td>${prod.buyer.buyerName}</td>
					<td>${prod.prodCost}</td>
					<td>${prod.prodPrice}</td>
					<td>${prod.prodTotalstock}</td>
					<td>${prod.prodMileage}</td>
				</tr>
			</c:forEach>
			
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8">
					상품 없음.
				</td>
			</tr>
		</c:otherwise>
	</c:choose>	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">
				${pagingHTML }	
				<!-- 입력용 -->
				<div id="search-ui">
					<select name="lprodGu" data-init-value="${condition.lprodGu }">
						<option value>상품분류</option>
						<c:forEach items="${lprodList}" var="lprod">
							<option value="${lprod.lprodGu}">${lprod.lprodNm }</option>
						</c:forEach>
					</select>
					<select name="buyerId" data-init-value="${condition.buyerId }">
						<option value>제조사선택</option>
						<c:forEach items="${buyerList}" var="buyer">
							<option value="${buyer.buyerId }">${buyer.buyerName }</option>
						</c:forEach>
					</select>
					<input type="text" name="prodName" placeholder="상품명" value="${condition.prodName }"/>
					<button type="button" id="search-btn">상세검색</button>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<!-- 전송용 -->
<form id="search-form">
	<input type="text" name="page"/>
	<input type="text" name="lprodGu" value="${condition.lprodGu }"/>
	<input type="text" name="buyerId" value="${condition.buyerId }"/>
	<input type="text" name="prodName" value="${condition.prodName }"/>
</form>

<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
  	<table class="table table-bordered">
		<tr>
			<td colspan="2" data-update='<c:url value='/prod/prodUpdate.do'/>'>
				<!-- go -> index 값으로 가고싶은 경로 지정 -->
				
			</td>
		</tr>
		<tr>
			<th>상품코드</th>
			<td data-name="prodId"></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td data-name="prodName"></td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td data-name="lprodGu"></td>
		</tr>
		<tr>
			<th>제조사코드</th>
			<td data-name="buyerId"></td>
		</tr>
		<tr>
			<th>구매가</th>
			<td data-name="prodCost"></td>
		</tr>
		<tr>
			<th>판매가</th>
			<td data-name="prodPrice"></td>
		</tr>
		<tr>
			<th>세일가</th>
			<td data-name="prodSale"></td>
		</tr>
		<tr>
			<th>요약정보</th>
			<td data-name="prodOutline"></td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td data-name="prodDetail"></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td data-img="<c:url value='/resources/prodImages'/>">
				
			</td>
		</tr>
		<tr>
			<th>총재고</th>
			<td data-name="prodTotalstock"></td>
		</tr>
		<tr>
			<th>입고일</th>
			<td data-name="prodInsdate"></td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td data-name="prodProperstock"></td>
		</tr>
		<tr>
			<th>크기</th>
			<td data-name="prodSize"></td>
		</tr>
		<tr>
			<th>색상</th>
			<td data-name="prodColor"></td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td data-name="prodDelivery"></td>
		</tr>
		<tr>
			<th>단위</th>
			<td data-name="prodUnit"></td>
		</tr>
		<tr>
			<th>입고량</th>
			<td data-name="prodQtyin"></td>
		</tr>
		<tr>
			<th>출고량</th>
			<td data-name="prodQtysale"></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td data-name="prodMileage"></td>
		</tr>
	
	
	</table>
  </div>
</div>


<script src="${pageContext.request.contextPath }/resources/js/prod/prodList.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/common/paging.js"></script>