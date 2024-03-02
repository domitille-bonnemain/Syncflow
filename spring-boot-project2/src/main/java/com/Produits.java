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
    private Integer idProduits;

    private String nomProduit;
    private Integer idFournisseur;
    private Integer quantiteProduit;

    // Getters and Setters

    public Integer getIdProduits() {
        return idProduits;
    }

    public void setIdProduits(Integer idProduits) {
        this.idProduits = idProduits;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Integer getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Integer getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(Integer quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }
}
