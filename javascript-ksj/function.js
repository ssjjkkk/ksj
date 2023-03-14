// 함수의 기본형
// 함수의 선언
const func1 = function() {
    console.log("Hello");
};

// 함수의 호출, 함수는 반드시 호출이 되어야 내부의 코드가 실행됨.
func1();

const func2 = function(x) {
    // 함수선언문의 ()안의 값을 매개변수(Parameter)라고 한다.
    x = x * 2;
    return x;
};

let value2 = 2;
// 함수 호출 시 함수의 ()안에 넣어주는 값을 인수(Argument)라고 한다.
value2 = func2(value2);
console.log(value2);

let value3 = 3;
// value3 = func2(value3);  (value3)가 인수(Argument)
console.log(value3);


// 함수 선언
const greet = function (userName) {
    console.log("Hello" + userName);
};

// 함수 호출
greet("석준");

const multiply = function(x, y) {
    return x * y;
};

const value4 = multiply(4, 5);
console.log(value4);

// 플러스 함수
const plus = function(x, y) {
    return x + y;
};
console.log(plus(2, 8));

const greet2 = function (userName) {
    let returnValue = "Hello" + userName;
    return returnValue;
};

const greet2Return = greet2("석준");
console.log(greet2Return);

// 3개 이상의 매개변수(parameter)
const average = function(w, x, y, z) {
    const sum = w + x + y + z;
    return sum / 4;
};

const sum22 = average(1, 2, 4, 5);
console.log(sum22);
console.log(average(1, 2, 4, 5));


const ave2 = function(x){
    let sum = 0;
    for (let i = 0; i<x.length; i++){
        sum = sum + x[i];
    };
    return sum / x.length; // 총합 / 렝스 = 평균
};

const array = [1, 2, 3, 4];
console.log(ave2(array));
console.log(ave2([1, 2, 3, 4]));

const ave3 = function(y){
    let sum1 = 0;
    y.forEach(function(i){sum1 = sum1 + i;});
    return sum1 / y.length;
};

const array1 = [1, 5, 4, 2];
console.log(ave3(array1));

let sum2 = 0;
array1.forEach(function(i){sum2 = sum2 + i;})
console.log(sum2)

// 함수선언의 다른 방법
function display() {
    console.log("display");
};
display();

const greet3 = function (userName) {
    let returnValue = "Hello" + userName;
    return returnValue;
};

const userName = prompt("이름을 적어주세요 : ");
const greet3Return = greet3(userName);
console.log(greet3Return);