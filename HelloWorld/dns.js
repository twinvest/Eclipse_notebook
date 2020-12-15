var dns = require("dns");

//dns서버로부터 정보가 날라오면 function함수가 호출됨
//두번째 매개변수인 address가 ip주소, 세번째 매개변수인 family가 ip버전(4인지 6인지)
//오류가 발생하면 첫번째 매개변수 err에 에러정보가 담긴다
dns.lookup("naver.com", function(err, address, family){
	console.log("IP주소 :", address);
	console.log("IP버전 :", family);
});
//출력된 ip주소를 부라우저에 복붙하면 실제로 naver나옴~


var op1 = {
	family : 4
};
dns.lookup("naver.com", op1, function(err, address, family){
	console.log("IP주소 v4:", address);
});

var op2 = {
	family : 6
};
dns.lookup("naver.com", op2, function(err, address, family){
	console.log("IP주소 v6:", address);
});