// 1.遍历数组
let arr = [1, 2, 3, 4, 5];
for(let i = 0; i < 5; i++) {
    console.log(arr[i]);
}

// 2.遍历对象
let obj = {a : 1, b : 2, c : 3};
for(let key in obj) {
    console.log(key + ":" + obj[key]);
}

// 3.遍历可迭代对象（数组/字符串）
let str = "string";
for(let value of str) {
    console.log(value);
}

// 4.数组和一些类数组对象有forEach方法，接受一个函数作为参数，这个函数可以接受三个参数：元素的值、元素的索引和正在遍历的数组对象本身
let numbers = [1, 2, 3, 4, 5];
numbers.forEach(function(value, key, arr){
    // 使用第三个参数arr可直接修改原始数组
    arr[key] = value * value;
});
console.log(numbers);

// if...else if...else；switch；三元运算符 与java中一致
let isRaining = true;
let message = isRaining ? "带雨伞" : "不带雨伞";
console.log(message);