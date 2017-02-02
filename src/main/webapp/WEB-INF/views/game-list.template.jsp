<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-inline">
  <div class="">
    <div class="">
      <form ng-submit="$ctrl.submit()" name="myForm">
        <input type="hidden" ng-model="$ctrl.game.id" />
        <div class="">
          <div class="form-group">
            <label class="control-lable" for="file">Господарі</label>
            <div class="">
              <input type="text" ng-model="$ctrl.game.firstTeam" name="fteam" class="form-control" placeholder="назва команди" required
                />
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.fteam.$error.required">Це обов'язкове  поле для заповнення</span>
              </div>
            </div>
          </div>
        </div>
        <div class="">
          <div class="form-group">
            <label class="control-lable" for="file">Гості</label>
            <div class="">
              <input type="text" ng-model="$ctrl.game.secondTeam" name="steam" class="form-control" placeholder="назва команди"
                required/>
              <div class="has-error" ng-show="myForm.$dirty">
                <span ng-show="myForm.steam.$error.required">Це обов'язкове  поле для заповнення</span>
              </div>
            </div>
          </div>
        </div>
        <div class="">
          <div class="form-group">
            <label class="control-lable" for="file">Дата</label>
            <div class="">
              <input type="text" ng-model="$ctrl.game.date" class="form-control" placeholder="дата гри" />
            </div>
          </div>
        </div>
        <div class="">
          <div class="form-group">
            <label class="control-lable" for="file">Час</label>
            <div class="">
              <input type="text" ng-model="$ctrl.game.time" class="form-control" placeholder="час гри" />
            </div>
          </div>
        </div>
        <div class="">
          <div class="form-group">
            <label class="control-lable" for="file">Сезон</label>
            <div class="">
              <input type="text" ng-model="$ctrl.game.season_id" class="form-control" placeholder="сезон" />
            </div>
          </div>
        </div>
        <div class="">
          <div class="form-actions">
            <input type="submit" value="{{!$ctrl.game.id ? 'Створити' : 'Оновити'}}" class="btn btn-primary btn-sm">
            <button type="button" ng-click="$ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Очистити форму</button>
          </div>
        </div>

      </form>
    </div>

  </div>
  <div>
    <div class=""><span class="lead">Список ігор</span></div>

    <table>
      <tr >
      <td></td>
      </tr>
    </table>
    
    
    
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
        <tr ng-repeat="game in $ctrl.gameList ">
          <td><span ng-bind="game.firstTeam"></span></td>
          <td><span ng-bind="game.secondTeam"></span></td>
          <td><span ng-bind="game.date"></span></td>
          <td><span ng-bind="game.time"></span></td>
          <td><span ng-bind="game.season_id"></span></td>
          <td>
            <button type="button" ng-click="$ctrl.edit(game.id)" class="btn btn-success custom-width">Редагувати</button>
            <button type="button" ng-click="$ctrl.remove(game.id)" class="btn btn-danger custom-width">Видалити</button>
          </td>
        </tr>
      </tbody>
    </table>

  </div>
</div>