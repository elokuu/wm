$("#name").blur(function () {
    var uname = document.getElementById("name").value;
    var len = uname.length;
    if(len >= 16 || len <8){
        var a = document.getElementById("alert");
        a.hidden=false;
    }
    if (len>=8 && len<=16) {
        var a = document.getElementById("alert");
        a.hidden=true;
    }
});
$("#password1").blur(function () {
    var pwd1 = document.getElementById("password1").value;
    var len = pwd1.length;
    if(len >= 16 || len <8){
        var a = document.getElementById("alert2");
        a.hidden=false;
    }
    if (len>=8 && len<=16) {
        var a = document.getElementById("alert2");
        a.hidden=true;
    }
})
$("#password2").blur(function () {
    var pwd1 = document.getElementById("password1").value;
    var pwd2 = document.getElementById("password2").value;
    var len = pwd1.length;
    if(len >= 16 || len <8){
        var a = document.getElementById("alert3");
        a.hidden=false;
    }
    if (len>=8 && len<=16) {
        var a = document.getElementById("alert3");
        a.hidden=true;
    }
    if( pwd1 != pwd2){
        var a = document.getElementById("alert3");
        a.hidden=false;
    }else {
        var a = document.getElementById("alert3");
        a.hidden=true;
    }
})

function tijiao() {
    var a1 = document.getElementById("alert").hidden;
    var a2 = document.getElementById("alert2").hidden;
    var a3 = document.getElementById("alert3").hidden;
    var uname = document.getElementById("name").value;
    var pwd1 = document.getElementById("password1").value;
    var pwd2 = document.getElementById("password2").value;
    if(!a1 || !a2 || !a3 || uname==null || uname=='' || pwd1==null || pwd1=='' || pwd2==null || pwd2==''){
        alert("请正确填写注册表");
        return false;

    }
}

