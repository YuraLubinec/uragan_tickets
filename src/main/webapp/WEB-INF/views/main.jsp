<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html">
<html ng-app="ticketApp" ng-cloak class="ng-cloak">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<navbar></navbar>
	<div class="container-fluid">
		<login-page ng-if="!access"></login-page>
		<div ng-if="access" ng-view class="view"></div>
	</div>
</body>

<!-- Bootstrap -->
<link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

<!-- Page CSS -->
<link href="<c:url value = "/resources/css/main-page.css" />" rel="stylesheet">
<link href="<c:url value = "/resources/css/game-list.css" />" rel="stylesheet">
<link href="<c:url value = "/resources/css/login.css" />" rel="stylesheet">

<!-- jQuery CSS -->
<link href="<c:url value = "/resources/dist/css/jquery/jquery-ui.css" />" rel="stylesheet">

<!-- Angular Material style sheet  -->
<link href="<c:url value = "/resources/css/angular-material/angular-material.min.css" />" rel="stylesheet"> 
 
<!-- mdPickers CSS -->
<link href="<c:url value = "/resources/css/mdPickers/mdPickers.min.css" />" rel="stylesheet"> 

<!-- jQuery -->
<script src="<c:url value = "/resources/dist/jQuery/jquery.min.js" />"></script>
<script src="<c:url value = "/resources/dist/jQuery/jquery.js" />"></script>
<script src="<c:url value = "/resources/dist/jQuery/jquery-ui.js" />"></script>

<!-- Bootstrap JS -->
<script src="<c:url value = "/resources/dist/bootstrap/js/bootstrap.js" />"></script>

<!-- Angular JS -->
<script src="<c:url value = "/resources/dist/angular/angular.js" />"></script>
<script src="<c:url value = "/resources/dist/angular/angular-resource.js" />"></script>
<script src="<c:url value = "/resources/dist/angular/angular-route.js" />"></script>

<!-- ui-bootstrap JS -->
<script src="<c:url value = "/resources/js/ui-bootstrap/ui-bootstrap.js" />"></script>

<!-- Angular Material requires libraries -->
<script src="<c:url value = "/resources/js/angular-material/angular-animate.min.js"/>"></script>
<script src="<c:url value = "/resources/js/angular-material/angular-aria.min.js"/>"></script>

<!-- Angular Material Library -->
<script src="<c:url value = "/resources/js/angular-material/angular-material.min.js"/>"></script>

<!-- Angular Moment JS -->
<script src="<c:url value = "/resources/js/moment/moment.js" />"></script>
<script src="<c:url value = "/resources/js/moment/angular-moment.js" />"></script>

<!-- mdPickers -->
<script src="<c:url value = "/resources/js/angular-material/mdPickers/mdPickers.min.js" />"></script>

<!-- Angular modules definition -->
<script src="<c:url value = "/resources/app.module.js" />"></script>
<script src="<c:url value = "/resources/navbar/navbar.module.js" />"></script>
<script src="<c:url value = "/resources/login-page/login-page.module.js" />"></script>
<script src="<c:url value = "/resources/main-page/main-page.module.js" />"></script>
<script src="<c:url value = "/resources/game-list/game-list.module.js" />"></script>
<script src="<c:url value = "/resources/subcription-page/subscription-page.module.js" />"></script>
<script src="<c:url value = "/resources/sector-page/sector-page.module.js" />"></script>

<script src="<c:url value = "/resources/app.config.js" />"></script>

<!-- Navbar -->
<script src="<c:url value = "/resources/navbar/navbar.component.js" />"></script>
<script src="<c:url value = "/resources/navbar/navbar.service.js" />"></script>

<!-- Login -->
<script src="<c:url value = "/resources/login-page/login-page.component.js" />"></script>
<script src="<c:url value = "/resources/login-page/login-page.service.js" />"></script>

<!-- Main Page -->
<script src="<c:url value = "/resources/main-page/main-page.component.js" />"></script>
<script src="<c:url value = "/resources/main-page/main-page.service.js" />"></script>

<!-- Games -->
<script src="<c:url value = "/resources/game-list/game-list.component.js" />"></script>
<script src="<c:url value = "/resources/game-list/game-list.service.js" />"></script>

<!-- Subscription -->
<script src="<c:url value = "/resources/subcription-page/subscription-page.component.js" />"></script>
<script src="<c:url value = "/resources/subcription-page/subscription-page.service.js" />"></script>

<!-- Sector -->
<script src="<c:url value = "/resources/sector-page/sector-page.component.js" />"></script>
<script src="<c:url value = "/resources/sector-page/sector-page.service.js" />"></script>

</html>

