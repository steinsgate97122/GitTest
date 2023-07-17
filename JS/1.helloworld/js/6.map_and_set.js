/* Map 是一种键值对的集合，其中每个键都是唯一的，而值可以重复
*  Set 是一种无重复元素的集合，它存储的值都是唯一的
*/

// 创建一个空的 Map
let myMap = new Map();

// 添加键值对到 Map
myMap.set("name", "John");
myMap.set("age", 25);
myMap.set("city", "New York");

// 获取 Map 的大小
console.log(myMap.size); // 输出: 3

// 获取指定键的值
console.log(myMap.get("name")); // 输出: John

// 检查是否包含指定键
console.log(myMap.has("age")); // 输出: true

// 遍历 Map 的键值对
myMap.forEach(function(value, key) {
  console.log(key + ": " + value);
});

// 删除指定键的值
myMap.delete("city");
console.log(myMap);

// 清空 Map
myMap.clear();
console.log(myMap);

// Set与Map用法类似
let mySet = new Set();
mySet.add("apple");
mySet.add("banana");
mySet.add("apple"); // 重复元素将被忽略

console.log(mySet.size); // 2
console.log(mySet.has("apple")); // true

mySet.forEach(function(value){
    console.log(value);
});

mySet.delete("banana");
mySet.clear();