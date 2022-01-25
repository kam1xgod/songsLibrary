<%--
  Created by IntelliJ IDEA.
  User: kami
  Date: 12/2/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
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
        <a href="/" class="active">Home</a>
        <a href="allSongs">All songs</a>
        <a href="allGenres">All genres</a>
        <a href="allArtists">All artists</a>
<%--        <a href="add" class="right">Add new</a>--%>
    </div>

    <div class="row">
        <div class="side">
            <h2>Stay in good vibes.</h2>
            <h5>It's all in your head.</h5>
            <img src='<c:url value="/css/img5.png">img5</c:url>' style="width: 250px; height: 250px;"/>
        </div>
        <div class="main">
            <h2>About project.</h2>
            <h5>I don't mind if you will not read it at all.</h5>
            <img src='<c:url value="/css/img2.jpg">img2</c:url>' style="width: 250px; height: 250px; opacity: 55%;"/>
            <p>This is a simple Spring Hibernate web application that represents some kind of songs search or library. Doesn't matter actually.</p>
            <p>Maybe I'll change the subject but for now it's okay. You can simply navigate to any page from the top bar. Good luck!</p>
        </div>
    </div>

    <div class="footer">
        <h2>Footer. Please add here some memes. I need memes...</h2>
    </div>
</body>
</html>
