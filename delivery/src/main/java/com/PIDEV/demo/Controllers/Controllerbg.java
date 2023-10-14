package com.PIDEV.demo.Controllers;

import com.PIDEV.demo.Entities.*;
import com.PIDEV.demo.Services.IDeliveryService;

import com.PIDEV.demo.Services.IRelyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/Controllerbg")
public class Controllerbg {

    //private Logger logger = LoggerFactory.getLogger(Controllerbg.class);

    IRelyService iRelyService;

    IDeliveryService iDeliveryService;


    //  http://localhost:8888/pidev/Controllerbg/ajouter-rely
    @PostMapping("/ajouter-rely")
    public void ajouterRelyPoint(@RequestBody RelyPoint p) {
        iRelyService.ajouterRelyPoint(p);
    }


    //  http://localhost:8888/pidev/Controllerbg/modifier-rely
    @PutMapping("/modifier-rely/{idRp}")
    @ResponseBody
    public RelyPoint modifierRelyPoint(@RequestBody RelyPoint p, @PathVariable("idRp") int idRp) {
        return iRelyService.modifierRelyPoint(p, idRp);
    }


    //  http://localhost:8888/pidev/Controllerbg/supprimer-rely/id_rp
    @DeleteMapping("/supprimer-rely/{idRp}")
    void supprimerRelyPoint(@PathVariable("idRp") int idRp) {
        iRelyService.supprimerRelyPoint(idRp);
    }


    // http://localhost:8888/pidev/Controllerbg/allRely
    @GetMapping("/allRely")
    public List<RelyPoint> getRely() {
        List<RelyPoint> listRely = iRelyService.affichageAllRely();
        return listRely;
    }

    // http://localhost:8888/pidev/Controllerbg/afficheIdRely/
    @GetMapping("/afficheIdRely/{idRp}")
    public RelyPoint afficheRely(@PathVariable("idRp") Integer idRp) {
        return iRelyService.afficheRely(idRp);
    }


    //////////////// *************Delivery**************** //////////////////////////

    //  http://localhost:8888/pidev/Controllerbg/supprimer-delivery/idD
    @DeleteMapping("/supprimer-delivery/{idD}")
    void supprimerDelivery(@PathVariable("idD") int idD) {
        iDeliveryService.supprimerDelivery(idD);
    }


    //  http://localhost:8888/pidev/Controllerbg/ajouter-delivery
    @PostMapping("/ajouter-delivery")
    public void ajouterDelivery(@RequestBody Delivery d) {
        iDeliveryService.ajouterDelivery(d);
    }



    @PutMapping("/delivery/{idD}")
    public ResponseEntity<Delivery> modifierReference(@PathVariable(value = "idD") int idD,
                                                      @RequestBody Map<String, String> request) {
        String newReference = request.get("reference");
        String point = request.get("point");
       System.out.println("test");
        System.out.println(request.get("point"));

        Delivery delivery = iDeliveryService.modifierDelivery(newReference ,point, idD);
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }



    // http://localhost:8888/pidev/Controllerbg/afficheDelivery/idD
    @GetMapping("/afficheDelivery/{idD}")
    public Delivery afficheDelivery(@PathVariable("idD") Integer idD) {
        return iDeliveryService.afficheDelivery(idD);
    }


    //  http://localhost:8888/pidev/Controllerbg/affecter-Deliverer/idD/id
    @PutMapping(value = "/affecter-Deliverer/{idD}/{id}")
    public void AffecterDeliverer(@PathVariable("idD") Integer idD, @PathVariable("id") Integer id) {
        iDeliveryService.AffecterDeliverer(idD, id);
    }

    // http://localhost:8888/pidev/Controllerbg/disponibles
    @GetMapping("/disponibles")
    public int nbrLivreursDisponibles() {
        int DD = iDeliveryService.getLivreursDisponibles();
        return DD;
    }


    //  http://localhost:8888/pidev/Controllerbg/countD
    @GetMapping("/countD")
    public Long CountD() {
        return iRelyService.countD();
    }


    //  http://localhost:8888/pidev/Controllerbg/findOneByAddress/
    @GetMapping("/findOneByAddress/{ad}")
    public double findOneByAddress(@PathVariable String ad) {
        log.info(ad);
        Long total = iRelyService.countD();
        log.info("total " + total);
        double totalD = total.doubleValue();
        log.info("totalD" + totalD);
        RelyPoint relyPoint = iRelyService.findByAddress(ad).get(0);
        log.info("relypoint" + relyPoint);
        int nbA = iRelyService.findByRelyPointe(relyPoint.getIdRp()).size();
        log.info("nbA" + nbA);
        double nbD = (double) nbA;
        log.info("nbD" + nbD);
        double c = totalD * nbD;
        log.info("c" + c);
        double t = (c / 100);
        return t;
        //return iRelyService.findByAddress(ad);
    }


    //////////////////////////////////////////////////

    @PostMapping("/addDelivery/{id}/{ido}")
    public void addDeliveryWithAssignments(@RequestBody Delivery delivery, @PathVariable("id") Integer deliveryManId, @PathVariable("ido") int orderId) {
        iDeliveryService.addDeliveryWithAssignments(delivery, deliveryManId, orderId);
    }


    @GetMapping("/getall")
    public List<Delivery> getAllDeliveriesWithCustomerAndTotalPrice() {
        List<Delivery> listdeli = iDeliveryService.getAllDeliveriesWithCustomerAndTotalPrice();
        return listdeli;
    }



    @GetMapping("/getlivreur")
    public List<Integer> getLivraisonsWithAvailableDeliverer() {
        List<Integer> listlivreur = iDeliveryService.getLivraisonsWithAvailableDeliverer();
        return listlivreur;
    }


    @GetMapping("/getorders")
    public List<Integer> getLivraisonsWithAvailableOrder() {
        List<Integer> listord = iDeliveryService.getLivraisonsWithAvailableOrder();
        return listord;
    }


    @GetMapping("/searchDeliveryByReference/{reference}")
    public int searchDeliveryByReference(@PathVariable("reference") String reference) {
        return iDeliveryService.searchDeliveryByReference(reference);
    }


    @GetMapping("/getLivraisonAllIds")
    public List<Integer> getLivraisonsAllIds() {
        List<Integer> listall = iDeliveryService.getLivraisonsAllIds();
        return listall;
    }

    @GetMapping("/getCustomerNameAndRelypForDelivery/{deliveryId}")
    public String getCustomerNameAndRelypForDelivery(@PathVariable Integer deliveryId) {
        String customerNameAndRelyp = iDeliveryService.getCustomerNameAndRelypForDelivery(deliveryId);
        return customerNameAndRelyp;
    }


    @PostMapping("/addAdress/{deliveryId}")
    public void AddAdressForDelivery(@PathVariable("deliveryId") Integer deliveryId) {
        iDeliveryService.AddAdressForDelivery(deliveryId);
    }


    @PutMapping(value = "/affecter-Rely/{idD}/{IdRp}")
    public void AffecterPointRely(@PathVariable("idD") Integer idD, @PathVariable("IdRp") Integer IdRp) {
        iDeliveryService.AffecterPointRely(idD, IdRp);
    }


   @GetMapping("/allDelivery")
    public List<Delivery> getDelivery() {
        List<Delivery> listall = iDeliveryService.affichageAll();
        return listall;
    }


}