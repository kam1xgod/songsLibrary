<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Album</title>
    <link href="<c:url value="/css/album.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Stint+Ultra+Condensed&display=swap" rel="stylesheet">
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
        <a href="addAlbum" class="right">Добавить новый</a>
    </div>

<div class="row">
    <div class="side">
        <div class="albumName">
            <h2>${album.title}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/allArtists/${album.artist.id}">${album.artist.name}</a>
            </h5>
            <p>Дата выхода: ${album.releaseDate}</p>
        </div>
    </div>
    <div class="main">
        <h5><a href="${pageContext.request.getContextPath()}/editAlbum/${album.id}">редактировать</a> <a
                href="${pageContext.request.getContextPath()}/delete/${album.id}">удалить</a></h5>
        <p>Песни:</p>
        <c:forEach var="song" items="${songsInAlbum}">
            <p><a href="${pageContext.request.getContextPath()}/allSongs/${song.id}">${song.title}</a></p>
        </c:forEach>
        <p></p>
    </div>
</div>


<div class="footer">
        <h2>Labadabadab</h2>
</div>

</body>
</html>
