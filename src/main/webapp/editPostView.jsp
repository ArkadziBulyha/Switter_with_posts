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
            <form action="/post/editPost" method="post" class="border border-light">
                <input type="hidden" name="idPost" value=${requestScope.idPost}>
                <div class="form-floating my-3 px-3">
                    <h1 class="h3 fw-normal">Login: ${requestScope.loginUser} ID Post: ${requestScope.idPost}.</h1>
                        <textarea class="form-control" name="text" id="floatingTextarea2" maxlength="2048" required style="resize: none">
                            ${requestScope.text}
                        </textarea>

                    <button type="submit" class="btn btn-primary mt-2 pr-3">Edit post</button>
                    <button class="btn btn-secondary mt-2 pr-3" type="button" onClick='location.href="/post"'>Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
