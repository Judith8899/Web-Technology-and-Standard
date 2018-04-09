$(document).ready(function(){
	$(".tabDiv").click(function(){
		$(this).addClass("tabStyle").siblings().removeClass("tabStyle")
        var tabId=$(this).attr("id");
        $("."+ tabId).addClass("cur").removeClass("tabHide")
        $("."+ tabId).siblings().addClass("tabHide").removeClass("cur")
	})
})
