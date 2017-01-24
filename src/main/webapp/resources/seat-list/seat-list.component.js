angular.module('phoneList').component('phoneList', {
  templateUrl: 'seat-list/seat-list.template/html',
  controller: ['SeatListService', function SeatListController(SeatListService){
    this.seatList = SeatListService.fetchAllSeats();
  }]
});