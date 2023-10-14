package com.PIDEV.demo.Repositories;






import com.PIDEV.demo.Entities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRep extends CrudRepository<Supplier,Integer> {

}
