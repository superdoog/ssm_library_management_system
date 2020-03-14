<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的图书</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
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
                    <labela class="navbar-brand">我的图书</labela>
                </div>

                <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/bookSelector">图书查询</a></li>
                        <li><a href="${pageContext.request.contextPath}/rlendList">我的借还</a></li>
                        <li><a href="${pageContext.request.contextPath}/readerInfo">我的信息</a></li>
                    </ul>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/user/exit">退出</a></li>
                    </ul>
                </div>
            </nav>

            <form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/bookSelector">
                <input type="hidden" name="pageIndex" value="1"/>
                <div class="form-group">
                    <input type="text" class="form-control" name="bookName" value="${bookName}"/>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>

            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th>书号</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>现存量</th>
                    <th>详情</th>
                    <th>借阅</th>
                </tr>
                </thead>
                <c:forEach var="book" items="${booklist}" varStatus="status">
                    <tr>
                        <td><span>${book.book_id}</span></td>
                        <td><span>${book.book_name}</span></td>
                        <td><span>${book.author}</span></td>
                        <td><span>${book.number}</span></td>
                        <td><span><a href="${pageContext.request.contextPath}/rBookView?book_id=${book.book_id}">详情</a></span></td>
                        <td><span><a href="${pageContext.request.contextPath}/">借阅</a></span></td>
                    </tr>
                </c:forEach>
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
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bookManagement.js"></script>
</body>
</html>





