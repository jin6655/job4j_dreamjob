<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Работа мечты</title>
    <script>
        var display = true;
    </script>
</head>
<body>
<div class="container pt-3">
    <div class="row" align="center">
        <ul class="nav">
            <c:if test="${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out value="${user.name}"/> |
                        Выйти</a>
                </li>
            </c:if>
            <c:if test="${user == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Войти</a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Вакансии
            </div>
            <div>
                <h4 style="margin-left: 50px; margin-top: 20px;">За последний день</h4>
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Вакансия</th>
                        <th scope="col">Редактировать</th>
                        <th>Добавлено</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${postsForDay}" var="post">
                        <tr>
                            <td style="width: 200px;">
                                <c:out value="${post.name}"/>
                            </td>
                            <td style="width: 200px;">
                                <a href='<c:url value="/post/edit.jsp?id=${post.id}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                            </td>
                            <td style="width: 200px;">
                                <c:out value="${post.time}"/>
                            </td>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div>
                <h4 style="margin-left: 50px; margin-top: 20px;">За всё время</h4>
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Вакансия</th>
                        <th scope="col">Редактировать</th>
                        <th>Добавлено</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td style="width: 200px;">
                                <c:out value="${post.name}"/>
                            </td>
                            <td style="width: 200px;">
                                <a href='<c:url value="/post/edit.jsp?id=${post.id}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                            </td>
                            <td style="width: 200px;">
                                <c:out value="${post.time}"/>
                            </td>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
