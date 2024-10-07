<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.DbStore" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <title>Работа мечты</title>
    <script>
        function validate() {
            let error = '';
            if ($('#name').val().length == 0) {
                error += 'Имя\n'
            }
            ;
            if ($('#cities').val() == "Выберите город") {
                error += 'Город\n'
            }
            ;
            if (error.length != 0) {
                alert("Не заполнены поля: \n" + error);
            }
        }
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                crossDomain: true,
                url: 'http://localhost:8080/dreamjob/cities',
                dataType: 'json'
            }).done(function (data) {
                for (var city of data) {
                    $('#cities option:last').after('<option>' + city + '</option>');
                }
            }).fail(function (err) {
                console.log(err);
            });
        });
    </script>
</head>
<body>
<%
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "", "");
    if (id != null) {
        candidate = DbStore.instOf().findCandidateById(Integer.parseInt(id));
    }
%>
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
    <div class="card" style="width: 100%">
        <div class="card-header">
            <% if (id == null) { %>
            Новый кандидат.
            <% } else { %>
            Редактирование карточки кандидата.
            <% } %>
        </div>
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>" method="post">
                <div class="form-group" style="margin: 20px;">
                    <label>Имя</label>
                    <input type="text" class="form-control" name="name" value="<%=candidate.getName()%>" id="name">
                </div>
                <div>
                    <select class="form-select" aria-label="Default select example" name="city" value="<%=candidate.getCity()%>" id="cities">
                        <option selected>Выберите город</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" style="margin-left: 20px; margin-top: 20px;"
                        onclick="validate();">Сохранить
                </button>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
