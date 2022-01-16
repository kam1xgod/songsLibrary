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
    <title>Album</title>
    <link href="<c:url value="/css/album.css"/>" rel="stylesheet" type="text/css"/>
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
    <a href="/allGenres">All genres</a>
    <a href="/allArtists">All artists</a>
    <a href="/addAlbum" class="right">Add new</a>
</div>

<div class="row">
    <div class="side">
        <div class="albumName">
            <h2>${album.title}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/allArtists/${album.artist.id}">${album.artist.name}</a>
            </h5>
            <p>Release date: ${album.releaseDate}</p>
        </div>
    </div>
    <div class="main">
        <h5><a href="${pageContext.request.getContextPath()}/editAlbum/${album.id}">edit</a> <a
                href="${pageContext.request.getContextPath()}/delete/${album.id}">delete</a></h5>
        <p>Songs:</p>
        <c:forEach var="song" items="${songsInAlbum}">
            <p><a href="${pageContext.request.getContextPath()}/allSongs/${song.id}">${song.title}</a></p>
        </c:forEach>
        <p></p>
    </div>
</div>


<div class="footer">
    <h2>Footer. Please add here some memes. I need memes...</h2>
</div>

</body>
</html>