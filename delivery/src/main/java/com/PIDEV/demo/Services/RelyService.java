package com.PIDEV.demo.Services;

import com.PIDEV.demo.Entities.Delivery;
import com.PIDEV.demo.Entities.RelyPoint;
import com.PIDEV.demo.Repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class RelyService implements IRelyService {

   @Autowired
   RelyPointRep relyPointRep;
   @Autowired
   DeliveryRep deliveryRep;
   @Override
   public void ajouterRelyPoint(RelyPoint p)
   {
      relyPointRep.save(p);
   }

   @Override
   public RelyPoint modifierRelyPoint(RelyPoint p , int idRp ) {
      Optional<RelyPoint> optionalRelyPoint = relyPointRep.findById(idRp);
      if (optionalRelyPoint.isPresent()) {
         RelyPoint relyPoint = optionalRelyPoint.get();
         if (p.getAddress() != null) {
            relyPoint.setAddress(p.getAddress());
         }
         if (p.getName() != null) {
            relyPoint.setName(p.getName());
         }
         if (p.getDescription() != null) {
            relyPoint.setDescription(p.getDescription());
         }
         return relyPointRep.save(relyPoint);
      } else {
         throw new NoSuchElementException("Rely not found.");
      }
   }

   @Override
   public void supprimerRelyPoint(int idRp)
   {
      relyPointRep.deleteById(idRp);
   }

   public List<RelyPoint> affichageAllRely()
   {
      return (List<RelyPoint>) relyPointRep.findAll();
   }

   public RelyPoint afficheRely (Integer  idRp)
   {
      return relyPointRep.findById(idRp).orElse(null);
   }

   @Override
   public  Long countD() {
      return deliveryRep.count();
   }

   //11
   @Override
   public List<RelyPoint> findByAddress(String ad) {
      return relyPointRep.findByAdresse(ad);
   }
   //11
   @Override
   public List<Delivery> findByRelyPointe(int id) {
      return deliveryRep.findByRelyPointe(id);
   }
}
