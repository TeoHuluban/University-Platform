package Database;

import java.util.Date;

public class ActivitatiGrup {
    private int idActivitate;
    private int idGrup;
    private String descriere;
    private Date data;
    private int nrMinParticipanti;
    private int durata;

    public ActivitatiGrup(int id_activitate, int id_grup, String descriere, Date data, int nr_min_participanti, int durata) {
        this.idActivitate = id_activitate;
        this.idGrup = id_grup;
        this.descriere = descriere;
        this.data = data;
        this.nrMinParticipanti = nr_min_participanti;
        this.durata = durata;
    }

    public ActivitatiGrup() {
    }

    public int getIdActivitate() {
        return idActivitate;
    }

    public int getIdGrup() {
        return idGrup;
    }

    public String getDescriere() {
        return descriere;
    }

    public Date getData() {
        return data;
    }

    public int getNrMinParticipanti() {
        return nrMinParticipanti;
    }

    public int getDurata() {
        return durata;
    }

    public void setIdActivitate(int idActivitate) {
        this.idActivitate = idActivitate;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setNrMinParticipanti(int nrMinParticipanti) {
        this.nrMinParticipanti = nrMinParticipanti;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}
