<!doctype html>
<html>
<head>
    <title>Welcome to LibMgmt :: Login</title>
</head>
<body>
    <g:if test="${flash.message}">
        <div>
            <b>${flash.message}</b>
        </div>
    </g:if>
    <h3>${greeting}</h3>
    <g:form action="auth">
        <p>
            <g:textField name="username" placeholder="Enter Username"/>
        </p>
        <p>
            <g:passwordField name="password" placeholder="Enter password"/>
        </p>
        <p>
            <g:submitButton name="login" value="Login"/>
        </p>
        <p>
            New User ?<g:link action="register">Sign up here!</g:link>
        </p>
    </g:form>
</body>
</html>
