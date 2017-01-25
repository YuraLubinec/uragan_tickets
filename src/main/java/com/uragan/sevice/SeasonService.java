package com.uragan.sevice;

import java.util.List;

import com.uragan.model.Season;

public interface SeasonService {

  List<Season> findAllSeason();

  void save(Season season);

  void delete(int id);

  Season findById(int id);

}
