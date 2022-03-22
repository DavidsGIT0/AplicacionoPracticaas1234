package com.example.aplicacionopracticaas1234;

import java.io.Serializable;

public class Municipio implements Serializable {
    private Long id;
    private Long codMuncipio;
    private String municipi;
    private Integer casosPCR;
    private Integer casosPCR_14;
    private String incidencia_acumulada;
    private String incidencia_acumulada_14;
    private Long defuncions;
    private String taxa_defuncio;

    public Municipio() {
    }

    public Municipio(Long id, Long codMuncipio, String municipi, Integer casosPCR, Integer casosPCR_14, String incidencia_acumulada, String incidencia_acumulada_14, Long defuncions, String taxa_defuncio) {
        this.id = id;
        this.codMuncipio = codMuncipio;
        this.municipi = municipi;
        this.casosPCR = casosPCR;
        this.casosPCR_14 = casosPCR_14;
        this.incidencia_acumulada = incidencia_acumulada;
        this.incidencia_acumulada_14 = incidencia_acumulada_14;
        this.defuncions = defuncions;
        this.taxa_defuncio = taxa_defuncio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodMuncipio() {
        return codMuncipio;
    }

    public void setCodMuncipio(Long codMuncipio) {
        this.codMuncipio = codMuncipio;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public Integer getCasosPCR() {
        return casosPCR;
    }

    public void setCasosPCR(Integer casosPCR) {
        this.casosPCR = casosPCR;
    }

    public Integer getCasosPCR_14() {
        return casosPCR_14;
    }

    public void setCasosPCR_14(Integer casosPCR_14) {
        this.casosPCR_14 = casosPCR_14;
    }

    public String getIncidencia_acumulada() {
        return incidencia_acumulada;
    }

    public void setIncidencia_acumulada(String incidencia_acumulada) {
        this.incidencia_acumulada = incidencia_acumulada;
    }

    public String getIncidencia_acumulada_14() {
        return incidencia_acumulada_14;
    }

    public void setIncidencia_acumulada_14(String incidencia_acumulada_14) {
        this.incidencia_acumulada_14 = incidencia_acumulada_14;
    }

    public Long getDefuncions() {
        return defuncions;
    }

    public void setDefuncions(Long defuncions) {
        this.defuncions = defuncions;
    }

    public String getTaxa_defuncio() {
        return taxa_defuncio;
    }

    public void setTaxa_defuncio(String taxa_defuncio) {
        this.taxa_defuncio = taxa_defuncio;
    }
}