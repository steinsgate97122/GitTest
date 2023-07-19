// 先获取需要的dom元素
let numberDisplay = document.getElementById("numberDisplay");
let startButton = document.getElementById("startButton");
let stopButton = document.getElementById("stopButton");

// 外面定义定时器
let intervalId;

// 定义开始按钮的事件处理函数 和 结束按钮的事件处理函数
let startFunction = function() {
    // 定时器
    intervalId = setInterval(function() {
        // 生成随机数，Math.random()生成0-1，左闭右开
        let number = Math.floor(Math.random() * 100 + 1);
        // 替换numberDisplay
        numberDisplay.innerHTML = `${number}`;
    }, 30);
};

let stopFunction = function() {
    clearInterval(intervalId);
}

startButton.addEventListener("click", startFunction);
stopButton.addEventListener("click", stopFunction);