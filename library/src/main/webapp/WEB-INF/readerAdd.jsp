<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加读者</title>
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
                        <li><a href="#">图书管理</a></li>
                        <li><a href="#">借还管理</a></li>
                        <li class="active"><a href="#">读者管理</a></li>
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
                        <form role="form" action="">
                            <div class="form-group">
                                <label>读者号</label><input type="text" class="form-control" id="book_id"/>
                            </div>
                            <div class="form-group">
                                <label>用户名</label><input type="text" class="form-control" id="book_name"/>
                            </div>
                            <div class="form-group">
                                <label>密码</label><input type="text" class="form-control" id="author"/>
                            </div>
                            <div class="form-group">
                                <label>姓名</label><input type="text" class="form-control" id="number"/>
                            </div>
                            <div class="form-group">
                                <input class="btn btn-default btn-primary " type="submit" value="增加">
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





