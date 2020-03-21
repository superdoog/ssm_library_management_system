<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改读者</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" />
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery.js"></script>
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
                    <labela class="navbar-brand">我的图书</labela>
                </div>

                <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/bookSelector">图书查询</a></li>
                        <li><a href="${pageContext.request.contextPath}/toReaderLendList">我的借还</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/readerInfo">我的信息</a></li>
                    </ul>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/user/exit">退出</a></li>
                    </ul>
                </div>
            </nav>

            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-4 column">
                    </div>
                    <div class="col-md-4 column">
                        <form id="bookForm" name="bookForm" method="post" action="${pageContext.request.contextPath}/updateReader">
                            <input type="hidden" name="reader_id" value="${reader.reader_id}"/>
                            <div>
                                <label for="username">用户名:</label>
                                <input type="text" name="username" id="username" required value="${reader.username}">
                            </div>
                            <div>
                                <label for="password">密 码：</label>
                                <input type="text" name="password" id="password" required value="${reader.password}">
                            </div>
                            <div>
                                <label for="name">姓 名：</label>
                                <input type="text" name="name" id="name" required value="${reader.name}">
                            </div>

                            <div class="nav navbar-nav navbar-right">
                                <input class="btn btn-default btn-primary " type="submit" name="save" id="save" value="保存" />
                                <a href="${pageContext.request.contextPath}/readerInfo">
                                    <input class="btn btn-default btn-primary " type="button" value="返回">
                                </a>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-4 column">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>





