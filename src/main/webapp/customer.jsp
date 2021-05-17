<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Taller-5</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_to_register.css">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@1,300&display=swap" rel="stylesheet">
    <script src="js/next.js"></script>
</head>
<body>

<!--Form-->
<div class="content">
    <h1 class="logo">Register <span> Client</span></h1>
    <div class="contact-wrapper animated bounceInUp">
        <div class="contact-form">
            <h3>Registry</h3>
            <form action="create-customer">
                <p>
                    <label>Firs name</label>
                    <input type="text" id="txt_first_name" name ="first_name"required>
                </p>
                <p>
                    <label>Last name</label>
                    <input type="text" id="txt_last_name" name ="last_name"required>
                </p>
                <p>
                    <label>Gender</label>
                    <select class="select-item" id="txt_gender"name ="gender" required>
                        <option>Please select...</option>
                        <option>Man</option>
                        <option>Woman</option>
                    </select>
                </p>
                <p>
                    <label>Age</label>
                    <input type="number" id="txt_age"name ="age" required>
                </p>
                <p>
                    <label>Email</label>
                    <input type="email" id="txt_email" name ="email"required>
                </p>
                <div class="block">
                    <input type="submit" id="button-register" >
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
