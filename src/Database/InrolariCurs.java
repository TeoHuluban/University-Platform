package Database;

public class InrolariCurs {
    private int idInrolare;
    private int idStudent;
    private int idProfesor;
    private int idCurs;

    public InrolariCurs(int id_inrolare, int id_student, int id_profesor, int id_curs) {
        this.idInrolare = id_inrolare;
        this.idStudent = id_student;
        this.idProfesor = id_profesor;
        this.idCurs = id_curs;
    }

    public InrolariCurs() {
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

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }
}
