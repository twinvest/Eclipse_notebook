/**
 * equal : 주어진 두 변수나 수식의 결과 값이 다를 경우 오류가 발생한다. 값의 타입은 무시한다.
 * strictEqual : 주어진 두 변수나 수식의 결과 값이 다를 경우 오류가 발생한다. 값의 타입도 검사한다.
 * notEqual : 주어진 두 변수나 수식의 결과 값이 같을 경우 오류가 발생한다. 값의 타입은 무시한다.
 * notStrictEqual : 주어진 두 변수나 수식의 결과 값이 같을 경우 오류가 발생한다. 값의 타입도 검사한다.
 */

var assert = require('assert'); //객체생성

var v1 = 10;
var v2 = 10;
var v3 = 20;
var v4 = '10';

assert.equal(v1, v2);
console.log("v1과 v2는 같습니다.");

/*
assert.equal(v1, v3); //오류발생. 같지않기 때문에.
console.log("v1과 v3는 같습니다.");
*/

assert.equal(v1, v4); //타입을 검사하지 않기때문에 오류가 발생하지 않는다.
console.log("v1과 v4는 같습니다.");

/*
assert.strictEqual(v1, v4) //오류발생. 타입검사도 하기때문에!
console.log("v1과 v4는 같습니다.");
*/

/*
assert.notEqual(v1, v2); //값이 같으면 오류가 발생.
console.log("v1과 v2는 다릅니다.");
*/

assert.notEqual(v1, v3); //값이 다르니 밑에 문장이 실행됨.
console.log("v1과 v3는 다릅니다.");

/*
assert.notEqual(v1, v4); //값이 같으면 오류가 발생.
console.log("v1과 v4는 다릅니다."); //타입검사안하니까 오류발생.
*/

assert.notStrictEqual(v1, v4); 
console.log("v1과 v4는 다릅니다.");