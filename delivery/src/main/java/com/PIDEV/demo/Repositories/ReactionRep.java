package com.PIDEV.demo.Repositories;





import com.PIDEV.demo.Entities.Reaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRep extends CrudRepository<Reaction,Integer> {
}
