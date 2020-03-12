<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>读者管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" />
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1"><span
                            class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span></button>
                    <labela class="navbar-brand">图书管理系统</labela>
                </div>

                <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/bookManager">图书管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/lendList">借还管理</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/readerList">读者管理</a></li>
                    </ul>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/user/exit">退出</a></li>
                    </ul>
                </div>
            </nav>

            <form class="navbar-form navbar-right" role="search">
                <input type="hidden" name="pageIndex" value="1"/>
                <div class="form-group">
                    <input type="text" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>

            <button type="button" class="btn btn-default btn-primary navbar-left" href="#">增加读者</button>

            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th>读者号</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reader" items="${readerlist}" varStatus="status">
                    <tr>
                        <td><span>${reader.reader_id}</span></td>
                        <td><span>${reader.username}</span></td>
                        <td><span>${reader.password}</span></td>
                        <td><span>${reader.name}</span></td>
                        <td><span><a href="#">编辑</a></span></td>
                        <td><span><a href="#">删除</a></span></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
            <c:import url="page.jsp">
                <c:param name="totalCount" value="${totalCount}"/>
                <c:param name="currentPageNo" value="${currentPageNo}"/>
                <c:param name="totalPageCount" value="${totalPageCount}"/>
            </c:import>

        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery.js"></script>
</html>





