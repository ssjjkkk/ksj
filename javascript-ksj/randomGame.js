const guessed = document.querySelector("#guessed");
const btn = document.querySelector("button");
const div = document.querySelector("div");
const pTag = document.createElement("p");

// const enter = function (e) {
//     if (e.code === "Enter"){
//         guessed.value
//         if (Math.floor(Math.random()*10 + 1) == guessed.value) {
//             div.innerHTML = "You Win"
//         }else {
//             div.innerHTML = "X";
//         };
//     };
// };
// guessed.addEventListener("keydown", enter);

// const verify = function () {
//     guessed.value;
//     const random = Math.floor(Math.random() * (11 - 1)) + 1;
//     if (isNaN(guessed.value)){
//         div.innerHTML = "1 ~ 10의 숫자를 넣어주세요.";
//         return;
//     };

//     if (guessed.value < 1 || guessed.value > 10 ) {
//         div.innerHTML = "1 ~ 10의 숫자를 넣어주세요.";
//     } else if (guessed.value === random) {
//         div.innerHTML = "You win.";
//     } else {
//         div.innerHTML = `${input} != ${random} : You lose. Please retry.`;
//     };
// };


// pTag.innerHTML = 
// div.appendChild(pTag);

//  if (isNaN(input)){
//     div.innerHTML = 1 ~ 10의 숫자를 넣어주세요.;
// } else if (input === 0, input > 10 ) {
//     div.innerHTML = 1 ~ 10의 숫자를 넣어주세요.;
// } else if (input === random) {
//     div.innerHTML = "You win.";
// } else {
//     div.innerHTML = `${input} != ${random} : You lose. Please retry.`;
// };

function verify() {
    let input = document.querySelector("#guessed").value;
    input = parseInt(input, 10);
    const random = Math.floor(Math.random() * (11 - 1)) + 1;
    
    // if (isNaN(input)){  // 문자열인지 아닌지 물어보는 함수. 답은 항상 참 또는 거짓.
    //     div.innerHTML = "1 ~ 10의 숫자를 넣어주세요.";
    //     return;
    // };  // 리턴 구문을 만나면 더 이상 프로세스를 진행하지 않고 나간다. 아래 코드는 실행하지 않는다.

    if (isNaN(input)){
        div.innerHTML = "1 ~ 10의 숫자를 넣어주세요.";
        return;
    }
    
    if (input < 1 || input > 10 ) {
        div.innerHTML = "1 ~ 10의 숫자를 넣어주세요.";
    } else if (input === random) {
        div.innerHTML = "You win.";
    } else {
        div.innerHTML = `${input} != ${random} : You lose. Please retry.`;
    };
};

// `백틱 안에 ${}로 연산 또는 변수를 적용가능.

// typeof input === "text"
// isNaN(input)
// NaN : Not a Number