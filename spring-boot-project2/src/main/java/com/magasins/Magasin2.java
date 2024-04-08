package com;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Magasin2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_magasin2")
    private Integer idMagasin2;

    @Column(name="nom_magasin2")
    private String nomMagasin2;
    
    @Column(name="adresse_magasin2")
    private String adresseMagasin2;

    public Integer getidMagasin2() {
        return idMagasin2;
      }
    
    public void setidMagasin2(Integer idMagasin2) {
        this.idMagasin2 = idMagasin2;
      }

    public String getnomMagasin2() {
        return nomMagasin2;
      }

    public void setnomMagasin2(String nomMagasin2) {
        this.nomMagasin2 = nomMagasin2;
      }

    public String getadresseMagasin2() {
        return adresseMagasin2;
      }

    public void setadresseMagasin2(String adresseMagasin2) {
        this.adresseMagasin2 = adresseMagasin2;
      }
    }



























    
