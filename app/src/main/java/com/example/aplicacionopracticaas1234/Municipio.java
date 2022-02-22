package com.example.aplicacionopracticaas1234;

public class Municipio {
    private Long id;
    private Long codMuncipio;
    private String municipi;
    private Integer casosPCR;
    private Integer casosPCR_14;
    private Double incidencia_acumulada;
    private Double incidencia_acumulada_14;
    private Long defuncions;
    private Double taxa_defuncio;

    public Municipio() {
    }

    public Municipio(Long id, Long codMuncipio, String municipi, Integer casosPCR, Integer casosPCR_14, Double incidencia_acumulada, Double incidencia_acumulada_14, Long defuncions, Double taxa_defuncio) {
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

    public Double getIncidencia_acumulada() {
        return incidencia_acumulada;
    }

    public void setIncidencia_acumulada(Double incidencia_acumulada) {
        this.incidencia_acumulada = incidencia_acumulada;
    }

    public Double getIncidencia_acumulada_14() {
        return incidencia_acumulada_14;
    }

    public void setIncidencia_acumulada_14(Double incidencia_acumulada_14) {
        this.incidencia_acumulada_14 = incidencia_acumulada_14;
    }

    public Long getDefuncions() {
        return defuncions;
    }

    public void setDefuncions(Long defuncions) {
        this.defuncions = defuncions;
    }

    public Double getTaxa_defuncio() {
        return taxa_defuncio;
    }

    public void setTaxa_defuncio(Double taxa_defuncio) {
        this.taxa_defuncio = taxa_defuncio;
    }
}