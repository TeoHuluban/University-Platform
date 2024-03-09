package Database;

public class Profesor {
    private int idProfesor;
    private String cnp;
    private String nume;
    private String prenume;
    private String adresa;
    private String nrTel;
    private String email;
    private int nrContract;
    private String iban;
    private int nrMinOre;
    private int nrMaxOre;
    private String departament;

    public Profesor(int idProfesor, String cnp, String nume, String prenume, String adresa, String nrTel, String email, int nrContract, String iban, int nrMinOre, int nrMaxOre, String departament) {
        this.idProfesor = idProfesor;
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.nrTel = nrTel;
        this.email = email;
        this.nrContract = nrContract;
        this.iban = iban;
        this.nrMinOre = nrMinOre;
        this.nrMaxOre = nrMaxOre;
        this.departament = departament;
    }

    public Profesor() {
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrContract() {
        return nrContract;
    }

    public void setNrContract(int nrContract) {
        this.nrContract = nrContract;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getNrMinOre() {
        return nrMinOre;
    }

    public void setNrMinOre(int nrMinOre) {
        this.nrMinOre = nrMinOre;
    }

    public int getNrMaxOre() {
        return nrMaxOre;
    }

    public void setNrMaxOre(int nrMaxOre) {
        this.nrMaxOre = nrMaxOre;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
