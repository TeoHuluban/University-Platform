package Database;

public class Note {
    private int id_nota;
    private int id_student;
    private int id_curs;
    private int nota_curs;
    private int nota_seminar;
    private int nota_laborator;
    private int nota_finala;

    public Note(int id_nota, int id_student, int id_curs, int nota_curs, int nota_seminar, int nota_laborator, int nota_finala) {
        this.id_nota = id_nota;
        this.id_student = id_student;
        this.id_curs = id_curs;
        this.nota_curs = nota_curs;
        this.nota_seminar = nota_seminar;
        this.nota_laborator = nota_laborator;
        this.nota_finala = nota_finala;
    }

    public int getIdNota() {
        return id_nota;
    }

    public int getIdStudent() {
        return id_student;
    }

    public int getIdCurs() {
        return id_curs;
    }

    public int getNotaCurs() {
        return nota_curs;
    }

    public int getNotaSeminar() {
        return nota_seminar;
    }

    public int getNotaLaborator() {
        return nota_laborator;
    }

    public int getNotaFinala() {
        return nota_finala;
    }

    public void setIdNota(int idNode) {
        this.id_nota = idNode;
    }

    public void setIdStudent(int idStudent) {
        this.id_student = idStudent;
    }

    public void setIdCurs(int idCurs) {
        this.id_curs = idCurs;
    }

    public void setNotaCurs(int notaCurs) {
        this.nota_curs = notaCurs;
    }

    public void setNotaSeminar(int notaSeminar) {
        this.nota_seminar = notaSeminar;
    }

    public void setNotaLaborator(int notaLaborator) {
        this.nota_laborator = notaLaborator;
    }

    public void setNotaFinala(int notaFinala) {
        this.nota_finala = notaFinala;
    }
}
