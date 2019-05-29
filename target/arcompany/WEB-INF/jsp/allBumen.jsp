<%--
  Created by IntelliJ IDEA.
  User: taoyinrong
  Date: 2019-05-19
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>部门列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    当前部门列表
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>部门列表 —— 显示所有部门</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/BuMen/toInsertBumen">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>部门编号</th>
                    <th>部门名字</th>
                    <th>部门经理</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="Bumen" items="${requestScope.get('list')}" varStatus="status">
                    <tr>
                        <td>${Bumen.departmentID}</td>
                        <td>${Bumen.departmentName}</td>
                        <td>${Bumen.managerID}</td>
                        <td>
                            <a href="${path}/BuMen/allBumen?id=${Bumen.departmentID}">更改</a> |
                            <a href="${path}/BuMen/allBumen?id=${Bumen.departmentID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
