$(".login-btn").on("click", function(){
	var cellphone=$(".cellphone").val();
	var password=$(".password").val();
	var code=$(".code").val();	
        $.ajax({
            url: "/login/dl",
            type: "post",
            data: {cellphone:cellphone, 
	                  password:password,
	                  code:code,},
	          		dataType:"json",
	        		
success:function(data){
	          	console.log("成功后返回的数据",data);
	        	alert(data.msg);
                if (data.code==1) {
	        
                        location.href="/redirect?page=e-commerce_product"
       sessionStorage.setItem("id",data.userid);
   sessionStorage.setItem("eusername",data.username);
   sessionStorage.setItem("status",1);
                }
            },
        		error:function(data){
	console.log("失败返回后的数据",data);	
}
        })
    

})

$(function() {
 var img = document.getElementsByClassName("img")[0];
 img.src = "imgGetCode";
})
function imgChange() {
 var img = document.getElementsByClassName("img")[0];
 var time = new Date().getTime();
 img.src = "imgGetCode?t=" + time;
}