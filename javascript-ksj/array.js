// Array 어레이, 배열
const cars = [
   "jeep", "volvo", "bmw"
];
// console.log(cars);
// console.log(cars.length);
// console.log(cars[0]);

// Array methods 배열의 메쏘드
// Push
cars.push("Hyundai");
// cars[3] = "Hyundai";
console.log(cars);

// Pop
cars.pop();
console.log(cars);

// Slice 잘라내기
const a = cars.slice(1);
console.log(a);
console.log(cars);

const b = cars.slice(0, 2);
console.log(b);
console.log(cars);

const c = cars.slice(0);
console.log(c);
console.log(cars);

// 배열의 복사
// const copy = cars;
const copy = cars.slice(0);
console. log(copy);
copy[0] = "hyundai";
console.log(copy);
// 문제점 등장 - 값 복사와 참조복사의 차이로 발생함
// Slice(0) 을 이용하여 강제로 값복사를 실행시키면 문제를 해결할 수 있다.
console.log(cars);

// Splice 삭제하기
const spliceValue = cars.splice(1,2);
console.log(spliceValue);
console.log(cars);

cars.splice(1, 0, "현대", "르노", "기아")
console.log(cars);

//map, filter, reduce 3대장 method는 나중에..

//상수로서의 배열 (배열 안에 item은 값을 바꿀 수 있다.)
const 과일들 = ['사과', '배', '귤', '복숭아'];
과일들[0] = '오렌지';
// 과일들 = ['Banana']; 에러발생, 상수 변경 시도
console.log(과일들);

