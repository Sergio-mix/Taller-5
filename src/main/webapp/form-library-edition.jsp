<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./associate-edition">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
    Edition Id: <input type="text" id="edition" name="edition" required>
    <input type="submit" value="Associate-edition">
</form>

</body>
</html>
