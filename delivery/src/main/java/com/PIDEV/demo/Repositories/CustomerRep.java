package com.PIDEV.demo.Repositories;

import com.PIDEV.demo.Entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRep extends CrudRepository<Customer,Integer> {
}
