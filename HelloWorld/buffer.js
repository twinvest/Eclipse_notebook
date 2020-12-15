//alloc : 지정된 바이트만큼 기억공간이 만들어지고 0으로 초기화 된다.
var buf1 = Buffer.alloc(10);
console.log(buf1);

//allocUnsafe : 지정된 바이트만큼 기억공간이 만들어지고 0으로 초기화 되지 않는다. alloc에 비해 속도가 빠르다.
var buf2 = Buffer.allocUnsafe(10);
console.log(buf2);

//byteLength : 버퍼의 용량(바이트)을 반환한다.
var size1 = Buffer.byteLength(buf1);
console.log("size1 :",size1);

//length : 버퍼의 용량(바이트)을 반환한다. byteLength와 똑같음.
console.log("bytes :", buf1.length);

//from : 지정된 값을 관리하는 기억공간이 만들어진다.
var buf3 = Buffer.from('abcd');
var buf4 = Buffer.from('안녕하세요');
console.log(buf3);
console.log(buf4);

//compare : 두 기억공간을 비교한다.(같으면 0, 첫번째 버퍼가 값이 크면 1 작으면 -1을 반환한다.)
var buf5 = Buffer.from('cccc');
var buf6 = Buffer.from('cccc');
var buf7 = Buffer.from('aaaa');
var buf8 = Buffer.from('dddd');

var v1 = Buffer.compare(buf5, buf6);
console.log("v1 :", v1);

var v2 = Buffer.compare(buf5, buf7);
console.log("v2 :", v2);

var v3 = Buffer.compare(buf5, buf8);
console.log("v3 :", v3);

//concat : 배열안에 있는 모든 버퍼를 하나로 합쳐 새로운 버퍼를 만든다.
var array1 = [buf5, buf6, buf7, buf8]; //자바스크립트 배열
var buf9 = Buffer.concat(array1);
console.log(buf9);

//copy : 버퍼의 내용을 다른 버퍼에 복사한다.
var buf10 = Buffer.from('123456789');
var buf11 = Buffer.alloc(10);
buf10.copy(buf11, 0, 2, 5);
console.log(buf10);

//entries : 버퍼의 내용을 [인덱스, 값] 형태의 객체로 만들어 가지고 있는 배열을 반환한다.
var array2 = buf5.entries();
for(var str of array2)
{
	console.log(str);
}

//equals : 두 버퍼의 내용이 같은지 비교한다.
var buf11 = Buffer.from('abcd');
var buf12 = Buffer.from('abcd');
var buf13 = Buffer.from('zzzz');

var v4 = buf11.equals(buf12);
console.log("v4 :", v4);

var v5 = buf11.equals(buf13);
console.log("v5 :", v5);

//fill : 버퍼에 지정된 값을 채워준다.
var buf14 = Buffer.from('aaaaa');
console.log(buf14);

buf14.fill('c');
console.log(buf14);

buf14.fill('abc');
console.log(buf14); //abcab가 들어감.

//includes : 버퍼에 지정된 값이 있는지 확인한다.
var buf15 = Buffer.from("Hello Node.js Node.js");
var v6 = buf15.includes("Node");
console.log("v6 :", v6);

var v7 = buf15.includes("Java");
console.log("v7 :", v7);

//indexOf : 버퍼에 지정된 값의 위치를 반환한다.(값이 없으면 -1을 반환한다.)
var v8 = buf15.indexOf("Node");
console.log("v8 :", v8);

var v9 = buf15.indexOf("Java");
console.log("v9 :", v9);
//lastIndexOf : 버퍼에 지정된 값의 위치를 뒤에서 부터 검사하여 반환한다.(값이 없으면 -1을 반환한다.)
var v10 = buf15.lastIndexOf("Node");
console.log("v10 :", v10);

//isBuffer : 지정된 객체가 버퍼 객체인지 확인한다.
var v11 = Buffer.isBuffer(buf15);
console.log("v11 :", v11);

var obj1 = {
		a1 : 10
};
var v12 = Buffer.isBuffer(obj1);
console.log("v12 :", v12);

//keys : 버퍼에 저장된 객체의 인덱스를 가져온다.
var array3 = buf15.keys();
for(var i of array3){
	console.log(i);
}

//toString : 버퍼에 저장된 값을 문자열로 가져온다.
var v13 = buf15.toString();
console.log("v13 :", v13)