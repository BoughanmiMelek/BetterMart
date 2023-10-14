package com.PIDEV.demo.Repositories;







import com.PIDEV.demo.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends CrudRepository<User,Integer> {

}
