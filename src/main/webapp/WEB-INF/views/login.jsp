<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html">
<html ng-app="ticketApp">
<head>z
<link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-6 col-md-offset-4">
        <div class="col-md-8">
          <c:if test="${succes==true}">
            <div>
              <p><strong>Ви успішно увійшли до системи!</strong></p>
              <p><a href=<c:url value="/logout" /> class="btn transparent">Вийти</a></p>
            </div>
          </c:if>

          <c:if test="${succes!=true}">
            <div>
              <h3>Будь ласка увійдіть до системи</h3>
             
              <c:if test="${not empty param.error}">
                <div class="alert alert-danger">
                  <strong>Неправильний логін або пароль!</strong>
                </div>
              </c:if>
              
              <form action="${pageContext.request.contextPath}/loginCheck" method="POST">
                <div class="form-group">
                  <label for="pwd">Логін:</label>
                  <input class="form-control" name="username" placeholder="Введіть логін" id="log" autofocus required>
                </div>
                <div class="form-group">
                  <label for="pwd">Пароль:</label>
                  <input class="form-control" type="password" name="password" placeholder="Введіть пароль" id="pwd" required>
                </div>
                <input type="submit" class="btn col-md-12" value="Увійти" />
              </form>
            </div>
          </c:if>
        </div>
      </div>
    </div>
  </div>
</body>
<script src="<c:url value = "/resources/dist/jQuery/jquery.min.js" />"></script>
<script src="<c:url value = "/resources/dist/bootstrap/js/bootstrap.js" />"></script>
</html>