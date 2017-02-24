<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="wrapper" ng-if="!$root.access">
	<form class="form-signin">
		<h2 class="form-signin-heading text-center">Будь ласка авторизуйтесь</h2>
		<span ng-show="$ctrl.authenticationError" class="help-block text-center"> Ви ввели невірний логін або пароль, повторіть спробу</span>
		<input id="login" ng-model="$ctrl.username" type="text" class="form-control" required="required" placeholder="Ім'я користувача" /> 		
    <input id="password" ng-model="$ctrl.password" type="password" class="form-control" required="required" placeholder="Пароль" />
		<button ng-click="$ctrl.login()" class="btn btn-primary btn-block">Увійти</button>
	</form>
</div>