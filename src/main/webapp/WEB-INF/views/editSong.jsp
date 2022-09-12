<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit song.</title>
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
        <a href="allSongs" class="active">Все песни</a>
        <a href="allGenres">Все жанры</a>
        <a href="allArtists">Все исполнители</a>
        <a href="" class="right active">Добавить новую</a>
    </div>

<div class="row">
        <div class="side">
            <h2>Лучшие хиты.</h2>
            <h5>Только здесь.</h5>
        </div>

    <div class="main">
        <form:form method="post" modelAttribute="song">
            <label for="title">Название</label>
            <form:input path="title" id="title"/> <br><br>
            <label for="releaseDate">Дата выпуска</label>
            <form:input path="releaseDate" id="releaseDate"/> <br><br>
            <label for="longevity">Длительность</label>
            <form:input path="longevity" id="longevity"/> <br><br>
            <label for="genre">Жанр</label>
            <form:select path="genre" name="genre" id="genre">
                <form:options items="${genreList}" itemLabel="genre" itemValue="id"/>
            </form:select> <br><br>
            <label for="album">Альбом</label>
            <form:select path="album" name="album" id="album">
                <form:options items="${albumsList}" itemLabel="title" itemValue="id"/>
            </form:select> <br><br>
            <label for="artist">Исполнитель</label>
            <form:select path="artist" name="artist" id="artist">
                <form:options items="${artistList}" itemLabel="name" itemValue="id"/>
            </form:select> <br><br>
            <input type="submit" value="Edit song">
        </form:form>
    </div>
</div>

<div class="footer">
        <h2>Labadabadab</h2>
</div>
</body>
</html>
