$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})
$(".order3").on("click", function(){
    $(".main-top li").eq(3).text("未通过用户");
})
$(".change-info").on("click", function(event){
    $(".masking").show();
})
$(".save").on("click", function(event){
    $(".masking").hide();
    console.log("保存");
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})
$(function(){
	var name=sessionStorage.getItem("serviceName");
	$(".servicename").text(name);
})
$(function(){
	var name=sessionStorage.getItem("cmbProvince");
	$(".cmbProvince").text(name);
})
$(function(){
	var name=sessionStorage.getItem("cmbCity");
	$(".cmbCity").text(name);
})
$(function(){
	var name=sessionStorage.getItem("cmbArea");
	$(".cmbArea").text(name);
})
$(function(){
	var name=sessionStorage.getItem("servicePhone");
	$(".servicePhone").text(name);
})
$(function(){
	var name=sessionStorage.getItem("wechat");
	$(".wechat").text(name);
})
$(function(){
	var name=sessionStorage.getItem("qq");
	$(".qq").text(name);
})
$(function(){
	var name=sessionStorage.getItem("email");
	$(".email").text(name);
})
$(function(){
	var name=sessionStorage.getItem("id");
	$(".id").text(name);
})
/*$(function) {
	$.ajax({
		type:"get",
		url:"/sysuserlist",
		success:function(data){
			console.log("成功后返回数据",data);
			var id=sessionStorage.getItem("id");
			var imgPath="/headImgS?id="+id;
			$("#abc").val(id);
			$("#aaa").attr("src",imgPath);
		},
		error:function(data){
			console.log("失败后返回数据",data);
	}
})
$(function) {
	$.ajax({
		type:"get",
		url:"/selectQ",
		success:function(data){
			console.log("成功后返回数据",data);
			var id=sessionStorage.getItem("id");
			var imgPath="/headImgS?id="+id;
			$("#abc").val(id);
			$("#aaa").attr("src",imgPath);
		},
		error:function(data){
			console.log("失败后返回数据",data);
	}
})*/