<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者登录</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css"/>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Icon -->
        <div class="fadeIn first">
            <p>读者登录</p>
        </div>

        <!-- Login Form -->
        <form method="post" action="${pageContext.request.contextPath}/user/readerLogin">
            <div class="fadeIn second info">${error}</div>
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="username">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

        <!-- Remind Password -->
        <div id="formFooter">
            <a class="underlineHover" href="adminLogin.jsp">管理员登录</a>
        </div>

    </div>
</div>
</body>
</html>
