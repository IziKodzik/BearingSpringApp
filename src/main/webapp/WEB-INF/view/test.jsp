<%--
  Created by IntelliJ IDEA.
  User: JebanyDis
  Date: 31.08.2020
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/test" modelAttribute="JWT" method="post" class="form-container">

    <ul id="login-list">
        <li><input class="button" formaction="/processLogin" name="logIn" type="submit" value="Log in"/></li>
        <li><input class="button" formaction="/remind" name="RemindPassword" type="submit" value="Remind me password"/></li>


    </ul>

</form:form>
</body>
</html>
