<%@ include file="header.jsp"%>


<head>
    <title>Bearing Comparer - login page</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/tests.css">
    <header>

        <div class="welcome">Welcome</div>

    </header>

</head>
<body>


<section id="login-section">

    <form:form action="/processLogin" modelAttribute="user" method="post" class="form-container">

        <ul>

            <li><form:input path="name" placeholder="Your name" type='text'/></li>
            <li><form:input path="password" placeholder="Password" type='password'/></li>
            <li><input class="button" name="logIn" type="submit" value="Log in"/></li>
        </ul>

    </form:form>

</section>


</body>
</html>
