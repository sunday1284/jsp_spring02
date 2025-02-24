<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="buyer" method="post"
	enctype="multipart/form-data">
	<div class="row mb-3">
		<label for="buyerName" class="col-sm-2 col-form-label">제조사명</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerName"
				id="buyerName" value="${buyer.buyerName}">
			<form:errors path="buyerName" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="lprodGu" class="col-sm-2 col-form-label">분류코드</label>
		<div class="col-sm-10" >
			<!-- 처음 form으로 요청 올때 ModelAttribute 커맨드 오브젝트가 필요함 -->
			<form:select path="lprodGu">
				<option value>제조사분류</option>
				<form:options items="${lprodList }" itemValue="lprodGu" itemLabel="lprodNm" />
			</form:select>
			<form:errors path="lprodGu" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerBank" class="col-sm-2 col-form-label">거래은행</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerBank"
				id="buyerBank" value="${buyer.buyerBank}">
			<form:errors path="buyerBank" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerBankno" class="col-sm-2 col-form-label">계좌번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerBankno"
				id="buyerBankno" value="${buyer.buyerBankno}">
			<form:errors path="buyerBankno" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerBankname" class="col-sm-2 col-form-label">계좌주</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerBankname"
				id="buyerBankname" value="${buyer.buyerBankname}">
			<form:errors path="buyerBankname" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerZip" class="col-sm-2 col-form-label">우편번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerZip" id="buyerZip"
				value="${buyer.buyerZip}">
			<form:errors path="buyerZip" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerAdd1" class="col-sm-2 col-form-label">주소1</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerAdd1"
				id="buyerAdd1" value="${buyer.buyerAdd1}">
			<form:errors path="buyerAdd1" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerAdd2" class="col-sm-2 col-form-label">주소2</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerAdd2"
				id="buyerAdd2" value="${buyer.buyerAdd2}">
			<form:errors path="buyerAdd2" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerComtel" class="col-sm-2 col-form-label">전화번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerComtel"
				id="buyerComtel" value="${buyer.buyerComtel}">
			<form:errors path="buyerComtel" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerFax" class="col-sm-2 col-form-label">팩스번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerFax" id="buyerFax"
				value="${buyer.buyerFax}">
			<form:errors path="buyerFax" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerMail" class="col-sm-2 col-form-label">이메일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerMail"
				id="buyerMail" value="${buyer.buyerMail}">
			<form:errors path="buyerMail" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerCharger" class="col-sm-2 col-form-label">담당자</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerCharger"
				id="buyerCharger" value="${buyer.buyerCharger}">
			<form:errors path="buyerCharger" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerTelext" class="col-sm-2 col-form-label">내선번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="buyerTelext"
				id="buyerTelext" value="${buyer.buyerTelext}">
			<form:errors path="buyerTelext" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<label for="buyerImg" class="col-sm-2 col-form-label">사업자등록증</label>
		<div class="col-sm-10">
			<input type="file" name="buyerImage" id="buyerImage" accept="image/*"/>
			<form:errors path="buyerImage" class="text-danger" element="span" />
		</div>
	</div>
	<div class="row mb-3">
		<button class="btn btn-primary" type="submit">저장</button>
	</div>
</form:form>