/**
 * 
 */
$(document).ready(function(){
	


	
	var formObj=$("form[role='BDelete']");
$("input[type='submit']").on("click",function(e){
		e.preventDefault();//submit 해제
		console.log("submit버튼엑션해제완료.")
		var pw=$("#pw").val();
		var Lpw=$("#Lpw").val();
		if(pw==Lpw){
			formObj.submit();
		}else{
			alert("비밀번호가 다릅니다.")
			window.reload()
		}
	})
	
	
	
})