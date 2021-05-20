<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 17/05/2021
  Time: 11:18 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify edition</title>
</head>
<body>
<form action="./modify-edition">
    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">
    Description: <input type="text" id="description" name="description"required>
    Release year: <input type="date" id="release" name="release"required>
    <input type="submit" value="Create edition!">
</form>

</body>
</html>
