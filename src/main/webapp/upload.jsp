<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Upload</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="row" align="center">
    <ul class="nav">
      <c:if test="${user != null}">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out value="${user.name}"/> | Выйти</a>
        </li>
      </c:if>
      <c:if test="${user == null}">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Войти</a>
        </li>
      </c:if>
    </ul>
  </div>
  <table class="table">
    <thead>
    <tr>
      <th><p align="center">URL</p></th>
      <th><p align="center">View</p></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${images}" var="image" varStatus="status">
      <tr align="center">
        <td><a href="<c:url value='/download?name=${image}'/>"><p align="center">Download</p></a></td>
        <td>
          <img src="<c:url value='/download?name=${image}'/>" align="center" width="150px" height="150px"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <h2>Upload image</h2>
  <form action="<c:url value='/upload'/>" method="post" enctype="multipart/form-data">
    <div class="checkbox">
      <input type="file" name="file">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>
