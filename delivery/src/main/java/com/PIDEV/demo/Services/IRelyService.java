package com.PIDEV.demo.Services;

import com.PIDEV.demo.Entities.Delivery;
import com.PIDEV.demo.Entities.RelyPoint;

import java.util.List;

public interface IRelyService {

    public void ajouterRelyPoint(RelyPoint p);
    public RelyPoint modifierRelyPoint(RelyPoint p, int idRp);
    void supprimerRelyPoint (int idRp);
    public List<RelyPoint> affichageAllRely();
    public RelyPoint afficheRely (Integer  idRp);
    public Long countD ();


    //1
    public List<RelyPoint> findByAddress(String ad);
    public List<Delivery> findByRelyPointe (int id );



}
