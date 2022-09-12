<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add artist.</title>
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
        <a href="allArtists" class="active">Все исполнители</a>
        <a href="" class="right">Добавить нового</a>
    </div>

<div class="row">
        <div class="side">
            <h2>Лучшие хиты.</h2>
            <h5>Только здесь.</h5>
        </div>
    <div class="main">
        <form:form action="addArtist" method="POST" modelAttribute="artist">
            <label for="name">Исполнитель</label>
            <form:input path="name" type="text" name="name" id="name"/> <br><br>
            <input type="submit" value="Add new artist">
        </form:form>
    </div>
</div>

<div class="footer">
        <h2>Labadabadab</h2>
</div>
</body>
</html>
