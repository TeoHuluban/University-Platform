package Database;

public class InrolariGrup {
    private int idInrolare;
    private int idStudent;
    private int idGrup;

    public InrolariGrup(int idInrolare, int idStudent, int idGrup) {
        this.idInrolare = idInrolare;
        this.idStudent = idStudent;
        this.idGrup = idGrup;
    }

    public InrolariGrup() {
    }

    public int getIdInrolare() {
        return idInrolare;
    }

    public void setIdInrolare(int idInrolare) {
        this.idInrolare = idInrolare;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdGrup() {
        return idGrup;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }
}
