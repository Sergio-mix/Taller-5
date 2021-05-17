<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Author</title>
</head>
<body>
<form action="./modify-author">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    Author name: <input type="text" id="name" name="name"required>
    Author country: <input type="text" id="country" name="country"required>

    <input type="submit" value="Modify author">
</form>
</body>
</html>
