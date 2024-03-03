package com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_produits")
    private Integer idP;

    @Column(name="nom_produits")
    private String nomProduits;

    private Integer quantiteProduits;

    @ManyToOne
    @JoinColumn(name = "id_fournisseurs")
    private Fournisseurs fournisseurs; // Relation avec Fournisseurs

    // Getters and Setters

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getNomProduits() {
        return nomProduits;
    }

    public void setNomProduits(String nomProduits) {
        this.nomProduits = nomProduits;
    }

    public Integer getQuantiteProduits() {
        return quantiteProduits;
    }

    public void setQuantiteProduits(Integer quantiteProduits) {
        this.quantiteProduits = quantiteProduits;
    }

    public Fournisseurs getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(Fournisseurs fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
}
