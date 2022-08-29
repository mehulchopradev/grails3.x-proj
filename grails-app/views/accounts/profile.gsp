<!doctype html>
<html>
<head>
    <title>Welcome to LibMgmt :: My Profile</title>
</head>
<body>
<g:form action="updateProfile">
    <g:if test="${flash.message}">
        <div>
            <b>${flash.message}</b>
        </div>
    </g:if>
    <p>
        <g:textField name="username" placeholder="Enter username" value="${session.user.username}" readonly="readonly"/>
    </p>
    <p>
        Country:
        <g:select
                name="country"
                from="${countries}"
                optionKey="key"
                optionValue="value"
                value="${session.user.country}"
        />
    </p>
    <p>
        Gender:
        <g:radioGroup name="gender" values="['M', 'F']" labels="['Male', 'Female']" value="${session.user.gender}">
            ${it.radio}${it.label}&nbsp;
        </g:radioGroup>
    </p>
    <p>
        <g:textField name="contact.mobile" value="${session.user.contact.mobile}"/>
    </p>
    <p>
        <g:textField name="contact.websiteUrl" value="${session.user.contact.websiteUrl}"/>
    </p>
    <p>
        <g:submitButton name="save" value="Save" />
    </p>
</g:form>
</body>
</html>
