
function btn_click(str){

 //str이 update이면 수정 action
 if(str=="update"){
 	 //board/uboard
 	 mupdate.action="/member/memberUpdate";
 	 mupdate.method="get";
 }else{
 //str이 delete이면 삭제 action
	//board/Delete
	mupdate.action="/member/gomemberDelete";
	mupdate.method="post";
}
}	
