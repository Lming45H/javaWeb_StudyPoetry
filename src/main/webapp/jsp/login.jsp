<%--
  Created by IntelliJ IDEA.
  User: 26728
  Date: 2022/4/29
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>
<c:if test="${requestScope.mssg!=null&&requestScope.mssg.code!=2}">
    <script>
        alert("${requestScope.mssg.msg}");
    </script>
</c:if>
<div class="container">
    <div class="welcome">
        <div class="pinkbox">
            <div class="signup nodisplay">
                <h1>注册</h1>
                <form autocomplete="off">
                    <input type="text" placeholder="用户名" name="username">
                    <input type="email" placeholder="邮箱" name="email">
                    <input type="password" placeholder="密码" name="password">
                    <input type="password" placeholder="确认密码" name="confirm_password">
                    <button class="button submit">创建账号 </button>
                </form>
            </div>
            <div class="signin">
                <h1>登录</h1>
                <form class="more-padding" autocomplete="off" method="post" onsubmit="return isLogin()" action="${pageContext.request.contextPath}/login">
                    <input type="text" placeholder="邮箱" name="email" required id="email_login">
                    <input type="password" placeholder="密码" name="password" required id="password_login">
                    <div class="checkbox">
                        <input type="checkbox" id="remember" /><label for="remember">记住我</label>
                    </div>
                    <button class="button submit" type="submit">登录</button>
                </form>
            </div>
        </div>
        <div class="leftbox">
            <h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
            <p class="desc">pick your perfect <span>bouquet</span></p>
            <img class="flower smaller" src="${pageContext.request.contextPath}/static/images/flower.jpg" alt="1357d638624297b" border="0">
            <p class="account">have an account?</p>
            <button class="button" id="signin">登录</button>
        </div>
        <div class="rightbox">
            <h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
            <p class="desc"> pick your perfect <span>bouquet</span></p>
            <img class="flower" src="${pageContext.request.contextPath}/static/images/flower2.jpg" />
            <p class="account">don't have an account?</p>
            <button class="button" id="signup">注册</button>
        </div>
    </div>
</div>

</div>
<script src="../static/js/jquery-3.5.1.min.js"></script>
<script src="../static/js/login.js"></script>
</body>
</html>
