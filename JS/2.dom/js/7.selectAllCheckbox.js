// 对于checkbox，使用checked属性判断是否选中
let selectAll = document.getElementById("selectAll");
let selectors = document.querySelectorAll(".checkbox");

// 子复选框的状态跟随selectAll
selectAll.addEventListener("change", function() {
    for(let i = 0; i < selectors.length; i++) {
        selectors[i].checked = selectAll.checked;
    }
});

// 子复选框非全选时，取消selectAll的选中状态，每个子复选框都绑定change事件
for(let i = 0; i < selectors.length; i++) {
    selectors[i].addEventListener("change", function() {
        if(selectors[i].checked === false) {
            selectAll.checked = false;
        }
    });
}