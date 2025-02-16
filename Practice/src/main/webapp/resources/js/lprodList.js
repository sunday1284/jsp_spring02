document.addEventListener("DOMContentLoaded",function(){
    const $detail =  $("#detail-table");
    $("#listBody").on("click", "a" ,function(e){
        $detail.empty();
        // 1. 클릭이벤트 중단
        e.preventDefault();
        // 2. 비동기 요청 전송(dataType : json)
        let url = this.href;
	
        $.ajax({
            url:url,
            dataType:"json",
			// 3. success 함수에서 응답 수신
            success:function({lprod}){
                let html = `
                <tr>
                    <th>분류명</th>
                    <td>${lprod.lprodNm }</td>
                </tr>
                `;
                let prodList = lprod.prodList;
                if(prodList){
                    html += `
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
                    `;
                    $.each(prodList, function(i, prod){
                        html += `
                        <tr>
                            <td>${prod.prodName }</td>
                            <td>${prod.prodCost }</td>
                        </tr>
                        `;
                    });
                    html += `
                        </tbody>
                        </table>
                        </td>
                        </tr>
                    `;
                    $detail.html(html);
                }
            },error:function(){
                console.log(arguments);
            }
        })
        

    });
});
