const stars = document.querySelectorAll(".fa-solid");
// const star0 = document.querySelector("#0");
// const star1 = document.querySelector("#1");
// const star2 = document.querySelector("#2");
// const star3 = document.querySelector("#3");
// const star4 = document.querySelector("#4");



for (let i = 0; i < stars.length; i++) {
    stars[i].addEventListener("click", (e) => {
        for (let x = 0; x < stars.length; x++) {
            if (x <= i) {
                stars[x].classList.add("active")
            } else {
                stars[x].classList.remove("active")
            }
        }
    })
};

