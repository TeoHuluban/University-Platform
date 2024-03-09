package Database;

public class Mesaje {
    private int idMesaj;
    private int idGrup;
    private int idStudent;
    private String mesaj;

    public Mesaje(int idMesaj, int idGrup, int idStudent, String mesaj) {
        this.idMesaj = idMesaj;
        this.idGrup = idGrup;
        this.idStudent = idStudent;
        this.mesaj = mesaj;
    }

    public int getIdMesaj() {
        return idMesaj;
    }

    public int getIdGrup() {
        return idGrup;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setIdMesaj(int idMesaj) {
        this.idMesaj = idMesaj;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
