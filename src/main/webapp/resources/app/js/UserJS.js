function selectSex() {
    var cb1 = document.getElementById("check1");
    var cb2 = document.getElementById("check2");
    cb1.onclick = function () {
        cb2.checked = false;
    }
    cb2.onclick = function () {
        cb1.checked = false;
    }
}
function checkPwd() {
    var pwd1 = document.getElementById("pwd1");
    var pwd2 = document.getElementById("pwd2");
    if(pwd1.value !== pwd2.value){
        alert("两次密码不一致，请重新输入！");
        return false;
    }
    else
        return true;
}