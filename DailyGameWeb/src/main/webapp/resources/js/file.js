/**javaScript=html에서 javaScript로 가지고 와서 작업을 한다.html로 부족한 것들을.
 * 
 */
function back(){
		window.location.href="http://localhost:8080/board/boardList";		
	}
function wback(){
		window.location.href="http://localhost:8080/wboard/boardList";		
	}
	
	
$(document).ready(function(){
	
	
	
	//file의 form 태그 처리//원래 즉발submit을 해제하고 → 새로 쓴 form을 submit
	var formObj=$("form[role='boardwrite']");//role이라는 값이 form이면 form태그가 저장되는 곳.
	$("input[type='submit']").on("click",function(e){
		e.preventDefault();//submit 해제
		console.log("submit버튼엑션해제완료.")
		var str="";
		$(".uploadResult ul li").each(function(i,obj){
			var jobj=$(obj);
			str+="<input type='text' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
			str+="<input type='text' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
			str+="<input type='text' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
		})
		var ti=$("#BWti").val();
		if(ti=='' || null || undefined || 0 || NaN){
			alert("제목을 입력 해주세요.")
		}else{
			formObj.append(str).submit();//form 태그의 name에 있는 것을 싹 다 넘겨라 submit을 누르면.	
		}
		
		})
		
		//다중파일업로드 처리
		//file속성의 input을 선택.
	$("input[type='file']").change(function(e){//change이벤트로 input의 file대신 new ForData로 파일창을 띄움.
		var formData= new FormData();
		//name속성의 input을 선택.
		var inputFile= $("input[name='uploadFile']");
		var files=inputFile[0].files;//올린 파일의 정보를 files에 담음.
		for(var i=0; i<files.length;i++){
			formData.append("uploadFile",files[i]);//form에 append한 데이터를 전송함.
		}
		
		
		$.ajax({//json형태의 form데이터를 가지고,url로 가서 동작함. 
			url:"/upload/uploadFormAction",
			data:formData,
			datatype:"json",
			//processData와 contentType은 파일업로드시 false가 되어야함.
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				alert("업로드됨");
				console.log(data);
				showUploadResult(data);
			},
			error:function(){
				window.location.href="localhost:8080/main/Board"
			}
		})
	})	
	function showUploadResult(uploadResultArr){
		if(!uploadResultArr || uploadResultArr.length==0){
			return;
		}
		var uploadUL=$(".uploadResult ul");
		var str="";
		$(uploadResultArr).each(function(i,obj){
			console.log("obj.uploadPath="+obj.uploadPath)
			console.log("obj.uuid="+obj.uuid);
			console.log("obj.fileName="+obj.fileName);
			var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
			str+="<li data-path='"+obj.uploadPath+"'";
			str+="data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"'"
			str+="><div>";
			str+="<span>"+obj.fileName+"</span>";
			str+="<img src='/upload/display?fileName="+fileCallPath+"'>";
			str+="</div></li>";
		})
		uploadUL.append(str);
		
	}
	
	
	

	
	
})