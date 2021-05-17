<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 16/05/2021
  Time: 5:50 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify library</title>
</head>
<body>
<form action="./modify-library">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
    Library name: <input type="text" id="name" name="name" required>
    <input type="submit" value="Create library!">
</form>

</body>
</html>
