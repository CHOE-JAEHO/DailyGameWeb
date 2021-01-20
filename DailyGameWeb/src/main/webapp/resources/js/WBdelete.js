/**
 * 
 */
$(document).ready(function(){
	



	var wformObj=$("form[role='WBDelete']");
	$("input[type='submit']").on("click",function(e){
		e.preventDefault();//submit 해제
		console.log("submit버튼엑션해제완료.")
		var pw=$("#pw").val();
		var Lpw=$("#Lpw").val();
		console.log(pw)
		console.log(Lpw)
		if(pw==Lpw){
			wformObj.submit();
		}else{
			alert("비밀번호가 다릅니다.")
			window.reload()
	}
	})
	
	
	
})