/**
 * 
 */

function goUrl(url){
	if(url=="Detail"){
		var id=$("#id").val();
		/*function open_in_frame(url) {
	$('#my_frame').attr('src', url); 'src'속성을 선택 url값을 넣는다.*/
	sessionStorage.setItem("InfoID",id);
	window.parent.window.location.href="http://localhost:8080/main/Member";
	}else if(url=="join"){
		window.location.href="http://localhost:8080/main/Member"
	}
	
}
//header메인
function main(){
	window.location.href="http://localhost:8080/main/Base";	
}
//header navi 자유게시판
function board(){
	window.location.href="http://localhost:8080/main/Board";	
}
//header navi 건의사항게시판
function wboard(){
	window.location.href="http://localhost:8080/main/Wboard";
}
//base페이지의 sboard에서 클릭시 바로 자유게시판--boardDetail로 이동
	function DfromM(dbno){ 
	var bno=dbno
	window.parent.window.location.href="http://localhost:8080/main/Board";
	sessionStorage.setItem("dbno",bno);
	
}
//더보기 클릭시 이동
function moreBoard(){
		window.parent.window.location.href="http://localhost:8080/main/Board";
	}
//로그인 창을 팝업으로 띄우기
function login(){
	
	/*var option="width=480,height=480,left=480,top=480, scrollbars=no,"
	이건 옵션만 따로 문자열 객체로 만들어 놓는 것일것.
		
		window.open("url","name","option") */
		window.name="main"
		window.open("http://localhost:8080/member/gomemberLogin","로그인페이지","width=480,height=480,left=-1280, top=240, scrollbars=no")
	}
//게임창가기
function game(){
	window.location.href="http://localhost:8080/main/Game";
}

// iframe 자동조절 펑션
function setIFrameHeight(obj){

    if(obj.contentDocument){
	setTimeout(function(){
        obj.height = obj.contentDocument.body.offsetHeight + 40;
		console.log(obj.height)
		},400)
    } else {
	/*scrollHeight : 스크롤바 높이를 뺀 내용 전체의 높이

	clientHeight : 스크롤바 높이를 뺀 가시적인 높이

	offsetHeight : 스크롤바 높이를 포함한 가시적인 높이 */
        obj.height = obj.contentWindow.document.body.scrollHeight;

    }

}

