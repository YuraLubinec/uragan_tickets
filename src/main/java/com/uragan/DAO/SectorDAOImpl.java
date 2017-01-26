package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.uragan.model.Sector;

@Repository
public class SectorDAOImpl extends AbstractDAO<Integer, Sector> implements SectorDAO {

  @Override
  public Sector findById(int id) {
    
    Sector sector = getById(id);
    if (sector != null){
      Hibernate.initialize(sector.getSeats());
    }
    return sector;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Sector> findAllSector() {
    Criteria crit = createEntityCriteria();
    
    crit.addOrder(Order.desc("id"));
    List<Sector> sectors = (List<Sector>) crit.list(); 
    for(Sector sector : sectors){
      Hibernate.initialize(sector.getSeats());
    }
    return sectors;
  }

  @Override
  public void save(Sector sector) {
    persist(sector);

  }

}
