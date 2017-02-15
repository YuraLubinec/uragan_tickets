<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="bordered add-margin-top">
	<div class="row">
		<div class="col-md-12 col-lg-12">
			<div class="form-group col-md-2 col-lg-2">
				<label for="sector">Сектори :</label> 
				<select id="sector" class="form-control" ng-model="$ctrl.sector" ng-options="sector.name for sector in $ctrl.sectors"
					ng-change="$ctrl.price = $ctrl.sector.price">
					<option value="" disabled>Оберіть гру</option>
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-lg-12">
			<div class="form-group col-md-2 col-lg-2">
				<form name="form" ng-submit="$ctrl.submit()" ng-if="$ctrl.sector != null">
					<div class="form-group" for="price">
						<label for="price">Ціна :</label>
						<input name="input" id="price" ng-model="$ctrl.price" ng-pattern="$ctrl.onlyNumber" class="form-control">
					</div>
					<button type="submit" class="btn btn-success" ng-disabled="$ctrl.sector.price == $ctrl.price || form.input.$invalid">Зберегти</button>
			</div>
			</form>
		</div>
	</div>
</div>