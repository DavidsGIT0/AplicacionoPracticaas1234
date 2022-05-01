package com.example.aplicacionopracticaas1234;

public class ReportInfo {
    private Integer diagnosticCode;
    private String startDate, municipio;
    private Boolean fever, cough, shortness, fatigue, muscle, headache, newLoss, sore, congestion, nausea,
            diarrhea, closeContact;

    public ReportInfo(String startDate, Boolean fever, Boolean cough, Boolean shortness, Boolean fatigue, Boolean muscle, Boolean headache, Boolean newLoss, Boolean sore, Boolean congestion, Boolean nausea, Boolean diarrhea, Boolean closeContact) {
        this.startDate = startDate;
        this.fever = fever;
        this.cough = cough;
        this.shortness = shortness;
        this.fatigue = fatigue;
        this.muscle = muscle;
        this.headache = headache;
        this.newLoss = newLoss;
        this.sore = sore;
        this.congestion = congestion;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.closeContact = closeContact;
    }

    public ReportInfo(Integer diagnosticCode, String startDate, Boolean fever, Boolean cough, Boolean shortness, Boolean fatigue, Boolean muscle, Boolean headache, Boolean newLoss, Boolean sore, Boolean congestion, Boolean nausea, Boolean diarrhea, Boolean closeContact) {

        this.diagnosticCode = diagnosticCode;
        this.startDate = startDate;
        this.fever = fever;
        this.cough = cough;
        this.shortness = shortness;
        this.fatigue = fatigue;
        this.muscle = muscle;
        this.headache = headache;
        this.newLoss = newLoss;
        this.sore = sore;
        this.congestion = congestion;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.closeContact = closeContact;
    }

    public ReportInfo(String startDate, Boolean fever, Boolean cough, Boolean shortness, Boolean fatigue, Boolean muscle, Boolean headache, Boolean newLoss, Boolean sore, Boolean congestion, Boolean nausea, Boolean diarrhea, Boolean closeContact, String municipio) {
        this.startDate = startDate;
        this.fever = fever;
        this.cough = cough;
        this.shortness = shortness;
        this.fatigue = fatigue;
        this.muscle = muscle;
        this.headache = headache;
        this.newLoss = newLoss;
        this.sore = sore;
        this.congestion = congestion;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.closeContact = closeContact;
        this.municipio = municipio;
    }

    public ReportInfo() {
    }

    public Integer getDiagnosticCode() {
        return diagnosticCode;
    }

    public void setDiagnosticCode(Integer diagnosticCode) {
        this.diagnosticCode = diagnosticCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {

        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getShortness() {
        return shortness;
    }

    public void setShortness(Boolean shortness) {
        this.shortness = shortness;
    }

    public Boolean getFatigue() {
        return fatigue;
    }

    public void setFatigue(Boolean fatigue) {
        this.fatigue = fatigue;
    }

    public Boolean getMuscle() {
        return muscle;
    }

    public void setMuscle(Boolean muscle) {
        this.muscle = muscle;
    }

    public Boolean getHeadache() {
        return headache;
    }

    public void setHeadache(Boolean headache) {
        this.headache = headache;
    }

    public Boolean getNewLoss() {
        return newLoss;
    }

    public void setNewLoss(Boolean newLoss) {
        this.newLoss = newLoss;
    }

    public Boolean getSore() {
        return sore;
    }

    public void setSore(Boolean sore) {
        this.sore = sore;
    }

    public Boolean getCongestion() {
        return congestion;
    }

    public void setCongestion(Boolean congestion) {
        this.congestion = congestion;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean getCloseContact() {
        return closeContact;
    }

    public void setCloseContact(Boolean closeContact) {
        this.closeContact = closeContact;
    }

    public String getMunicipio() { return municipio; }

    public void setMunicipio(String municipio) { this.municipio = municipio;}
}
