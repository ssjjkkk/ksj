// 이벤트 등록 1단계
const loginForm = document.querySelector("#loginForm")
const input = document.querySelector("#inp1")
const input2 = document.querySelector("#inp2")
const h1 = document.querySelector("#greeting")
// 이벤트 등록 2단계
const callback = function (e) {
    e.preventDefault();
    localStorage.setItem("userName", input.value);
    const savedName = localStorage.getItem("userName");
    if (savedName !== null) {
        input.classList.add("hidden");
        input2.classList.add("hidden");
        h1.innerHTML = savedName + " Hello!";
    }else {
        input.classList.remove("hidden");
        input2.classList.remove("hidden");
    };
};

// 이벤트 등록 3단계
loginForm.addEventListener("submit", callback);

const savedName = localStorage.getItem("userName");

if (savedName !== null) {
    input.classList.add("hidden");
    input2.classList.add("hidden");
    h1.innerHTML = savedName + " Hello!";
}else {
    input.classList.remove("hidden");
    input2.classList.remove("hidden");
};
    