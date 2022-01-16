<%--
  Created by IntelliJ IDEA.
  User: kami
  Date: 12/2/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <c:if test="${empty song.title}">
        <title>Add song.</title>
    </c:if>
    <c:if test="${!empty song.title}">
        <title>Edit song.</title>
    </c:if>
    <link href="<c:url value="/css/homePage.css"/>" rel="stylesheet" type="text/css"/>
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
    <a href="" class="right active">Add new</a>
</div>

<div class="row">

    <div class="side">
        <h2>Stay in good vibes.</h2>
        <h5>It's all in your head.</h5>
        <img src='<c:url value="/css/img5.png">img5</c:url>' style="width: 250px; height: 250px;"/>
    </div>

    <div class="main">
        <form:form action="addSong" method="post" modelAttribute="song">
            <label for="title">Title</label>
            <form:input path="title" id="title"/> <br><br>
            <label for="releaseDate">Release date</label>
            <form:input path="releaseDate" id="releaseDate"/> yyyy-MM-dd <br><br>
            <label for="longevity">Longevity</label>
            <form:input path="longevity" id="longevity"/> [00:00:00] <br><br>
            <label for="genre">Genre</label>
            <form:select path="genre" name="genre" id="genre">
                <form:options items="${genreList}" itemLabel="genre" itemValue="id"/>
            </form:select> <br><br>
            <label for="album">Album</label>
            <form:select path="album" name="album" id="album">
                <form:options items="${albumsList}" itemLabel="title" itemValue="id"/>
            </form:select> <br><br>
            <label for="artist">Artist</label>
            <form:select path="artist" name="artist" id="artist">
                <form:options items="${artistList}" itemLabel="name" itemValue="id"/>
            </form:select> <br><br>
            <input type="submit" value="Add new song">
        </form:form>
    </div>
</div>

<div class="footer">
    <h2>Footer. Please add here some memes. I need memes...</h2>
</div>
</body>
</html>