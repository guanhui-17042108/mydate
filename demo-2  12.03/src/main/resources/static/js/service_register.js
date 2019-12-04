$(".code1").on("click", function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})

// 自运行
$(function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})

$(".login-btn").on("click", function() {
	var id = $(".id").val();
	var servicePhone = $(".servicePhone").val();
	var servicePassword = $(".servicePassword").val();
	var imgcode = $(".code").val();
	var cmbProvince=$("#cmbProvince option:selected").val();
	var cmbCity=$("#cmbCity option:selected").val();
	var cmbArea=$("#cmbArea option:selected").val();
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "/registerService",
		// 请求参数
		data : {
			id : id,
			servicePhone :servicePhone,
			servicePassword: servicePassword,
			imgcode : imgcode,
			cmbProvince,cmbProvince,
			cmbCity,cmbCity,
			cmbArea,cmbArea,
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("注册成功后返回数据", data);
			alert("code=:" + data.code);
			if (data.code == 1) {
				location.href = "service_login.html"
			} else {
				alert("注册失败!");
				location.href = "service_register.html"
			}

		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
})
//判断电话
$(".servicePhone").blur(function(){
var servicePhone =$(this).val();
if(servicePhone.length==0) { 
        alert('手机号码不能为空！');
        return false; 
        } 
    if(servicePhone.length!=11) { 
        alert('请输入有效的手机号码，需是11位！');
        return false; 
        } 

    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
    if(!myreg.test(servicePhone)) { 
        alert('请输入有效的手机号码！'); 
        return false; 
        } 

});
