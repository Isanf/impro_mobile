package com.supernettechnologie.impromobile.data.DTOS;

import android.os.Build;

import com.supernettechnologie.impromobile.data.enumeration.TypeDocIdentification;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.RequiresApi;

public class DocIdentificationPPDTO implements Serializable {

    private Long id;
    private String numeroDoc;
    private LocalDate dateEtablissement;
    private String lieuEtablissement;
    private String autoriteEmettrice;
    private TypeDocIdentification typeDocIdentification;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public LocalDate getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(LocalDate dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }

    public String getLieuEtablissement() {
        return lieuEtablissement;
    }

    public void setLieuEtablissement(String lieuEtablissement) {
        this.lieuEtablissement = lieuEtablissement;
    }

    public String getAutoriteEmettrice() {
        return autoriteEmettrice;
    }

    public void setAutoriteEmettrice(String autoriteEmettrice) {
        this.autoriteEmettrice = autoriteEmettrice;
    }

    public TypeDocIdentification getTypeDocIdentification() {
        return typeDocIdentification;
    }

    public void setTypeDocIdentification(TypeDocIdentification typeDocIdentification) {
        this.typeDocIdentification = typeDocIdentification;
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

        DocIdentificationPPDTO docIdentificationPPDTO = (DocIdentificationPPDTO) o;
        if (docIdentificationPPDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), docIdentificationPPDTO.getId());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DocIdentificationPPDTO{" +
            "id=" + getId() +
            ", numeroDoc='" + getNumeroDoc() + "'" +
            ", dateEtablissement='" + getDateEtablissement() + "'" +
            ", lieuEtablissement='" + getLieuEtablissement() + "'" +
            ", autoriteEmettrice='" + getAutoriteEmettrice() + "'" +
            ", typeDocIdentification='" + getTypeDocIdentification() + "'" +
            "}";
    }
}
