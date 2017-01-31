<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-lg-4 col-md-4 col-lg-offset-4 col-lg-offset-4">
		<select id="selector" ng-model="$ctrl.currentGame" ng-options="game.date+' '+game.firstTeam+' проти '+game.secondTeam for game in $ctrl.gameList"
			class="form-control" ng-change="$ctrl.pointAllOccupiedSeats()" ng-cloak>
			<option value="" disabled>Оберіть гру</option>
		</select>
	</div>
</div>
<div ng-show="$ctrl.currentGame != null">
	<div class="row">
		<div class="col-lg-12 col-md-12 text-center">
			<h2>Гра {{$ctrl.currentGame.date}}р. : {{$ctrl.currentGame.firstTeam}} проти {{$ctrl.currentGame.secondTeam}}</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="col-md-1 col-lg-1"></div>
			<div ng-repeat="sector in $ctrl.seatList | orderBy: 'id'" id="sector.id" class="col-lg-2 col-md-2"
				ng-if="sector.id == 1 || sector.id == 2 || sector.id == 3 || sector.id == 4 || sector.id == 5">
				<div class="bordered col-md-12 col-lg-12 text-center">
					<table class="col-lg-12 col-md-12">
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==3">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==2">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==1">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
					</table>
					<p>{{sector.name}}-{{sector.price}} грн</p>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div ng-repeat="sector in $ctrl.seatList" id="sector.id" class="col-md-3 col-lg-3" ng-if="sector.id == 6">
				<div class="bordered col-md-12 col-lg-12 text-center">
					<table class="col-lg-12 col-md-12">
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==1">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==2">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==3">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
					</table>
					<p>{{sector.name}}-{{sector.price}} грн</p>
				</div>
			</div>
			<div ng-repeat="sector in $ctrl.seatList" id="sector.id" class="col-md-6 col-lg-6" ng-if="sector.id == 7">
				<div class="bordered col-md-12 col-lg-12 text-center">
					<table class="col-lg-12 col-md-12">
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==1">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==2">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==3">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
					</table>
					<p>{{sector.name}}-{{sector.price}} грн</p>
				</div>
			</div>
			<div ng-repeat="sector in $ctrl.seatList" id="sector.id" class="col-md-3 col-lg-3" ng-if="sector.id == 8">
				<div class="bordered col-md-12 col-lg-12 text-center">
					<table class="col-lg-12 col-md-12">
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==1">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==2">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==3">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
					</table>
					<p>{{sector.name}}-{{sector.price}} грн</p>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<img class="col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2" alt="no photo" ng-src="resources/images/pole.png">
	</div>
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div ng-repeat="sector in $ctrl.seatList" id="sector.id" class="col-lg-3 col-md-3 col-md-offset-1 col-lg-offset-1 " ng-if="sector.id == 9">
				<div class="bordered col-md-12 col-lg-12 text-center">
					<table class="col-lg-12 col-md-12">
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==1">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==2">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==3">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
					</table>
					<p>{{sector.name}}-{{sector.price}} грн</p>
				</div>
			</div>
			<div ng-repeat="sector in $ctrl.seatList" id="sector.id" class="col-lg-3 col-md-3 col-md-offset-4 col-lg-offset-4" ng-if="sector.id == 10">
				<div class="bordered col-md-12 col-lg-12 text-center">
					<table class="col-lg-12 col-md-12">
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==1">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==2">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
						<tr>
							<td ng-repeat="seat in sector.seats | orderBy: 'id'" ng-if="seat.row==3">
								<button id="{{seat.id}}" data-toggle="modal" data-target="#myModal" ng-click="($ctrl.seat_obj=seat)&&($ctrl.sector_name=sector.name)">{{seat.place}}</button>
							</td>
						</tr>
					</table>
					<p>{{sector.name}}-{{sector.price}} грн</p>
				</div>
			</div>
		</div>
	</div>

	<div class="modal modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Сектор-{{$ctrl.sector_name}} Ряд-{{$ctrl.seat_obj.row}} Місце-{{$ctrl.seat_obj.place}}</h4>
				</div>		
				<div class="modal-body">
					<button class="btn btn-success" ng-click="$ctrl.submit()" ng-if="!$ctrl.classChecker()">Зберегти та роздрукувати білет</button>
					<button class="btn btn-danger" ng-click="$ctrl.deleteT()" ng-if="$ctrl.classChecker()">Видалити квиток</button>
				</div>
			</div>
		</div>
	</div>
</div>


