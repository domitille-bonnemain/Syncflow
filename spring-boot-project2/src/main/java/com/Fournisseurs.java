package com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fournisseurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fournisseurs")
    private Integer idFournisseurs;

    @Column(name = "nom_fournisseurs")
    private String nomFournisseurs;

    @Column(name = "adresse_fournisseurs")
    private String adresseFournisseurs;

    // Getters and Setters

    public Integer getIdFournisseurs() {
        return idFournisseurs;
    }

    public void setIdFournisseurs(Integer idFournisseurs) {
        this.idFournisseurs = idFournisseurs;
    }

    public String getNomFournisseurs() {
        return nomFournisseurs;
    }

    public void setNomFournisseurs(String nomFournisseurs) {
        this.nomFournisseurs = nomFournisseurs;
    }

    public String getAdresseFournisseurs() {
        return adresseFournisseurs;
    }

    public void setAdresseFournisseurs(String adresseFournisseurs) {
        this.adresseFournisseurs = adresseFournisseurs;
    }
}
