/**
 * 
 */
//function goHome() {
//	location.href = "../burgerking/main.jsp";
//}
//function goIndex() {
//	location.href = "../index.jsp";
//}
//function goBurgerking() {
//	location.href = "../burgerking/main.jsp";
//}
//function goKakao() {
//	location.href = "../kakao/main.jsp";
//}
//function goLotto() {
//	location.href = "../lotto/main.jsp";
//}
//function goSktelecom() {
//	location.href = "../sktelecom/main.jsp";
//}
//function goBitcamp() {
//	location.href = "../bitcamp/main.jsp";
//}
//function clickMe() {
//	document.querySelector("#go_home").onclick=goHome;
//	document.querySelector("#go_index").onclick=goIndex;
//	document.querySelector("#go_burgerking").onclick=goBurgerking;
//	document.querySelector("#go_kakao").onclick=goKakao;
//	document.querySelector("#go_sktelecom").onclick=goSktelecom;
//	document.querySelector("#go_lotto").onclick=goLotto;
//	document.querySelector("#go_bitcamp").onclick=goBitcamp;
//}
window.onload = function() {
	var arr = ['burgerking', 'kakao', 'bitcamp', 'sktelecom', 'lotto'];
	for(var i = 0; i < arr.length; i++){
		document.querySelector('#'+arr[i]).addEventListener('click', function(e){ location.href="../" + this.id + "/main.jsp"}, false);
	}
}