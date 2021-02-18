$(document).ready(function(){
//두더지 mole div 생성-------------------
	var str="";
			for(var num=1;num<13;num++){
		$("#GameBoard").html(
			/*str로 추가하지 않으면 마지막 12번만 출력됨.*/
			str+="<div class='MoleHole'>"+
            "<div class='mole' id='mole"+num+"' onclick='getPoint()' >"+
		    "<img class='moleImg' id='moleImg"+num+"'src='/resources/images/mole.png'></div>"+
		
		    "<div class='attecked'id='attecked"+num+"'>"+
		    "<img class='atteckedImg' src='/resources/images/attecked.png'></div>"+
		"</div>")
	}// div 생성  끝-------------------------
		
	$(".attecked").hide();
	$(".mole").hide();
	
	
	//---------점수판 두더지 움직임-------------------
	var image_arr = ["mole","molebad","attecked"];
	var index=0;
	setInterval(function(){
						if(index>=image_arr.length){index=0}
						$("#show").fadeIn(500)
						$("#mole13").attr("src","/resources/images/"+image_arr[index]+".png")
						index++
						
	},1000)
	//---------점수판 두더지 움직임-------끝------------
	
	//---------기존 내점수 가져오기/guest는 없음---------
		var id=$("#id").val();
		var name=$("#name") .val();
		var score=Number($("#NowS").text())				
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
		success:function(data){
		
			
								},
		//전송이 실패 했을 때 할 동작(명령).
		error:function(){
					
						}	
		})
		//---------기존 내점수 가져오기/guest는 없음------끝---
		
		//---------랭킹 1위값.-----------------------
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
				var indexc=0;
				setInterval(function(){
						if(indexc>=color_arr.length){indexc=0}
						
						$("#Rank1").css("color",color_arr[indexc])
						indexc++
				},50)


//출처: https://iruplace.tistory.com/192 [iruplace]
								},
		//전송이 실패 했을 때 할 동작(명령).
		error:function(){
					
						}	
		})
		//---------랭킹 1위값.--------------끝---------
		
		
	$("#startbtn").one("click",function(){
		start();
	})

})//창 오픈 동시동작 끝-------------------------------

	var Tpoint=0;
	var point=0;
	
	
//-Start버튼 함수----------------------------------------	
function start(){

	var pop = 0;
			
	var move=function(num){
	
		var rn1=Math.random();
		pop = Math.floor(rn1*3)
		if(pop<2){
				setTimeout(3000)//두더지 안나옴 끝
		}else if(pop==2){
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
					})//두더지 맞으며 사라지는 동작끝 
				
				})//두더지 잡는 클릭 동작 끝
			}
	}
	

//--플레이 시작 두더지 움직임----------------------------------
	var moveString=''
	for(var i=1;i<13;i++){
		moveString+="var mo"+i+"=setInterval(move,3000,"+i+");"
	}
	eval(moveString)
	console.log(moveString)
//플레이 종료 -----------------------------------------------	
	setTimeout(function(){
			var clearMove=''	
			for(var j=1;j<13;j++){
			clearMove+="clearInterval(mo"+j+");"
					}
			console.log(clearMove)
			eval(clearMove)		
			alert("GameOver!\n"+Tpoint)
						
			var id=$("#id").val();		
			if(id){//문자열이 공백이면 false취급이다. 로그인 확인.
			  getScore(id);
			  location.reload();
			}else{
			  alert("로그인 하시면 기록이 추가 됩니다!")
			}
						
	},15000)
		
}
//---점수------------------------							
function getPoint(){
					point +=10;
					Tpoint=point;
					$("#NowS").text(point)	
}
//---점수 기록--------------------
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
				//원 점수와 비교 많을 때만 갱신.
				var Ascore=data.mscore;
				var Nscore=score;
				if(Nscore>Ascore){
					alert("기록갱신")
					$.ajax({
					type:"put",
					url:"/game/UpdateRecord",
					data:JSON.stringify({id:id,name:name,mscore:score}),
					contentType:"application/json;charset=utf-8",
					success:function(){
						alert("기록 갱신을!\n 축하합니다!")
						location.reload();
					},
					error:function(){
						alert("기록갱신 오류!")
							}
					})
				}
							
			},
			//전송이 실패 했을 때 할 동작(명령).
			error:function(){
					$.ajax({
					type:"post",
					url:"/game/newRecord",
					data:JSON.stringify({id:id,name:name,mscore:score}),
					contentType:"application/json;charset=utf-8",
					success:function(){
						alert("기록을 추가합니다!")	
					},
					error:function(){
						alert("기록갱신 추가실패!")
						}
					})
		
			}
		})

				
			
}


