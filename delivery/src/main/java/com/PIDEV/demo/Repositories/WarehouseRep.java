package com.PIDEV.demo.Repositories;
import com.PIDEV.demo.Entities.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRep extends CrudRepository<Warehouse,Integer> {

}
