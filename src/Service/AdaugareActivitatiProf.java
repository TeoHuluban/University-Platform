package Service;

import Service.HomeProf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Repository.UtilizatorRepository.adaugaActivitateCurs;
import static java.lang.Integer.parseInt;

public class AdaugareActivitatiProf extends JFrame {
    private JTextField denumireField, tipActivitateField, oraInceputField, oraSfarsitField, participantiField, ziuaField;

    public AdaugareActivitatiProf(String email) {
        setTitle("Adăugare Activitate");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email);
    }

    private void initUI(String email) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10)); // Modificarea aici pentru a adăuga spații între componente
        //JPanel panel = new JPanel();
        //getContentPane().add(panel);
        // Labels
        panel.add(new JLabel("Denumire Curs:"));
        denumireField = new JTextField(20);
        panel.add(denumireField);

        panel.add(new JLabel("Tip Activitate:"));
        tipActivitateField = new JTextField(20);
        panel.add(tipActivitateField);

        ziuaField = new JTextField(20);
        panel.add(new JLabel("Ziua activitatii:"));
        panel.add(ziuaField);

        panel.add(new JLabel("Ora Început:"));
        oraInceputField = new JTextField(20);
        panel.add(oraInceputField);

        panel.add(new JLabel("Ora Sfârșit:"));
        oraSfarsitField = new JTextField(20);
        panel.add(oraSfarsitField);

        panel.add(new JLabel("Număr Maxim Participanți:"));
        participantiField = new JTextField(20);
        panel.add(participantiField);

        JButton adaugaButton = new JButton("Adaugă Activitate");
        JButton inapoiButton = new JButton("Înapoi"); // Butonul Înapoi

        panel.add(inapoiButton);
        panel.add(adaugaButton);


        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementarea existentă
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeProf(email).setVisible(true);
            }
        });

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdaugareActivitatiProf("ivancosmina@yahoo.com"));
    }
}
