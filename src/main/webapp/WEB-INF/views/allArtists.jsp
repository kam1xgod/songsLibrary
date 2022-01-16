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
    <title>Artists</title>
    <link href="<c:url value="/css/allArtists.css"/>" rel="stylesheet" type="text/css"/>
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
    <a href="/allArtists" class="active">All artists</a>
    <a href="/addArtist" class="right">Add new</a>
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
            <h2>Pick artist from list on left side.</h2>
            <h5>And that's all.</h5>
            <p>There you can find artist's albums and navigate to them.</p>
        </c:if>
        <c:if test="${!empty activeArtist.name}">
            <h2>${activeArtist.name}</h2>
            <h5><a href="${pageContext.request.getContextPath()}/editArtist/${activeArtist.id}">edit</a> <a href="/delete/${activeArtist.id}">delete</a></h5>
            <p>Albums:</p>
            <c:forEach var="album" items="${activeArtist.album}">
                <p><a href="${pageContext.request.getContextPath()}/album/${album.id}">${album.title}</a></p>
            </c:forEach>
            <p></p>
        </c:if>
    </div>
</div>

<div class="footer">
    <h2>Footer. Please add here some memes. I need memes...</h2>
</div>

</body>
</html>