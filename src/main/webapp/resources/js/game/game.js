$(function() {
  $(document).ready(function() {
	    $('#games').DataTable({
	      language: {
	        search: "Введіть дату:",
	        searchPlaceholder: "пошук...",
	        zeroRecords: "Збігів не знайдено",
	        paginate: {
	          next: "наступна",
	          previous: "попередня"
	        }
	      },
	      order: [1, 'asc'],
	      columnDefs: [{
	        targets: [4,5],
	        orderable: false,
	      }, {
	        targets: [0,1,2,3],
	        searchable: true,
	      }],
	      bLengthChange: false,
	      info: true,
	    });
	  });
});