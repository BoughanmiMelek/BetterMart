package com.PIDEV.demo.Repositories;


import com.PIDEV.demo.Entities.Deliverer;
import com.PIDEV.demo.Entities.Delivery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DelivererRep extends CrudRepository<Deliverer,Integer> {


}
