<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<script src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js"></script>

<form:form modelAttribute="prod" method="post" enctype="multipart/form-data">
	<input type="text" name="prodId" value="${prod.prodId }">
   <div class="row mb-3">
      <label for="prodName" class="col-sm-2 col-form-label">상품명</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="prodName" id="prodName"
				value="${prod.prodName}">
			<form:errors path="prodName" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="lprodGu" class="col-sm-2 col-form-label">분류코드</label>
      <div class="col-sm-10">
        <select name="lprodGu" data-init-value="${codition.lprodGu }" class="form-control">
         <option value>상품분류</option>
         <c:forEach items="${lprodList }" var="lprod"> 
            <option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
         </c:forEach>
      </select>
         <form:errors path="lprodGu" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="buyerId" class="col-sm-2 col-form-label">제조사코드</label>
      <div class="col-sm-10">
        <select name="buyerId" data-init-value="${codition.buyerId }" class="form-control">
         <option value>제조사코드</option>
         <c:forEach items="${buyerList }" var="buyer"> 
            <option value="${buyer.buyerId }">${buyer.buyerName }</option>
         </c:forEach>
      </select>
         <form:errors path="buyerId" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodCost" class="col-sm-2 col-form-label">구매가</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" name="prodCost"
				id="prodCost" value="${prod.prodCost}">
			<form:errors path="prodCost" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodPrice" class="col-sm-2 col-form-label">판매가</label>
      <div class="col-sm-10">
       <input type="number" class="form-control" name="prodPrice"
				id="prodPrice" value="${prod.prodPrice}">
			<form:errors path="prodPrice" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodSale" class="col-sm-2 col-form-label">세일가</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" name="prodSale"
				id="prodSale" value="${prod.prodSale}">
			<form:errors path="prodSale" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodOutline" class="col-sm-2 col-form-label">요약정보</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="prodOutline"
				id="prodOutline" value="${prod.prodOutline}">
			<form:errors path="prodOutline" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodDetail" class="col-sm-2 col-form-label">상세정보</label>
      <div class="col-sm-10">
			<textarea name="prodDetail" id="prodDetail">${prod.prodDetail}</textarea>
			<form:errors path="prodDetail" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodImage" class="col-sm-2 col-form-label">이미지</label>
      <div class="col-sm-10">
        <input type="file" name="prodImage"  id="prodImage" class="form-control">
        <form:errors path="prodImage" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodTotalstock" class="col-sm-2 col-form-label">총재고</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" name="prodTotalstock"
				id="prodTotalstock" value="${prod.prodTotalstock}">
			<form:errors path="prodTotalstock" class="text-danger" element="span" />
      </div>
    </div>

    <div class="row mb-3">
      <label for="prodProperstock" class="col-sm-2 col-form-label">적정재고</label>
      <div class="col-sm-10">
       <input type="number" class="form-control" name="prodProperstock"
				id="prodProperstock" value="${prod.prodProperstock}">
			<form:errors path="prodProperstock" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodSize" class="col-sm-2 col-form-label">크기</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="prodSize" id="prodSize"
				value="${prod.prodSize}">
		<form:errors path="prodSize" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodColor" class="col-sm-2 col-form-label">색상</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="prodColor"
				id="prodColor" value="${prod.prodColor}">
			<form:errors path="prodColor" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodDelivery" class="col-sm-2 col-form-label">배송방법</label>
      <div class="col-sm-10">
       <input type="text" class="form-control" name="prodDelivery"
				id="prodDelivery" value="${prod.prodDelivery}">
			<form:errors path="prodDelivery" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodUnit" class="col-sm-2 col-form-label">단위</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="prodUnit" id="prodUnit"
				value="${prod.prodUnit}">
			<form:errors path="prodUnit" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodQtyin" class="col-sm-2 col-form-label">입고량</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" name="prodQtyin"
				id="prodQtyin" value="${prod.prodQtyin}">
			<form:errors path="prodQtyin" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodQtysale" class="col-sm-2 col-form-label">출고량</label>
      <div class="col-sm-10">
       <input type="number" class="form-control" name="prodQtysale"
				id="prodQtysale" value="${prod.prodQtysale}">
			<form:errors path="prodQtysale" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="prodMileage" class="col-sm-2 col-form-label">마일리지</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" name="prodMileage"
				id="prodMileage" value="${prod.prodMileage}">
			<form:errors path="prodMileage" class="text-danger" element="span" />
      </div>
    </div>
    <div class="row mb-3">
      <div class="col-sm-10">
          <button type="submit" class="btn btn-primary">저장</button>
      </div>
    </div>
</form:form>
<script>
	/*  체이닝구조*/
	document.addEventListener("DOMContentLoaded", ()=>{
		const $buyerId = $('[name="buyerId"]').val("${prod.buyerId}");
		$('[name="lprodGu"]').on("change", function(){
			// 'P101'
			let selectedLprod = $(this).val();
			$buyerId.find("option").hide();
			$buyerId.find("option:first").show();
			// 'P101', 'P10101', 'P10102'
			if(selectedLprod)
				$buyerId.find(`option[value^=\${selectedLprod}]`).show();
			else
				$buyerId.find("option").show();
		}).val("${prod.lprodGu}");
		
		 CKEDITOR.replace( 'prodDetail', {
			 versionCheck : false
		 } );
	});
</script>


