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
              <input type="text" ng-model="$ctrl.game.firstTeam" name="fteam" class="form-control" placeholder="назва команди"
                required/>
            </div>
            <div class="form-group">
              <input type="text" ng-model="$ctrl.game.secondTeam" name="steam" class="form-control" placeholder="назва команди"
              />
            </div>

            <div class="form-group">

              <input type="text" ng-model="$ctrl.game.date" class="form-control" placeholder="дата гри" />

            </div>
            <div class="form-group">
              <input type="text" ng-model="$ctrl.game.time" class="form-control" placeholder="час гри" />
            </div>
            <div class="form-group">
              <select class="form-control" ng-model="$ctrl.currentSelectSeason" ng-options="season.years for season in $ctrl.seasonList">
            <option value="" disabled>Оберіть сезон</option>
            </select>
            </div>
            <div class="form-group">
              <input type="submit" value="{{!$ctrl.game.id ? 'Створити' : 'Оновити'}}" class="btn btn-success btn-sm">
              <button type="button" ng-click="$ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Очистити форму</button>
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
  <select class="form-control" ng-model="$ctrl.currentSeason" ng-options="season.years for season in $ctrl.seasonList"
    ng-change="getGamesOfSeason()">
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
              <th class="col-md-2">ГОСПОДАРІ</th>
              <th class="col-md-2">ГОСТІ</th>
              <th class="col-md-2">ДАТА</th>
              <th class="col-md-2">ЧАС</th>
              <th class="col-md-2">СЕЗОН</th>
              <th class="col-md-2" width="20%"></th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="game in $ctrl.paginList | filter : {secondTeam: filterText} as filteredName">

              <td><span ng-bind="game.firstTeam"></span></td>
              <td><span ng-bind="game.secondTeam"></span></td>
              <td><span ng-bind="game.date"></span></td>
              <td><span ng-bind="game.time"></span></td>

              <td ng-repeat="season in $ctrl.seasonList" ng-if="season.id == game.season_id">
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