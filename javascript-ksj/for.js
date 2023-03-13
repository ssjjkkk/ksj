// For ..of
const fruits = ["apple", "orange", "banana", "pear", "pineapple"];
for (const fruit of fruits) {
    console.log(fruit);
}


// 전통적인 For loop
for (let i=0; i<fruits.length; i++){
    console.log(fruits[i]);
}


// 전통적인 ForEach
fruits.forEach(function (fruit, i) {
    console.log(fruit);
})

fruits.push("포도")
console.dir(fruits)





