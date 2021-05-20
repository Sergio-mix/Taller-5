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
    <h1 class="logo">Create <span> Author</span></h1>
    <div class="contact-wrapper animated bounceInUp">
        <div class="contact-form">
            <form action="./create-author">
                <p>
                    <label>Author name</label>
                    <input type="text" id="name" name="name" required>
                </p>
                <p>
                    <label>Author country</label>
                    <input type="text" id="country" name="country" required>
                </p>
                <div class="block">
                    <input id="button-register" type="submit" value="Create author!">
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
