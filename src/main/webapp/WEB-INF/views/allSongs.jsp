<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Songs</title>
    <link href="<c:url value="/css/allSongs.css"/>" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../js/songs.js"></script>
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
        <a href="allSongs" class="active">Все песни</a>
        <a href="allGenres">Все жанры</a>
        <a href="allArtists">Все исполнители</a>
        <a href="addSong" class="right">Добавить новую</a>
    </div>

<div class="row">
    <div class="side">
        <div class="paginator">
            <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
                <c:url value="/allSongs/" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href="${url}">${i.index}</a>
            </c:forEach>
        </div>
        <div class="songs">
            <table id="songs">
                <c:forEach var="song" items="${songsList}">
                    <tr <c:if test="${song.id eq activeSong.id}">class="activeSong"</c:if>>
                        <td><a href="${pageContext.request.getContextPath()}/allSongs/${song.id}">${song.title}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="main" id="mainBlock">
        <c:if test="${empty activeSong.title}">
            <h2>Выберите песню слева.</h2>
        </c:if>
        <c:if test="${!empty activeSong.title}">
            <h2>
                <a href="${pageContext.request.getContextPath()}/allArtists/${activeSong.artist.id}">${activeSong.artist.name}</a>
                - ${activeSong.title}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/editSong/${activeSong.id}">редактировать</a> <a
                    href="${pageContext.request.getContextPath()}/delete/${activeSong.id}">удалить</a></h5>
            <h4>жанр: <a
                    href="${pageContext.request.getContextPath()}/allGenres/${activeSong.genre.id}">${activeSong.genre.genre}</a><br>longevity: ${activeSong.longevity}
            </h4>
            <p>альбом:
                <a href="${pageContext.request.getContextPath()}/album/${activeSong.album.id}">
                        ${activeSong.album.title}
                </a>
            </p>
            <p>
                дата выхода: ${activeSong.releaseDate}
            </p>
        </c:if>
    </div>
</div>

<div class="footer">
        <h2>Labadabadab</h2>
</div>

</body>
</html>
