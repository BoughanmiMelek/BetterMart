package com.PIDEV.demo.Repositories;





import com.PIDEV.demo.Entities.Reaction;
import com.PIDEV.demo.Entities.RelyPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface RelyPointRep extends JpaRepository<RelyPoint,Integer> {

    public List<RelyPoint> findAll();



    //11
    @Query("select r from RelyPoint r where r.address=?1")
    List<RelyPoint> findByAdresse(String ad);

}
