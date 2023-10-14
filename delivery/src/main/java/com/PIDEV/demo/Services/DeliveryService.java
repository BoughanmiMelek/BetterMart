package com.PIDEV.demo.Services;

import com.PIDEV.demo.Entities.*;
import com.PIDEV.demo.Repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.*;
import java.util.logging.Logger;

@Service
@Slf4j
public class DeliveryService implements  IDeliveryService {

    @Autowired
     DeliveryRep deliveryRep;
    @Autowired
    RelyPointRep relyPointRep;
    @Autowired
    DelivererRep delivererRep;

    @Autowired
    UserRep userRep;
    @Autowired
    OrderRep orderRep;


    @Override
    public void supprimerDelivery(int idD)
    {
        deliveryRep.deleteById(idD);
    }

    @Override
    public void ajouterDelivery(Delivery d)
    {
        d.setDate(new Date());
        deliveryRep.save(d);
    }


    @Override
    public Delivery modifierDelivery(String newReference,String point, int idD) {
        Optional<Delivery> optionalDelivery = deliveryRep.findById(idD);
        if (!optionalDelivery.isPresent()) {
            throw new NoSuchElementException("Delivery with ID " + idD + " not found");
        }
        Delivery delivery = optionalDelivery.get();
        delivery.setReference(newReference);
        delivery.setPoint(point);
        return deliveryRep.save(delivery);
    }




    @Override
    public Delivery afficheDelivery (Integer  idD)
    {
        return deliveryRep.findById(idD).orElse(null);
    }


    @Override
    public void AffecterPointRely (Integer idD, Integer IdRp){
        Delivery delivery = deliveryRep.findById(idD).orElse(null);
        RelyPoint relyPoint = relyPointRep.findById(IdRp).orElse(null);
        delivery.setRelyPoint(relyPoint);
        relyPointRep.save(relyPoint);
    }


    @Override
    public void AffecterDeliverer (Integer idD,Integer id)
    {
        Delivery delivery = deliveryRep.findById(idD).orElse(null);
        Deliverer deliverer = delivererRep.findById(id).orElse(null);
        delivery.setDeliverer(deliverer);
        delivererRep.save(deliverer);
    }


    public int getLivreursDisponibles() {
        return  deliveryRep.findByDisponible(1);
    }


    public int searchDeliveryByReference(String reference) {
        return deliveryRep.findByReference(reference);
    }



    ///////////////////////////////////////


    @Override
    public void addDeliveryWithAssignments(Delivery delivery, Integer deliveryManId, int orderId) {

        delivery.setDate(new Date());

        Deliverer deliveryMan = delivererRep.findById(deliveryManId)
                .orElseThrow(() -> new IllegalArgumentException("Delivery man not found"));
        delivery.setDeliverer(deliveryMan);

        Orderr order = orderRep.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        delivery.setOrderr(order);


       deliveryRep.save(delivery);
    }


    public List<Delivery> getAllDeliveriesWithCustomerAndTotalPrice() {
        List<Delivery> deliveries = deliveryRep.getAllDeliveriesWithCustomerAndTotalPrice();
        List<Delivery> deliveryDtos = new ArrayList<>();
        for (Delivery delivery : deliveries) {
            Delivery deliveryDto = new Delivery();
            delivery.setIdD(delivery.getIdD());
            delivery.setRefOrder(delivery.getOrderr().getRefer());
            delivery.setName_Customer(delivery.getOrderr().getCustomer().getName());
            delivery.setTotal(delivery.getOrderr().getPrixTotal());
           //add and save
            deliveryDtos.add(delivery);
            deliveryRep.save(delivery);
        }

        return deliveryDtos;
    }


    public List<Integer> getLivraisonsWithAvailableDeliverer() {
        return  deliveryRep.findAvailableDelivererIds();
    }

    public List<Integer> getLivraisonsWithAvailableOrder() {
        return  deliveryRep.findAvailableorderIds();
    }


    public List<Integer> getLivraisonsAllIds() {
        return  deliveryRep.findAllIds();
    }



    public String getCustomerNameAndRelypForDelivery(Integer deliveryId) {
        String result = deliveryRep.findCustomerNameAndRelypByDeliveryId(deliveryId);
     if (result != null && result.length()!=0)
        {
           return  "Customer name: " + result + ", wishes to have a home delivery to a closer address.";
        }
     else
     {
         return "The customer wants a home delivery to your address.";
     }
    }


    public void AddAdressForDelivery(Integer deliveryId)
    {   String adr = deliveryRep.addAdressDelivery(deliveryId);
        Delivery delivery = deliveryRep.findById(deliveryId).get();
        delivery.setAdrss(adr);
        deliveryRep.save(delivery);
    }


    @Override
    public List<Delivery> affichageAll()
    {
        List<Delivery> deliveryList = deliveryRep.findAll();


          return  deliveryList;
    }


}
