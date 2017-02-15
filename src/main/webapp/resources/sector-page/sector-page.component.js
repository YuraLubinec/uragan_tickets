'use strict'
angular.module('sectorPage').component('sectorPage', {
  templateUrl : 'template/sector/',
  controller : [ 'SectorPageService', function SectorPageController(SectorPageService) {

    var main = this;
    main.sector = null;
    main.price = null;
    main.sectors = [];
    main.onlyNumber = '[0-9]{1,7}';
    main.submit = submit;

    fetchAllSectors();

    function fetchAllSectors() {
      SectorPageService.fetchAllSectors().then(function(response) {
        main.sectors = response;
      }, function() {
        console.error('Error while fetching Sectors');
      });
    }

    function setPrice(sector) {
      SectorPageService.setPrice(sector).then(fetchAllSectors, function() {
        console.error('Error while saving sector');
      })
    }

    function submit() {
        main.sector.price = main.price;
        setPrice(main.sector);
    }
    
  } ]
})