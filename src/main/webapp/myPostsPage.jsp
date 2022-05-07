<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.switter.entity.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Posts</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

<div class="container-fluid d-flex justify-content-md-center">

    <div class="row col-6">
        <div class="col mt-3">
            <form action="/post" method="post" class="border border-light">
                <div class="form-floating my-3 px-3">
                        <textarea class="form-control" name="text" placeholder="Leave a text here"
                                  id="floatingTextarea2" style="height: 100px">
                        </textarea>
                    <button type="submit" class="btn btn-primary mt-2 pr-3">Add new post</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container-fluid d-flex justify-content-md-center">
    <div class="row col-6">
        <div class="col mt-3">

            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown button
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/post">Get only my posts</a>
                    <a class="dropdown-item" href="/postHistory">Get all posts</a>
                </div>
            </div>




            <c:set var="result" value="${requestScope.noPosts}"/>

            <c:if test="${result}">
                <p>No posts yet ;(</p>
            </c:if>

            <c:if test="${!result}">

                <div class="form-floating my-3 px-3">
                    <c:forEach var="post" items="${allPosts}">
                        <ul class="list-group list-group-flush" style="margin-top: 15px">
                            <input class="list-group-item">
                                <%--                                <c:set var="idPost" value="${post.idPost}"  scope="page" />--%>
                            <input type="text" name="idPost" value=${post.idPost} hidden>
                            <p class="text-left"> ID: ${post.idPost}</p>
                            <p class="text-left"> User: ${post.user.login}</p>
                            <p class="text-left"> text: ${post.text}</p>
                            <div class="d-inline">
                                <p> likes: ${post.likeList}</p>
                                <p>comments: ${post.commentList}</p>
                            </div>

                            <c:set var="date" value="<%=new java.util.Date()%>"/>
                            <p> date: <fmt:formatDate type="both" value="${date}"/></p>

                                <%--                            <c:if test="${admin}">--%>
                                <%--                                <form action="/post/editPost" method="get">--%>
                                <%--                                    <input type="text" name="idPost" value=${post.idPost} hidden>--%>
                                <%--                                    <button type="submit" name="buttonEdit" class="btn btn-outline-success mt-2 pr-3">--%>
                                <%--                                        Edit post--%>
                                <%--                                    </button>--%>
                                <%--                                </form>--%>

                                <%--                                <form action="/post/deletePost" method="post">--%>
                                <%--                                    <input type="text" name="idPost" value=${post.idPost} hidden>--%>
                                <%--                                    <button type="submit" name="buttonDelete" class="btn btn-outline-danger mt-2 pr-3">--%>
                                <%--                                        Delete post--%>
                                <%--                                    </button>--%>
                                <%--                                </form>--%>
                                <%--                            </c:if>--%>
                            <c:choose>

                                <c:when test="${notAdmin == post.user.login || admin == post.user.login}">
                                    <form action="/post/editPost" method="get">
                                        <input type="text" name="idPost" value=${post.idPost} hidden>
                                        <button type="submit" name="buttonEdit"
                                                class="btn btn-outline-success mt-2 pr-3" >
                                            Edit post
                                        </button>
                                    </form>

                                    <form action="/post/deletePost" method="post">
                                        <input type="text" name="idPost" value=${post.idPost} hidden>
                                        <button type="submit" name="buttonDelete"
                                                class="btn btn-outline-danger mt-2 pr-3" >
                                            Delete post
                                        </button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/post/editPost" method="get">
                                        <input type="text" name="idPost" value=${post.idPost} hidden>
                                        <button type="submit" name="buttonEdit"
                                                class="btn btn-outline-success mt-2 pr-3 disabled">
                                            Edit post
                                        </button>
                                    </form>

                                    <form action="/post/deletePost" method="post">
                                        <input type="text" name="idPost" value=${post.idPost} hidden>
                                        <button type="submit" name="buttonDelete"
                                                class="btn btn-outline-danger mt-2 pr-3 disabled">
                                            Delete post
                                        </button>
                                    </form>
                                </c:otherwise>
                            </c:choose>

                            </li>
                        </ul>
                    </c:forEach>
                </div>
            </c:if>
            <%--            </form>--%>
        </div>
    </div>


    <%--    <form action="/post/editPost" method="post">--%>
    <%--        <input type="text" name="idPost" value="1" hidden >--%>
    <%--        <input type="text" name="text" value="new text">--%>
    <%--        <button type="submit"> save </button>--%>
    <%--    </form>--%>

</div>


<%--<ul class="list-group list-group-flush">--%>
<%--    <li class="list-group-item">Cras justo odio</li>--%>
<%--    <li class="list-group-item">Dapibus ac facilisis in</li>--%>
<%--    <li class="list-group-item">Morbi leo risus</li>--%>
<%--    <li class="list-group-item">Porta ac consectetur ac</li>--%>
<%--    <li class="list-group-item">Vestibulum at eros</li>--%>
<%--</ul>--%>

</body>
</html>
