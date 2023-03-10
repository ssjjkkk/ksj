// 변수를 공부해 보자.
// 변수를 선언하는 3가지 방법

// var
var value = 1;
value = 2;
value = 10;
value = 'smith';
value = 5;
value = value + 1;
var value = 1000;
console.log(value);

// let
let a = 1;
// let a = 2; <-2중 선언 에러
a = 2;
let counter = 1;
counter = counter + 1;
console.log(a);

// const
const b = 1;
//  const b = 2; <-2중 선언 에러
// b = 2; /* 상수는 값을 바꿀 수 없다 */
const url = "naver.com"
console.log(b);