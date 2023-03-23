let gallery = document.querySelector("#balloon-gallery");
const balloons = document.querySelectorAll(".balloon");
let message = document.querySelector("#yay-no-balloons");

// For Loop
let count = 0;
for (let i = 0; i < balloons.length; i++) {
  balloons[i].addEventListener("mouseenter", (e) => {
    balloons[i].style.backgroundColor = "#ededed";
    if(balloons[i].innerHTML !== "Pop!") {
      count++;
    };
    balloons[i].innerHTML = "Pop!"   
   
    // if(balloons[i].classList.contains("pop"))  {
    //   count = count;
    // }else {
    //   count = count + 1;
    //   balloons[i].classList.add("pop")
    // }
    
    console.log(count);
    if(count === 24) {
      message.style.display = "block";
      gallery.style.display = "none";
    };
  } // {once: true}; // 이벤트가 대상에서 한번만 발생하도록 한다.
  )
}

// removeEventListner
