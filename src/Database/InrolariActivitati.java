package Database;

public class InrolariActivitati {

    private int idInrolareActivitate;
    private int idActivitate;
    private int idStudent;

    public InrolariActivitati(int idInrolareActivitate, int idActivitate, int idStudent)
    {
        this.idInrolareActivitate = idInrolareActivitate;
        this.idActivitate = idActivitate;
        this.idStudent = idStudent;
    }

    public void setIdInrolareActivitate(int idInrolareActivitate){this.idInrolareActivitate = idInrolareActivitate; }
    public int getIdInrolareActivitate(){return idInrolareActivitate; }
    public void setIdActivitate(int idActivitate){this.idActivitate = idActivitate; }
    public int getIdActivitate(){return idActivitate; }
    public void setIdStudent(int idStudent){this.idStudent = idStudent; }
    public int getIdStudent(){return idStudent; }
}
