<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>借还管理</title>
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
                    <labela class="navbar-brand">图书管理系统</labela>
                </div>

                <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/bookManager">图书管理</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/toLendList">借还管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/readerList">读者管理</a></li>
                    </ul>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/user/exit">退出</a></li>
                    </ul>
                </div>
            </nav>

            <form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/toLendList">
                <span>按读者号搜索:</span>
                <input type="hidden" name="pageIndex" value="1"/>
                <div class="form-group">
                    <input type="text" class="form-control" name="reader_id" value="${reader_id}"/>
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
                        <td><span><fmt:formatDate value="${lend.lend_date}" pattern="yyyy-MM-dd"/></span></td>
                        <td><span><fmt:formatDate value="${lend.back_date}" pattern="yyyy-MM-dd"/></span></td>
                        <td><span><a class="deleteLend" href="javascript:;" ser_num=${lend.ser_num}>删除</a></span></td>
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

        <!--点击删除按钮后弹出的页面-->
        <div class="zhezhao"></div>
        <div class="remove" id="removeUse">
            <div class="removerChid">
                <h2>提示</h2>
                <div class="removeMain">
                    <p>你确定要删除该记录吗？</p>
                    <a href="#" id="yes">确定</a>
                    <a href="#" id="no">取消</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/lendList.js"></script>
</html>





