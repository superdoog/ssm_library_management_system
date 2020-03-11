<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书管理</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
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
                        <li><a href="${pageContext.request.contextPath}/bookManager">图书管理</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/lendList">借还管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/readerList">读者管理</a></li>
                    </ul>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/user/exit">退出</a></li>
                    </ul>
                </div>
            </nav>

            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>



            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th>流水号</th>
                    <th>图书号</th>
                    <th>读者号</th>
                    <th>借出日期</th>
                    <th>归还日期</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lend" items="${lendlist}" varStatus="status">
                    <tr>
                        <td><span>${lend.ser_num}</span></td>
                        <td><span>${lend.book_id}</span></td>
                        <td><span>${lend.reader_id}</span></td>
                        <td><span>${lend.lend_date}</span></td>
                        <td><span>${lend.back_date}</span></td>
                        <td><span><a href="#">删除</a></span></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <ul class="pagination">
                <li><a href="#">上一页</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">下一页</a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>





