<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Taller-5</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style_index.css">
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
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
                <a href="#" class="nav__link active">
                    <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Autor</span>
                </a>
                <a href="#" class="nav__link">
                    <ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Libreria</span>
                </a>

                <div class="nav__link collapse">
                    <ion-icon name="folder-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Projects</span>

                    <ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>

                    <ul class="collapse__menu">
                        <a href="#" class="collapse__sublink">Data</a>
                        <a href="#" class="collapse__sublink">Group</a>
                        <a href="#" class="collapse__sublink">Members</a>
                    </ul>
                </div>

                <a href="#" class="nav__link">
                    <ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
                    <span class="nav__name">Librerias</span>
                </a>
            </div>
        </div>

        <a href="#" class="nav__link">
            <ion-icon name="log-out-outline" class="nav__icon"></ion-icon>
            <span class="nav__name">Salir</span>
        </a>
    </nav>
</div>
<!-- ===== IONICONS ===== -->
<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>

<!-- ===== MAIN JS ===== -->
<script src="js/main.js"></script>


<button onclick="location.href='./form-library.jsp';">Create library</button>
<button onclick="location.href='./form-author.jsp';">Create author</button>

<!-- ===== index ===== -->
<h3>Libraries</h3>

<table id="librariesTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<h3>Authors</h3>

<table id="authorsTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th># Books</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

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

                    if (actions.includes('create-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Create book');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('delete-author')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Delete author');
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
    printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name']);

    // Printing authors
    printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'numBooks'], actions = ['create-book', 'delete-author']);

</script>

</body>
</html>