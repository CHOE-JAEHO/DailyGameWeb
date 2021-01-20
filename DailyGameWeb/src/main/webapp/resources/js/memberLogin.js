/**
 * 
 */
$(document).ready(function(){
	
	var name=$("#name").val()
	var failid=$("#failid").val();
	var failpw=$("#failpw").val();
	console.log(failid)
	console.log(failpw)

	if(name==''){
		if(failid){
			alert("아이디가 존재하지 않습니다.")
			failid=null;
		}else if(failpw){
			alert("비밀번호가 틀렸습니다")
			failpw=null;
		}
		
	}else if(name!=null){
		
		window.opener.location.href="http://localhost:8080/main/Base";
		setTimeout(function(){
			
		self.close();
		},300)

	}
})