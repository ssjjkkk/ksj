const debtn = document.querySelector(".decrease");
const rebtn = document.querySelector(".reset");
const inbtn = document.querySelector(".increase");

const callback = function (e) {
    const spanValue = document.querySelector("#value");
    let counter = parseInt(spanValue.innerHTML, 10);
    if (e.target.innerHTML === "decrease") {
        counter = counter - 1;
        spanValue.innerHTML = counter;
    } else if (e.target.innerHTML === "reset") {
        spanValue.innerHTML = 0;
    } else {        
        counter = counter + 1;
        spanValue.innerHTML = counter;
    } ;

    if (parseInt(spanValue.innerHTML, 10) < 0) {
        spanValue.style.color = "red";
    } else if (parseInt(spanValue.innerHTML, 10) > 0) {
        spanValue.style.color = "blue";
    } else {spanValue.style.color = "#102A42"};
};

debtn.addEventListener("click", callback);
rebtn.addEventListener("click", callback);
inbtn.addEventListener("click", callback);

// @@.@@.contains(x) x라는 클래스가 있으면 true.