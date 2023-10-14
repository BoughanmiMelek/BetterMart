package com.PIDEV.demo.Repositories;





import com.PIDEV.demo.Entities.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRep extends CrudRepository<PurchaseOrder,Integer> {
}
