<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Stint+Ultra+Condensed&display=swap" rel="stylesheet">
    <link href="<c:url value="/css/homePage.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

    <div class="header">
        <h1>Музтека.</h1>
        <p>Музыкальная библиотека.</p>
    </div>

    <div class="navbar">
        <a href="/" class="active">Домашняя</a>
        <a href="allSongs">Все песни</a>
        <a href="allGenres">Все жанры</a>
        <a href="allArtists">Все исполнители</a>
    </div>

    <div class="row">
        <div class="side">
            <h2>Лучшие хиты.</h2>
            <h5>Только здесь.</h5>
        </div>
        <div class="main">
            <h2>О проекте.</h2>
            <h5>Можно не читать, в принципе.</h5>
            <p>Простое веб-приложение на Спринге, представляющее собой библиотеку музыки.</p>
        </div>
    </div>

    <div class="footer">
        <h2>Labadabadab</h2>
    </div>
</body>
</html>
