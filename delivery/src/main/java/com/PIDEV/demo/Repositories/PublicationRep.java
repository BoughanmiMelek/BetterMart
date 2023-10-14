package com.PIDEV.demo.Repositories;





import com.PIDEV.demo.Entities.Publication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRep extends CrudRepository<Publication,Integer> {
}
