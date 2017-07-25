<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@include file="../layout/tablib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<style type="text/css">
			.pagination>li>a:focus, .pagination>li>a:hover, .pagination>li>span:focus, .pagination>li>span:hover {
				background-color:#a9b3c0!important;
				color:#ffffff!important;
			}
			.pagination>li>a, .pagination>li>span {
				color:#666666!important;
			}
			.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover, .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover{
				color:#ffffff!important;
				background-color:#18aec9!important;
			}
     </style>
	<title>智者汇 - 活动管理</title>
</head>
	<body>
	
	<!--活动管理界面-->

			<div class = "table-responsive m40">
				<table class="table table-bordered table-add">
				<col width="20%" >
				<col width="40%" >
				<col width="10%" >
				<col width="10%" >
				<col width="15%" >
	 				<thead>
						<tr>
							<!-- <th>序号</th> -->
							<th>缩略图</th>
							<th>图片说明</th>
							<th>排序</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${bannerList}" var="banner">
						<tr>
							<%-- <td>${banner.id}</td> --%>
							<td><img style="height: 36px;" src="${banner.bannerImg1}" class="suo"/></td>
							<td>${banner.imgDesc}</td>
							<td>${banner.sortOrder}</td>
							<td><c:if test="${banner.enabled =='0'}">关闭</c:if><c:if test="${banner.enabled =='1'}">开放</c:if>  </td>
							<td>
								<a target="contentF" class = "edit_img" title = "编辑" href="${ctx}/rest/banner/enterEditBanner?id=${banner.id}"></a>
								<a onclick="deleteBanner(${banner.id})"  class = "delete_img" title = "删除"></a>
								<!-- <a href="javascript:;" target="contentFrame" class = "admin_img" title = "管理图片"></a> -->
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 分页 -->
			 <c:if test="${!empty paginator}"> 
			    <c:set var="paginator" value="${paginator}"/>
			    <c:set var="target" value="listDiv"/>
			    <%@include file="../layout/pagination.jsp"%>
			 </c:if> 
	<!-- 本页私有js -->
	<script type="text/javascript">
	$(document).ready(function(){
		//checkbox的整体选中
	
		$("#selectAll").on("click",function() {
			if($("input[name = 'selectAll']").is(":checked")){
				$("table td input").each(function(){
					$(this)[0].checked = true;
				})
			}
			if(!($("input[name = 'selectAll']").is(":checked"))){
				$("table td input").each(function(){
					$(this)[0].checked = false;
				})
			}
		})
	})
	

	</script>
	</body>
</html>
