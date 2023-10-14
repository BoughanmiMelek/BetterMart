package com.PIDEV.demo.Repositories;



import com.PIDEV.demo.Entities.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRep extends CrudRepository<Discount,Integer> {
}
