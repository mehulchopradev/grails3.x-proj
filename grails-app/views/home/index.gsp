<!doctype html>
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <title>Welcome to LibMgmt :: Login</title>
</head>
<body>
<table border="1">
    <thead>
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Pages</th>
            <th>Publication House</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <g:each in="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.pages}</td>
                <td>${book.publicationHouse.name}</td>
                <td>
                    <g:if test="${book.notYetIssued}">
                        <g:link action="issueBook" id="${book.id}">Issue Book</g:link>
                    </g:if>
                    <g:else>
                        <g:link action="returnBook" id="${book.id}">Return Book</g:link>
                    </g:else>
                </td>
                <td>
                    <g:link action="transfer" id="${book.id}">Transfer book</g:link>
                </td>
            </tr>
        </g:each>
    </tbody>
</table>
</body>
</html>
