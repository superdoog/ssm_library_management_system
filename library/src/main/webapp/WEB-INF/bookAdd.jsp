<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>增加书籍</title>
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

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/bookManager">图书管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/lendList">借还管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/readerList">读者管理</a></li>
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
                        <form role="form" method="post" action="${pageContext.request.contextPath}/addBook">
                            <div class="form-group">
                                <label>书号</label><input type="text" class="form-control" id="book_id" name="book_id" required/>
                            </div>
                            <div class="form-group">
                                <label>书名</label><input type="text" class="form-control" id="book_name" name="book_name" required/>
                            </div>
                            <div class="form-group">
                                <label>作者</label><input type="text" class="form-control" id="author" name="author" required/>
                            </div>
                            <div class="form-group">
                                <label>现量</label><input type="text" class="form-control" id="number" name="number" required/>
                            </div>
                            <div class="form-group">
                                <label>总量</label><input type="text" class="form-control" id="total" name="total" required/>
                            </div>
                            <div class="form-group">
                                <input class="btn btn-default btn-primary " type="submit" value="增加">

                                <a href="${pageContext.request.contextPath}/bookManager">
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





