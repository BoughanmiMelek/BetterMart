package com.PIDEV.demo.Services;

import com.PIDEV.demo.Entities.Deliverer;
import com.PIDEV.demo.Entities.Delivery;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IDeliveryService {


    public void supprimerDelivery(int idD);
    public void ajouterDelivery(Delivery d);
    public Delivery modifierDelivery(String newReference,String point, int idd);

    public Delivery afficheDelivery (Integer  idD);
    public void AffecterPointRely (Integer idD, Integer IdRp);

    public void AffecterDeliverer (Integer idD,Integer id);

    public int getLivreursDisponibles();


   public int searchDeliveryByReference(String reference);


   ////////////////////////

    public void addDeliveryWithAssignments(Delivery delivery, Integer deliveryManId, int orderId);
    public List<Delivery> getAllDeliveriesWithCustomerAndTotalPrice();

    public List<Integer> getLivraisonsWithAvailableDeliverer();
    public List<Integer> getLivraisonsWithAvailableOrder();

    public List<Integer> getLivraisonsAllIds();

    public String getCustomerNameAndRelypForDelivery(Integer deliveryId);

    public void AddAdressForDelivery(Integer deliveryId);

    public List<Delivery> affichageAll();


}
