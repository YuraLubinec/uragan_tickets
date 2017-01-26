<div class="col-lg-12 col-md-12">
	<ul>
		<li ng-repeat="sector in $ctrl.seatList">
			<p>{{sector.id}}</p>
			<p>{{sector.seats}}</p>
			<p ng-repeat="seat in sector.seats">
			{{seat.id}}+{{seat.row}}+{{seat.place}}</p>
			
		</li>
	</ul>
</div>