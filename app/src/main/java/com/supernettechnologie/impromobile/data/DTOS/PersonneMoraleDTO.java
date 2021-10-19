package com.supernettechnologie.impromobile.data.DTOS;

import android.os.Build;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

import androidx.annotation.RequiresApi;


public class PersonneMoraleDTO implements Serializable {

    private Long id;
    private String numeroIFU;
    private String denomination;
    private LocalDate dateCreate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIFU() {
        return numeroIFU;
    }

    public void setNumeroIFU(String numeroIFU) {
        this.numeroIFU = numeroIFU;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
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

        PersonneMoraleDTO personneMoraleDTO = (PersonneMoraleDTO) o;
        if (personneMoraleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), personneMoraleDTO.getId());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PersonneMoraleDTO{" +
            "id=" + getId() +
            ", numeroIFU='" + getNumeroIFU() + "'" +
            ", denomination='" + getDenomination() + "'" +
            ", dateCreate='" + getDateCreate() + "'" +
            "}";
    }
}
