package Database;

public class Autentificare {
    private String email;
    private String parola;

    public Autentificare(String email, String parola) {
        this.email = email;
        this.parola = parola;
    }

    public Autentificare() {
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
