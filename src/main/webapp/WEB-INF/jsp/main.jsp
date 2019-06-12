<%--
  Created by IntelliJ IDEA.
  User: taoyinrong
  Date: 2019-05-18
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<% String appPath = request.getContextPath(); %>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>卡通建筑公司</title>

    <meta name="description" content="Dynamic tables and grids using jqGrid plugin" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="/assets/css/jquery-ui.min.css" />
    <link rel="stylesheet" href="/assets/css/bootstrap-datepicker3.min.css" />
    <link rel="stylesheet" href="/assets/css/ui.jqgrid.min.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="/assets/js/html5shiv.min.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    卡通建筑公司管理平台
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">

        </div>
    </div><!-- /.navbar-container -->
</div>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">

            </div>

        </div><!-- /.sidebar-shortcuts -->

        <ul class="nav nav-list">


            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 人事管理 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="active">
                        <a href="employee.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            雇员表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="${path}/BuMen/allBumen">
                            <i class="menu-icon fa fa-caret-right"></i>
                            部门表
                        </a>

                        <b class="arrow"></b>
                    </li>
                    <li class="active">
                        <a href="${path}/departmentfield/alldepartmentfield">
                            <i class="menu-icon fa fa-caret-right"></i>
                            部门场地
                        </a>

                        <b class="arrow"></b>
                    </li>


                    <li class="active">
                        <a href="dependant.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            受赡养人表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="records_of_managers.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            往届管理者表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="incumbency.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            在职状态表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="customer.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            顾客表
                        </a>

                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>

            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 项目管理 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="active">
                        <a href="${path}/project/allproject">
                            <i class="menu-icon fa fa-caret-right"></i>
                            项目表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="${path}/projectfield/allprojectfield">
                            <i class="menu-icon fa fa-caret-right"></i>
                            项目场地表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="pay.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            付款表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="involve.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            员工参与表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="need.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            材料需求表
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 材料供应 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="active">
                        <a href="material.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            材料表
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="${path}/supplier/allsupplier">
                            <i class="menu-icon fa fa-caret-right"></i>
                            供应商
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="${path}/supply/allsupply">
                            <i class="menu-icon fa fa-caret-right"></i>
                            供应表
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 设置 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="active">
                        <a href="material.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            个人资料设置
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="active">
                        <a href="${path}/supplier/allsupplier">
                            <i class="menu-icon fa fa-caret-right"></i>
                            系统设置
                        </a>

                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>


                </ul>
            </li>
        </ul><!-- /.nav-list -->

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- /.nav-search -->
            </div>

            <div class="page-content">
            <small>
            </small>

                <%
                    Object message = request.getAttribute("message");
                    if(message!=null && !"".equals(message)){

                %>
                <script type="text/javascript">
                    alert("<%=message%>");
                </script>
                <%} %>


            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">卡通</span>
							建筑公司 &copy; 1919-2019
						</span>

                &nbsp; &nbsp;
                <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
            </div>
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="/assets/js/bootstrap-datepicker.min.js"></script>
<script src="/assets/js/jquery.jqGrid.min.js"></script>
<script src="/assets/js/grid.locale-en.js"></script>

<!-- ace scripts -->
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

</body>
</html>

