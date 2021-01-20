
function btn_click(str){

 //str이 update이면 수정 action
 if(str=="update"){
 	 //board/uboard
	
 	 boardUD.action="/board/boardUpdate";
 	 boardUD.method="get";
 }else{
 //str이 delete이면 삭제 action
	//board/Delete
	
	boardUD.action="/board/boardDelete";
	boardUD.method="get";
}
}	


function wbtn_click(str){

 //str이 update이면 수정 action
 if(str=="update"){
 	 //board/uboard
 	 boardUD.action="/wboard/boardUpdate";
 	 boardUD.method="get";
 }else{
 //str이 delete이면 삭제 action
	//board/Delete
	boardUD.action="/wboard/boardDelete";
	boardUD.method="get";
}
}	