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
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
			  <a href="#!/">
			    <img alt="no photo" class="navbar-brand" ng-src="resources/images/Uragan_Logo.png"/>
			  </a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#!/">Головна</a></li>
				<li><a href="#!/game">Ігри</a></li>
				<li><a href="#!/subscription">Абонементи</a></li>
				<li><a href="#!/sector">Сектори</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li>
				  <a href=<c:url value="/logout" /> class="login-logout"> 
				    <span class="glyphicon glyphicon-log-out login-logout" aria-hidden="true"></span> Вийти
				  </a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid ng-cloak" ng-cloak>
		<div ng-view class="view"></div>
	</div>
</body>

<!-- Bootstrap -->
<link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

<!-- Page CSS -->
<link href="<c:url value = "/resources/css/main-page.css" />" rel="stylesheet">
<link href="<c:url value = "/resources/css/game-list.css" />" rel="stylesheet">

<!-- jQuery CSS -->
<link href="<c:url value = "/resources/dist/css/jquery/jquery-ui.css" />" rel="stylesheet">

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
<script src="<c:url value = "/resources/dist/angular/ui-bootstrap.js" />"></script>


<script src="<c:url value = "/resources/app.module.js" />"></script>
<script src="<c:url value = "/resources/login-page/login-page.module.js" />"></script>
<script src="<c:url value = "/resources/main-page/main-page.module.js" />"></script>
<script src="<c:url value = "/resources/game-list/game-list.module.js" />"></script>
<script src="<c:url value = "/resources/subcription-page/subscription-page.module.js" />"></script>
<script src="<c:url value = "/resources/sector-page/sector-page.module.js" />"></script>

<script src="<c:url value = "/resources/app.config.js" />"></script>

<script src="<c:url value = "/resources/login-page/login-page.component.js" />"></script>
<script src="<c:url value = "/resources/login-page/login-page.service.js" />"></script>

<script src="<c:url value = "/resources/main-page/main-page.component.js" />"></script>
<script src="<c:url value = "/resources/main-page/main-page.service.js" />"></script>

<script src="<c:url value = "/resources/game-list/game-list.component.js" />"></script>
<script src="<c:url value = "/resources/game-list/game-list.service.js" />"></script>

<script src="<c:url value = "/resources/subcription-page/subscription-page.component.js" />"></script>
<script src="<c:url value = "/resources/subcription-page/subscription-page.service.js" />"></script>

<script src="<c:url value = "/resources/sector-page/sector-page.component.js" />"></script>
<script src="<c:url value = "/resources/sector-page/sector-page.service.js" />"></script>

</html>

