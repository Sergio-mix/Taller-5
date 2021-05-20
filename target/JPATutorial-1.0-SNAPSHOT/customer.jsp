<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Taller-5</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_index.css">
    <link rel="stylesheet" href="css/module.css">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@1,300&display=swap" rel="stylesheet">
    <script src="js/next.js"></script>
</head>
<body>
<div class="l-navbar" id="navbar">
    <nav class="nav">
        <div>
            <div class="nav__brand">
                <ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle"></ion-icon>
                <a href="#" class="nav__logo">Library Manager</a>
            </div>
            <div class="nav__list">
                <a href="#" class="nav__link" onclick="doOpen('index.jsp')">
                    <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Autor</span>
                </a>

                <a href="#" class="nav__link" onclick="doOpen('library.jsp')">
                    <ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Libreria</span>
                </a>

                <a href="#" class="nav__link" onclick="doOpen('edition.jsp')">
                    <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Edición</span>
                </a>

                <a href="#" class="nav__link" onclick="doOpen('book.jsp')">
                    <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Book</span>
                </a>

                <a href="#" class="nav__link active" onclick="doOpen('customer.jsp')">
                    <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">To list</span>
                </a>

            </div>
        </div>

        <a href="javascript:window.close()" class="nav__link">
            <ion-icon name="log-out-outline" class="nav__icon"></ion-icon>
            <span class="nav__name">Salir</span>
        </a>
    </nav>
</div>
<!-- ===== IONICONS ===== -->
<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>

<!-- ===== MAIN JS ===== -->
<script src="js/main.js"></script>
<!-- ===== menu ===== -->
<h1 id="title-module">Client <span style="color: #d90c43;"> list</span></h1>
<div id="from-module">
    <div>
        <table id="customerTbl">
            <thead>
            <tr id="header">
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <button onclick="location.href='./form-register-customer.jsp';" id="button-regis">Create customer</button>
</div>
<script>
    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);

                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                data.map(d => {

                    var newRow = tbodyRef.insertRow();

                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });

                    if (actions.includes('create-customer')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-register-customer.jsp?email=' + d['email'] + '";');
                        var text = document.createTextNode('Create customer');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('delete-customer')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./delete-customer?email=' + d['email'] + '";');
                        var text = document.createTextNode('Delete customer');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('modify-customer')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-modify-customer.jsp?email=' + d['email'] + '";');
                        var text = document.createTextNode('Modify customer');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);

    }

    // Printing libraries
    printTable(elementId = 'customerTbl', servlet = 'list-customer', columns = ['email', 'firstName', 'lastName', 'gender', 'age'], actions = ['delete-customer', 'modify-customer']);
</script>
</body>
</html>
