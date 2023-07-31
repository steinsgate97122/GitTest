$(document).ready(function() {
    // 监听document内的鼠标移动事件
    $(document).mousemove(function(event) {
        let mouseX = event.pageX;
        let mouseY = event.pageY;

        // 更新坐标
        $("#coordinates").text("X: " + mouseX + ", Y: " + mouseY);
    });
});