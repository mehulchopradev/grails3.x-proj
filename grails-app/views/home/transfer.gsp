<!doctype html>
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <title>Welcome to LibMgmt :: Login</title>
</head>
<body>
    <h2>${book.title}</h2>
    <h3>Select student</h3>
    <g:form action="performTransfer">
        <g:hiddenField name="bookId" value="${book.id}"/>
        <g:select name="studentId" from="${students}" optionKey="id"/><br>
        <button type="submit">Transfer</button>
    </g:form>
</body>
</html>
