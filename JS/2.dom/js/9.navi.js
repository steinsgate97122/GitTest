// 获取dom
let navbar = document.getElementById("navbar");
let sections = document.querySelectorAll(".section");

let currentSectionIndex = 0;

// 监听滚动事件，位于页面顶部时隐藏导航
window.addEventListener("scroll", function() {
    // 获取页面滚动垂直距离
    let scrollY = window.scrollY || window.pageYOffset;

    // 顶部时隐藏导航
    if (scrollY > 0) {
        navbar.style.display = "block";
    } else {
        navbar.style.display = "none";
    }

    currentSectionIndex = getCurrentSectionIndex(scrollY);

    setActiveNav();
});

// 根据scrollY判断当前模块的索引
function getCurrentSectionIndex(scrollY) {
    for (let i = 0; i < sections.length; i++) {
        let sectionTop = sections[i].offsetTop;
        let sectionBottom = sectionTop + sections[i].clientHeight;

        if ((scrollY >= sectionTop) && (scrollY <= sectionBottom)) {
            return i;
        }
    }
    return 0;
}

// 监听导航栏点击事件，重写跳转
navbar.addEventListener("click", function(event) {
    if (event.target.tagName === "A") {
        // 命中a标签
        event.preventDefault(); // 阻止默认跳转

        let targetId = event.target.getAttribute("href"); // 目标id在href属性中

        let targetSection = document.querySelector(targetId);
        let targetTop = targetSection.offsetTop;

        // 滚动到targetTop的位置
        window.scrollTo({
            top: targetTop,
            behavior: "smooth"
        });
    }
});

// 导航栏信息更新
function setActiveNav() {
    let navLinks = navbar.querySelectorAll("a");
    for(let i = 0; i < navLinks.length; i++) {
        if (i === currentSectionIndex) {
            navLinks[i].classList.add("active");
        } else {
            navLinks[i].classList.remove("active");
        }
    }
}