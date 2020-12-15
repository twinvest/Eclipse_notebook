var crypto = require('crypto');

//getCiphers : 지원하는 암호화 알고리즘 이름들을 반환한다.
var ciphers = crypto.getCiphers();
for(var x of ciphers)
{
	console.log(x);
}

//createCiphers : 암호화용 객체를 생성한다.
//createDecipher : 복호화용 객체를 생성한다.
//update : 데이터를 암호화 하거나 복호화한다.
//final : 암호화된 데이터에 마지막 종료 블럭을 추가한다.

//암호화
var key = "test key";
var data = "암호화 할 데이터";

var ciphers = crypto.createCipher("aes-256-cbc", key);
var result = ciphers.update(data, "utf8", "base64");
result += ciphers.final("base64");
console.log("암호화 문자열 :", result);

//복호화
var decipher = crypto.createDecipher("aes-256-cbc", key);
var result2 = decipher.update(result, "base64", "utf8");
result2 += decipher.final("utf8");
console.log("복호화 문자열 :", result2);