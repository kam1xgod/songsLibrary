<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit album.</title>
    <link href="<c:url value="/css/homePage.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Readex+Pro:wght@300&display=swap" rel="stylesheet">
</head>
<body>


    <div class="header">
        <h1>Музтека.</h1>
        <p>Музыкальная библиотека.</p>
    </div>

    <div class="navbar">
        <a href="/">Домашняя</a>
        <a href="allSongs">Все песни</a>
        <a href="allGenres">Все жанры</a>
        <a href="allArtists">Все исполнители</a>
        <a href="" class="right active">Добавить новый</a>
    </div>

<div class="row">
        <div class="side">
            <h2>Лучшие хиты.</h2>
            <h5>Только здесь.</h5>
        </div>
    <div class="main">
        <form:form method="POST" modelAttribute="album">
            <label for="title">Название</label>
            <form:input path="title" type="text" name="title" id="title"/> <br><br>
            <label for="year">Дата выхода</label>
            <form:input path="releaseDate" type="text" name="year" id="year"/> <br><br>
            <label for="artist">Исполнитель</label>
            <form:select path="artist" name="artist" id="artist">
                <form:options items="${artistList}" itemLabel="name" itemValue="id"/>
            </form:select>
            <input type="submit" value="Edit album">
        </form:form>
    </div>
</div>

<div class="footer">
        <h2>Labadabadab</h2>
</div>
</body>
</html>
