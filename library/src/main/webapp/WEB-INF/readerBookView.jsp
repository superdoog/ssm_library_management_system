<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书详情</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css"/>
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
                        <li class="active"><a href="${pageContext.request.contextPath}/bookSelector">图书查询</a></li>
                        <li><a href="${pageContext.request.contextPath}/rlendList">我的借还</a></li>
                        <li><a href="${pageContext.request.contextPath}/">我的信息</a></li>
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
                        <div class="row">
                            <div class="col-md-12">
                                <div class="thumbnail">

                                    <div class="caption">
                                        <p><strong>书号：</strong><span>${book.book_id}</span></p>
                                        <p><strong>书名：</strong><span>${book.book_name}</span></p>
                                        <p><strong>作者：</strong><span>${book.author}</span></p>
                                        <p><strong>现量：</strong><span>${book.number}</span></p>
                                        <p><strong>总量：</strong><span>${book.total}</span></p>
                                    </div>
                                </div>
                                <a href="${pageContext.request.contextPath}/bookSelector">
                                    <input class="btn btn-default btn-primary " type="button" value="返回">
                                </a>
                            </div>
                        </div>
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





