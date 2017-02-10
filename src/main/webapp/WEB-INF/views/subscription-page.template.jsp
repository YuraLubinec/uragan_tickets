<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal modal fade" id="myModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Створення новго абонемента </h4>
      </div>
      <div class="modal-body">
        <div class="container-fluid">
          <form ng-submit="$ctrl.submit()" name="subForm" class="form-group" role="">
            <input type="hidden" ng-model="$ctrl.subscription.id" />
            <div class="form-group">
              <label class="control-lable" for="file">ПІП</label>
              <div class="">
                <input type="text" class="form-control" ng-model="$ctrl.subscription.fullName" name="fname" placeholder="ПІП" required />
                <div class="has-error" ng-show="subForm.$dirty">
                  <span ng-show="subForm.fname.$error.required">Це обов'язкове  поле для заповнення</span>
                </div>
              </div>
            </div>

            <div class="form-group">
              <label class="control-lable" for="file">Місце</label>
              <div class="">
                <input type="text" class="form-control" ng-model="$ctrl.subscription.seat_id" name="seat" placeholder="місце" required />
                <div class="has-error" ng-show="subForm.$dirty">
                  <span ng-show="subForm.seat.$error.required">Це обов'язкове  поле для заповнення</span>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="control-lable" for="file">Сезон</label>
              <div class="">
                <select class="form-control" class="form-control" ng-model="$ctrl.currentSelectSeason" ng-options="season.years for season in $ctrl.seasonList">
            <option value="" disabled>Оберіть сезон</option>
            </select>
              </div>
            </div>
            <div class="">
              <div class="form-actions">
                <input type="submit" value="{{!$ctrl.subscription.id ? 'Створити' : 'Оновити'}}" class="btn btn-success btn-sm">
                <button type="button" ng-click="$ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="subForm.$pristine">Очистити форму</button>
              </div>
            </div>
          </form>
          <div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="col-lg-2 col-md-2 add-padding-top">
  <button id="idSubModal" data-toggle="modal" data-target="#myModal" class="btn btn-primary form-control"> Cтворити абонемент </button>
</div>
<div class="col-lg-4 col-lg-offset-6 col-md-4 col-lg-offset-2 add-padding-top">
  <select class="form-control" ng-model="$ctrl.currentSeason" ng-options="season.years for season in $ctrl.seasonList" ng-change="getSubOfSeason()">
        <option value="" disabled>Оберіть сезон</option>
        </select>
</div>

<div class="bordered col-md-12 col-lg-12 text-center">
  <div class="row">
    <div class="col-md-12">
      <div class="table-responsive">
        <table class="table">
          <thead>
            <tr>
              <th class="col-md-3">П І П</th>
              <th class="col-md-3">МІСЦЕ</th>
              <th class="col-md-3">СЕЗОН</th>
              <th class="col-md-3"></th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="sub in $ctrl.paginList ">
              <td><span ng-bind="sub.fullName"></span></td>
              <td><span ng-bind="sub.seat_id"></span></td>
              <td><span ng-bind="sub.season_id"></span></td>
              <td>
                <button type="button" ng-click="$ctrl.edit(sub.id)" data-toggle="modal" data-target="#myModal" class="btn btn-success custom-width">Редагувати</button>
                <button type="button" ng-click="$ctrl.remove(sub.id)" class="btn btn-danger custom-width">Видалити</button>
              </td>
            </tr>
          </tbody>
        </table>
        <div data-pagination="" data-num-pages="numPages()" data-current-page="currentPage" data-max-size="maxSize" data-boundary-links="true">
        </div>
      </div>
    </div>
  </div>
</div>