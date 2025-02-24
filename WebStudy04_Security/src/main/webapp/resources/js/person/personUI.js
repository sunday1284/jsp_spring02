
document.addEventListener("DOMContentLoaded", ()=>{
	const personHandler = {
		list:function(){
			//resp를 안받아도 된다.
		    const fnSuccess = function(list){
		        let trTags = list.map(p=>
		             `
		                 <tr class="data-tr" data-id="${p.id}">
		                     <td>${p.name}</td>
		                     <td>${p.gender}</td>
		                     <td>${p.age}</td>
		                 </tr>
		             `
		        ).join("\n");
		        $personTbody.html(trTags);
		        $personForm[0].reset();
		     };

		    $.ajax({
		        url:baseURI,
		        dataType:"json",
		        success:fnSuccess
		    }); // ajax end
		},
		detail:function(id){
			$.ajax({
	          url:`${baseURI}/${id}`,
	          dataType:"json",
	          success:function(person){
	              myModalAlternative.show(person); 
	           }
	 		});
		},
		create:function(data){
			$.ajax({
	            url:baseURI,
	            method:"post",
	            dataType:"json",
	            processData:false,
	            contentType:"application/json",
	            data:JSON.stringify(data), // parameter --> json
	            success:function(resp){
					if(resp.success){
						personHandler.list();
					}
				}         
	        });
		},
		remove:function(personId){
			// /person/a001 DELETE
	       let url = `${baseURI}/${personId}`;
			$.ajax({
	            url:url,
	            method:"delete",
	            dataType:"json",

	            success:function(resp){
	                if(resp.success){
	                    // 2. tbody 의 목록 갱신 -> 하나의 tr 제거 
	                    $(`tr[data-id=${personId}]`).remove();
	                    // 3. 모달 종료 
	                    myModalAlternative.hide();
	                }

	            }
	        });
		},
		modify:function(data){   
			// 1. /person/a001 PUT 
			let url = `${baseURI}/${data.id}`;
			// 2. 비동기 수정 요청 전송
			$.ajax({
				url:url,
				method:"put",
				dataType:"json",
				contentType:"application/json",
				data:JSON.stringify(data),
				success:function(resp){
					// 3. tbody 의 목록 갱신 -> 수정된 tr 수정
					if(resp.success){
						personHandler.list();
						// 4. 모달 종료
						myModalAlternative.hide(); // 모달 닫기
					}
				}
			});
		}
	}
	//이밴트 처리단
    const $personForm = $('#person-form'); //insert form Id selecter
    const $updateForm = $("#update-form"); // update form id selecter
    const $personTb = $('#person-tb');  // table selecter
    const $personTbody = $('#person-tb tbody');//jsp에서 비운 tobody 사이에 값을 넣을거다.
    const baseURI = "../../person";
    const modalEl = document.getElementById('exampleModal');
	// 부트스트랩에서 모달창 생성자 생성
    const myModalAlternative = new bootstrap.Modal(modalEl, {});
    const $delBtn = $("#del-btn");
	
	personHandler.list();
	

    $personForm.on("submit", function(e){
        e.preventDefault();
        // let queryString = $(this).serialize();
        let data = {};
        //input 태그의 name->key  두번째요소 value값 
        let fd = new FormData(this);
        for (let p of fd.keys()){
            // console.log(p, fd.get(p));
            data[p] =fd.get(p);
        }
        personHandler.create(data);

    }); // form submit 이벤트 처리 end 
    //이벤트 버블링 구조 -> 자식을 타겟으로 잡음
    $personTbody.on("click", "tr.data-tr" ,function(){
       let id = this.dataset.id;
       personHandler.detail(id);
    }); // click event handler end 

    modalEl.addEventListener("show.bs.modal",function(e){
        // let trTag = e.relatedTarget
        // let id = trTag.dataset.id;
        let person = e.relatedTarget;
        let $modalBody = $(this).find(".modal-body");
   
        // $updateForm 입력 태그들을 person 의 포로포티들로 초기화
		// 입력 태그 전체를 받아옴
		$updateForm.find(":input[name]").each(function(idx, input){
			let name = input.name;
			//프로퍼티값 셋팅 -> 연관배열
			$(input).val(person[name])
		});
		

        $delBtn[0].dataset.id = person.id;
    });
    modalEl.addEventListener("hidden.bs.modal",function(e){
        let $modalBody = $(this).find(".modal-body");
        //$modalBody.empty();
		$updateForm.get(0).reset();
        //마지막에 id값을 초기화
        $delBtn[0].dataset.id = "";
		$(modalEl).removeAttr("aria-hidden");
    });

    $delBtn.on("click",function(){
        let personId = this.dataset.id;
        // 1. 비동기 삭제 요청 전송 
        personHandler.remove(personId);
		//삭제 버튼 클릭 이벤트 처리 end
    }); 

    $updateForm.on("submit",function(e){
        e.preventDefault();	
		let personId = $delBtn[0].dataset.id;
		
		let data = {};
		
		let fd = new FormData(this);
        for (let p of fd.keys()){
            data[p] = fd.get(p);
        }
		
		data.id = personId; // ID 값 추가
		
        // 1. /person/a001 PUT 
        // 2. 비동기 수정 요청 전송 
		// 3. tbody 의 목록 갱신 -> 수정된 tr 수정
		personHandler.modify(data);
	    // 4. 모달 종료
	});		
});