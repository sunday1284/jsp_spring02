/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
	const myOffcanvasEL = document.getElementById('offcanvasExample')
	const $dataTds = $("[data-name]");
	const $imgTd = $("[data-img]");
	const $updateTd = $("[data-update]");
	
	
	myOffcanvasEL.addEventListener('show.bs.offcanvas', event => {
		let relatedTarget = event.relatedTarget;
		console.log(relatedTarget);
		$.ajax({
			url:relatedTarget.detailUrl,
			data:{
				what:relatedTarget.what 
			},
			dataType:"json",
			success:function(resp){
				let prod = resp.prod;
				
				$dataTds.each(function(idx, td){
					let name = td.dataset.name;
					//동적 프로퍼티 접근 td[data-name="prodName"] prod.prodName 한쌍으로 접근
					//17번의 하드코딩x
					td.innerHTML = prod[name];
				});
				let baseUrl = $imgTd.data("img");
				let src = baseUrl + "/" + prod.prodImg;
				$imgTd.html(`<img src="${src}" />`);
				
				let updateUrl = $updateTd.data("update");
				let href = `${updateUrl}?what=${prod.prodId}`;
				$updateTd.html(`<a class="btn-btn-primary" href="${href}">상품 수정</a>`);
			}
		})
	})
	
	//offcanvas 생성으로 옆으로 쫙 나오게 함
	const bsOffcanvas = new bootstrap.Offcanvas(myOffcanvasEL);
	
    $("tr[data-prod-id]").on('click', function() {
        let $table = $(this).parents('table');
        let detailUrl = $table.data("detailUrl");
        let what = this.dataset.prodId;
		
        //location.href = `${detailUrl}?what=${what}`;
		bsOffcanvas.show({
			what:what,
			detailUrl:detailUrl
		});
    });
	
	const $buyerId = $('[name="buyerId"]');
	   $('[name="lprodGu"]').on("change",function(){
	      // 'P101'
	      let selectedLprod = $(this).val();
	      $buyerId.find("option").hide();
	      $buyerId.find("option:first").show();
	      // 'P101' , 'P10101', 'P10102'
		  if(selectedLprod)
		           $buyerId.find(`option[value^=${selectedLprod}]`).show();
		        else
		           $buyerId.find("option").show();
	 });
	  
});




