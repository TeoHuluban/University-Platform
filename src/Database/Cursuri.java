package Database;

public class Cursuri {
    private int idCurs;
    private String denumire;
    private String descriere;
    private int nrMaxStudenti;

    public Cursuri(int id_curs, String denumire, String descriere, int nr_max_studenti) {
        this.idCurs = id_curs;
        this.denumire = denumire;
        this.descriere = descriere;
        this.nrMaxStudenti = nr_max_studenti;
    }

    public Cursuri() {
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getNrMaxStudenti() {
        return nrMaxStudenti;
    }

    public void setNrMaxStudenti(int nrMaxStudenti) {
        this.nrMaxStudenti = nrMaxStudenti;
    }
}
