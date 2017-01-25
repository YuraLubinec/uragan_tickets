package com.uragan.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.SeasonDAO;
import com.uragan.model.Season;

@Service
public class SeasonServiceImpl implements SeasonService {

  @Autowired
  SeasonDAO dao;

  @Transactional
  @Override
  public List<Season> findAllSeason() {
    return dao.findAllSeason();
  }

  @Transactional
  @Override
  public void save(Season season) {
    dao.save(season);
  }

  @Transactional
  @Override
  public void delete(int id) {
    dao.delete(id);
  }

  @Transactional
  @Override
  public Season findById(int id) {
    return dao.findById(id);
  }

}
