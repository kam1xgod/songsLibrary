<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artists</title>
    <link href="<c:url value="/css/allArtists.css"/>" rel="stylesheet" type="text/css"/>
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
        <a href="allArtists" class="active">Все исполнители</a>
        <a href="addAritist" class="right">Добавить нового</a>
    </div>

<div class="row">
    <div class="side">
        <div class="paginator">
            <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
                <c:url value="/allArtists/" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href="${url}">${i.index}</a>
            </c:forEach>
        </div>
        <div class="artists">
            <table id="artists">
                <c:forEach var="artist" items="${artistsList}">
                    <tr <c:if test="${artist.id eq activeArtist.id}">class="activeArtist"</c:if>>
                        <td><a href="${pageContext.request.getContextPath()}/allArtists/${artist.id}">${artist.name}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="main">
        <c:if test="${empty activeArtist.name}">
            <h2>Выберите исполнителя слева.</h2>
        </c:if>
        <c:if test="${!empty activeArtist.name}">
            <h2>${activeArtist.name}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/editArtist/${activeArtist.id}">редактировать</a> <a href="/delete/${activeArtist.id}">удалить</a></h5>
            <p>Альбомы:</p>
            <c:forEach var="album" items="${activeArtist.album}">
                <p><a href="${pageContext.request.getContextPath()}/album/${album.id}">${album.title}</a></p>
            </c:forEach>
            <p></p>
        </c:if>
    </div>
</div>

<div class="footer">
        <h2>Labadabadab</h2>
</div>

</body>
</html>
