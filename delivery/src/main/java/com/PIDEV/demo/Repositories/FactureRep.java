package com.PIDEV.demo.Repositories;



import com.PIDEV.demo.Entities.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRep extends CrudRepository<Facture,Integer> {
}
