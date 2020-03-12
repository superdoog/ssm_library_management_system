<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style>
        /*页码*/
        .page-bar {
            position: relative;
            margin-top: 10px;
        }

        .page-num-ul li {
            float: left;
        }

        .page-num-ul li a {
            display: inline-block;
            padding: 3px 5px;
            margin: 0px 3px;
            border: 1px solid #b8b8b8;
        }

        .page-num-ul a:hover, .page-num-ul .thisclass {
            border: 1px solid #c5063f;
            background-color: #c5063f;
            color: #FFF;
            text-decoration: none;
        }

        .page-key {
            width: 50px;
        }

        .page-btn {
            border: 1px solid #b8b8b8;
            background-color: #fff3f8;
            display: inline-block;
            width: 52px;
            height: 25px;
            line-height: 25px;
            font-weight: 20px;
        }

        .page-go-form {
            position: absolute;
            display: inline-block;
            right: 50px;
            top: 0px;
        }

        .page-go-form input, label, button {
            margin: 0px 5px;
        }
    </style>
</head>
<body>
<div class="page-bar">
    <ul class="page-num-ul clearfix">
        <li>共${param.totalCount}条记录&nbsp;&nbsp; ${param.currentPageNo }/${param.totalPageCount }页</li>
        <c:if test="${param.currentPageNo > 1}">
            <a href="javascript:page_nav(document.forms[0],1);">首页</a>
            <a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a>
        </c:if>
        <c:if test="${param.currentPageNo < param.totalPageCount }">
<%--            <a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1 });">下一页</a>--%>
            <a href="javascript:page_nav(document.forms[0],2);">下一页</a>
            <a href="javascript:page_nav(document.forms[0],${param.totalPageCount });">最后一页</a>
        </c:if>
    </ul>
    <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key"/>页
	     <button type="button" class="page-btn"
                 onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
</div>
</body>
<script src="${pageContext.request.contextPath}/bootstrap/js/page.js"></script>
</html>