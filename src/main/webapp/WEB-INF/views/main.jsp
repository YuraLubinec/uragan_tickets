<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  ng-app="ticketApp">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap -->
  <link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value = "/resources/dist/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
  
  <!-- jQuery -->
  <script src="<c:url value = "/resources/dist/jQuery/jquery.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/jQuery/jquery.js" />"></script>    
   
  <!-- Bootstrap JS -->
  <script src="<c:url value = "/resources/dist/bootstrap/js/bootstrap.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/bootstrap/js/bootstrap.js" />"></script>
  
  <!-- Angular Js -->
  <script src="<c:url value = "/resources/dist/angular/angular.js" />"></script>
  <script src="<c:url value = "/resources/dist/angular/angular-resource.js" />"></script>
  <script src="<c:url value = "/resources/dist/angular/angular-route.js" />"></script>
  
  <script src="<c:url value = "/resources/app.module.js" />"></script>
  <script src="<c:url value = "/resources/seat-list/seat-list.module.js" />"></script>
  <script src="<c:url value = "/resources/app.config.js" />"></script>
  <script src="<c:url value = "/resources/seat-list/seat-list.component.js" />"></script>
  <script src="<c:url value = "/resources/seat-list/seat-list.service.js" />"></script>
  
</head>
<body>
	<div class="">
		<div ng-view class=""></div>
	</div>
</body>
</html>