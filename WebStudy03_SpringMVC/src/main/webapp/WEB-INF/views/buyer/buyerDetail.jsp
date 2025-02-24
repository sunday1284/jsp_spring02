<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!--    제조사 분류 코드 대신 분류명 출력 -->
<!--    해당 제조사의 거래 품목(상품명, 구매가, 판매가, 세일가, 마일리지) 리스트 출력. -->

<table class="table table-bordered">
	<tr>
		<td colspan="2">
		<button onclick="history.go(-1);"> 뒤로가기</button>
			<c:url value="/buyer/${buyer.buyerId}/edit" var="editUrl" />
			<a class="btn btn-primary" href="${editUrl }">제조사 수정</a>	
	</tr>

	
   <tr>
      <th>제조사코드</th>
      <td>${buyer.buyerId}</td>
   </tr>
   <tr>
      <th>제조사명</th>
      <td>${buyer.buyerName}</td>
   </tr>
   <tr>
      <th>분류명</th>
      <td>${buyer.lprod.lprodNm}</td>
   </tr>
   <tr>
      <th>거래은행</th>
      <td>${buyer.buyerBank}</td>
   </tr>
   <tr>
      <th>계좌번호</th>
      <td>${buyer.buyerBankno}</td>
   </tr>
   <tr>
      <th>계좌주</th>
      <td>${buyer.buyerBankname}</td>
   </tr>
   <tr>
      <th>우편번호</th>
      <td>${buyer.buyerZip}</td>
   </tr>
   <tr>
      <th>주소1</th>
      <td>${buyer.buyerAdd1}</td>
   </tr>
   <tr>
      <th>주소2</th>
      <td>${buyer.buyerAdd2}</td>
   </tr>
   <tr>
      <th>전화번호</th>
      <td>${buyer.buyerComtel}</td>
   </tr>
   <tr>
      <th>팩스번호</th>
      <td>${buyer.buyerFax}</td>
   </tr>
   <tr>
      <th>이메일</th>
      <td>${buyer.buyerMail}</td>
   </tr>
   <tr>
      <th>담당자</th>
      <td>${buyer.buyerCharger}</td>
   </tr>
   <tr>
      <th>내선번호</th>
      <td>${buyer.buyerTelext}</td>
   </tr>
   <tr>
      <th>사업자등록증</th>
      <td>
         <c:if test="${not empty buyer.buyerImg }">
            <spring:eval expression="@fileInfo.buyerImages" var="buyerImages" ></spring:eval>
            <img src="<c:url value='${buyerImages}${buyer.buyerImg}'/>" />
         </c:if>
      </td>
   </tr>
   <c:if test="${not empty buyer.prodList }">
      <tr>
         <th>거래품목</th>
         <td>
            <table class="table table-bordered">
               <thead>
                  <tr>
                     <th>상품명</th>
                     <th>구매가</th>
                     <th>판매가</th>
                     <th>세일가</th>
                     <th>마일리지</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${buyer.prodList }" var="prod">
                  
                     <c:url value="/prod/prodDetail.do" var="detailUrl">
                        <c:param name="what" value="${prod.prodId }"></c:param>
                     </c:url>
                     <tr>
                        <td>
                           <a href="${detailUrl }">${prod.prodName }</a>
                        </td>
                        <td>${prod.prodCost }</td>
                        <td>${prod.prodPrice }</td>
                        <td>${prod.prodSale }</td>
                        <td>${prod.prodMileage }</td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </td>
      </tr>
   </c:if>
</table>