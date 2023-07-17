// 定义函数，接受传参
function sayHello(name){
    console.log("hello, " + name + "!");
}

sayHello("alice"); // 调用函数

// 匿名函数，可通过调用变量来执行函数
let sumNumbers = function(a, b){
    let s = a + b;
    return s;
};
console.log(sumNumbers(1, 2));

// 箭头函数，函数体为单个表达式，自动将表达式结果作为返回值
let mulNumbers = (a, b) => a * b;
console.log(mulNumbers(2, 3));

// 函数也可以作为参数
function printNumber(number) {
    console.log(number);
}
let processNumbers = function(numbers, callback) {
    for(let i = 0; i < numbers.length; i++) {
        callback(numbers[i]);
    }
}
processNumbers([1, 2, 3, 4, 5], printNumber);

// arguments可访问函数的参数列表，它是一个类数组对象
function show(a, b) {
    console.log(arguments[0]);
    console.log(arguments[1]);
}
show(2, 3);

function multiply() {
    let s = 1;
    // arguments只是一个类数组对象，不能直接调用数组的forEach方法
    argArr = Array.from(arguments);
    argArr.forEach(function(value){
        s *= value;
    });
    return s;
}
console.log(multiply(2, 3, 4, 5));

// 推荐使用...args来接收任意数量的参数，可以和普通参数混合使用
function greet(greeting, ...names) {
    for(let name of names) {
        console.log(`${greeting}, ${name}~`);
    }
}
greet("Hello", "John", "Jane", "Bob");

// 对象内部也可以定义方法
function greet_v2(message) {
  console.log(message + ", my name is " + this.name + " and I am " + this.age + " years old.");
}
let person = {
  name: "John",
  age: 30,
  greet: greet_v2 // 将函数赋值给对象的属性作为方法
};
// 下面的两种方式都调用了greet_v2函数，并将person对象作为函数的上下文
person.greet("Hello"); // 这种方式更简洁，易于阅读和维护
greet_v2.apply(person, ["Hi"]); // 这种方式更加灵活，适用于那些需要在运行时根据不同的上下文和参数来调用函数的情况