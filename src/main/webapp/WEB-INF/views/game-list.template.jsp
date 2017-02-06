<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar">
  <div class="container-fluid">

    <div class="collapse navbar-collapse" id="">
      <form ng-submit="$ctrl.submit()" name="myForm" id="" class="form-inline" role="">
        <input type="hidden" ng-model="$ctrl.game.id" />
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class=""></i></span>
            <input type="text" ng-model="$ctrl.game.firstTeam" name="fteam" class="form-control" placeholder="назва команди"
              required/>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class=""></i></span>
            <input type="text" ng-model="$ctrl.game.secondTeam" name="steam" class="form-control" placeholder="назва команди"
            />
          </div>
        </div>

        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class=""></i></span>
            <input type="text" ng-model="$ctrl.game.date" class="form-control" placeholder="дата гри" />
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class=""></i></span>
            <input type="text" ng-model="$ctrl.game.time" class="form-control" placeholder="час гри" />
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class=""></i></span>
            <select class="form-control" ng-model="$ctrl.currentSelectSeason" ng-options="season.years for season in $ctrl.seasonList">
            <option value="" disabled>Оберіть сезон</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <input type="submit" value="{{!$ctrl.game.id ? 'Створити' : 'Оновити'}}" class="btn btn-primary btn-sm">
            <button type="button" ng-click="$ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Очистити форму</button>
          </div>
        </div>
      </form>

    </div>
  </div>
</nav>

<div class="form-inline col-lg-4 col-md-4 col-lg-offset-4 col-lg-offset-4  add-padding-top">
  <div class="form-group">
    <div class="input-group">
      <div class="nameTable">Список ігор</div>
    </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <select class="form-control" ng-model="$ctrl.currentSeason" ng-options="season.years for season in $ctrl.seasonList"
        ng-change="getGamesOfSeason()">
        <option value="" disabled>Оберіть сезон</option>
        </select>
    </div>
  </div>
</div>
<table class="table">
  <thead>
    <tr>
      <th>Господарі</th>
      <th>Гості</th>
      <th>Дата</th>
      <th>Час</th>
      <th>Сезон</th>
      <th width="20%"></th>
    </tr>
  </thead>
  <tbody>
    <tr ng-repeat="game in $ctrl.gameList">

      <td><span ng-bind="game.firstTeam"></span></td>
      <td><span ng-bind="game.secondTeam"></span></td>
      <td><span ng-bind="game.date"></span></td>
      <td><span ng-bind="game.time"></span></td>

      <td ng-repeat="season in $ctrl.seasonList" ng-if="season.id == game.season_id">
        <span ng-bind="season.years"></span>
      </td>
      <td>
        <button type="button" ng-click="$ctrl.edit(game.id)" class="btn btn-success custom-width">Редагувати</button>
        <button type="button" ng-click="$ctrl.remove(game.id)" class="btn btn-danger custom-width">Видалити</button>
      </td>
    </tr>
  </tbody>
</table>