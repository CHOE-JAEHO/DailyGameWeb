/**
 * 
 */
$(document).ready(function(){
	
	$("#Mdelete").on("click",function(){
	
	
			
		var OutMember=confirm("정말 삭제하시겠습니까?")
			var id=$("#id").val();
			var pw=$("#pw").val(); 
		
		if(OutMember){
			$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"delete",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/member/memberDelete",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({id:id,pw:pw}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			
				//if(result=="success"){
				alert("정상적으로 탈퇴되었습니다.")
				window.parent.window.location.href="http://localhost:8080/main/Base";
			}/*}*/,
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
				alert("아직 탈퇴되지 않았습니다.")	
			}	
		})//댓글삭제 ajax end
		}else{
			window.parent.window.location.href="http://localhost:8080/main/Base";
		}
	})
})