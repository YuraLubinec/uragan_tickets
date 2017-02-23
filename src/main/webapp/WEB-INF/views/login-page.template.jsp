<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<form>
	<div class="form-group">
		<input id="login" ng-model="$ctrl.username" type="text" class="form-control" required="required" placeholder="login" /> <span ng-show="authenticationError"
			class="help-block"> Please check your credentials and try again. </span>
	</div>

	<div class="form-group">
		<input id="password" ng-model="$ctrl.password" type="password" class="form-control" required="required" placeholder="password" />
	</div>

	<button ng-click="$ctrl.login()">Login</button>
</form>