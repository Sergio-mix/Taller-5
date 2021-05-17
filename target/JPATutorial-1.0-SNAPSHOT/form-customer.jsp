<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 16/05/2021
  Time: 9:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<form action="./create-customers">

    Customer email: <input type="text" id="email" name="email"required>
    Customer First Name: <input type="text" id="first_name" name="first_name"required>
    Customer Last Name: <input type="text" id="last_name" name="last_name"required>
    Customer gender: <input type="text" id="gender" name="gender"required>
    Customer age: <input type="number" id="age" name="age"required>
    <input type="submit" value="Create Customer!">
</form>

</body>
</html>
