<!doctype html>
<html>
<head>
    <title>Welcome to LibMgmt :: Register</title>
</head>
<body>
<h3>Register here!</h3>
<g:form action="createUser">
    <g:if test="${flash.message}">
        <div>
            <b>${flash.message}</b>
        </div>
    </g:if>
    <p>
        <g:textField name="username" placeholder="Enter username"/>
    </p>
    <p>
        <g:passwordField name="password" placeholder="Enter password"/>
    </p>
    <p>
        Country:
        <%-- <select>
           <g:each in="${countries}" var="country">
               <option value="${country.key}">${country.value}</option>
           </g:each>
        </select> --%>
        <g:select
            name="country"
            from="${countries}"
            optionKey="key"
            optionValue="value"
        />
    </p>
    <p>
        Gender:
        <g:radioGroup name="gender" values="['M', 'F']" labels="['Male', 'Female']" value="F">
            ${it.radio}${it.label}&nbsp;
        </g:radioGroup>
    </p>
    <p>
        <g:submitButton name="register" value="Register" />
    </p>
    <p>
        Already have an account ? <g:link action="login">Sign in here!</g:link>
    </p>
</g:form>
</body>
</html>
