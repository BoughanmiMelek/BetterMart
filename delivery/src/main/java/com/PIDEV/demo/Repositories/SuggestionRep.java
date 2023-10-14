package com.PIDEV.demo.Repositories;





import com.PIDEV.demo.Entities.RelyPoint;
import com.PIDEV.demo.Entities.Suggestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRep extends CrudRepository<Suggestion,Integer> {

}
