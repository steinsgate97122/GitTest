// 获取元素
let textInput = document.getElementById("textInput");
let charCount = document.getElementById("charCount");
let submitButton = document.getElementById("submitButton");

// 显示当前字数
function showCharCount() {
    charCount.innerHTML = `当前字数：${textInput.value.length}`;
    charCount.style.display = "block";
}

// 隐藏字数
function hideCharCount(){
    charCount.style.display = "none";
}

// 提交内容
function submitContent(){
    alert("提交了\n" + textInput.value);
    textInput.value = null;
}

// 输入框获得焦点时显示字数
textInput.addEventListener("focus", showCharCount);

// 输入框失去焦点时隐藏字数
textInput.addEventListener("blur", hideCharCount);

// 字数实时更新
textInput.addEventListener("input", showCharCount);

// 点击发布时提交
submitButton.addEventListener("click", submitContent);

// 输入回车时提交
textInput.addEventListener("keydown", function(event) {
    // 回调函数的第一个参数就是事件对象
    console.log(event.key);
    if(event.key === "Enter") {
        submitContent();
        event.preventDefault(); // 阻止默认的回车动作
    }
});
