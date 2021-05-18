<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 17/05/2021
  Time: 8:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create edition</title>
</head>
<body>
<form action="./create-edition">
    Description: <input type="text" id="description" name="description"required>
    Release year: <input type="date" id="release" name="release"required>
    Book ID: <input type="text" id="bookId" name="bookId"required>
    <input type="submit" value="Create edition!">
</form>

</body>
</html>
