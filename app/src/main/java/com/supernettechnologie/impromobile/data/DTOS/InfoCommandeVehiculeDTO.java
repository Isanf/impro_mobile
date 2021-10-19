package com.supernettechnologie.impromobile.data.DTOS;


import android.os.Build;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.RequiresApi;


public class InfoCommandeVehiculeDTO implements Serializable {

    private Long id;
    private String numeroCommande;
    private ZonedDateTime dateCommande;
    private Long quantiteCommande;
    private Long commandeVehiculeId;
    private Long marqueVehiculeId;
    Long typeVehiculeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public ZonedDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(ZonedDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Long getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(Long quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public Long getCommandeVehiculeId() {
        return commandeVehiculeId;
    }

    public void setCommandeVehiculeId(Long commandeVehiculeId) {
        this.commandeVehiculeId = commandeVehiculeId;
    }

    public Long getMarqueVehiculeId() {
        return marqueVehiculeId;
    }

    public void setMarqueVehiculeId(Long marqueVehiculeId) {
        this.marqueVehiculeId = marqueVehiculeId;
    }

    public Long getTypeVehiculeId() {
        return typeVehiculeId;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InfoCommandeVehiculeDTO infoCommandeVehiculeDTO = (InfoCommandeVehiculeDTO) o;
        if (infoCommandeVehiculeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), infoCommandeVehiculeDTO.getId());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InfoCommandeVehiculeDTO{" +
            "id=" + getId() +
            ", numeroCommande='" + getNumeroCommande() + "'" +
            ", dateCommande='" + getDateCommande() + "'" +
            ", quantiteCommande=" + getQuantiteCommande() +
            ", commandeVehiculeId=" + getCommandeVehiculeId() +
            ", marqueVehiculeId=" + getMarqueVehiculeId() +
            "}";
    }
}
