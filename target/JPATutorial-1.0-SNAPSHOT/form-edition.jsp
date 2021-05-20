<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create edition</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_index.css">
    <link rel="stylesheet" href="css/module.css">
    <link rel="stylesheet" href="css/style_to_register.css">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@1,300&display=swap" rel="stylesheet">
</head>
<body>
<div class="content">
    <h1 class="logo">Create <span> Edition</span></h1>
    <div class="contact-wrapper animated bounceInUp">
        <div class="contact-form">
            <d action="./modify-book">
                <form action="./create-edition">
                    <p>
                        <label>Description</label>
                        <input type="text" id="description" name="description" required>
                    </p>

                    <p>
                        <label> Release year</label>
                        <input type="date" id="release" name="release" required>
                    </p>
                    <p>
                        <label>Book ID</label>
                        <input type="text" id="bookId" name="bookId" required>
                    </p>

                    <div class="block">
                        <input id="button-register" type="submit" value="Create edition!">
                    </div>

                </form>
        </div>
    </div>
</div>
</body>
</html>
