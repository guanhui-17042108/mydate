
$(function(){
	list(1);
	cartnum();
	userinfo();
})
function userinfo(){
	var userid=sessionStorage.getItem("id")
	var username=sessionStorage.getItem("name")
	$(".userinfo").html("");
	var txt="";
	txt +=`
	<img class="btn btn-primary" src="/headImg?id=${userid}" onerror="defaultImg(this)" style="
    width: 95px;
    height: 95px;
    display: inline-block;
    border: 1px solid #e1e1e1;
	"/>
<p>${username}</p>
	`
	$(".userinfo").append(txt);
}
function cartnum(){
	var cartnum=sessionStorage.getItem("cartnum");
	$(".cartnum").html("");
	var txt="";
	txt +=cartnum
  	$(".cartnum").append(txt);
}
function list(content){// content=1未评价
	var userid=sessionStorage.getItem("id");
	var username=sessionStorage.getItem("name");
	var status=sessionStorage.getItem("status");
	
	$.ajax({
		type: "post",
		url: "/content",
		data:{
			userid:userid,
			content:content,
		},
		dataType: "json",
		success: function(data){
			login();
			var List = data.list;
			console.log(data.list);
			$("#list3").html("");
			txt="";
			if(content==1){
			for(var i = 0;i<List.length;i++){
				console.log(List[i].ppId);
				txt +=`<div class="article ">
				<img class="ss" src="/product/headImg2?id=${List[i].ppId}" onerror="defaultImg(this)" style="
    width: 50px;
    height: 50px;
    display: inline-block;
    border: 1px solid #e1e1e1;
	"/>
                <ul class="article-info">
					<li>${List[i].productName}</li>
                    <li>${List[i].productId}</li>
                    <li>${List[i].providerName}</li>
                </ul>
                <p>购买时间：${List[i].createTime}</p>
                <p class="evaluate_btn">去评价</p>
                </div>
				`
			}
			}else{
				for(var i = 0;i<List.length;i++){
					txt +=`<div class="article ">
				<img class="ss" src="/product/headImg2?id=${List[i].ppId}" onerror="defaultImg(this)" style="
    width: 50px;
    height: 50px;
    display: inline-block;
    border: 1px solid #e1e1e1;
	"/>
	                <ul class="article-info">
						<li>${List[i].productName}</li>
	                    <li>${List[i].productId}</li>
	                    <li>${List[i].providerName}</li>
	                </ul>
	                <p>购买时间：${List[i].createTime}</p>
	                <p class="evaluate_btn">已评价</p>
	                </div>
					`
				}
			}
			$("#list3").append(txt);
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
}










function login(){
	var userid=sessionStorage.getItem("id");
	var username=sessionStorage.getItem("name");
	var status=sessionStorage.getItem("status");
	console.log(userid);
	if(status!=1){
		alert("请先登录");
		 location.href="redirect?page=e-commerce_login"
	}
	
	$("#sysuser").html("");
	var txt="";
	txt +=username
	$("#sysuser").append(txt);
}
function defaultImg(img){
	img.src="/images/user-lg.png";
}
$(".change1").on("click", function(){
	list(1);
})

$(".change2").on("click", function(){
	list(2);
})

$(".user-quit").on("click", function () {
	sessionStorage.setItem("status",2);
})

$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
$(".evaluate_btn").on("click", function(event){
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