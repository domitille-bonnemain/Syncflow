package com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Parametres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_parametres")
    private Integer id;

    @Column(name="date_souhaitee")
    private Integer dateSouhaitee;

    
    @Column(name="date_butoir")
    private Integer dateButoir;

    @Column(name="quantite_commande")
    private Integer quantiteCommande;

    @ManyToOne
    @JoinColumn(name="id")
    private Magasin2 magasin2;
    @JoinColumn(name="adresse_magasin2")


    // Getters and Setters

    public Integer getIdParametres() {
        return id;
    }

    public void setIdParametres(Integer id) {
        this.id = id;
    }

    public Integer getDateSouhaitee() {
        return dateSouhaitee;
    }

    public void setDateSouhaitee(Integer dateSouhaitee) {
        this.dateSouhaitee = dateSouhaitee;
    }

    public Integer getDateButoir() {
        return dateButoir;
    }

    public void setDateButoir(Integer dateButoir) {
        this.dateButoir = dateButoir;
    }

    public Integer getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(Integer quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public Magasin2 getMagasin2() {
        return magasin2;
    }

    public void setMagasin2(Magasin2 magasin2) {
        this.magasin2 = magasin2;
    }
}