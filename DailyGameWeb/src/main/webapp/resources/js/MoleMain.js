$(document).ready(function(){
	
	
	
	$(".attecked").hide();
	$(".mole").hide();
	
	var image_arr = ["mole","molebad","attecked"];
				var index=0;
	setInterval(function(){
						if(index>=image_arr.length){index=0}
						$("#show").fadeIn(500)
						$("#mole3").attr("src","/resources/images/"+image_arr[index]+".png")
						index++	
	},1000)
				
		var id=$("#id").val();
		var name=$("#name") .val();
		var score=Number($("#NowS").text())				
		//기존 내점수 가져오기
		$.ajax({
		//method방식.get(select),post(insert),put(update),delete(delete)
		type:"POST",
		//form의 action과같은 url주소
		//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
		url:"/game/msCheck",
		//name으로 주는 form태그 안의 값들.
		data:JSON.stringify({id:id,name:name,mscore:score}),
		//controller에 받을 데이터 타입. return?? 문자코드/방식.
		contentType:"application/json;charset=utf-8",
		//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
		success:function(date){
		
			
								},
		//전송이 실패 했을 때 할 동작(명령).
		error:function(){
					
						}	
		})
		//랭킹 1위값.
		$.ajax({
		//method방식.get(select),post(insert),put(update),delete(delete)
		type:"POST",
		//form의 action과같은 url주소
		//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
		url:"/game/getBscore",
		//name으로 주는 form태그 안의 값들.
		data:JSON.stringify({id:id,name:name,mscore:score}),
		//controller에 받을 데이터 타입. return?? 문자코드/방식.
		contentType:"application/json;charset=utf-8",
		//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
		success:function(date){
		
				$("#Rank1Name").text(date.name)
				$("#Rank1Score").text(date.mscore)
				var color_arr = ["red","orange","yellow","green","blue","navy","purple"];
				var index=0;
				setInterval(function(){
						if(index>=color_arr.length){index=0}
						
						$("#Rank1").css("color",color_arr[index])
						index++
				},50)


//출처: https://iruplace.tistory.com/192 [iruplace]
								},
		//전송이 실패 했을 때 할 동작(명령).
		error:function(){
					
						}	
		})
		
		
		
$("#startbtn").one("click",function(){
	start();
})
})
	var Tpoint=0;
	var point=0;
	
	
	
function start(){

	var pop = 0;
			
	var start=function(num){
	
		var rn1=Math.random();
		pop = Math.floor(rn1*3)
		if(pop<2){
				setTimeout(3000)
		}else if(pop==2){
		//index 구하기
		//var index = $("li").index(this);
	//	var idx = $item.index(this)
//[출처] [jQuery] 클릭(선택)한 요소의 index 찾기|작성자 chris
					$("#mole"+num).fadeIn(200)
					
					setTimeout(function(){
						$("#mole"+num).fadeOut(100)}
					,1000)//클릭 안된 두더지 동작 끝
						
					$("#mole"+num).one("click",function(){
						$("#mole"+num).fadeOut(100,function(){
							$("#attecked"+num).fadeIn(100,function(){
									setTimeout(function(){
										$("#attecked"+num).fadeOut(100)
									},700)//맞은 두더지지속시간 끝
							})//맞은 두더지 나타나고 시작되는 동작 끝
						})//일반두더지 맞으며 사라지는 동작끝 
				
					})//1회용 클릭 동작 끝
					}
			}
			var m1=setInterval(start,3000,1)
			var m2=setInterval(start,3000,2)
			var m3=setInterval(start,3000,3)
			var m4=setInterval(start,3000,4)
			var m5=setInterval(start,3000,5)
			var m6=setInterval(start,3000,6)
			var m7=setInterval(start,3000,7)
			var m8=setInterval(start,3000,8)
			var m9=setInterval(start,3000,9)
			var m10=setInterval(start,3000,10)
			var m11=setInterval(start,3000,11)
			var m12=setInterval(start,3000,12)

setTimeout(function(){
					
				clearInterval(m1);
				clearInterval(m2);
				clearInterval(m3);
				clearInterval(m4);
				clearInterval(m5);
				clearInterval(m5);
				clearInterval(m6);
				clearInterval(m7);
				clearInterval(m8);
				clearInterval(m9);
				clearInterval(m10);
				clearInterval(m11);
				clearInterval(m12);
				alert("GameOver!\n"+Tpoint)
				
					var id=$("#id").val();
			
				if(id){//문자열이 공백이면 false취급이다. 로그인 확인.
					getScore(id);
					location.reload();
				}else{
					alert("로그인 하시면 기록이 추가 됩니다!")
				}
				
},30000)

}			
				

					
function getPoint(){
					point +=10;
					Tpoint=point;
					$("#NowS").text(point)	
}

function getScore(id){
			var name=$("#name") .val();
			var score=Number($("#NowS").text())	
				
				
			$.ajax({//score존재 확인
			//method방식.get(select),post(insert),put(update),delete(delete)
			type:"post",
			//form의 action과같은 url주소
			//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
			url:"/game/msCheck",
			//name으로 주는 form태그 안의 값들.
			data:JSON.stringify({id:id,name:name,mscore:score}),
			//controller에 받을 데이터 타입. return?? 문자코드/방식.
			contentType:"application/json;charset=utf-8",
			//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
			success:function(data){
				var Ascore=data.mscore;
				var Nscore=score;
				if(Nscore>Ascore){
					alert("기록갱신")
					$.ajax({
					//method방식.get(select),post(insert),put(update),delete(delete)
					type:"put",
					//form의 action과같은 url주소
					//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
					url:"/game/UpdateRecord",
					//name으로 주는 form태그 안의 값들.
					data:JSON.stringify({id:id,name:name,mscore:score}),
					//controller에 받을 데이터 타입. return?? 문자코드/방식.
					contentType:"application/json;charset=utf-8",
					//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
					success:function(){
						//if(result=="success"){
						alert("기록 갱신을!\n 축하합니다!")
						location.reload();
					}/*}*/,
					//전송이 실패 했을 때 할 동작(명령).
					error:function(){
						alert("기록갱신 오류!")
							}
					})
				}
							
			},
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
					$.ajax({
					//method방식.get(select),post(insert),put(update),delete(delete)
					type:"post",
					//form의 action과같은 url주소
					//method방식으로 구분이 가능하므로 동일한 url주소를 주어도 된다.
					url:"/game/newRecord",
					//name으로 주는 form태그 안의 값들.
					data:JSON.stringify({id:id,name:name,mscore:score}),
					//controller에 받을 데이터 타입. return?? 문자코드/방식.
					contentType:"application/json;charset=utf-8",
					//server전송이 완료된후 어떻게 하겠다(명령).(전송성공)
					success:function(){
						//if(result=="success"){
						alert("기록을 추가합니다!")
						
					}/*}*/,
					//전송이 실패 했을 때 할 동작(명령).
					error:function(){
						alert("기록갱신 추가실패!")
							}
					})
		
			}	
		})

				
			
}


