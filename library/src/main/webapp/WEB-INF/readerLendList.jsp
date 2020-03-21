<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的借还</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css"/>
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
                        <li class="active"><a href="${pageContext.request.contextPath}/toReaderLendList">我的借还</a></li>
                        <li><a href="${pageContext.request.contextPath}/readerInfo">我的信息</a></li>
                    </ul>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/user/exit">退出</a></li>
                    </ul>
                </div>
            </nav>

            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th>流水号</th>
                    <th>图书</th>
                    <th>借出日期</th>
                    <th>归还日期</th>
                    <th>还书</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lend" items="${lendlist}" varStatus="status">
                    <tr>
                        <td><span>${lend.ser_num}</span></td>
                        <td><span>${lend.book_name}</span></td>
                        <td><span><fmt:formatDate value="${lend.lend_date}" pattern="yyyy-MM-dd"/></span></td>
                        <td><span><fmt:formatDate value="${lend.back_date}" pattern="yyyy-MM-dd"/></span></td>
                        <td><span><a class="deleteLend" href="javascript:;" ser_num=${lend.ser_num} book_name=${lend.book_name}>还书</a></span></td>
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

        <!--点击还书后弹出的页面-->
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
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/readerLendList.js"></script>
</html>





