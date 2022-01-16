<%--
  Created by IntelliJ IDEA.
  User: kami
  Date: 12/3/2021
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Songs</title>
    <link href="<c:url value="/css/allSongs.css"/>" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../js/songs.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Readex+Pro:wght@300&display=swap" rel="stylesheet">
</head>
<body>

<div class="header">
    <h1>Songs Library/Search.</h1>
    <p>My <b> university </b> project for coursework.</p>
</div>

<div class="navbar">
    <a href="/">Home</a>
    <a href="/allSongs" class="active">All songs</a>
    <a href="/allGenres">All genres</a>
    <a href="/allArtists">All artists</a>
    <a href="/addSong" class="right">Add new</a>
<%--

--%>
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
            <h2>Pick songs from list on left side.</h2>
            <h5>And that's all.</h5>
            <p>There you can find song's artist, album, genre, release date and longevity.</p>
            <p>You can edit or delete the song if you want. You also can navigate to anything from it!</p>
        </c:if>
        <c:if test="${!empty activeSong.title}">
            <h2>
                <a href="${pageContext.request.getContextPath()}/allArtists/${activeSong.artist.id}">${activeSong.artist.name}</a>
                - ${activeSong.title}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/editSong/${activeSong.id}">edit</a> <a
                    href="${pageContext.request.getContextPath()}/delete/${activeSong.id}">delete</a></h5>
            <h4>genre: <a
                    href="${pageContext.request.getContextPath()}/allGenres/${activeSong.genre.id}">${activeSong.genre.genre}</a><br>longevity: ${activeSong.longevity}
            </h4>
            <p>from album:
                <a href="${pageContext.request.getContextPath()}/album/${activeSong.album.id}">
                        ${activeSong.album.title}
                </a>
            </p>
            <p>
                release date: ${activeSong.releaseDate}
            </p>
        </c:if>
    </div>
</div>

<div class="footer">
    <h2>Footer. Please add here some memes. I need memes...</h2>
</div>

</body>
</html>
