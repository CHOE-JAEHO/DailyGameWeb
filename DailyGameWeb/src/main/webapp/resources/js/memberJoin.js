/**
 * 
 */
$(document).ready(function(){
	var form=$('#joinFrom');
	
	$("input[type='submit']").on("click",function(e){
		e.preventDefault();//submit해제
	var id=$("#id").val()
	
	var idPt=/^[A-Za-z0-9]{5,12}$/
	var blankPt = /\s/g;
	var idTF=idPt.test(id)
	var blTF=blankPt.test(id)
	if(!idTF||blTF){
		$(".idOp").remove()
		$("<span id='idFail'class='idOp'>아이디는 5~12글자의 영문 숫자입니다.<span>").insertAfter("#idL")
		
	}else{
		$(".idOp").remove()
		$("<span id='idOk'class='idOp'>좋은 아이디입니다.<span>").insertAfter("#idL")
		var pw=$("#pw").val()
		//영문숫자특문조합 정규표현식
		var pwPt=/^[A-Za-z0-9\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]{6,14}$/g
		var blankPt = /\s/g;
		console.log(pwPt.test(pw));
		console.log(blTF)
		var pwTF=pwPt.test(pw)
		//조합이 틀리거나 공백이 있을 때.는 false or true 참(잘못됨)
		//조합이 맞거나 공백이 있을 때는    true or true 참(잘못됨)
		//조합이 틀리거나 공백이 없을 때는 false or false 틀림 (잘됨
		// 조합이 맞거나 공백이 없을 때는 true or false 틀림(잘못됨)
		if(!pwTF||blTF){
		$(".pwOp").remove()
			var pw=$("#pw").val('')
		$("<span id='pwFail'class='pwOp'>비밀번호는 6~14글자의 영문,숫자,특스문자 조합입니다.<span>").insertAfter("#pwL")		
		}else{
		$(".pwOp").remove()
		$("<span id='pwOk'class='pwOp'>좋은 비밀번호입니다.<span>").insertAfter("#pwL")
		
			
		}
	}
		var formData=form.serialize();
		console.log(formData.id)
		})
		
/*ID 블러문구*/	
	$("#id").on('blur',function(){
	var id=$("#id").val()
		if(id.length>=5){
		$(".idOp").remove()
		$("<span id='idOk'class='idOp'>좋은 아이디입니다.<span>").insertAfter("#idL")
		}else{
		$(".idOp").remove()
		$("<span id='idFail'class='idOp'>아이디는 5~12글자의 영문,숫자입니다.<span>").insertAfter("#idL")
			}
		})
/*pw			
	$("#pw").on('blur',function(){
	var pw=$("#pw").val()
		if(pw.length>=6){
		$(".pwOp").remove()
		$("<span id='pwOk'class='pwOp'>좋은 비밀번호입니다.<span>").insertAfter("#pwL")
		}else{
		$(".pwOp").remove()
		$("<span id='pwFail'class='pwOp'>비밀번호는 6~14글자의 영문 숫자입니다.<span>").insertAfter("#pwL")		
			}
		})*/

/*pwc*/	
	$("#pwc").on('blur',function(){
	
	var pwc=$("#pwc").val()
	var pw=$("#pw").val()
	
	if(pw==pwc){
		$(".pwcOp").remove()
		$("<span id='pwcOk'class='pwcOp'>비밀번호가 일치합니다<span>").insertAfter("#pwcL")
	}else{
		$(".pwcOp").remove()
	 	$("<span id='pwcFail'class='pwcOp'>비밀번호가 일치 안합니다<span>").insertAfter("#pwcL")
	}
	})
	

})

	
	

	
	


function AN(e)  {
  e.value = e.value.replace(/[^A-Za-z0-9]/ig, '')
}



	function idC(){

		var id=$("#id").val()
	
		$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"post",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/member/idCheck",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({id:id}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			
				//if(result=="success"){
					alert("이미 존재하는 아이디입니다.")
					$("#id").val('')				
			}/*}*/,
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
				alert("사용가능한 아이디입니다.")	
			}	
		})//댓글쓰기 ajax end
		
	}
/*phone*/
function numberMaxLength(e){
	if(e.value.length>e.maxlength){
		e.value = e.value.slice(0, e.maxLength);
	}
}
	
		function NickC(){
		
		var name=$("#name").val()
		
		$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"post",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/member/nameCheck",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({name:name}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			
				//if(result=="success"){
					alert("이미 존재하는 닉네임입니다.")
					$("#name").val('')
			}/*}*/,
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
				alert("사용가능한 닉네임입니다.")
			}
		})//댓글쓰기 ajax end
		
	}
		function join(){

		var id=$("input[name='id']").val()
		var pw=$("input[name='pw']").val()
		var name=$("input[name='name']").val()
		var gen=$("input[name='gen']").val()
		var birth=$("input[name='birth']").val()
		var email=$("input[name='email']").val()
		var phone=$("#ph1").val()+$("#ph2").val()+$("#ph3").val()
		
		alert(phone)
		$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"post",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/member/memberJoin",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({id:id,pw:pw,name:name,gen:gen,birth:birth,email:email,phone:phone}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			alert("가입을 축하합니다.")
			window.parent.window.location.href="http://localhost:8080/main/Base";			
			},
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
				alert("입력을 확인해 주세요")	
			}	
		})//join ajax end 
}

	