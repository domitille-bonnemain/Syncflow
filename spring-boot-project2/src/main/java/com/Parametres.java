package com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import java.util.Date;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Entity
public class Parametres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_parametres")
    private Integer id;

   // @Temporal(TemporalType.DATE)
   // @Column(name="date_souhaitee")
  //  private Date dateSouhaitee;

  //  @Temporal(TemporalType.DATE)
   // @Column(name="date_butoir")
   // private Date dateButoir;

    @Column(name="quantite_commandee")
    private Integer quantiteCommandee;

   // @ManyToOne
   // @JoinColumn(name="id_magasin2")
   // private Magasin2 idMagasin2;
   // @JoinColumn(name="adresse_magasin2")
   // private String adresseMagasin2;


    // Getters and Setters

    public Integer getIdParametres() {
        return id;
    }

    public void setIdParametres(Integer id) {
        this.id = id;
    }

   /*  public Date getDateSouhaitee() {
        return dateSouhaitee;
    }

    public void setDateSouhaitee(Date dateSouhaitee) {
        this.dateSouhaitee = dateSouhaitee;
    }

    public Date getDateButoir() {
        return dateButoir;
    }

    public void setDateButoir(Date dateButoir) {
        this.dateButoir = dateButoir;
    }*/

    public Integer getQuantiteCommandee() {
        return quantiteCommandee;
    }

    public void setQuantiteCommandee(Integer quantiteCommandee) {
        this.quantiteCommandee = quantiteCommandee;
    }
}
   /*  public Magasin2 getidMagasin2() {
        return idMagasin2;
    }

    public void setidMagasin2(Magasin2 idMagasin2) {
        this.idMagasin2 = idMagasin2;
    }
}*/
