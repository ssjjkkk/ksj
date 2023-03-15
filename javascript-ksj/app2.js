const colors = ["red", "blue", "green", "yellow", "brown", "grey", "black"];
for (let i=0; i<colors.length; i++) {
    console.log(colors[i]);
};

const colorSlice = colors.slice(3, 6);
console.log(colorSlice); // y, b, g

const x = colors.splice(3, 1, "pink");
console.log(colors); // r, b, g, p, b, g, bl

const colorSplice = colors.splice(0, 1);
console.log(colorSplice); // r