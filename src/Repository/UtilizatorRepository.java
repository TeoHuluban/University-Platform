package Repository;
import Configuration.ConnectConfig;

import javax.swing.*;
import java.sql.*;


public class UtilizatorRepository {
    public static int autentificare(String email, String parola) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String sqlQuery = "{call Autentificare(?, ?)}";  // Presupunând că procedura stocată returnează un rezultat
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, parola);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int rezultatAutentificare = resultSet.getInt(1);
                        return rezultatAutentificare;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;  // În cazul în care nu există rezultate
    }

    public static int adaugareStudent(String email, String parola, String cnp, String nume, String prenume, String adresa, String nrTel, int nrContract, String iban, int anStudiu, int nrOre) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call AdaugareStudent(?,?,?,?,?,?,?,?,?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);
                callableStatement.setString(2, parola);
                callableStatement.setString(3, cnp);
                callableStatement.setString(4, nume);
                callableStatement.setString(5, prenume);
                callableStatement.setString(6, adresa);
                callableStatement.setString(7, nrTel);
                callableStatement.setInt(8, nrContract);
                callableStatement.setString(9, iban);
                callableStatement.setInt(10, anStudiu);
                callableStatement.setInt(11, nrOre);

                callableStatement.execute();

                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int rezultat = resultSet.getInt(1);
                        return rezultat;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static int adaugareProfesor(String email, String parola, String cnp, String nume, String prenume, String adresa, String nrTel, int nrContract, String iban, int nrMinOre, int nrMaxOre, String departament) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call AdaugareProfesor(?,?,?,?,?,?,?,?,?,?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);
                callableStatement.setString(2, parola);
                callableStatement.setString(3, cnp);
                callableStatement.setString(4, nume);
                callableStatement.setString(5, prenume);
                callableStatement.setString(6, adresa);
                callableStatement.setString(7, nrTel);
                callableStatement.setInt(8, nrContract);
                callableStatement.setString(9, iban);
                callableStatement.setInt(10, nrMinOre);
                callableStatement.setInt(11, nrMaxOre);
                callableStatement.setString(12, departament);

                callableStatement.execute();
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int rezultat = resultSet.getInt(1);
                        return rezultat;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static int adaugareAdministrator(String email, String parola, String cnp, String nume, String prenume, String adresa, String nrTel, int nrContract, String iban, boolean superAdmin) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call AdaugareAdministrator(?,?,?,?,?,?,?,?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);
                callableStatement.setString(2, parola);
                callableStatement.setString(3, cnp);
                callableStatement.setString(4, nume);
                callableStatement.setString(5, prenume);
                callableStatement.setString(6, adresa);
                callableStatement.setString(7, nrTel);
                callableStatement.setInt(8, nrContract);
                callableStatement.setString(9, iban);
                callableStatement.setBoolean(10, superAdmin);

                callableStatement.execute();
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int rezultat = resultSet.getInt(1);
                        return rezultat;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static String vizualizareDatePersonale(String email) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call VizualizareDatePersonale(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);

                // Executăm procedura stocată și returnăm rezultatul
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        // Construim un șir de caractere cu datele
                        String rezultat = "Email: " + resultSet.getString("email") + "\n" +
                                "Nume: " + resultSet.getString("nume") + "\n" +
                                "Prenume: " + resultSet.getString("prenume") + "\n" +
                                "CNP: " + resultSet.getString("cnp") + "\n" +
                                "Adresa: " + resultSet.getString("adresa") + "\n" +
                                "Numar telefon: " + resultSet.getString("nr_tel") + "\n" +
                                "IBAN: " + resultSet.getString("iban") + "\n" +
                                "Numar contract: " + resultSet.getString("nr_contract");

                        // Întoarcem rezultatul sub forma unui șir de caractere
                        return rezultat;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Nu s-au găsit date personale pentru adresa de email specificată.";
    }


    public static String datePersonale(String email) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call VizualizareDatePersonale(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);

                // Executăm procedura stocată și returnăm rezultatul
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        // Construim un șir de caractere cu datele
                        String rezultat = resultSet.getString("nume") + "," +
                                resultSet.getString("prenume") + "," +
                                resultSet.getString("email") + "," +
                                resultSet.getString("cnp") + "," +
                                resultSet.getString("adresa") + "," +
                                resultSet.getString("nr_tel") + "," +
                                resultSet.getString("iban") + "," +
                                resultSet.getString("nr_contract");

                        // Întoarcem rezultatul sub forma unui șir de caractere
                        return rezultat;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Nu s-au găsit date personale pentru adresa de email specificată.";
    }


    public static int inrolareCurs(String emailStudent, String numeCurs) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call InrolareCurs(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setString(2, numeCurs);

                // Execute the stored procedure and return the result
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        int result = resultSet.getInt(1);
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0; // Default result, you can change it based on your specific needs
    }

    public static String vizualizareDetaliiCurs(String numeCurs) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call VizualizareDetaliiCurs(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Execute the stored procedure and return the result
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        // Construct a string with the details
                        String result = "Denumire: " + resultSet.getString("denumire") + "\n" +
                                "Descriere: " + resultSet.getString("descriere") + "\n" +
                                "Nr. Max Studenti: " + resultSet.getInt("nr_max_studenti") + "\n";

                        // Return the result as a string
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Nu s-au gasit detalii pentru cursul specificat.";
    }

    public static int renuntareCurs(String emailStudent, String numeCurs) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call RenuntareCurs(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setString(2, numeCurs);

                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static String afisareNoteStudent(String emailStudent, String numeCurs) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call AfisareNoteStudent(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setString(2, numeCurs);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        // If the student is enrolled, return the notes
                        return "Nota Curs: " + resultSet.getDouble("nota_curs") +
                                "\nNota Seminar: " + resultSet.getDouble("nota_seminar") +
                                "\nNota Laborator: " + resultSet.getDouble("nota_laborator") +
                                "\nNota Finala: " + resultSet.getDouble("nota_finala");

                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Nu sunteti inrolat/Nu aveti note la acest curs!";
    }

    public static void calculareNotaFinala(String emailStudent, String numeCurs) {
        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call CalculareNotaFinala(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setString(2, numeCurs);

                // Executăm procedura stocată
                callableStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String vizualizareActivitatiStudent(String emailStudent) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call VizualizareActivitatiStudent(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Tip Activitate: ").append(resultSet.getString("tip_activitate")).append("\n")
                                .append("Ziua: ").append(resultSet.getString("ziua")).append("\n")
                                .append("Ora Inceput: ").append(resultSet.getString("ora_inceput")).append("\n")
                                .append("Ora Sfarsit: ").append(resultSet.getString("ora_sfarsit")).append("\n")
                                .append("Nr Max Participanti: ").append(resultSet.getInt("nr_max_participanti")).append("\n")
                                .append("Nume Profesor: ").append(resultSet.getString("nume_profesor")).append("\n").append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu sunteti inscris la nicio activitate!";
        }
    }

    public static String vizualizareActivitatiCurs(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call VizualizareActivitatiCurs(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Id: ").append(resultSet.getString("id_activitate")).append("\n")
                                .append("Tip Activitate: ").append(resultSet.getString("tip_activitate")).append("\n")
                                .append("Ziua: ").append(resultSet.getString("ziua")).append("\n")
                                .append("Ora Inceput: ").append(resultSet.getString("ora_inceput")).append("\n")
                                .append("Ora Sfarsit: ").append(resultSet.getString("ora_sfarsit")).append("\n")
                                .append("Nr Max Participanti: ").append(resultSet.getInt("nr_max_participanti")).append("\n")
                                .append("Nume Profesor: ").append(resultSet.getString("nume_profesor")).append("\n").append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu exista activitati pentru acest curs!";
        }
    }

    public static String inrolareStudentActivitateCurs(int idActivitate, String emailStudent) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call InrolareStudentActivitateCurs(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setInt(1, idActivitate);
                callableStatement.setString(2, emailStudent);

                // Execute the stored procedure
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la înrolare.";
    }

    public static String renuntareActivitateCurs(int idActivitate, String emailStudent) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call RenuntareActivitateCurs(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setInt(1, idActivitate);
                callableStatement.setString(2, emailStudent);

                // Execute the stored procedure
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la renunțare.";
    }

    public static String vizualizareActivitatiGrupStudiu(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call VizualizareActivitatiGrupStudiu(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Id Activitate: ").append(resultSet.getInt("id_activitate")).append("\n")
                                .append("Id Grup: ").append(resultSet.getInt("id_grup")).append("\n")
                                .append("Descriere: ").append(resultSet.getString("descriere")).append("\n")
                                .append("Data: ").append(resultSet.getDate("data")).append("\n")
                                .append("Nr Min Participanti: ").append(resultSet.getInt("nr_min_participanti")).append("\n")
                                .append("Durata in ore: ").append(resultSet.getInt("durata")).append("\n")
                                .append("Numar Participanti: ").append(resultSet.getInt("numarStudenti")).append("\n").append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu exista grupuri/activitati de grup pentru acest curs!";
        }
    }

    public static String vizualizareActivitatiGrupStudent(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call VizualizareActivitatiGrupStudent(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Id Activitate: ").append(resultSet.getInt("id_activitate")).append("\n")
                                .append("Curs: ").append(resultSet.getString("Curs")).append("\n")
                                .append("Id Grup: ").append(resultSet.getInt("id_grup")).append("\n")
                                .append("Descriere: ").append(resultSet.getString("descriere")).append("\n")
                                .append("Data: ").append(resultSet.getDate("data")).append("\n")
                                .append("Nr Min Participanti: ").append(resultSet.getInt("nr_min_participanti")).append("\n")
                                .append("Durata in ore: ").append(resultSet.getInt("durata")).append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu ai activitati";
        }
    }

    public static String inrolareGrupStudiu(String emailStudent, int idGrup) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call InrolareGrupStudiu(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setInt(2, idGrup);

                // Execute the stored procedure
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la înrolare în grupul de studiu.";
    }


    public static String renuntareGrupStudiu(String emailStudent, int idGrup) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call RenuntareGrupStudiu(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setInt(2, idGrup);

                // Execute the stored procedure
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la renunțare la grupul de studiu.";
    }


    public static String inrolareActivitateGrup(int idActivitate, String emailStudent) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call InrolareActivitateGrup(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setInt(1, idActivitate);
                callableStatement.setString(2, emailStudent);

                // Execute the stored procedure
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la înrolare în activitatea de grup.";
    }

    public static String renuntareActivitateGrup(String emailStudent, int idActivitate) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call RenuntareActivitateGrup(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailStudent);
                callableStatement.setInt(2, idActivitate);

                // Execute the stored procedure
                try (ResultSet resultSet = callableStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la renunțarea la activitatea de grup.";
    }

    public static int verificaTipUtilizator(String email) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call VerificaTipUtilizator(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);

                // Execute the stored procedure and return the result
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        int result = resultSet.getInt(1);
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1; // Utilizatorul nu a fost gasit in nicio categorie
    }

    public static String cautareUtilizator(String nume, String prenume) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call cautareUtilizator(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {

                callableStatement.setString(1, nume);
                callableStatement.setString(2, prenume);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        String result = resultSet.getString(1);
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Nu s-au gasit detalii pentru utilizatorul specificat.";
    }


    public static String actualizareDatePersonale(String admin_email, String email, String nume, String prenume, String cnp, String adresa, String numarTelefon, String iban, int numarContract) {
        try {
            Connection connection = ConnectConfig.getConnection();
            String storedProcedureCall = "{call actualizareDatePersonale(?,?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, admin_email);
                callableStatement.setString(2, email);
                callableStatement.setString(3, nume);
                callableStatement.setString(4, prenume);
                callableStatement.setString(5, cnp);
                callableStatement.setString(6, adresa);
                callableStatement.setString(7, numarTelefon);
                callableStatement.setString(8, iban);
                callableStatement.setInt(9, numarContract);

                // Execute the stored procedure and return the result
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        String result = resultSet.getString(1);
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String vizualizareUtilizatori(int filtru) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call VizualizareUtilizatori(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setInt(1, filtru);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Email: ").append(resultSet.getString("email")).append("\n")
                                .append("Nume: ").append(resultSet.getString("nume")).append("\n")
                                .append("Prenume: ").append(resultSet.getString("prenume")).append("\n")
                                .append("CNP: ").append(resultSet.getString("cnp")).append("\n")
                                .append("Adresa: ").append(resultSet.getString("adresa")).append("\n")
                                .append("Numar telefon: ").append(resultSet.getString("nr_tel")).append("\n")
                                .append("IBAN: ").append(resultSet.getString("iban")).append("\n")
                                .append("Numar contract: ").append(resultSet.getString("nr_contract")).append("\n").append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu sunt utilizatori!";
        }
    }

    public static String stergereUtilizatorDupaEmail(String adminEmail, String emailUtilizator) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call StergereUtilizatorDupaEmail(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, adminEmail);
                callableStatement.setString(2, emailUtilizator);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append(resultSet.getString(1)).append("\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultStringBuilder.toString();

    }

    public static String profesoriCuCurs(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call ProfesoriCuCurs(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null) {
                        // Iterate through the result set and append details to the string
                        while (resultSet.next()) {
                            resultStringBuilder.append("ID Profesor: ").append(resultSet.getInt("id_profesor")).append("\n")
                                    .append("Nume: ").append(resultSet.getString("nume")).append("\n")
                                    .append("Prenume: ").append(resultSet.getString("prenume")).append("\n")
                                    .append("\n");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Check if any results were found
        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu s-au gasit profesori pentru cursul specificat.";
        }
    }

    public static String inrolareProfesorLaCurs(String numeProfesor, String prenumeProfesor, String denumireCurs) {
        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call InrolareProfesorLaCurs(?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeProfesor);
                callableStatement.setString(2, prenumeProfesor);
                callableStatement.setString(3, denumireCurs);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        String result = resultSet.getString(1);
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String studentiCuCurs(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call StudentiCuCurs(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Execute the stored procedure and return the result
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null) {
                        // Iterate through the result set and append details to the string
                        while (resultSet.next()) {
                            resultStringBuilder.append("ID Student: ").append(resultSet.getInt("id_student")).append("\n")
                                    .append("Nume: ").append(resultSet.getString("nume")).append("\n")
                                    .append("Prenume: ").append(resultSet.getString("prenume")).append("\n")
                                    .append("\n");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Check if any results were found
        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu s-au găsit studenți pentru cursul specificat.";
        }
    }

    public static String membriGrup(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call MembriGrup(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Executarea procedurii stocate
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Nume: ").append(resultSet.getString("nume")).append("\n")
                                .append("Prenume: ").append(resultSet.getString("prenume")).append("\n\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu există membri/grup pentru acest curs!";
        }
    }

    public static String mesaje(String numeCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call Mesaje(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, numeCurs);

                // Executarea procedurii stocate
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append(resultSet.getString("nume")).append(" ")
                                .append(resultSet.getString("prenume")).append(": ")
                                .append(resultSet.getString("mesaj")).append(" ----")
                                .append(resultSet.getString("data")).append("\n\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu există mesaje/grup pentru acest cursul!";
        }
    }

    public static void adaugaMesaj(String mesaj, String emailStudent, String numeCurs) {
        String url = "jdbc:mysql://localhost:3306/proiect";
        String user = "username"; // Schimbă cu username-ul tău
        String password = "password"; // Schimbă cu parola ta

        try (Connection connection = ConnectConfig.getConnection()) {
            String callProcedure = "{CALL AdaugaMesaj(?, ?, ?)}";

            try (PreparedStatement statement = connection.prepareCall(callProcedure)) {
                statement.setString(1, mesaj); // Mesajul
                statement.setString(2, emailStudent); // Email-ul studentului
                statement.setString(3, numeCurs); // Numele cursului

                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String vizualizareActivitatiProfesor(String emailProfesor, String denumireCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call VizualizareActivitatiProfesor(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailProfesor);
                callableStatement.setString(2, denumireCurs);

                // Execută procedura stocată
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        resultStringBuilder.append("Id activitate: ").append(resultSet.getInt("id_activitate")).append("\n")
                                .append("Curs: ").append(resultSet.getString("denumire_curs")).append("\n")
                                .append("Tip activitate: ").append(resultSet.getString("tip_activitate")).append("\n")
                                .append("Ziua: ").append(resultSet.getString("ziua")).append("\n")
                                .append("Ora inceput: ").append(resultSet.getTime("ora_inceput")).append("\n")
                                .append("Ora sfarsit: ").append(resultSet.getTime("ora_sfarsit")).append("\n")
                                .append("Numar maxim participanti: ").append(resultSet.getInt("nr_max_participanti")).append("\n\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Nu aveti activități la acest curs.";
        }
    }

    public static String adaugaActivitateCurs(String emailProfesor, String denumireCurs, String tipActivitate,
                                              String oraInceput, String oraSfarsit, int nrMaxParticipanti, String ziua) {
        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call AdaugaActivitateCurs(?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, emailProfesor);
                callableStatement.setString(2, denumireCurs);
                callableStatement.setString(3, tipActivitate);
                callableStatement.setString(4, oraInceput);
                callableStatement.setString(5, oraSfarsit);
                callableStatement.setInt(6, nrMaxParticipanti);
                callableStatement.setString(7, ziua);

                // Execute the stored procedure
                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null && resultSet.next()) {
                        String result = resultSet.getString(1);
                        return result;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Eroare la adaugare!";
    }

    public static String asignareNoteStudent(String numeCurs, int idStudent, int notaCurs, int notaSemi, int notaLab) {
        try (Connection connection = ConnectConfig.getConnection()) {
            // Apelarea procedurii stocate
            String storedProcedureCall = "{call AsignareNoteStudent(?, ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Setarea parametrilor procedurii
                callableStatement.setString(1, numeCurs);
                callableStatement.setInt(2, idStudent);
                callableStatement.setInt(3, notaCurs);
                callableStatement.setInt(4, notaSemi);
                callableStatement.setInt(5, notaLab);

                // Execute the stored procedure and return the result
                if (callableStatement.execute()) {
                    // Se obține rezultatul procedurii
                    String result = null;
                    while (callableStatement.getResultSet().next()) {
                        result = callableStatement.getResultSet().getString(1);
                    }
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // Tratarea cazului în care nu există rezultat
    }
    public static int[] tipActivitatiCurs(String numeCurs) {
        int[] result = new int[3]; // array pentru a stoca valorile

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call TipActivitatiCurs(?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Setarea parametrilor procedurii
                callableStatement.setString(1, numeCurs);

                // Înregistrarea parametrilor OUT
                callableStatement.registerOutParameter(2, Types.INTEGER);
                callableStatement.registerOutParameter(3, Types.INTEGER);
                callableStatement.registerOutParameter(4, Types.INTEGER);

                // Execute the stored procedure
                callableStatement.execute();

                // Obținerea valorilor rezultate
                result[0] = callableStatement.getInt(2);
                result[1] = callableStatement.getInt(3);
                result[2] = callableStatement.getInt(4);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static String studentiProfesoriLaCurs(String emailProfesor, String denumireCurs) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call StudentiProfesoriLaCurs(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Setarea parametrilor procedurii
                callableStatement.setString(1, emailProfesor);
                callableStatement.setString(2, denumireCurs);

                callableStatement.execute();

                if (callableStatement.execute()) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    if (resultSet != null ) {
                        // Iterate through the result set and append details to the string
                        while (resultSet.next()) {
                            resultStringBuilder.append("ID Student: ").append(resultSet.getInt("id_student")).append("\n")
                                    .append("Nume: ").append(resultSet.getString("nume")).append("\n")
                                    .append("Prenume: ").append(resultSet.getString("prenume")).append("\n")
                                    .append("\n");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (resultStringBuilder.length() > 0) {
            return resultStringBuilder.toString();
        } else {
            return "Cursul nu exista/ Nu predai acest curs!";
        }
    }

    public static String adaugaProcentaj(String numeCurs, String emailProfesor, int procentajCurs, int procentajSeminar, int procentajLaborator) {
        try (Connection connection = ConnectConfig.getConnection()) {
            String storedProcedureCall = "{call AdaugaProcentaj(?, ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Setarea parametrilor procedurii
                callableStatement.setString(1, numeCurs);
                callableStatement.setString(2, emailProfesor);
                callableStatement.setInt(3, procentajCurs);
                callableStatement.setInt(4, procentajSeminar);
                callableStatement.setInt(5, procentajLaborator);

                // Execute the stored procedure
                callableStatement.execute();

                // Obținerea rezultatului procedurii
                String result = null;
                if (callableStatement.getResultSet() != null) {
                    ResultSet resultSet = callableStatement.getResultSet();
                    while (resultSet.next()) {
                        result = resultSet.getString(1);
                    }
                }

                return result != null ? result : "Operațiunea nu a putut fi efectuată.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}



