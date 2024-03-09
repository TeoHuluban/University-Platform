package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Repository.UtilizatorRepository.*;

public class GrupuriStudiu extends JFrame {

    private JTextField searchField;
    private JTextField idActivitateField;
    private JTextField idGrupField;  // Noul câmp Id Grup
    private JButton searchButton;
    private JButton inapoiButton;
    private JButton inrolareGrupButton;
    private JButton renuntareGrupButton;
    private JButton inrolareActvButton;
    private JButton renuntareActvButton;
    private JButton actStudButton;
    private JTextArea detailsTextArea;
    private JButton membriButton;
    private JButton mesajeButton;

    public GrupuriStudiu(String email) {
        setTitle("Grupuri Studiu");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email);
    }

    private void initUI(String email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        searchField = new JTextField(20);
        idActivitateField = new JTextField(5);
        idGrupField = new JTextField(5);  // Noul câmp Id Grup
        searchButton = new JButton("Cautare");
        inapoiButton = new JButton("Inapoi");
        inrolareGrupButton = new JButton("Inscriere");
        renuntareGrupButton = new JButton("Renuntare");
        inrolareActvButton = new JButton("Inscriere");
        renuntareActvButton = new JButton("Renuntare");
        actStudButton = new JButton("Activitatile tale");
        detailsTextArea = new JTextArea();
        membriButton = new JButton("Membri");
        mesajeButton = new JButton("Mesaje");

        inrolareGrupButton.setVisible(false);
        renuntareGrupButton.setVisible(false);
        inrolareActvButton.setVisible(false);
        renuntareActvButton.setVisible(false);
        detailsTextArea.setVisible(false);

        panel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(membriButton);
        topPanel.add(mesajeButton);
        topPanel.add(inapoiButton);

        panel.add(topPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 3));  // Setăm layout-ul la GridLayout

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Id Grup:"));
        panel1.add(idGrupField);
        panel1.add(inrolareGrupButton);
        panel1.add(renuntareGrupButton);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Id Activitate:"));
        panel2.add(idActivitateField);
        panel2.add(inrolareActvButton);
        panel2.add(renuntareActvButton);

        JPanel panel3 = new JPanel();
        panel3.add(actStudButton);

        bottomPanel.add(panel1);
        bottomPanel.add(panel2);
        bottomPanel.add(panel3);

        bottomPanel.setVisible(false);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomPanel.removeAll(); // Elimină toate componentele din bottomPanel
                String numeCurs = searchField.getText();

                String detaliiGrupuri = UtilizatorRepository.vizualizareActivitatiGrupStudiu(numeCurs);

                if (detaliiGrupuri.equals("Nu exista grupuri/activitati de grup pentru acest curs!")) {
                    JOptionPane.showMessageDialog(null, "Nu exista grupuri/activitati de grup pentru acest curs!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    detailsTextArea.setVisible(false);
                    inrolareGrupButton.setVisible(false);
                    renuntareGrupButton.setVisible(false);
                    inrolareActvButton.setVisible(false);
                    renuntareActvButton.setVisible(false);
                    bottomPanel.setVisible(false);
                } else {
                    detailsTextArea.setText(detaliiGrupuri);
                    detailsTextArea.setEditable(false);
                    inrolareGrupButton.setVisible(true);
                    renuntareGrupButton.setVisible(true);
                    inrolareActvButton.setVisible(true);
                    renuntareActvButton.setVisible(true);
                    detailsTextArea.setVisible(true);

                    // Adaugă câmpurile inițiale în bottomPanel
                    JPanel panel1 = new JPanel();
                    panel1.add(new JLabel("Id Grup:"));
                    panel1.add(idGrupField);
                    panel1.add(inrolareGrupButton);
                    panel1.add(renuntareGrupButton);

                    JPanel panel2 = new JPanel();
                    panel2.add(new JLabel("Id Activitate:"));
                    panel2.add(idActivitateField);
                    panel2.add(inrolareActvButton);
                    panel2.add(renuntareActvButton);

                    JPanel panel3 = new JPanel();
                    panel3.add(actStudButton);

                    bottomPanel.add(panel1);
                    bottomPanel.add(panel2);
                    bottomPanel.add(panel3);
                }

                bottomPanel.setVisible(true);
                bottomPanel.revalidate(); // Asigură-te că layout-ul este actualizat
            }
        });

        mesajeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomPanel.removeAll(); // Elimină toate componentele din bottomPanel
                bottomPanel.repaint();  // Asigură-te că se redesenează

                String numeCurs = searchField.getText();

                String mesaje = UtilizatorRepository.mesaje(numeCurs);

                if (mesaje.equals("Nu există mesaje/grup pentru acest cursul!")) {
                    JOptionPane.showMessageDialog(null, "Nu există mesaje/grup pentru acest cursul!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    detailsTextArea.setVisible(false);
                } else {
                    detailsTextArea.setText(mesaje);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

                    // Adaugă un câmp de text pentru mesaj și un buton de trimitere în bara de jos
                    JPanel inputPanel = new JPanel();
                    JTextField mesajField = new JTextField(20);
                    JButton trimiteMesajButton = new JButton("Trimite Mesaj");

                    trimiteMesajButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String mesajText = mesajField.getText();
                            UtilizatorRepository.adaugaMesaj(mesajText, email, numeCurs);
                            detailsTextArea.setText(UtilizatorRepository.mesaje(numeCurs));
                            mesajField.setText("");
                            //JOptionPane.showMessageDialog(null, "Mesaj trimis cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
                        }
                    });

                    inputPanel.add(mesajField);
                    inputPanel.add(trimiteMesajButton);
                    bottomPanel.add(inputPanel);
                }

                bottomPanel.setVisible(true);
                bottomPanel.revalidate(); // Asigură-te că layout-ul este actualizat
                bottomPanel.repaint();  // Asigură-te că se redesenează
            }
        });


        membriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomPanel.setVisible(false);
                String numeCurs = searchField.getText();

                String membri = UtilizatorRepository.membriGrup(numeCurs);

                if (membri.equals("Nu există membri/grup pentru acest curs!")) {
                    JOptionPane.showMessageDialog(null, "Nu există membri/grup pentru acest curs!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    detailsTextArea.setVisible(false);
                } else {
                    detailsTextArea.setText(membri);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                }
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inrolareGrupButton.setVisible(false);
                renuntareGrupButton.setVisible(false);
                inrolareActvButton.setVisible(false);
                renuntareActvButton.setVisible(false);
                detailsTextArea.setVisible(false);
                searchField.setText("");
                idGrupField.setText("");
                idActivitateField.setText("");
            }
        });

        inrolareGrupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idGrupText = idGrupField.getText();

                // Verifică dacă șirul nu este gol
                if (!idGrupText.isEmpty()) {
                    int idGrup = Integer.parseInt(idGrupText);
                    String inrolareGrup = inrolareGrupStudiu(email, idGrup);
                    JOptionPane.showMessageDialog(GrupuriStudiu.this, inrolareGrup);
                }
            }
        });


        renuntareGrupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idGrupText = idGrupField.getText();

                // Verifică dacă șirul nu este gol
                if (!idGrupText.isEmpty()) {
                    int idGrup = Integer.parseInt(idGrupText);
                    String renuntareGrup = renuntareGrupStudiu(email, idGrup);
                    JOptionPane.showMessageDialog(GrupuriStudiu.this, renuntareGrup);
                }
            }
        });


        inrolareActvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idActivitateText = idActivitateField.getText();

                // Verifică dacă șirul nu este gol
                if (!idActivitateText.isEmpty()) {
                    int idActivitate = Integer.parseInt(idActivitateText);
                    String inrolareActivitate = inrolareActivitateGrup(idActivitate, email);
                    JOptionPane.showMessageDialog(GrupuriStudiu.this, inrolareActivitate);
                }
            }
        });


        renuntareActvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idActivitateText = idActivitateField.getText();

                // Verifică dacă șirul nu este gol
                if (!idActivitateText.isEmpty()) {
                    int idActivitate = Integer.parseInt(idActivitateText);
                    String renuntareActivitate = renuntareActivitateGrup(email, idActivitate);
                    JOptionPane.showMessageDialog(GrupuriStudiu.this, renuntareActivitate);
                }
            }
        });


        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeStudent(email).setVisible(true);
            }
        });

        actStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String detaliiGrupuri = UtilizatorRepository.vizualizareActivitatiGrupStudent(email);
                detailsTextArea.setText(detaliiGrupuri);
                detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                bottomPanel.setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GrupuriStudiu("hulubanteodora@yahoo.com"));
    }
}
