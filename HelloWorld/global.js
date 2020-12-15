console.log("__dirname", __dirname);
console.log("__filename", __filename);
/*
console.log("node.js코드입니다.");
//작업이 완료된 후에 실행됨.
setImmediate(function(){
	console.log("Immdediate 동작1");
});

console.log("node.js코드입니다.");
//작업이 완료된 후에 실행됨.
var a1 = setImmediate(function(){
	console.log("Immdediate 동작2");
});

console.log("node.js코드입니다.");
//Immediate취소
clearImmediate(a1);
*/
/*
var a1 = 0;
//setInterval : 주어진 함수를 주어진 시간마다 계속호출
var a2 = setInterval(function(){
	console.log("interval 동작")
	a1++;
	console.log("a1 :", a1);
	//clearInterval : 등록된 Interval을 제거한다.
	if(a1 >= 5)
		clearInterval(a2);
}, 1000);
*/

//setTimeout : 주어진 함수를 주어진 시간 후에 한번 호출한다.
var a1 = setTimeout(function(){
	console.log("timeout 동작")
}, 1000);

//clearTimeout : 등록된 Timeout을 제거한다.
clearTimeout(a1);

console.log("작업이 모두 완료되었습니다.");


//console : 화면출력을 위한 객체이다.
//exports : 개발자가 모듈을 만들때 사용하는 객체이다.
//require : 모듈 객체를 만드는 함수이다.