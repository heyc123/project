$(function(){
	//绑定提交事件
	$('#submit_btn').bind('click', function(){    
		fromSub();
    });    

})

function fromSub(){
	$('#user_submit').form({    
	    url:'register',
	    method: 'post',
	    success:function(data){   
	    	var result = $.parseJSON(data);
	        alert(result.message);    
	    }    
	});    
	$('#user_submit').submit();  
	
}