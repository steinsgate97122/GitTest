// 创建日期对象
let currentDate = new Date();
let specificDate = new Date(2023, 5, 12);
let timestampDate = new Date(1623465600000);

console.log(currentDate.getDate()); // 获取当前日期的日期部分（1-31）
console.log(currentDate.getMonth() + 1); // 获取当前日期的月份部分（0-11，需要 +1 表示实际月份）
console.log(currentDate.getFullYear()); // 获取当前日期的年份部分
console.log(currentDate.getHours()); // 获取当前时间的小时部分（0-23）
console.log(currentDate.getMinutes()); // 获取当前时间的分钟部分（0-59）
console.log(currentDate.getSeconds()); // 获取当前时间的秒钟部分（0-59）

let formattedDate = currentDate.toLocaleDateString(); // 格式化为本地日期字符串
let formattedTime = currentDate.toLocaleTimeString(); // 格式化为本地时间字符串
let formattedDateTime = currentDate.toLocaleString(); // 格式化为本地日期和时间字符串
console.log(formattedDate); // 2023/7/17
console.log(formattedTime); // 21:02:15
console.log(formattedDateTime); // 2023/7/17 21:02:21

// 可进行日期和时间的计算
let futureDate = new Date();
futureDate.setDate(currentDate.getDate() + 7);
console.log(futureDate.toLocaleString()); // 2023/7/24 21:07:16
let timeDiff = futureDate - currentDate;
console.log(timeDiff); // 604800000，毫秒数