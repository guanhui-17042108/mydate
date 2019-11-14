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

$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(".search-btn").on("click", function(event){
    var username=$(".search input").val();
    location.href="fenyelikeE?username="+username;
})

$(document).ready(function(){
			var pcount=$('#count').val();
			var psize=$('#pageSize').val();
			var pstart=$('#pageStart').val();
			var username=$('#username').val();
			var nowpage=Math.floor(pstart/psize)+1;		
			var cpage=Math.ceil(pcount/psize);
			var strhtml="";
			
			if(cpage<=10){
				for(var i=1;i<=cpage;i++){
					if(i==nowpage){
						strhtml+='<a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
						//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
					}else{
						strhtml+='<span> <a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+'>'+i+'</a></span>';
					}
				}
			}
			else if(cpage>10){
			
				if( 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
				
					for(var i=1;i<=10;i++){			
					
						if(i==nowpage){
							strhtml+='<a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
							//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
						}else{
							strhtml+='<span> <a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+'>'+i+'</a></span>';
						}
					}
				}
				else if( nowpage<=cpage-4){
				
					for(var i=nowpage-5;i<=nowpage+4;i++){//6--15			
				
						if(i==nowpage){
							strhtml+='<a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
							//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
						}else{
							strhtml+='<span> <a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+'>'+i+'</a></span>';
						}
					
					}
				} 
				else if( cpage-4<nowpage && nowpage<=cpage){
				
					for(var i=cpage-9;i<=cpage;i++){
					
						if(i==nowpage){
							strhtml+='<a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
							//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
						}else{
							strhtml+='<span> <a href=/fenyelikeE?pageStart='+psize*(i-1)+'&username='+username+'>'+i+'</a></span>';
						}
					}
				}
				else{
					console.error(00000000);
				}
			}
			else{  console.error(00000000); }
			$("#mydiv").html(strhtml);

				})();