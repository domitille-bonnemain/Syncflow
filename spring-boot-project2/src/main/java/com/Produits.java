package com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nomProduit;

    // Supprimez les importations inutilisées des annotations ManyToOne et JoinColumn
    // Ces annotations sont actuellement commentées et non utilisées, mais vous pouvez également les supprimer si vous ne les utilisez pas.
    
    /*
    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    private Fournisseurs fournisseur; 
    */

    @Column(name = "quantite_produit")
    private Integer quantiteProduit;

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    /*
    public Fournisseurs getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseurs fournisseur) {
        this.fournisseur = fournisseur;
    }
    */

    public Integer getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(Integer quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }
}
