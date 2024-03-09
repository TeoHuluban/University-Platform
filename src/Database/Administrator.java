package Database;

public class Administrator {
    private int idAdmin;
    private String cnp;
    private String nume;
    private String prenume;
    private String adresa;
    private String nrTel;
    private String email;
    private String iban;
    private int nrContract;
    private Boolean superAdmin;

    public Administrator(int idAdmin, String cnp, String nume, String prenume, String adresa, String nrTel, String email, String iban, int nrContract, Boolean superAdmin) {
        this.idAdmin = idAdmin;
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.nrTel = nrTel;
        this.email = email;
        this.iban = iban;
        this.nrContract = nrContract;
        this.superAdmin = superAdmin;
    }

    public Administrator() {
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNrTel() {
        return nrTel;
    }

    public String getEmail() {
        return email;
    }

    public String getIban() {
        return iban;
    }

    public int getNrContract() {
        return nrContract;
    }

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setNrContract(int nrContract) {
        this.nrContract = nrContract;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }
}
