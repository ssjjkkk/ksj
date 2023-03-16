const navbar = document.getElementById("navbar");
const content = document.querySelector(".content");
const offset = navbar.offsetTop;

const func1 = function (e) {
    console.log(window.scrollY, offset);
    if (window.scrollY >= offset) {
        navbar.classList.add("sticky");
        // content.style.marginTop = `${navbar.offsetHeight}px`;
        // ` 백틱
        content.classList.add("topSpace");
    } else {
        navbar.classList.remove("sticky");
        // content.style.marginTop = 0;
        content.classList.remove("topSpace");
    };
};


window.addEventListener("scroll", func1);

