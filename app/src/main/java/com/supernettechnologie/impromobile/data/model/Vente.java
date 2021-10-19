package com.supernettechnologie.impromobile.data.model;

import java.util.Date;

public class Vente {
    private Long id;
    private String numeroVente;
    private Date dateVente;
    private Integer quantiteVendue;
    private Long revendeurId;
    private Long personnePhysiqueId;
    private Long personneMoraleId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroVente() {
        return numeroVente;
    }

    public void setNumeroVente(String numeroVente) {
        this.numeroVente = numeroVente;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public int getQuantiteVendue() {
        return quantiteVendue;
    }

    public void setQuantiteVendue(int quantiteVendue) {
        this.quantiteVendue = quantiteVendue;
    }

    public Long getRevendeurId() {
        return revendeurId;
    }

    public void setRevendeurId(Long revendeurId) {
        this.revendeurId = revendeurId;
    }

    public Long getPersonnePhysiqueId() {
        return personnePhysiqueId;
    }

    public void setPersonnePhysiqueId(Long personnePhysiqueId) {
        this.personnePhysiqueId = personnePhysiqueId;
    }

    public Long getPersonneMoraleId() {
        return personneMoraleId;
    }

    public void setPersonneMoraleId(Long personneMoraleId) {
        this.personneMoraleId = personneMoraleId;
    }


}
