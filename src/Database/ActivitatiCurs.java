package Database;

import java.sql.Time;
import java.util.Date;

public class ActivitatiCurs {
    private int idActivitate;
    private int idCurs;
    private String tipActivitate;
    private Date oraInceput;
    private Date oraSfarsit;
    private int nrMaxParticipanti;
    private int idProfesor;
    private String ziua;

    public ActivitatiCurs(int id_activitate, String tip_activitate, Time oraInceput, Time oraSfarsit, int nr_max_participanti, int id_profesor, int id_curs, String ziua) {
        this.idActivitate = id_activitate;
        this.tipActivitate = tip_activitate;
        this.oraInceput = oraInceput;
        this.oraSfarsit = oraSfarsit;
        this.nrMaxParticipanti = nr_max_participanti;
        this.idProfesor = id_profesor;
        this.idCurs = id_curs;
        this.ziua = ziua;
    }
    public ActivitatiCurs() {
    }

    public int getIdActivitate() {
        return idActivitate;
    }

    public void setIdActivitate(int idActivitate) {
        this.idActivitate = idActivitate;
    }

    public String getTipActivitate() {
        return tipActivitate;
    }

    public void setTipActivitate(String tipActivitate) {
        this.tipActivitate = tipActivitate;
    }

    public Date getOraInceput() {
        return oraInceput;
    }

    public void setOraInceput(Date data) {this.oraInceput = oraInceput; }

    public Date getOraSfarsit() {
        return oraSfarsit;
    }

    public void setOraSfarsit(Date data) {
        this.oraSfarsit = oraSfarsit;
    }

    public int getNrMaxParticipanti() {
        return nrMaxParticipanti;
    }

    public void setNrMaxParticipanti(int nrMaxParticipanti) {
        this.nrMaxParticipanti = nrMaxParticipanti;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public String getZiua() {
        return ziua;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public void setZiua(String ziua) {
        this.ziua = ziua;
    }
}
