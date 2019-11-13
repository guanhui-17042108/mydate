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
 function getUser(id){			
	 $.ajax({
           type:"post",
           url:"/updateQ",
           data:$('#login_value').serialize(),
         success:function(data){
        	 var xdServiceUser=data.xdServiceUser;
        /*	 var txt="";
        	 txt+=`<tr><th>学号</th><th>姓名</th><th>密码</th></tr>`;
        	 txt +=`<tr>
             	<td><input type="text" name="id" value="${sysUser.id}" /></td>
             	<td><input type="text" name= "username" value="${sysUser.username}" /></td>
             	<td><input type="text" name="password" value="${sysUser.password}" /></td>
             		</tr>`;
             		txt+=`<tr><td><input type="submit" value="修改" /></td></tr>`;*/
             	   var tbody=$("<tbody></tbody>").html(txt);
             	   $('#xdServiceUser').html(tbody);
         },
           error:function(data){
        	   alert("Connection error1111111"+data);
        	   console.log("失败返回的数据",data);
        	   }
           })}