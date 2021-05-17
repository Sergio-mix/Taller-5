<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify book</title>
</head>
<body>

<form action="./modify-book">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">

    Book title: <input type="text" id="title" name="title" required>
    <br />
    Book ISBN: <input type="text" id="isbn" name="isbn"required>
    <br />
    <br />
    Book Genre: <input type="text" id="genre" name="genre"required>
    <br />
    <input type="submit" value="Modify book!">
</form>

</body>
</html>
