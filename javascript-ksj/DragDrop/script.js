// 4개의 div박스에 3종류의 이벤트를 등록한다.
// 1) dragover 이미지를 드래그 해서 div 위에 있을 때 발생
// 2) dragleave 1번의 드래그오버 이벤트가 발생한 div에서 마우스가 나가면 발생
// 3) drop 한 개의 div 위에서 이미지를 drop 하면 발생

// 각 이벤트를 핸들링 할 수 있는 코드 작성
// dragover 이벤트 : 이벤트가 발생한 특정 div요소에 hovered클래스 추가
// dragleave 이벤트 : 이벤트가 발생한 특정 div요소에 hovered클래스 삭제
// drop 이벤트 : 이벤트가 발생한 특정 div요소에 image 태그 요소를 추가 div에 appendChild
// divList 에 포문으로 함수를 등록?

const divList = document.querySelectorAll(".box");
const img = document.querySelector(".image");

for (let i = 0; i < divList.length; i++) {
    // dragover 이벤트의 디폴트 동작 때문에 drop 이벤트가 발생하지 못함.
    divList[i].addEventListener("dragover", (e) => {
        e.preventDefault();  // 드롭이벤트를 막고있는 default 동작을 중단.
        divList[i].classList.add("hovered");
    });
    divList[i].addEventListener("dragleave", (e) => {
        divList[i].classList.remove("hovered");
    });
    divList[i].addEventListener("drop", (e) => {
        divList[i].appendChild(img);
        divList[i].classList.remove("hovered");
    });
};
