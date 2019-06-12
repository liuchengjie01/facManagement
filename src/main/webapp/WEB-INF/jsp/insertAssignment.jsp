<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/10 0010
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>新增部门</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <meta name="description" content="Common form elements and layouts" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="/assets/css/jquery-ui.custom.min.css" />
    <link rel="stylesheet" href="/assets/css/chosen.min.css" />
    <link rel="stylesheet" href="/assets/css/bootstrap-datepicker3.min.css" />
    <link rel="stylesheet" href="/assets/css/bootstrap-timepicker.min.css" />
    <link rel="stylesheet" href="/assets/css/daterangepicker.min.css" />
    <link rel="stylesheet" href="/assets/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="/assets/css/bootstrap-colorpicker.min.css" />

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
<body>
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

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    新增任务分配
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>请注意各项填写</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        任务编号：<input type="text" name="task_id"><br><br><br>
        项目编号：<input type="text" name="project_id"><br><br><br>
        任务内容：<input type="text" name="task_content"><br><br><br>
        任务完成度：<input type="text" name="task_completion"><br><br><br>
        任务EF时间：<input type="text" name="task_EFTime"><br><br><br>
        任务RF时间：<input type="text" name="task_RFTime"><br><br><br>
        任务日志：<input type="text" name="task_log"><br><br><br>
        <input type="button" value="添加" onclick="addAssignment()">
    </form>

    <script type="text/javascript">
        function addAssignment() {
            var form = document.forms[0];
            form.action = "<%=basePath %>assignment/insertAssignment";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
</body>
</html>
