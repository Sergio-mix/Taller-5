<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_index.css">
    <link rel="stylesheet" href="css/module.css">
    <link rel="stylesheet" href="css/style_to_register.css">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@1,300&display=swap" rel="stylesheet">
</head>
<body>

<div class="content">
    <h1 class="logo">modify <span> Book</span></h1>
    <div class="contact-wrapper animated bounceInUp">
        <div class="contact-form">
            <form action="./create-book">

                    <input type="hidden" id="authorId" name="authorId" value="<%= request.getParameter("authorId") %>">

                <p>
                    <label>Book title</label>
                    <input type="text" id="title" name="title" required>
                </p>
                <p>
                    <label>Book ISBN</label>
                    <input type="text" id="isbn" name="isbn" required>
                </p>
                <p>
                    <label> Book Genre</label>
                    <input type="text" id="genre" name="genre" required>
                </p>
                <div class="block">
                    <input id="button-register" type="submit" value="Create book!">
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
