/**
 * 
 */

$(document).ready(function(){
	/* ul을 사용했더니 div를 넘어가서 불편함 폐기.	
      $('#linkHole').innerfade({
        animationtype: 'fade',
        speed: 1000,
        timeout: 3000,
        type: 'sequence',
        containerheight: '350px'

        });
*/
var fadeImg =function(){
	//fadeIn 효과에 function 부분에 fadeOut을 주고
	//fadeOut 효과에는 만들고 있는 fadeImg(함수)를 주어서 재귀함수로 만든다.
	 $('#linkImg1').fadeOut(2000,"easeInElastic", function(){
			$('#linkImg1').fadeIn(2000,"easeInElastic",fadeImg())  
				
})
}
fadeImg()


$("#startMole").on('click',function(){
	window.open("http://localhost:8080/game/MoleMain",'두더쥐잡기','width:100%,height:100%');
	
})


});

