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
document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');
    const showRegisterButton = document.getElementById('show-register-button');
    const returnToLoginButton = document.getElementById('return-to-login-button');
    const loginContainer = document.getElementById('login-container');
    const registerContainer = document.getElementById('register-container');

    showRegisterButton.addEventListener('click', function () {
        // 点击注册按钮时切换表单的可见性
        loginContainer.style.display = 'none';
        registerContainer.style.display = 'block';
    });

    returnToLoginButton.addEventListener('click', function () {
        // 点击返回登录按钮时切换表单的可见性
        registerContainer.style.display = 'none';
        loginContainer.style.display = 'block';
    });

    registerForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const name = document.getElementById('register-name').value;
        const studentId = document.getElementById('register-student-id').value;
        const phone = document.getElementById('register-phone').value;
        const major = document.getElementById('register-major').value;
        const password = document.getElementById('register-password').value;
        const confirmPassword = document.getElementById('register-confirm-password').value;
        const direction = Array.from(document.getElementById('direction').selectedOptions).map(option => option.value);

        // 清空表单
        registerForm.reset();

        // 切换回登录表单
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
    });

    loginForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const studentId = document.getElementById('login-student-id').value;
        const password = document.getElementById('login-password').value;

        // 在这里可以执行登录逻辑，例如验证用户的学号和密码
        if (isValidUser(studentId, password)) {
            console.log('登录成功:', studentId);
        } else {
            console.log('登录失败：学号或密码不正确');
        }

        // 清空表单
        loginForm.reset();
    });

    // 模拟一个验证用户的函数，实际应用中需替换为真正的验证逻辑
    function isValidUser(studentId, password) {
        // 这里可以与数据库中的用户信息进行比对
        // 如果找到匹配的学号和密码，返回 true，否则返回 false
        // 这里仅做示例，不进行真实验证
        return true;
    }
});
const submit = document.getElementById('submit2')
// submit.addEventListener("click", () => {
//     // 通过 JavaScript 跳转到面试进度页面
//     // 例如：window.location.href = "interview_progress.html";
//     window.location.href = "status.html"
// });
function checkpassword() {
    var password = document.getElementById("register-password").value;
    var repassword = document.getElementById("register-confirm-password").value;
    if (password == repassword) {
        document.getElementById("submit2").disabled = false;
        document.getElementById("tishi").innerHTML = "<br><font color='green'>两次密码输入一致</font>"
    } else {
        document.getElementById("tishi").innerHTML = "<br><font color='red'>两次输入密码不一致!</font>";
        document.getElementById("submit2").disabled = true;
    }
}
function recheckpassword() {
    var password = document.getElementById("register-confirm-password").value;
    var repassword = document.getElementById("login-password").value;
    if (password == repassword) {
        document.getElementById("tishi2").innerHTML = "<br><font color='green'>密码正确</font>"
        document.getElementById("submit2").disabled = false;
    } else {
        document.getElementById("tishi2").innerHTML = "<br><font color='red'>密码错误</font>";
        document.getElementById("submit2").disabled = true;
    }
}
const submit1 = document.getElementById("submit1");
submit1.onclick = function () {
    const name = document.getElementById('register-name').value;
    const studentId = document.getElementById('register-student-id').value;
    const phone = document.getElementById('register-phone').value;
    const major = document.getElementById('register-major').value;
    const password = document.getElementById('register-password').value;
    const confirmPassword = document.getElementById('register-confirm-password').value;
    const direction = $('#direction').val()
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/register');
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify({
        name: name,
        stu_num: studentId,
        phone: phone,
        major_class: major,
        password: password,
        direct: direction
    }));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status >= 200 && xhr.status < 300) {
                //处理结果 行 头 空行 体
                //响应 行
                console.log(xhr.status); //状态码
                console.log(xhr.statusText); //状态字符串
                console.log(xhr.getAllResponseHeaders()); //所有响应头
                console.log(xhr.response); //响应体
                let response = JSON.parse(xhr.responseText);
                if (response.code == 0) {
                    alert(response.msg);
                } else {
                    alert('注册成功')


                }
            }
        }
    }
}

const submit2 = document.getElementById("submit2");
submit2.onclick = function () {
    const studentId = document.getElementById('login-student-id').value;
    const password = document.getElementById('login-password').value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/login');
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify({
        stu_num: studentId,
        password: password,
    }));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status >= 200 && xhr.status < 300) {
                //处理结果 行 头 空行 体
                //响应 行
                console.log(xhr.status); //状态码
                console.log(xhr.statusText); //状态字符串
                console.log(xhr.getAllResponseHeaders()); //所有响应头
                let response = JSON.parse(xhr.responseText);
                if (response.code == 0) {
                    alert(response.msg);
                } else {
                    alert('登陆成功')
                    window.location.href = "status.html" + "?" + studentId

                }
            }
        }
    }
}