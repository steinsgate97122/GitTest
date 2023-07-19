// 先获取dom元素
let prevBtn = document.querySelector(".prev-button");
let nextBtn = document.querySelector(".next-button");
let slider = document.querySelector(".slider");
let images = document.querySelectorAll(".slider img");

let index = 0;
let intervalId;

// 轮播图位置更新
function updateSliderPosition() {
    slider.style.transform = `translateX(-${800 * index}px)`;
}

// 切换下一张
function nextSlide() {
    index = (index + 1) % images.length;
    updateSliderPosition();
}

// 切换上一张
function prevSlide() {
    index = (index - 1 + images.length) % images.length;
    updateSliderPosition();
}

// 开始自动播放，2s一次
function startAutoPlay() {
    intervalId = setInterval(nextSlide, 2000);
}
// 停止自动播放
function stopAutoPlay() {
    clearInterval(intervalId);
}

// 将按钮点击事件与对应函数绑定，点击后停止自动播放
nextBtn.addEventListener("click", function() {
    nextSlide();
    stopAutoPlay();
});
prevBtn.addEventListener("click", function() {
    prevSlide();
    stopAutoPlay();
});

// 开始自动播放
startAutoPlay();