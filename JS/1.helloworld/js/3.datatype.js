/*
* 数值类型支持 整数、浮点数、科学计数法
* NaN：not a number
* Infinity表示无穷大
* */

var data = 11;
console.log(data);

data = -9.9;
console.log(data);

data = 1e-11;
console.log(data);

data = NaN;
console.log(data);

data = Infinity;
console.log(data);
console.log(2 / 0);

// 字符串
console.log("abc" + 'abc');
/*
* 字符串中支持使用转义符号
* 反引号包裹的内容可换行，可使用模板字符串${}
* 字符串长度用.length属性
* 字符串方法与java类似，包括toUpperCase() indexOf() substring()
* */
console.log('\'a\'\nb');
console.log(`
    我是第一行字符串
    I change the line
    data: ${data}
`);
console.log("string".length);
console.log("string".toUpperCase());
console.log("string".indexOf('ing'));
console.log("string".substring(1, 3));

// boolean
console.log(2 >= 1);

// 与或非
console.log(true && false);
console.log(true || false);
console.log(!true);

/*
* 使用==时，类型不一样也会判断为true
* 使用===，除了比较值，还会比较类型
* NaN与所有数值都不相等，包括自己
* 如果需要判断是否为NaN，可使用isNaN方法
* */
console.log(1 == "1");
console.log(1 === "1");
console.log(NaN === NaN);
console.log(isNaN(NaN));

/*
* 浮点数的比较存在精度问题，这个与java中一致
* java中使用BigDecimal进行比较
* js中可以使用Math.abs计算两数之差的误差
* */
console.log((1 / 3) == (1 - 2 / 3));
console.log(Math.abs(1 / 3 - (1 - 2 / 3)) < 1e-10);

// 数组元素类型不需要相同，访问数组元素直接加下标
var arr = [1, "abc", null, true];
console.log(arr);
console.log(arr[0]);
console.log(arr[3]);

// 对象直接用大括号定义，访问对象属性用.
var person = {
    name: "zhehao",
    age: 26,
    tags: ["baidu", 'dhu', true]
};

console.log(person);
console.log(person.name);