package Database;

public class Predare {
    private int idProfesor;
    private int idCurs;
    private int nr_studenti;
    private boolean curs;
    private boolean seminar;
    private boolean laborator;
    private int procentajCurs;
    private int procentajSeminar;
    private int procentajLaborator;

    public Predare(int idProfesor, int idCurs, int nr_studenti, boolean curs, boolean seminar, boolean laborator, int procentajCurs, int procentajSeminar, int procentajLaborator) {
        this.idProfesor = idProfesor;
        this.idCurs = idCurs;
        this.nr_studenti = nr_studenti;
        this.curs = curs;
        this.seminar = seminar;
        this.laborator = laborator;
        this.procentajCurs = procentajCurs;
        this.procentajSeminar = procentajSeminar;
        this.procentajLaborator = procentajLaborator;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public int getNr_studenti() {
        return nr_studenti;
    }

    public boolean isCurs() {
        return curs;
    }

    public boolean isSeminar() {
        return seminar;
    }

    public boolean isLaborator() {
        return laborator;
    }

    public int getProcentajCurs() {
        return procentajCurs;
    }

    public int getProcentajSeminar() {
        return procentajSeminar;
    }

    public int getProcentajLaborator() {
        return procentajLaborator;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public void setNr_studenti(int nr_studenti) {
        this.nr_studenti = nr_studenti;
    }

    public void setCurs(boolean curs) {
        this.curs = curs;
    }

    public void setSeminar(boolean seminar) {
        this.seminar = seminar;
    }

    public void setLaborator(boolean laborator) {
        this.laborator = laborator;
    }

    public void setProcentajCurs(int procentajCurs) {
        this.procentajCurs = procentajCurs;
    }

    public void setProcentajSeminar(int procentajSeminar) {
        this.procentajSeminar = procentajSeminar;
    }

    public void setProcentajLaborator(int procentajLaborator) {
        this.procentajLaborator = procentajLaborator;
    }
}
