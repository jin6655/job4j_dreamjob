<%@ page contentType="text/html; charset=UTF-8" %>
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
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="row" align="center">
            <ul class="nav">
                <c:if test="${user != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out
                                value="${user.name}"/> | Выйти</a>
                    </li>
                </c:if>
                <c:if test="${user == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Войти</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <div>
                    <h4 style="margin: 30px;">За последний день</h4>
                </div>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Редактировать</th>
                        <th>Имя</th>
                        <th>Город</th>
                        <th>Фото</th>
                        <th>Редактировать фото</th>
                        <th>Дата регистрации</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${candidatesForDay}" var="can">
                        <tr>
                            <td style="width: 50px;">
                                <a href='<c:url value="/candidate/edit.jsp?id=${can.id}"/>'>
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                            </td>
                            <td style="width: 150px;">
                                <c:out value="${can.name}"/>
                            </td>
                            <td style="width: 100px;">
                                <c:out value="${can.city}"/>
                            </td>
                            <td style="width: 150px;">
                                <img src="<c:url value='/download?id=${can.id}'/>" width="150px" height="150px"/>
                            </td>
                            <td style="width: 150px;">
                                <table class="table">
                                    <tr>
                                        <a href="<c:url value="/photoUpload?id=${can.id}"/>"><p align="center">Добавить
                                            фото</p>
                                        </a>
                                    </tr>
                                    <tr>
                                        <form action="<c:url value='/deletePhoto?id=${can.id}'/>" method="post"
                                              enctype="multipart/form-data">
                                            <button type="submit" class="btn btn-default" style="margin-left: 30px;">
                                                Удалить фото
                                            </button>
                                        </form>
                                    </tr>
                                </table>
                            </td>
                            <td style="width: 100px;">
                                <c:out value="${can.time}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div>
                    <h4 style="margin: 30px;">За всё время</h4>
                </div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Редактировать</th>
                            <th>Имя</th>
                            <th>Город</th>
                            <th>Фото</th>
                            <th>Редактировать фото</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${candidates}" var="can">
                            <tr>
                                <td style="width: 50px;">
                                    <a href='<c:url value="/candidate/edit.jsp?id=${can.id}"/>'>
                                        <i class="fa fa-edit mr-3"></i>
                                    </a>
                                </td>
                                <td style="width: 150px;">
                                    <c:out value="${can.name}"/>
                                </td>
                                <td style="width: 100px;">
                                    <c:out value="${can.city}"/>
                                </td>
                                <td style="width: 150px;">
                                    <img src="<c:url value='/download?id=${can.id}'/>" width="150px"
                                         height="150px"/>
                                </td>
                                <td style="width: 150px;">
                                    <table class="table">
                                        <tr>
                                            <a href="<c:url value="/photoUpload?id=${can.id}"/>"><p align="center">
                                                Добавить
                                                фото</p>
                                            </a>
                                        </tr>
                                        <tr>
                                            <form action="<c:url value='/deletePhoto?id=${can.id}'/>" method="post"
                                                  enctype="multipart/form-data">
                                                <button type="submit" class="btn btn-default"
                                                        style="margin-left: 30px;">Удалить фото
                                                </button>
                                            </form>
                                        </tr>
                                    </table>
                                </td>
                                <td style="width: 100px;">
                                    <c:out value="${can.time}"/>
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
</div>
</body>
</html>