window.onload = function() {
    let count = 0;

    let intervalId = setInterval(function() {
        count++;
        console.log("定时器已执行 "+ count +" 次");

        if(count === 5) {
            console.log("定时器停止");
            clearInterval(intervalId);
        }
    }, 1000);
};