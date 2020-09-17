<%--
  Created by IntelliJ IDEA.
  User: JebanyDis
  Date: 12.09.2020
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp"%>
    <link href="../../resources/css/application.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="only screen and (max-width:550px)" href="../../resources/css/mobile-app.css">

    <title>Title</title>
</head>
<body>
    calculations
    <div id="application">   <input id="bitmap" type="hidden" value="${appView}">
        <canvas width="680" height="590"></canvas>
        <%--        <img src="../../resources/images/app-views/user0.PNG" alt="app-view">--%>
    </div>
    <div class="test">dziala</div>
    <script src="../../resources/js/user-application.js" type="text/javascript"></script>
</body>
</html>
