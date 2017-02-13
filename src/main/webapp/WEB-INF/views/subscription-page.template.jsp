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
              <label class="control-lable" for="file">Сезон</label>
              <div class="">
                <select class="form-control" class="form-control" ng-model="$ctrl.currentSelectSeason" ng-options="season.years for season in $ctrl.seasonList">
            <option value="" disabled>Оберіть сезон</option>
            </select>
              </div>
            </div>
            
            <div class="form-group">
              <label class="control-lable" for="file">Сектор</label>
              <div class="">
                <select class="form-control" class="form-control" ng-model="$ctrl.currentSelectSector" ng-options="sector.name for sector in $ctrl.sectorList" ng-change="getRowBySector()">
            <option value="" disabled>Оберіть сектор</option>
            </select>
              </div>
            </div>
            
           <div class="form-group">
              <label class="control-lable" for="file">Ряд</label>
              <div class="">
                <select class="form-control" class="form-control" ng-model="$ctrl.currentSelectRow" ng-options="seat.row for seat in $ctrl.seatListBySector" ng-change="getAvailablePlace()">
            <option value="" disabled>Оберіть ряд</option>
            </select>
              </div>
            </div>
            <div class="form-group">
              <label class="control-lable" for="file">Місце</label>
              <div class="">
                <select class="form-control" class="form-control" ng-model="$ctrl.currentSelectPlace" ng-options="seat.place for seat in $ctrl.placeList">
            <option value="" disabled>Оберіть місце</option>
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


<div class="col-lg-2 col-md-2 add-padding-top add-padding-left">
  <button id="idSubModal" data-toggle="modal" data-target="#myModal" class="btn btn-primary form-control"> Cтворити абонемент </button>
</div>
<div class="col-lg-4 col-lg-offset-6 col-md-4 col-lg-offset-2 add-padding-top">
  <select class="form-control" ng-model="$ctrl.currentSeason" ng-options="season.years for season in $ctrl.seasonList" ng-change="getSubOfSeason()">
        <option value="" disabled>Оберіть сезон</option>
        </select>
</div>
<div class="col-lg-2 col-lg-offset-2 col-md-2 add-padding-top not-padding-right">
  <input type="text" class="form-control" placeholder="search..." ng-model="filterText">
</div>
<div class="bordered col-md-12 col-lg-12 text-center">
  <div class="row">
    <div class="col-md-12">
      <div class="table-responsive">
        <table class="table">
          <thead>
            <tr>
            
              <th class="col-md-2"><a href="" ng-click="sortBy('fullName')">П І П</a></th>
              <th class="col-md-2"><a href="" ng-click="sortBy('name')">СЕКТОР</a></th>
              <th class="col-md-1"><a href="" ng-click="sortBy('row')">РЯД</a></th>
              <th class="col-md-1"><a href="" ng-click="sortBy('place')">МІСЦЕ</a></th>
              <th class="col-md-3"><a>СЕЗОН</a></th>
              <th class="col-md-3"></th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="sub in $ctrl.paginList | orderBy:propertyName:reverse | filter : {fullName: filterText} as filteredName">
              <td><span ng-bind="sub.fullName"></span></td>

              <td ng-repeat="seat in $ctrl.seatList" ng-if="seat.id == sub.seat_id">
                <span ng-repeat="sector in $ctrl.sectorList" ng-if ="sector.id == seat.sector_id" >
                  <span ng-bind="sector.name"></span>
                  </span>
              </td>
              
              <td ng-repeat="seat in $ctrl.seatList" ng-if="seat.id == sub.seat_id">
                <span ng-bind="seat.row"></span>
              </td>
              
              <td ng-repeat="seat in $ctrl.seatList" ng-if="seat.id == sub.seat_id">
                <span ng-bind="seat.place"></span>
              </td>
  
              <td ng-repeat="season in $ctrl.seasonList" ng-if="season.id == sub.season_id">
                <span ng-bind="season.years"></span>
              </td>
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