package com.supernettechnologie.impromobile.data.DTOS;

import android.os.Build;

import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.RequiresApi;

public class DocIdentificationPMDTO implements Serializable {

    private Long id;
    private String numero;
    private String numeroIFU;
    private String numeroRCCM;
    private String telephone;
    private String siegeSocial;
    private Long organisationId;
    private Long personneMoraleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroIFU() {
        return numeroIFU;
    }

    public void setNumeroIFU(String numeroIFU) {
        this.numeroIFU = numeroIFU;
    }

    public String getNumeroRCCM() {
        return numeroRCCM;
    }

    public void setNumeroRCCM(String numeroRCCM) {
        this.numeroRCCM = numeroRCCM;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiegeSocial() {
        return siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Long getPersonneMoraleId() {
        return personneMoraleId;
    }

    public void setPersonneMoraleId(Long personneMoraleId) {
        this.personneMoraleId = personneMoraleId;
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

        DocIdentificationPMDTO docIdentificationPMDTO = (DocIdentificationPMDTO) o;
        if (docIdentificationPMDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), docIdentificationPMDTO.getId());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DocIdentificationPMDTO{" +
            "id=" + getId() +
            ", numero='" + getNumero() + "'" +
            ", numeroIFU='" + getNumeroIFU() + "'" +
            ", numeroRCCM='" + getNumeroRCCM() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", siegeSocial='" + getSiegeSocial() + "'" +
            ", organisationId=" + getOrganisationId() +
            ", personneMoraleId=" + getPersonneMoraleId() +
            "}";
    }
}
