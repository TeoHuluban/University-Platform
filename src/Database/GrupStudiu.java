package Database;

public class GrupStudiu {
    private int idGrup;
    private int idCurs;
    private String mesaje;

    public GrupStudiu(int id_grup, int id_curs, String mesaje) {
        this.idGrup = id_grup;
        this.idCurs = id_curs;
        this.mesaje = mesaje;
    }

    public GrupStudiu() {
    }

    public int getIdGrup() {
        return idGrup;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getMesaje() {
        return mesaje;
    }

    public void setMesaje(String mesaje) {
        this.mesaje = mesaje;
    }
}
