package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CautareCurs extends JFrame {
    private JLabel numeLabel;
    private JLabel prenumeLabel;

    private JTextField searchField;
    private JTextField numeField;
    private JTextField prenumeField;

    private JButton searchButton;
    private JButton inapoiButton;
    private JButton asignareButton;
    private JButton studentiButton;
    private JTextArea detailsTextArea;
    private JTextArea detailsTextArea2;
    private JTextArea detailsTextArea3;


    public CautareCurs(String email) {
        setTitle("Cautare Curs");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email);
    }

    private void initUI(String email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        searchField = new JTextField(20);
        numeField = new JTextField(20);
        prenumeField = new JTextField(20);
        searchButton = new JButton("Cautare");
        inapoiButton = new JButton("Inapoi");
        studentiButton = new JButton("Studenti");
        asignareButton = new JButton("Asignare");
        detailsTextArea = new JTextArea();
        detailsTextArea2 = new JTextArea();
        detailsTextArea3 = new JTextArea();
        numeLabel = new JLabel("Nume: ");
        prenumeLabel = new JLabel("Prenume: ");

        detailsTextArea.setVisible(false);
        detailsTextArea2.setVisible(false);
        detailsTextArea3.setVisible(false);

        panel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(studentiButton);
        topPanel.add(inapoiButton);

        panel.add(topPanel, BorderLayout.NORTH);
        //panel.add(detailsTextArea3);
        JScrollPane scrollPane1 = new JScrollPane(detailsTextArea);
        JScrollPane scrollPane2 = new JScrollPane(detailsTextArea2);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane1, scrollPane2);
        splitPane.setDividerLocation(150);
        splitPane.setResizeWeight(0.2);
        panel.add(splitPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(numeLabel);
        bottomPanel.add(numeField);
        bottomPanel.add(prenumeLabel);
        bottomPanel.add(prenumeField);
        bottomPanel.add(asignareButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String numeCurs = searchField.getText();
                String detaliiCurs = UtilizatorRepository.vizualizareDetaliiCurs(numeCurs);
                String detaliiProfi= UtilizatorRepository.profesoriCuCurs(numeCurs);
                if (detaliiCurs.equals("Nu s-au gasit detalii pentru cursul specificat.")) {
                    JOptionPane.showMessageDialog(null, "Curs inexistent.", "Eroare", JOptionPane.ERROR_MESSAGE);

                    detailsTextArea.setVisible(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                    detailsTextArea2.setVisible(false);
                    detailsTextArea2.setFont(new Font("Arial", Font.PLAIN, 16));
                } else {
                    bottomPanel.setVisible(true);
                    scrollPane2.setVisible(true);
                    detailsTextArea.setText(detaliiCurs);
                    detailsTextArea2.setText(detaliiProfi);
                    detailsTextArea.setEditable(false);
                    detailsTextArea2.setEditable(false);

                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                    detailsTextArea2.setVisible(true);
                    detailsTextArea2.setFont(new Font("Arial", Font.PLAIN, 16));
                }
            }
        });

        asignareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numeField.getText();
                String prenume = prenumeField.getText();
                String curs= searchField.getText();
                JOptionPane.showMessageDialog(null,UtilizatorRepository.inrolareProfesorLaCurs(nume, prenume,curs));

                String detaliiProfi= UtilizatorRepository.profesoriCuCurs(curs);

                detailsTextArea2.setText(detaliiProfi);

                detailsTextArea2.setEditable(false);
                detailsTextArea2.setVisible(true);
                detailsTextArea2.setFont(new Font("Arial", Font.PLAIN, 16));

            }
        });

        studentiButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String curs= searchField.getText();
                String studenti= UtilizatorRepository.studentiCuCurs(curs);
                bottomPanel.setVisible(false);
                if (studenti.equals("Nu s-au găsit studenți pentru cursul specificat."))
                    JOptionPane.showMessageDialog(null, "Nu s-au găsit studenți pentru cursul specificat.", "Eroare", JOptionPane.ERROR_MESSAGE);
                else {
                    //splitPane.setVisible(false);
                    //scrollPane1.setVisible(false);
                    scrollPane2.setVisible(false);
                    detailsTextArea.setText(studenti);
                    detailsTextArea.setEditable(false);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

                }
            }
        }));

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeAdmin(email).setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CautareCurs("popescudaniela@yahoo.com");
    }
}
