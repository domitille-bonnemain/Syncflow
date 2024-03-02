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
    private Integer id;

    private String nomMagasin2;
    private String adresseMagasin2;

    public Integer getId() {
        return id;
      }
    
    public void setId(Integer id) {
        this.id = id;
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



























    
