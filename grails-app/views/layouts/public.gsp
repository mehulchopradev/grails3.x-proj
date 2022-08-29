<!doctype html>
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <title>
        <g:layoutTitle default="Welcome!"/>
    </title>
    <asset:stylesheet src="styles.css"/>
    <g:layoutHead/>
</head>
<body>
    <asset:image class="banner" src="banner.jpeg"/>
    <g:if test="${session.user?.username}">
        <h3>Welcome ${session.user.username}!</h3>
        <g:link controller="accounts" action="profile">My Profile</g:link>
        <g:link controller="accounts" action="logout">Logout</g:link>
    </g:if>
    <g:layoutBody/>
    <footer>
        Copyrighted. All rights reserved
    </footer>
</body>
</html>
