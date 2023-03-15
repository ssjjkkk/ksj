// 여러 종류의 변수 선언
const num = 1; // 숫자
const str = "Smith"; // 문자
const bool = true; // 불린 (참, 거짓)
const 숫자배열 = [1, 2, 3, 4]; // 배열
const 문자배열 = ["a", "b", "c"];
const 함수 = function() {};
const 객체 = {user : "smith", age : 20};
const html요소1 = document.querySelector("#demo");
const html요소2 = document.querySelector(".style");
const html요소3 = document.querySelector("div");

let num2 = num * 10; // num2 = 10
let str2 = str + "ㅂㅂ"; // str2 = "Smithㅂㅂ"
let bool2 = !bool; // bool2 = false
let 숫자배열2 = 숫자배열.slice(3); // 숫자배열2 = [4] <-- 원본 숫자배열은 그대로.
let 문자배열2 = 문자배열.splice(1, 2); // 문자배열 = [a] 문자배열2 = [b, c]
html요소1.innerHTML = "DEMO";
html요소2.innerHTML = "STYLE";
html요소3.innerHTML = "TEXT";

const num함수 = function(x) {
    return x * 10;
};
let num3 = num함수(num); // num = 10

const str함수 = function(str) {
    return str + "바보";
};
let str3 = str함수(str); // str3 = Smith바보

const bool함수 = function(bool) {
    return !bool;
};
let bool3 = bool함수(bool); // bool3 = false

const 숫자배열함수 = function(숫자배열, i) {
    return 숫자배열.slice(i);
};
let 숫자배열3 = 숫자배열함수(숫자배열, 3); // 숫자배열3 = [4]

const 문자배열함수 = function (문자배열, x, y) {
    return 문자배열.splice(x, y);
};
let 문자배열3 = 문자배열함수(문자배열, 1, 2); // 문자배열3 = ["b", "c"]

const text배열 = ["Text", "Demo", "Style"];
const divList = document.querySelectorAll("div");
const html함수 = function(divList, text배열) {
    for (let i = 0; i<divList.length; i++){
        divList[i].innerHTML = text배열[i];
    }
};

html함수(divList, text배열);

