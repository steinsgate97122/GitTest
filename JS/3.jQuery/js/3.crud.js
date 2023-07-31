// 点击addButton时，加一个段落到container中
$("#addButton").click(function(event) {
    $("#container").append("<p>New Paragraph</p>");
});

// 点击removeButton时，删除container中的最后一个元素
$("#removeButton").click(function() {
    $("#container p:last-child").remove();
});

// 点击changeButton时，修改message内容
$("#changeButton").click(function() {
    $("#message").text("内容修改了");
});

// 点击styleButton时，修改container样式
$("#styleButton").click(function() {
    $("#container").css({
        "background-color": "blue",
        "width": "200px",
        "height": "300px",
        "border": "2px solid black"
    });
});

// 点击getButton时，将inputField的内容输出到result
$("#getButton").click(function() {
    let value = $("#inputField").val();
    $("#result").text(value);
})