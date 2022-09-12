<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Genres</title>
    <link href="<c:url value="/css/allGenres.css"/>" rel="stylesheet" type="text/css"/>
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
        <a href="allGenres" class="active">Все жанры</a>
        <a href="allArtists">Все исполнители</a>
        <a href="addGenre" class="right">Добавить новый</a>
    </div>

<div class="row">
    <div class="side">
        <div class="paginator">
            <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
                <c:url value="/allGenres/" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href="${url}">${i.index}</a>
            </c:forEach>
        </div>
        <div class="genres">
            <table id="genres">
                <c:forEach var="genre" items="${genresList}">
                    <tr <c:if test="${genre.id eq activeGenre.id}">class="activeGenre"</c:if>>
                        <td><a href="${pageContext.request.getContextPath()}/allGenres/${genre.id}">${genre.genre}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="main">
        <c:if test="${empty activeGenre.genre}">
            <h2>Выберите жанр слева.</h2>
        </c:if>
        <c:if test="${!empty activeGenre.genre}">
            <h2>${activeGenre.genre}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/editGenre/${activeGenre.id}">редактировать</a> <a href="/delete/${activeGenre.id}">удалить</a></h5>
            <c:forEach var="song" items="${songsWithGenre}">
                <h5><a href="${pageContext.request.getContextPath()}/allSongs/${song.id}">${song.title}</a></h5>
            </c:forEach>
        </c:if>
    </div>
</div>

<div class="footer">
        <h2>Labadabadab</h2>
</div>

</body>
</html>
