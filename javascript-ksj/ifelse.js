let hour = 18;
let greeting = '';

if (hour < 12) {
   greeting = "Good morning";
} else if (hour < 18) {
   greeting = "Good Day"
} else {
   greeting = "Good evening"
}
console.log(greeting);

// == 같으면
// != 다르면
// !== 데이터 타입까지 다르면
// >크면
// <작으면
// >=크거나 같으면
// <= 작거나 같으면

let login = true;
if (login == true) {
   alert('Welcome~ user!!');
} else {
   alert("please login..");
}

// === 데이터 타입까지 같으면

const str = "1";
const num = 1;
if (str === num) {
   console.log("같다");
} else {
   console.log("다르다");
}

// 논리연산자 &&, ||, !
// && and
const x = 6;
const y = 3;
if (x > 5 && y <5) {
   alert ("window popup");
}

// || or
if (x > 7 || y < 5) {
   alert ("window popup!");
}

// ! not
const isLoginUser = false;
if (!isLoginUser) {
   alert ("Please Log in");
} else {
   alert ("Welcome");
}

// 삼항연산자
const age = 20;
let votable = age <18 ? "Too young" : "Old enough";
console.log(age <18 ? "Too young" : "Old enough");