<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./create-book">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    Book title: <input type="text" id="title" name="title"required>
    <br />
    Book ISBN: <input type="text" id="isbn" name="isbn"required>
    <br />
    <br />
    Book Genre: <input type="text" id="genre" name="genre"required>
    <br />
    <input type="submit" value="Create book!">
</form>

</body>
</html>
