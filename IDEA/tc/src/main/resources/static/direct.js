// 获取导航按钮元素
const tcIntroButton = document.getElementById("tc-intro");
const directionsButton = document.getElementById("directions");
const loginButton = document.getElementById("login");
const interviewProgressButton = document.getElementById("interview-progress");

// 添加点击事件监听器，实现页面跳转
tcIntroButton.addEventListener("click", () => {
    // 通过 JavaScript 跳转到 TC 简介页面
    // 例如：window.location.href = "tc_intro.html";
    window.location.href = "wel.html"
});

directionsButton.addEventListener("click", () => {
    // 通过 JavaScript 跳转到方向页面
    // 例如：window.location.href = "directions.html";
    window.location.href = "direct.html"
});

loginButton.addEventListener("click", () => {
    // 通过 JavaScript 跳转到登录页面
    // 例如：window.location.href = "login.html";
    window.location.href = "sing.html"
});

interviewProgressButton.addEventListener("click", () => {
    // 通过 JavaScript 跳转到面试进度页面
    // 例如：window.location.href = "interview_progress.html";
    window.location.href = "status.html"
});


var swiper = new Swiper(".mySwiper", {
    effect: "cards",
    grabCursor: true,
});