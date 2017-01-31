<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="form-inline">
  <form ng-submit="$ctrl.submit()" name="subForm">
    <input type="hidden" ng-model="$ctrl.subscription.id" />
    <div class="form-group">
      <label class="control-lable" for="file">ПІП</label>
      <div class="">
        <input type="text" ng-model="$ctrl.subscription.fullName" name="fname" placeholder="ПІП"
          required />
        <div class="has-error" ng-show="subForm.$dirty">
          <span ng-show="subForm.fname.$error.required">Це обов'язкове  поле для заповнення</span>
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="control-lable" for="file">Місце</label>
      <div class="">
        <input type="text" ng-model="$ctrl.subscription.seat_id" name="seat" placeholder="місце"
          required />
        <div class="has-error" ng-show="subForm.$dirty">
          <span ng-show="subForm.seat.$error.required">Це обов'язкове  поле для заповнення</span>
        </div>
      </div>
    </div>
    <div class="form-group">
      <label class="control-lable" for="file">Сезон</label>
      <div class="">
        <input type="text" ng-model="$ctrl.subscription.season_id" name="season" placeholder="сезон"
          required />
        <div class="has-error" ng-show="subForm.$dirty">
          <span ng-show="subForm.season.$error.required">Це обов'язкове  поле для заповнення</span>
        </div>
      </div>
    </div>
    <div class="">
      <div class="form-actions">
        <input type="submit" value="{{!$ctrl.subscription.id ? 'Створити' : 'Оновити'}}"
          class="btn btn-primary btn-sm">
          <button type="button" ng-click="$ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="subForm.$pristine">Очистити форму</button>
      </div>
    </div>
  </form>
  <div>
    <div class=""><span class="lead">Список абонементів</span></div>

    <table class="table">
      <thead>
        <tr>
          <th>П І П</th>
          <th>МІСЦЕ</th>
          <th>СЕЗОН</th>
          <th width="20%"></th>
        </tr>
      </thead>
      <tbody>
        <tr ng-repeat="sub in $ctrl.subscriptionList ">
          <td><span ng-bind="sub.fullName"></span></td>
          <td><span ng-bind="sub.seat_id"></span></td>
          <td><span ng-bind="sub.season_id"></span></td>
          <td>
            <button type="button" ng-click="$ctrl.edit(sub.id)" class="btn btn-success custom-width">Редагувати</button>
            <button type="button" ng-click="$ctrl.remove(sub.id)" class="btn btn-danger custom-width">Видалити</button>
          </td>
        </tr>
      </tbody>
    </table>

  </div>
</div>