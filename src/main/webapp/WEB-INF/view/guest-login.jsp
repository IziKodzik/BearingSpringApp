<%--
  Created by IntelliJ IDEA.
  User: JebanyDis
  Date: 26.08.2020
  Time: 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<html>
<head>
    <title>BearingsFinder - Log in</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/global.css">


</head>
<body>
    <header class="notice">Welcome to BearingFinder </header>

    <section id="login-section" class="form-container">
        <form:form modelAttribute="login-form" method="post" class="form-container">

            <ul id="login-list">


                <li><form:input path="username" placeholder="Username" type='text'/></li>
                <li><form:input path="password" placeholder="Password" type='password'/></li>


                <li><input class="button" formaction="/processLogin" name="logIn" type="submit" value="Log in"/></li>
                <li><input class="button" formaction="/remind" name="RemindPassword" type="submit" value="Remind me password"/></li>

            </ul>

            <form:input path="from" type="hidden" value="${from}"></form:input>

        </form:form>

    </section>

    <div class="popper">${badLogin}</div>

</body>
</html>
