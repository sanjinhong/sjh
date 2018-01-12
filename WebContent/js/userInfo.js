$(document).ready(function(){
	$("#back").bind("click",function(){
		window.close();
	});
	
	if('<%=request.getParameter("type")%>' == 'check'){
		doCheck('<%=request.getParameter("type")%>','request.getParameter("yhdm")');
	}
});
function save(type,yhdm){
	alert(type);
	
	if(type == "add"){
		var yhid = $("#yhid").val();
		var yhxm = $("#yhxm").val();
		var yhkl = $("#yhkl").val();
		var qrkl = $("#qrkl").val();
		var yhxb = $("#yhxb").val();
		var yhbm = $("#yhbm").val();
		var csrq = $("#csrq").val();
		var pxh = $("#pxh").val();
		if(pxh == ""){
			pxh = 0;
		}
		
		var sfjy = $("#sfjy").val();
		var msg = [];
		if(!yhid){
			msg.push("用户Id");
		}
		if(!yhxm){
			msg.push("用户姓名");
		}
		if(!yhkl){
			msg.push("用户口令");
		}else{
			if("admin" == yhkl){
				alert("用户口令不能为admin!");
			}
		}
		if(!qrkl){
			msg.push("确认口令");
		}else{
			if(qrkl != yhkl){
				alert("您两次输入的密码不一致!");
			}
		}
		if(!yhxm){
			msg.push(yhxm);
		}
		
		if(msg.length > 0){
			alert("请检查必填项：" + msg.join(","));
		}else{
			$.ajax({
				url:"dealUserServlet",
				data:{
					"type":type,
					"yhid" : yhid,
					"yhkl" : yhkl,
					"yhxm" : yhxm,
					"yhxb" : yhxb,
					"yhbm" : yhbm,
					"csrq" : csrq,
					"pxh"  : pxh,
					"sfjy" : sfjy
				},
				async:false,
				type:"POST",
				success:function(){
					alert("添加成功!");
				},
				error:function(){
					alert("添加失败!");
				}
			})
		}
	}else{
		alert("您的操作有误");
		$.ajax({
			url:"dealUserServlet",
			data:{"type":type,"yhdm":yhdm},
			type:"POST",
			dataType:"json,",
			success:function(){
				
			},
			error:function(){
				
			}
		})
	}
}
function doModify(){
	$.ajax({
		url:"dealUserServlet",
		data:{"type":type,"yhdm":yhdm},
		type:"POST",
		dataType:"json,",
		success:function(){
			alert("修改成功!");
		},
		error:function(){
			alert("修改成功!");
		}
	});
	$("yhid").attr("readonly","readonly");
}

function doCheck(type,yhdm){
	alert(type);
	$("#save").hide();
	$.ajax({
		url:"dealUserServlet",
		data:{"type":type,"yhdm":yhdm},
		type:"POST",
		dataType:"json,",
		success:function(data){
			alert(data);
			$("#yhid").val(data.yhid);
			$("#yhxm").val(data.yhxm);
			$("#yhkl").val(data.yhkl);
			$("#yhqr").val(data.yhkl);
			$("#yhxb").val(data.yhxb);
			$("#yhbm").val(data.yhbm);
			$("#pxh").val(data.pxh);
			$("#sfjy").val(data.sfjy);
		},
		error:function(){
			alert("修改成功!");
		}
	});
}