<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div class = "table-responsive m40">
				<table class="table table-bordered table-add">
	 				<thead>
						<tr>
							<th style="width: 5%">序号</th>
							<th style="width: 20%">用户名</th>
							<th style="width: 30%">用户名称</th>
							<th style="width: 20%">用户类型</th>
							<th style="width: 25%">操作</th>
						</tr>
					</thead>
					<tbody>
				<c:choose>
					<c:when test="${!empty requestScope.users }">
						<c:forEach items="${requestScope.users }" var="cust"
							varStatus="xh">
							<tr>
								<td>${xh.count }</td>
								<td>${cust.username }</td>
								<td>${cust.userCnName }</td>
								<td>
									<c:if test="${cust.userType==0}">智者汇</c:if> 
									<c:if test="${cust.userType==1}">渠道服务商</c:if>
									<c:if test="${cust.userType==2}">终端服务商</c:if>
									<c:if test="${cust.userType==3}">安装专员</c:if>
								</td>
								<td>
									<a onclick="preUpdate(${cust.id })" target="contentF" class = "edit_img" title = "编辑"></a>
									<a onclick="userRole(${cust.id },'${cust.userCnName }')" target="contentF" class = "uList_img" title = "角色列表"></a>
									<a href="#" onclick="isReset(${cust.id })" target="contentF" class = "reset_img" title = "重置密码"></a>
									<a target="contentF" class = "delete_img" title = "删除" onclick="isDelete(${cust.id })" 
										<c:if test="${cust.username == 'admin'}">style="visibility: hidden;"</c:if>>
									</a>
									<a href="javascript:;" target="contentF" 
										<c:if test="${cust.state == 0}">class = "offon_img" title = "启用"</c:if>
										<c:if test="${cust.state == 1}">class = "onoff_img"  title = "关闭"</c:if>
										<c:if test="${cust.username == 'admin'}">style="visibility: hidden;"</c:if>
										 onclick="isOffOn(${cust.id },'${cust.state }');">
									</a>
								  </td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="14">没有找到数据!</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
				</table>
</div>
	<!-- 分页 -->
	<c:if test="${!empty paginator}"> 
		  <c:set var="paginator" value="${paginator}"/>
		  <c:set var="target" value="listDiv"/>
		  <%@include file="../layout/pagination.jsp"%>
	</c:if>		  

<script type="text/javascript">
	//删除
	function isDelete(userId){
		layer.open({
			  type: 1,
			  skin: 'layer-style',
			  area: ['350px','200px'],
			  shadeClose: false, //点击遮罩关闭
			  title:['删除用户'],
			  resize: false,
			  scrollbar:false,
			  content:
			 	'<section class = "content" style = "border:none; height:100%;">'+
							'<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您确定要删除当前用户吗?</p>'+
				'</section>',
			  btn:['确定','取消'],
			  yes: function(index){
				  $.ajax({ 
						type: "post", 
						url: "${ctx}/rest/user/deleteUser?userId="+userId,
						cache:false, 
						async:false, // 此处必须同步
						dataType: "json",
						success: function(xmlobj){
							if(xmlobj.flag==1){
								layer.msg("删除成功！",{icon:1});
								setTimeout(function(){$("#searchForm").submit();},1000);
							}
							if(xmlobj.flag==0){
								layer.msg("删除失败！！",{icon:7});
							}
							layer.close(index);
						} 
					});
				 }
				,success: function (layero) {
				      var btn = layero.find('.layui-layer-btn');
				      btn.css('text-align', 'center');
				  }
			  });
		
	}

	//重置
	function isReset(userId){

		layer.open({
			  type: 1,
			  skin: 'layer-style',
			  area: ['350px','200px'],
			  shadeClose: false, //点击遮罩关闭
			  title:['重置密码'],
			  resize: false,
			  scrollbar:false,
			  content:
			 	'<section class = "content" style = "border:none; height:100%;">'+
							'<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您是否确定重置该用户的密码?</p>'+
				'</section>',
			  btn:['确定','取消'],
			  yes: function(index){
				  $.ajax({ 
						type: "post", 
						url: "${ctx}/rest/user/resetPwd?userId="+userId,
						cache:false, 
						async:false, // 此处必须同步
						dataType: "json",
						success: function(xmlobj){
							if(xmlobj.flag==1){
								layer.msg("已重置！",{icon:1});
							}
							if(xmlobj.flag==0){
								layer.msg("重置失败！！",{icon:7});
							}
							layer.close(index);
						} 
					});
				 }
				,success: function (layero) {
				      var btn = layero.find('.layui-layer-btn');
				      btn.css('text-align', 'center');
				  }
			  });
	}
	//修改
	function preUpdate(userId){
		layer.open({
			type: 2,
			title: ['用户信息'],
			shade: 0.3,
			area: ['500px', '520px'],
			content: ['${ctx}/rest/user/findUser?userId='+userId,'no']
			});
	}
	//角色列表
	function userRole(userId,userName){
		layer.open({
			type: 2,
			title: ['用户角色信息:'+userName],
			shade: 0.3,
			area: ['600px', '450px'],
			content: ['${ctx}/rest/user/userRole?userId='+userId,'yes']
			});
	}
	//查看
	function viewUser(userId){
		layer.open({
			type: 2,
			title: ['用户信息'],
			shade: 0.3,
			area: ['600px', '550px'],
			content: ['${ctx}/rest/user/findUser?userId='+userId,'no']
			});
	}
	//启用关闭
	function isOffOn(userId,state){
		if(state=="0"){
			
			layer.open({
				  type: 1,
				  skin: 'layer-style',
				  area: ['350px','200px'],
				  shadeClose: false, //点击遮罩关闭
				  title:['启用'],
				  resize: false,
				  scrollbar:false,
				  content:
				 	'<section class = "content" style = "border:none; height:100%;">'+
								'<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您是否确定开启该用户?</p>'+
					'</section>',
				  btn:['确定','取消'],
				  yes: function(index){
					  $.ajax({ 
							type: "post", 
							url: "${ctx}/rest/user/offOn?id="+userId+"&state=1",
							cache:false, 
							async:false, // 此处必须同步
							dataType: "json",
							success: function(xmlobj){
								if(xmlobj.flag==1){
									layer.msg("已重新开启！",{icon:1});
								}
								if(xmlobj.flag==0){
									layer.msg("操作失败！！",{icon:7});
								}
								setTimeout(function(){$("#searchForm").submit();},1000);
								layer.close(index);
							}
						});
					 }
					,success: function (layero) {
					      var btn = layero.find('.layui-layer-btn');
					      btn.css('text-align', 'center');
					  }
				  });
		}else{
			layer.open({
				  type: 1,
				  skin: 'layer-style',
				  area: ['350px','200px'],
				  shadeClose: false, //点击遮罩关闭
				  title:['关闭'],
				  resize: false,
				  scrollbar:false,
				  content:
				 	'<section class = "content" style = "border:none; height:100%;">'+
								'<p style = "text-align: center; font-size:16px; color:#000; margin-top:30px;">您是否确定关闭该用户?</p>'+
					'</section>',
				  btn:['确定','取消'],
				  yes: function(index){
					  $.ajax({ 
							type: "post", 
							url: "${ctx}/rest/user/offOn?id="+userId+"&state=0",
							cache:false, 
							async:false, // 此处必须同步
							dataType: "json",
							success: function(xmlobj){
								if(xmlobj.flag==1){
									layer.msg("已关闭！",{icon:1});
								}
								if(xmlobj.flag==0){
									layer.msg("操作失败！！",{icon:7});
								}
								setTimeout(function(){$("#searchForm").submit();},1000);
								layer.close(index);
							}
						});
					 }
					,success: function (layero) {
					      var btn = layero.find('.layui-layer-btn');
					      btn.css('text-align', 'center');
					  }
				  });
		}
	}
</script>
</body>
</html>