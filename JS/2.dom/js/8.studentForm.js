// 学生数组
var students = [];

// 获取输入框内变量
var nameInput = document.getElementById("nameInput");
var ageInput = document.getElementById("ageInput");
var genderInput = document.getElementById("genderInput");
var salaryInput = document.getElementById("salaryInput");
var addButton = document.getElementById("addButton");
var studentList = document.getElementById("studentList");

function addStudent() {
    var name = nameInput.value;
    var age = parseInt(ageInput.value);
    var gender = genderInput.value;
    var salary = parseFloat(salaryInput.value);

    var student = {
        name: name,
        age: age,
        gender: gender,
        salary: salary
    };

    // 将当前输入加入数组
    students.push(student);

    // 表单内数据清空
    nameInput.value = "";
    ageInput.value = "";
    genderInput.value = "";
    salaryInput.value = "";

    // 渲染列表
    console.log(students);
    renderList();
}

function deleteStudent(index) {
    students.splice(index, 1);

    renderList();
}

function renderList() {
    studentList.innerHTML = "";

    for(var i = 0; i < students.length; i++) {
        var student = students[i];

        // 新建一个列表项
        var studentListItem = document.createElement("li");
        studentListItem.classList.add("student");
        studentListItem.textContent = `序号:${i + 1} 姓名:${student.name} 年龄:${student.age} 性别:${student.gender} 薪资:${student.salary}`;

        // 列表项加入删除功能
        var deleteBottom = document.createElement("button");
        deleteBottom.classList.add("delete-button");
        deleteBottom.textContent = "删除";
        /*
         * 使用了data-index属性来存储每个删除按钮对应的学生索引，这样在点击删除按钮时可以获得正确的索引
         * 如果直接调用deleteStudent(i)，当点击删除按钮时，事件处理函数中的i变量已经遍历完毕，此时的i是循环结束后的i，不符合预期
        */
        deleteBottom.setAttribute("data-index", i);
        deleteBottom.addEventListener("click", function(event) {
            var index = event.target.getAttribute("data-index");

            deleteStudent(index);
        });
        studentListItem.appendChild(deleteBottom);

        studentList.appendChild(studentListItem);
        console.log(i);
    }
}

addButton.addEventListener("click", addStudent);
