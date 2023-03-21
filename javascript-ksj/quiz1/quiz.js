let count = 0;
count = 10;
console.log(count); // 10

const m1 = 3;
const m2 = 5;
const m3 = m1 * m2; // 변수이용
console.log(m3); // 15

const name1 = "www";
const name2 = "google";
const name3 = "com";
const url = name1.concat(".", name2, ".", name3);
console.log(url); // www.google.com

const emptyArray = [];
emptyArray.push("item1");
console.log(emptyArray); // ["item1"]

const front = ["react", "angular", "vue", "svelte"];
console.log(front.splice(2, 1)); // vue

const frontMod = front.splice(2, 1, "Javascript");
console.log(front); // ["react", "angular", "Javascript"]

const numArray = [1, 2, 3, 6, 7, 8];
const numArrayMod = numArray.splice(3, 3);
console.log(numArrayMod); // [6,7,8]

const bool = false;
console.log(typeof bool); // boolean

const multiply = function (a, b) {
  return a * b;
};
const multValue = multiply(4, 5);
console.log(multValue); // 20

const user = {
  lastName: "Hong",
  firstName: "Gildong",
  address: "Seoul",
  age: 30,
  fullname: function () {
    return user.lastName + " " + user.firstName;
  },
};
console.log(user.age); // 30

const fName = user.fullname(user);
console.log(fName); // Hong Gildong

const colorArray = ["black", "blue", "red", "green", "yellow", "purple"];
console.log(colorArray.length); // 6

for (let i = 0; i < colorArray.length; i++) {
  if (colorArray[i].length < 4) {
    console.log(colorArray[i]); // red
  }
}

const random = Math.floor(Math.random() * (11 - 1)) + 1;
console.log(random); // 1~10 사이의 랜덤숫자
