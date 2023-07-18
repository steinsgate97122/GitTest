/* BOM（Browser Object Model）是指浏览器对象模型，它提供了一组用于与浏览器进行交互的对象和方法。
 * 通过BOM对象，可以控制窗口的大小和位置、检测浏览器特性、处理页面导航等
*/

// window对象表示浏览器窗口
// window.open("http://www.baidu.com");
console.log(window.innerWidth); // 窗口宽度
console.log(window.innerHeight); // 窗口高度

// document对象表示当前页面的文档对象，访问操作页面元素
console.log(document.title); // 页面标题
console.log(document.getElementById("myLink"));
document.getElementById("myLink").href = "http://www.google.com";

// navigator对象提供关于浏览器的信息
console.log(navigator.userAgent); // Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36
console.log(navigator.language); // zh-CN

// location对象表示当前页面的URL信息
console.log(location.href);

// history对象表示浏览器的浏览历史记录，可进行前进/后退页面操作
// history.forward();
// history.back();

// screen对象提供关于用户屏幕的信息
console.log(screen.width);
console.log(screen.height);