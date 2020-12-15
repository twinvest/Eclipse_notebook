/*
 * Assert : 주어진 변수가 수식의 값이 0이거나 false인 경우 오류가 발생한다.
 */

var assert = require('assert'); //객체생성

var v1 = 10;
var v2 = 10;
var v3 = 20;

assert(v1 < v3); //참이기 때문에 프로그램이 중지되지 않고 쭉 실행됨.
console.log("v1은 v3보다 작습니다.");

assert(v1 == v3); 
console.log("v1은 v3은 같습니다."); //v1과 v3이 같지 않기 때문에 이 문장은 실행되지 않는다. 즉, 오류발생함.

assert(v1 == v2); 
console.log("v1은 v2은 같습니다.");

assert(v1 - v2); // 0이기때문에 오류발생.
console.log("v1 - v2는 0이 아닙니다."); //따라서 실행안됨.