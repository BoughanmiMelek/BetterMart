package com.PIDEV.demo.Repositories;


import com.PIDEV.demo.Entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface DeliveryRep extends JpaRepository<Delivery, Object> {


    @Query("SELECT count(d.deliverer.id) FROM Delivery d WHERE d.deliverer.dispo =:dispo ")
     int findByDisponible(int dispo);

    @Query("select idD from  Delivery  where reference= ?1 ")
    int findByReference(String reference );


    long count();

    //11
    @Query("select d from Delivery  d  where  d.relyPoint in (select r from RelyPoint r where r.idRp=:idRp)")
    List<Delivery> findByRelyPointe (@Param("idRp")int idRp);



    ////////////////////////////////////////////////


    @Query("SELECT d, o.prixTotal, c.name FROM Delivery d "
            + "JOIN d.orderr o "
            + "JOIN o.customer c ")
    List<Delivery> getAllDeliveriesWithCustomerAndTotalPrice();


    @Query("SELECT DISTINCT d.id FROM Deliverer d  WHERE d.dispo = true")
    List<Integer> findAvailableDelivererIds();


    @Query("SELECT o.ido FROM Orderr o WHERE o.state = 'processing'")
    List<Integer> findAvailableorderIds();


    @Query("SELECT d.idD FROM Delivery d")
    List<Integer> findAllIds();


    @Query("SELECT c.name FROM Delivery d "
            + "JOIN d.orderr o "
            + "JOIN o.customer c "
            + "WHERE (d.idD = :deliveryId ) AND (o.relyp = true)")
    String  findCustomerNameAndRelypByDeliveryId(Integer deliveryId);


    @Query("SELECT  c.address FROM Delivery d "
            + "JOIN d.orderr o "
            + "JOIN o.customer c"
            + " where (d.idD = :deliveryId )")
    String addAdressDelivery(Integer deliveryId);



    public List<Delivery> findAll();

}
