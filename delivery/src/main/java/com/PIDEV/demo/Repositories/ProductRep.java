package com.PIDEV.demo.Repositories;




import com.PIDEV.demo.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep extends CrudRepository<Product,Integer> {
}
