package com.PIDEV.demo.Repositories;



import com.PIDEV.demo.Entities.Customer;
import com.PIDEV.demo.Entities.Delivery;
import com.PIDEV.demo.Entities.Orderr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRep extends CrudRepository<Orderr,Integer> {




}
