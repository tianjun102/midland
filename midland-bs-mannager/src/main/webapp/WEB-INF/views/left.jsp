<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="${pageContext['request'].contextPath}" />
<!DOCTYPE html>
<html lang="en" style  = "height:100%;">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>智者汇 - 经营管理平台</title>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/assets/css/common.css">
</head>
<body
	style="background-color: #eff2f6; border-right: 1px solid #d8dde0; overflow-x:hidden; height:100%;">
	<!--左侧导航-->
	<nav class="nav">
		<shiro:hasPermission name="custManage">
			<dl class="list-left1">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/01.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/01_w.png) no-repeat 20px center">预约管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="arealist">
						<a id = "areaIndex" href="${ctx}/rest/cust/areaIndex" target="contentF"><span>预约记录</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="custlist">
						<a id = "custIndex" href="${ctx}/rest/cust/custIndex" target="contentF"><span>客户列表</span></a>
					</shiro:hasPermission>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="product">
			<dl class="list-left2">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/02.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/02_w.png) no-repeat 20px center">资讯管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="categoryList">
						<a id = "showCategoryIndex" href="${ctx}/rest/product/showCategoryIndex" target="contentF"><span>分类</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="productList">
						<a id = "showProductIndex" href="${ctx}/rest/product/showProductIndex" target="contentF"><span>产品列表</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="kctzdList">
						<a id = "showKctzdIndex" href="${ctx}/rest/stock/showKctzdIndex" target="contentF"><span>库存调整单</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="queryList">
						<a id = "stockQueryIndex" href="${ctx}/rest/stock/stockQueryIndex" target="contentF"><span>库存查询</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="distPlanList">
						<a id = "showDistPlanIndex" href="${ctx}/rest/distPlan/showDistPlanIndex" target="contentF"><span>产品分销区域</span></a>
					</shiro:hasPermission>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="noticelist">
			<dl class="list-left3">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/03.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/03_w.png) no-repeat 20px center">委托管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="noticelist">
						<a id = "enterPromotionIndex" href="${ctx}/rest/promotion/enterPromotionIndex" target="contentF"><span>委托记录</span></a>
					</shiro:hasPermission>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="orderInfo">
			<dl class="list-left4">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/04.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/04_w.png) no-repeat 20px center">买房助手<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="orderInfoList">
						<a id = "showOrderInfoIndex" href="${ctx}/rest/order/showOrderInfoIndex" target="contentF"><span>问答管理</span></a>
					</shiro:hasPermission>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="settlement">
			<dl class="list-left5">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/05.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/05_w.png) no-repeat 20px center">行情信息管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="settlementList">
						<a id = "settlementIndex" target="contentF" href="${ctx}/rest/settlement/settlementIndex"><span>行情信息列表</span></a>
					</shiro:hasPermission>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="dataTable">
			<dl class="list-left6">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/06.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/06_w.png) no-repeat 20px center">市场调究管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="showCustDataTable">
						<a id = "report1" href="${ctx}/rest/dataTable/showCustDataTable" target="contentF"><span>市场调究列表</span></a>
					</shiro:hasPermission>
					<%-- <shiro:hasPermission name="showOrderDataTable">
						<a id = "report2" href="${ctx}/rest/dataTable/showOrderDataTable" target="contentF"><span>订单统计</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="showProductDataTable">
						<a id = "report3" href="${ctx}/rest/dataTable/showProductDataTable" target="contentF"><span>商品排行统计</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="showPriceDataTable">
						<a id = "report4" href="${ctx}/rest/dataTable/showPriceDataTable" target="contentF"><span>财务统计</span></a>
					</shiro:hasPermission> --%>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="noticelist">
			<dl class="list-left7">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/07.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/07_w.png) no-repeat 20px center">内容管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="noticelist">
						<a id = "content1" href="${ctx}/rest/class/index" target="contentF"><span>栏目管理</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="noticelist">
						<a id = "content2" href="${ctx}/rest/activity/index" target="contentF"><span>活动管理</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="noticelist">
						<a id = "content3" href="${ctx}/rest/ad/listindex" target="contentF"><span>广告管理</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="noticelist">
						<a id = "content4" href="${ctx}/rest/banner/bannerindex" target="contentF"><span>Banner管理</span></a>
					</shiro:hasPermission>
				</dd>
			</dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="systemManage">
			<dl class="list-left8">
				<dt>
					<a href="javascript:;"
						dota="url(${ctx}/assets/img/08.png) no-repeat 20px center"
						data-img="url(${ctx}/assets/img/08_w.png) no-repeat 20px center">系统管理<span
						class="glyphicon glyphicon-menu-right"></span></a>
				</dt>
				<dd>
					<shiro:hasPermission name="noticelist">
						<a id = "system1" href="${ctx}/rest/notice/noticeIndex" target="contentF"><span>公告管理</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="noticelist">
						<a id = "system2" href="${ctx}/rest/product/rcms" target="contentF"><span>系统设置</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="backupList">
						<a id = "system3" href="${ctx}/rest/dataBackup/index" target="contentF"><span>数据备份</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="userList">
						<a id = "system4" href="${ctx}/rest/user/userIndex" target="contentF"><span>用户列表</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="rolelist">
						<a id = "system5" href="${ctx}/rest/role/roleIndex" target="contentF"><span>角色列表</span></a>
					</shiro:hasPermission>
					<shiro:hasPermission name="sysLoglist">
						<a id = "system6" href="${ctx}/rest/sysLog/sysLogIndex" target="contentF"><span>系统日志</span></a>
					</shiro:hasPermission>
						<a id = "system7" href="${ctx}/rest/user/toModifyPwdPage" target="contentF"><span>修改密码</span></a>
						<a id = "system8" href="${ctx}/rest/user/about" target="contentF"><span>关于平台</span></a>
				</dd>
			</dl>
		</shiro:hasPermission>
	</nav>
	<script type="text/javascript"
		src="${ctx}/assets/scripts/jquery.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/scripts/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/scripts/common.js"></script>
	<!-- 本页私有js -->
	<script type="text/javascript">
		$(document).ready(
				function() {

					intImg();

					var my_body = $("body").height();
				

					$(".nav dt a").click(
							function() {

								var $dt = $(".nav dt a").parent();

								var $dd = $(this).parent().next();

								var $a = $(".nav dt a");

								if ($dd.is(":hidden")) {

									$a.children().removeClass(
											'glyphicon glyphicon-menu-down');
									$a.children().addClass(
											'glyphicon glyphicon-menu-right');
									$(this).find('span').addClass(
											'glyphicon glyphicon-menu-down');

								}
								if ($dd.is(":visible")) {

									$(this).find('span').removeClass(
											'glyphicon glyphicon-menu-down');
									$(this).find('span').addClass(
											'glyphicon glyphicon-menu-right');
								}

								$dt.next().slideUp(400);

								if ($dd.is(":hidden")) {

									$dd.slideDown(400);

								}

								$dt.removeClass("turnBK");
								$(this).parent().addClass("turnBK");

								$a.removeClass("turnWH");
								$(this).addClass("turnWH");

								intImg();

								if ($dt.hasClass("turnBK")) {
									var dataImg = $(this).attr("data-img");
									$(this).css("background", dataImg);
								}

							});

					$(".nav dd a").addClass("other-list");
					$(".nav dd a").click(function() {
						$(".nav dd a").removeClass("current-list");
						$(this).addClass("current-list");
					})
				});
		function intImg() {
			var $a = $(".nav dt a");
			var arrlist = [];
			var len = $a.length;
			for (var i = 0; i < len; i++) {
				arrlist.push($a.eq(i).attr("dota"));
				$a.eq(i).css("background", arrlist[i]);
			}
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("a").click(function(event) {
				var e = event || window.event;
				if ($(this)[0].href) {
					var path = $(this)[0].getAttribute("href");
					sessionStorage.setItem("href", path);
				} 
				if ($(this)[0].id) {
					var id = $(this)[0].getAttribute("id");
					sessionStorage.setItem("ID", id);
				}

			})
		})

		window.onload = function() {
			var id_a = sessionStorage.getItem("ID");
			if (id_a) {
				$("#" + id_a).addClass("current-list");
				$("#" + id_a).parent().siblings().addClass("turnBK");
				$("#" + id_a).parent().siblings().children().addClass("turnWH");

				if ($("#" + id_a).parent().siblings().hasClass("turnBK")) {
					var dataImg = $("#" + id_a).parent().siblings().children()
							.attr("data-img");
					$("#" + id_a).parent().siblings().children().css(
							"background", dataImg);
				}
				if ($("#" + id_a).parent().is(":hidden")) {
					$("#" + id_a).parent().siblings().children().find('span')
							.removeClass('glyphicon glyphicon-menu-down');
					$("#" + id_a).parent().siblings().children().find('span')
							.addClass('glyphicon glyphicon-menu-down');
					$("#" + id_a).parent().slideDown(400);
				}
			}
		}
	</script>
</body>
</html>
