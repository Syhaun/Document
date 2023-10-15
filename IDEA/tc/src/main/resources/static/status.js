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
// script.js

//获取用户登录信息
let userdata = location.search.slice(1)
//const xhr = new XMLHttpRequest();
//xhr.open('GET', 'http://localhost:8080/select'+'?stu_num='+userdata);
//    xhr.setRequestHeader("Content-Type", "application/json");
//    xhr.send();
//    xhr.onreadystatechange = function () {
//        if (xhr.readyState == 4) {
//            if (xhr.status >= 200 && xhr.status < 300) {
//                //处理结果 行 头 空行 体
//                //响应 行
//                let response = JSON.parse(xhr.response);
//                console.log(response)
//                if (data.code == 1) {
//                    $('#user-info p strong').html('录取状态：' + data.msg);
//
//                }
//            }
//        }
//    }
let sendData = {
    stu_num: userdata
}
$.ajax({
    type: 'post',
    url: '/select',
    data: JSON.stringify(sendData),
    dataType: 'json',
    contentType:'application/json',
    success: function (data) {
        console.log(data)
        if (data.code == 1) {
            $('#user-info p strong').html('录取状态：' + data.data);
        }
    }
})
