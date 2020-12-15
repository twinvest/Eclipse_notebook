/**
 * 
 * deepEqual : 두 객체의 맴버가 동일하지 않을 경우 오류가 발생한다. 값의 타입은 무시한다.
 * deepStrictEqual : 두 객체의 맴버가 동일하지 않을 경우 오류가 발생한다. 값의 타입도 검사한다.
 * notDeepEqual : 두 객체의 맴버가 동일할 경우 오류가 발생한다. 값의 타입은 무시한다.
 * notDeepStrictEqual : 두 객체의 맴버가 동일할 경우 오류가 발생한다. 값의 타입도 검사한다.
 */

var assert = require('assert'); //객체생성

//객체1
var obj1 = {
	a1 : 10,
	a2 : 20
};

//객체2
var obj2 = {
	a1 : 10,
	a2 : 20
};

//객체3
var obj3 = {
	a1 : 10,
	a2 : 30
};

//객체4
var obj4 = {
	a1 : 10,
	a2 : '20'
};

assert.deepEqual(obj1, obj2);
console.log("obj1과 obj2는 같습니다.");

/*
assert.deepEqual(obj1, obj3); //오류발생!
console.log("obj1과 obj3는 같습니다.");
*/

assert.deepEqual(obj1, obj4);
console.log("obj1과 obj4는 같습니다.");

/*
assert.deepStrictEqual(obj1, obj4); //오류발생!! 타입도 검사하니까
console.log("obj1과 obj4는 같습니다.");
*/

/*
assert.notDeepEqual(obj1, obj2); //같기때문에 오류발생.
console.log("obj1과 obj2는 다릅니다.");
*/

assert.notDeepEqual(obj1, obj3);
console.log("obj1과 obj3는 다릅니다.");

/*
assert.notDeepEqual(obj1, obj4);//오류발생.
console.log("obj1과 obj4는 다릅니다.");
*/

assert.notDeepStrictEqual(obj1, obj4);
console.log("obj1과 obj4는 다릅니다.");
