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
    <title>Genres</title>
    <link href="<c:url value="/css/allGenres.css"/>" rel="stylesheet" type="text/css"/>
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
    <a href="/allSongs">All songs</a>
    <a href="/allGenres" class="active">All genres</a>
    <a href="/allArtists">All artists</a>
    <a href="/addGenre" class="right">Add new</a>
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
            <h2>Pick genre from list on left side.</h2>
            <h5>And that's all.</h5>
            <p>There you can find songs and navigate to them.</p>
        </c:if>
        <c:if test="${!empty activeGenre.genre}">
            <h2>${activeGenre.genre}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/editGenre/${activeGenre.id}">edit</a> <a href="/delete/${activeGenre.id}">delete</a></h5>
            <c:forEach var="song" items="${songsWithGenre}">
                <h5><a href="${pageContext.request.getContextPath()}/allSongs/${song.id}">${song.title}</a></h5>
            </c:forEach>
        </c:if>
    </div>
</div>

<div class="footer">
    <h2>Footer. Please add here some memes. I need memes...</h2>
</div>

</body>
</html>
