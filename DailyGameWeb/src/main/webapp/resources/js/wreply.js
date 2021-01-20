/**
 * 
 */
$(document).ready(function(){
	
	var bno=$("#bno").val();
//w이미지 불러오기--------------------------------------------------------------
	wgetimg();
	
	function wgetimg(){
		$.getJSON("/wboard/"+bno+".json",//url주소.
			function(data){
			showUploadResult(data)
				
			})};			
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
//END w이미지 불러오기--------------------------------------------------------------	

	
	
	
getList();
var bno=$("#bno").val();
	var str=""
	//댓글 쓰기.
	//버튼 클릭하면 댓글쓰기.
	$("#replyAdd").on("click",function(){
		
		var reply=$("#reply").val();
		var name=$("#name").val();
	
		//ajax
		$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"post",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/wreplies/new",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({bno:bno,reply:reply,name:name}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			
				//if(result=="success"){
				alert("댓글을 작성했습니다.")
				location.reload();
			}/*}*/,
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
				alert("댓글 작성에 실패했습니다.")	
			}	
		})//댓글쓰기 ajax end
		
		//댓글 목록(함수 getList) 방식만 가능한 표현		
	})//댓글 쓰기 버튼 end	
	
	function getList(){
		var lname=$("#Lname").val();
		$.getJSON("/wreplies/"+bno+".json",//url주소.
			function(data){//전송이 성공적인 경우 //mvc에서 받아나온 Data를 이용한 function
				console.log(data)
				$(data).each(function(){
				
					str+="<li><div style='display:flex;'>"+
					"<div id='rname'>"+this.name +"</div>&nbsp;<div id='rdate'> "+ this.replydate+"</div></div>"+
					"<p id='rcontent'>"+this.reply+"</p>"+
					"<input type='hidden' id='"+this.rno+"' value='"+this.rno+"'>"
				
					if(lname==this.name){
					str+="<div id='rud'>"+"<button id='popup"+this.rno+"' value='"+this.rno+"'>수정</button>"+
					" <button id='delete"+this.rno+"' value='"+this.rno+"'>삭제</button>"+
					"</div></li>"+
					"<div  id='updiv"+this.rno+"' style='display:none'>"+
					"<textarea id='ureply"+this.rno+"' rows='3' cols='20'>"+this.reply+"</textarea>"+
					"&nbsp<button id='update"+this.rno+"'value='"+this.rno+"'>댓글수정</button></div> "
					}
					
			
					
		$(document).on("click","#popup"+this.rno,function(){
				var rno=$(this).attr("value");
				$("#updiv"+rno).css("display","flex").css('justify-content','flex-end')
				$("#update"+rno).css({'height':'48px',width:'48px'})
		
		})//수정창 팝업		
					
			//delete		
		$(document).on("click","#delete"+this.rno,function(){
				var drno=$(this).attr('value')//button태그의 value가져오는법.
			$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"delete",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/wreplies/new",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({rno:drno}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			
				//if(result=="success"){
			alert("댓글이 삭제되었습니다")
				location.reload();
			}/*}*/,
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
					alert("댓글을 삭제하는데 실패했습니다.")	
			}	
		})//댓글삭제 ajax end
		
	})//댓글 삭제 버튼 end


	//update
	$(document).on("click","#update"+this.rno,function(){
			var urno=$(this).attr('value')//button태그의 value가져오는법.		
			var ureply=$("#ureply"+urno).val();	

			$.ajax({
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"put",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/wreplies/new",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({rno:urno,reply:ureply}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(){
			
				//if(result=="success"){
				alert("댓글 수정 성공")
				location.reload();
			}/*}*/,
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
				alert("댓글 수정 실패")	
			}	
		})//댓글수정 ajax end
		
	})//댓글수정 버튼액션 end
	
	
	
							})//each반복 끝
					$("#replies").html(str)
			})//$.getJSON 끝	
	}//getList 끝
	
	
})
function Wlist(){
		window.parent.window.location.href="http://localhost:8080/main/Wboard";
	};