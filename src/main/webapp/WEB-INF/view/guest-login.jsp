<%--
  Created by IntelliJ IDEA.
  User: JebanyDis
  Date: 26.08.2020
  Time: 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BearingsFinder - Log in</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/global.css">
</head>
<body>

    <section id="login-section" class="form-container">
        <form:form action="/processLogin" modelAttribute="user" method="post" class="form-container">

            <ul id="login-list">

                <li><form:input path="name" placeholder="Your name" type='text'/></li>
                <li><form:input path="password" placeholder="Password" type='password'/></li>


                <li><input class="button" name="logIn" type="submit" value="Log in"/></li>
                <li><input class="button" name="logIn" type="submit" value="Remind me password"/></li>


            </ul>

        </form:form>

    </section>

</body>
</html>
