package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.uragan.model.Sector;

@Repository
public class SectorDAOImpl extends AbstractDAO<Integer, Sector> implements SectorDAO {

  @Override
  public Sector findById(int id) {
    return getById(id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Sector> findAllSector() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Sector>) crit.list();
  }

  @Override
  public void save(Sector sector) {
    persist(sector);

  }

}
