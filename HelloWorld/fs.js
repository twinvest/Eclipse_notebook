var fs = require("fs");
/*
fs.writeFile("data1.txt", "Hello node.js", function(error){
	console.log("비동기식 저장1")
});

fs.writeFile("data2.txt", "Hello node.js", function(error){
	console.log("비동기식 저장2")
});
*/

/*
fs.appendFile("data1.txt", "안녕하세요", function(error){
	console.log("비동기식 추가1");
});

fs.appendFile("data2.txt", "반갑습니다", function(error){
	console.log("비동기식 추가2");
});

//비동기식으로 읽는 거여서 뭐가 먼저 읽힐지 모름!
fs.readFile("data1.txt", function(error, data){
	console.log("data1 :",data.toString());
});

fs.readFile("data2.txt", function(error, data){
	console.log("data2 :",data.toString());
});
*/

//동기식이라 콜백함수 쓸 필요없음.
/*
fs.writeFileSync("data3.txt", "Hello node.js");
console.log("동기식저장1");

fs.writeFileSync("data4.txt", "Hello node.js");
console.log("동기식저장2");
*/

fs.appendFileSync("data3.txt", "안녕하세요");
console.log("파일내용추가 1");

fs.appendFileSync("data4.txt", "반갑습니다.");
console.log("파일내용추가 2");

var data3 = fs.readFileSync("data3.txt");
console.log("data3 :", data3.toString());

var data4 = fs.readFileSync("data4.txt");
console.log("data4 :", data4.toString());