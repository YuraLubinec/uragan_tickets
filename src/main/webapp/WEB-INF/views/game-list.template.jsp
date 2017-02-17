<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal modal fade" id="myModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Створення нової гри </h4>
      </div>
      <div class="modal-body">

        <div class="container-fluid">

          <form ng-submit="$ctrl.submit()" name="myForm" id="" class="form-group" role="">
            <input type="hidden" ng-model="$ctrl.game.id" />
            <div class="form-group">
              <input type="text" ng-model="$ctrl.game.firstTeam" name="fteam" class="form-control" placeholder="назва команди" required/>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.fteam.$error.required">Обов'язкове поле для заповнення</span>
              </div>
            </div>
            <div class="form-group">
              <input type="text" ng-model="$ctrl.game.secondTeam" name="steam" class="form-control" placeholder="назва команди" required />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.steam.$error.required">Обов'язкове поле для заповнення</span>
              </div>
            </div>

            <div layout="row">

              <md-input-container class="md-block" flex="50" required>
                <md-datepicker ng-model="$ctrl.dateGame" name="dateGame" md-min-date="$ctrl.minDate" required></md-datepicker>
                <div ng-messages="myForm.dateGame.$error">
                  <div ng-message="valid">Введена дата не є датою!</div>
                  <div ng-message="required">Обов'язкове поле для заповнення!</div>
                </div>
              </md-input-container>


              <md-input-container class="md-block" flex="50">
                <mdp-time-picker ng-model="$ctrl.timeGame" name="timeGame" required></mdp-time-picker>
              </md-input-container>

            </div>
            <div class="form-group">
              <select class="form-control" ng-model="$ctrl.currentSelectSeason" ng-options="season.years for season in $ctrl.seasonList" required="required">
            <option value="" disabled>Оберіть сезон</option>
            </select>
            </div>
            <div class="form-group">
              <input type="submit" value="{{!$ctrl.game.id ? 'Створити' : 'Оновити'}}" class="btn btn-success">
              <button type="button" ng-click="$ctrl.reset()" class="btn btn-warning" ng-disabled="myForm.$pristine">Очистити форму</button>
            </div>
          </form>

        </div>

      </div>
    </div>
  </div>
</div>


<div class="col-lg-2 col-md-2 add-padding-top  add-padding-left">
  <button id="idGameModal" data-toggle="modal" data-target="#myModal" class="btn btn-primary custom-width form-control">Створити нову гру</button>
</div>
<div class=" col-lg-4 col-lg-offset-6 col-md-4 col-lg-offset-2 add-padding-top">
  <select class="form-control" ng-model="$ctrl.currentSeason" ng-options="season.years for season in $ctrl.seasonList" ng-change="getGamesOfSeason()">
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
        <table class="table" id="games">
          <thead>
            <tr>
              <th class="col-md-2 table-th-td">ГОСПОДАРІ</th>
              <th class="col-md-2 table-th-td">ГОСТІ</th>
              <th class="col-md-2 table-th-td">ДАТА</th>
              <th class="col-md-2 table-th-td">ЧАС</th>
              <th class="col-md-2 table-th-td">СЕЗОН</th>
              <th class="col-md-2 table-th-td" width="20%"></th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="game in $ctrl.paginList | filter : {secondTeam: filterText} as filteredName">

              <td class="table-th-td"><span ng-bind="game.firstTeam"></span></td>
              <td class="table-th-td"><span ng-bind="game.secondTeam"></span></td>
              <td class="table-th-td"><span ng-bind="game.date"></span></td>
              <td class="table-th-td"><span ng-bind="game.time"></span></td>
              <td class="table-th-td" ng-repeat="season in $ctrl.seasonList" ng-if="season.id == game.season_id">
                <span ng-bind="season.years"></span>
              </td>
              <td>
                <button type="button" ng-click="$ctrl.edit(game.id)" data-toggle="modal" data-target="#myModal" class="btn btn-success custom-width">Редагувати</button>
                <button type="button" ng-click="$ctrl.remove(game.id)" class="btn btn-danger custom-width">Видалити</button>
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