package com.uragan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.DTO.SectorDTO;
import com.uragan.model.Sector;
import com.uragan.sevice.SectorService;

@RestController
@RequestMapping(value="/main")
public class SectorPageRestController {
  
  @Autowired
  private SectorService serviceSector;
  
  @GetMapping("/sectors")
  public ResponseEntity<List<SectorDTO>> getAllSectors() {
    
    List<Sector> sectors = serviceSector.findAllSector();
    List<SectorDTO> sectorsDTO = sectors.stream()
        .map(sector -> new SectorDTO(sector.getId(), sector.getName(), sector.getPrice())).collect(Collectors.toList());
    if (sectorsDTO.isEmpty()) {
      return new ResponseEntity<List<SectorDTO>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<SectorDTO>>(sectorsDTO, HttpStatus.OK);
  }
  
  @PostMapping("/sectors/price")
  @ResponseStatus(HttpStatus.OK)
  public void setSectorPrice(@Validated @RequestBody SectorDTO sectorDTO, BindingResult result){
    
    if(result.hasErrors()){
      //loging is needed here
      return;
    }
    serviceSector.updateSectorPrice(sectorDTO);
  }

}
