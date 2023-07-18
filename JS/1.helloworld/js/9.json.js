/* JSON 的属性名和字符串必须用双引号括起来，且只能使用双引号而不能使用单引号
 * JSON不支持函数、日期对象等类型，主要用于数据交换和存储，易于解析和生成
*/

// JSON.parse()：用于将 JSON 字符串解析为 JavaScript 对象。
var jsonString = '{"employees": [{"name": "John", "age": 30}, {"name": "Jane", "age": 25}]}';
var jsonObj = JSON.parse(jsonString);
console.log(jsonObj.employees[0].name); // 输出: John
console.log(jsonObj.employees[1].age); // 输出: 25
console.log(jsonObj);

// JSON.stringify()：用于将 JavaScript 对象序列化为 JSON 字符串。
var person = {name: "John", age: 30};
var jsonString = JSON.stringify(person);
console.log(jsonString); // 输出: {"name":"John","age":30}