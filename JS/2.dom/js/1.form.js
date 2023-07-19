// querySelector通过CSS选择器获取元素，getElementById依赖id属性
var myInput = document.querySelector("#myInput");
var mySelect = document.querySelector("#mySelect");
var myButton = document.getElementById("myButton");

/*
 * 事件监听，可以让代码在特定事件发生时触发执行
 * 可以是用户交互，例如点击按钮、键盘输入、鼠标移动等，也可以是由浏览器或其他代码触发的事件，例如页面加载完成、定时器到期等
 * 1、选择要监听事件的目标元素，可以是HTML元素
 * 2、使用事件监听器 addEventListener
 * 3、事件处理函数
*/
myButton.addEventListener("click", function() {
  var inputValue = myInput.value; // 获取输入框的值
  var selectValue = mySelect.value; // 获取选择框的值

  alert("输入框的值：" + inputValue + "\n选择框的值：" + selectValue);
});