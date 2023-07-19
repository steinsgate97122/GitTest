// 根据id获取dom元素
var parentElement = document.getElementById("parentElement");
var referenceElement = document.getElementById("referenceElement");

// 创建新元素
var newElement = document.createElement("div");
newElement.textContent = "New Element";
newElement.classList.add("myClass");

// 插入新元素作为子节点
parentElement.appendChild(newElement);

// 更新元素样式，可使用style属性或classList属性
newElement.style.backgroundColor = "green";
newElement.style.fontSize = "30px";
newElement.classList.add("newElement");
// 元素内的html内容可以直接更新
let li1 = document.getElementById("li1");
li1.innerHTML = "<b>New content</b>"; // 把原先该元素内的 <div>li1</div> 改为 <b>New content</b>
li1.style.backgroundColor = "white";
li1.style.listStyle = "circle";

// 删除元素
referenceElement.parentNode.removeChild(referenceElement);
