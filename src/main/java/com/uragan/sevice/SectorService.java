package com.uragan.sevice;

import java.util.List;

import com.uragan.DTO.SectorDTO;
import com.uragan.model.Sector;

public interface SectorService {

  List<Sector> findAllSector();

  void save(Sector sector);

  Sector findById(int id);

  void updateSectorPrice(SectorDTO sectorDTO);

}
