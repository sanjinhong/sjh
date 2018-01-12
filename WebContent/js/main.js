$(document).ready(function(){
	//显示左侧部门树和下拉条中的 部门
	showBmTree();
	
	doQuery();
	//根据用户姓名查询用户姓名
	$("#query").bind("click",function(){
		doQuery();
	})
	$("#add").bind("click",function(){
		window.open("userInfo.jsp?type=add","","top=150,left=400,width=585,height=350");
	})
	
});

function showBmTree(){
	
	$.ajax({
		url : "mainServlet",
		type : "POST",
		dataType:"json",
		success: function(data){
			var bmSelect = $("#bmSelect");
			var bmTree = $("#bmTree");
			bmSelect.append("<option value=''>请选择</option>");
			if(data != null){
				for(var i in data){
					bmSelect.append('<option value="' + data[i].bmdm +'">' + data[i].bmmc +'</option>');
					bmTree.append('<ul><li><a href="#" id="bm" onclick="doQuery(' + data[i].bmdm +');">'+ data[i].bmmc +'</a></li></ul>');
				}
		    }else{
		        alert("无数据");                     
		    }
		},
		error: function(){
			alert("加载部门出错!");
		}
	});
}

function doQuery(bm){
	var yhxm = $("#yhxm").val();
	var yhbm = $("#bmSelect").val();
	$.ajax({
		url : "userSearchServlet",
		data:{"yhxm":yhxm,"yhbm":yhbm,"bm":bm},
		type : "POST",
		dataType:"json",
		success: function(data){
			var user = $("#user");
			user.empty();
			user.append('<tr>' + 
					'<th>排序号</th>' +
					'<th>姓名</th>' +
					'<th>账号</th>' +
					'<th>用户部门</th>' +
					'<th>性别</th>' +
					'<th>查看&nbsp;&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;删除</th>' +
				'</tr>');
			if(data != null){
				for(var i in data){
					user.append('<tr align="center">'+
									'<td>' + data[i].pxh + '</td>' +
									'<td>' + data[i].yhxm + '</td>' +
									'<td>' + data[i].yhid + '</td>' +
									'<td>' + data[i].yhbm + '</td>' +
									'<td>' + data[i].yhxb + '</td>' +
									'<td>' + 
										"<a href='#' onclick='doCheck(\"" + data[i].yhdm + "\");'>查看</a>" + 
										"<a href='#' onclick='doModify(\"" + data[i].yhdm + "\");'>修改</a>" + 
										"<a href='#' onclick='doRemove(\"" + data[i].yhdm + "\");'>删除</a>" +
									'</td>' +
							    '</tr>');
				}
		    }else{
		        alert("无数据");                     
		    }
		},
		error: function(data){
			alert("操作失败!");
		}
	});
}

function doCheck(yhdm){
	window.open("userInfo.jsp?type=check&yhdm="+yhdm,"","top=150,left=400,width=585,height=350");
}

function doModify(yhdm){
	window.open("userInfo.jsp?type=modify&yhdm="+yhdm,"","top=150,left=400,width=585,height=350");
}

function doRemove(yhdm){
	if(confirm("您确定要删除该用户吗？")){
		$.ajax({
			url:"dealUserServlet?type=remove",
			data:{"yhdm":yhdm},
			type:"POST",
			success:function(){
				location.reload(true);
				alert("删除成功!");
			},
			error:function(){
				alert("删除失败!");
			}
		})
	}
	
}