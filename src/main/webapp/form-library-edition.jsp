<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./associate-education">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
    Edition name: <input type="text" id="name" name="name" required>
    <input type="submit" value="Associate-edition">
</form>

</body>
</html>
