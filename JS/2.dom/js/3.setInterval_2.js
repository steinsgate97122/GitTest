// 先获取btn的dom对象
let btn = document.getElementById("btn");

let count = 6;
// 用setInterval做一个倒计时
let interval = setInterval(function() {
    count--;
    btn.innerHTML = `阅读协议(${count}s)`;
    if (count === 0) {
        btn.innerHTML = "确认";
        btn.disabled = false;
        clearInterval(interval);
    }
}, 1000);