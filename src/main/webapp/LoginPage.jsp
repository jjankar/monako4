<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Project Monaco</title>
</head>
<link href="<c:url value="/LoginPageCSS.css" />" rel="stylesheet">
<body>
    <form id="loginForm" action="LoginActionJSP.jsp" method="POST">
        <div id="loginDiv">
            Nickname:<br>
            <input id="lNickName" type="text" name="lNickName">
            <br>
            Password:<br>
            <input id="lPassword" type="text" name="lPassword">
            <br>
            <br>
            <button type="login" value="Login"/>
        </div>
    </form>

    <form id="registrationForm" action="LoginActionJSP.jsp" method="POST">
        <div id="registerDiv">
            Name:<br>
            <input id="rName" type="text" name="rName">
            <br>
            Surname:<br>
            <input id="rSurname" type="text" name="rSurname">
            <br>
            Nickname:*<br>
            <input id="rNickname" type="text" name="rNickname">
            <br>
            Password:*<br>
            <input id="rPassword" type="text" name="rPassword">
            <br>
            Email:*<br>
            <input id="rEmail" type="text" name="rEmail">
            <br>
            Age:<br>
            <input id="rAge" type="text" name="rAge">
            <br>
            City:*<br>
            <input id="rCity" type="text" name="rCity">
            <br>
            Country:*<br>
            <input id="rCountry" type="text" name="rCountry">
            <br>
            Tag:<br>
            <input id="rTag" type="text" name="rTag">
            <br>
            <br>
            <button type="register" value="Register"/>
        </div>
    </form>

</body>
</html>