// 이벤트 등록 1단계
const loginForm = document.querySelector("#loginForm")
const input = document.querySelector("#inp1")
const h1 = document.querySelector("#greeting")
// 이벤트 등록 2단계
const callback = function (e) {
    e.preventDefault();
    console.log("submit");
    localStorage.setItem("userName", input.value);
    const savedName = localStorage.getItem("userName");
    console.log(savedName);
    h1.innerHTML = savedName;
};


// 이벤트 등록 3단계
loginForm.addEventListener("submit", callback);


