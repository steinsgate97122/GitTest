/*
* 在第一行加上use strict后，会进行语法的严格检查；
* 例如变量前不加var/let/const时会报错
* Uncaught ReferenceError: i is not defined
* */
"use strict";
// let定义局部变量；const定义全局变量
// 全局变量可跨js文件生效
let i = 1;
console.log(i);