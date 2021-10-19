package com.supernettechnologie.impromobile.data.DTOS;

import android.os.Build;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import androidx.annotation.RequiresApi;

public class CommandeVehiculeDTO implements Serializable {

    private Long id;
    private String numeroCommandeVehicule;
    private ZonedDateTime dateCommande;
    private Boolean estLivree;
    private Long revendeurId;
    private Long concessionnaireId;
    private List<InfoCommandeVehiculeDTO> infoCommandeVehiculeDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCommandeVehicule() {
        return numeroCommandeVehicule;
    }

    public void setNumeroCommandeVehicule(String numeroCommandeVehicule) {
        this.numeroCommandeVehicule = numeroCommandeVehicule;
    }

    public ZonedDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(ZonedDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Boolean isEstLivree() {
        return estLivree;
    }

    public void setEstLivree(Boolean estLivree) {
        this.estLivree = estLivree;
    }

    public Long getRevendeurId() {
        return revendeurId;
    }

    public void setRevendeurId(Long organisationId) {
        this.revendeurId = organisationId;
    }

    public Long getConcessionnaireId() {
        return concessionnaireId;
    }

    public void setConcessionnaireId(Long organisationId) {
        this.concessionnaireId = organisationId;
    }

    public List<InfoCommandeVehiculeDTO> getInfoCommandeVehiculeDTO() {
        return infoCommandeVehiculeDTO;
    }

    public void setInfoCommandeVehiculeDTO(List<InfoCommandeVehiculeDTO> infoCommandeVehiculeDTO) {
        this.infoCommandeVehiculeDTO = infoCommandeVehiculeDTO;
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

        CommandeVehiculeDTO commandeVehiculeDTO = (CommandeVehiculeDTO) o;
        if (commandeVehiculeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), commandeVehiculeDTO.getId());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommandeVehiculeDTO{" +
            "id=" + getId() +
            ", numeroCommandeVehicule='" + getNumeroCommandeVehicule() + "'" +
            ", dateCommande='" + getDateCommande() + "'" +
            ", estLivree='" + isEstLivree() + "'" +
            ", revendeurId=" + getRevendeurId() +
            ", concessionnaireId=" + getConcessionnaireId() +
            "}";
    }
}
