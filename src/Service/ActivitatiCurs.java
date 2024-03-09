package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ActivitatiCurs extends JFrame {

    private JTextField searchField;
    private JTextField idField;
    private JButton searchButton;
    private JButton inapoiButton;
    private JButton inrolareButton;
    private JButton renuntareButton;
    private JButton actStudButton;
    private JTextArea detailsTextArea;
    private JButton downloadActStudButton;


    public ActivitatiCurs(String email) {
        setTitle("Activitati Curs");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email);
    }

    private void initUI(String email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        searchField = new JTextField(20);
        idField = new JTextField(5);
        searchButton = new JButton("Cautare");
        inapoiButton = new JButton("Inapoi");
        inrolareButton = new JButton("Inscriere");
        renuntareButton = new JButton("Renuntare");
        actStudButton = new JButton("Activitatile tale");
        downloadActStudButton = new JButton("Descarcă Activități");
        detailsTextArea = new JTextArea();


        inrolareButton.setVisible(false);
        renuntareButton.setVisible(false);
        detailsTextArea.setVisible(false);

        panel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(inapoiButton);

        panel.add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("ID Activitate:"));
        bottomPanel.add(idField);
        bottomPanel.add(inrolareButton);
        bottomPanel.add(renuntareButton);
        bottomPanel.add(actStudButton);
        bottomPanel.add(downloadActStudButton);
        bottomPanel.setVisible(false);

        panel.add(bottomPanel, BorderLayout.SOUTH);
        downloadActStudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = detailsTextArea.getText();
                downloadActivitatiStudent(content);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();

                String detaliiActivitati = UtilizatorRepository.vizualizareActivitatiCurs(numeCurs);

                if (detaliiActivitati.equals("Nu exista activitati pentru acest curs!")) {
                    JOptionPane.showMessageDialog(null, "Nu exista activitati pentru acest curs!", "Eroare", JOptionPane.ERROR_MESSAGE);
                    inrolareButton.setVisible(false);
                    renuntareButton.setVisible(false);
                    detailsTextArea.setVisible(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                }
                else {
                    detailsTextArea.setText(detaliiActivitati);
                    detailsTextArea.setEditable(false);
                    inrolareButton.setVisible(true);
                    renuntareButton.setVisible(true);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                    bottomPanel.setVisible(true);
                    downloadActStudButton.setVisible(false);
                }
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inrolareButton.setVisible(false);
                renuntareButton.setVisible(false);
                detailsTextArea.setVisible(false);
                searchField.setText("");
                idField.setText("");
            }
        });

        inrolareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();
                int idActivitate = Integer.parseInt(idField.getText());
                String inrolareAct = UtilizatorRepository.inrolareStudentActivitateCurs(idActivitate, email);
                JOptionPane.showMessageDialog(ActivitatiCurs.this, inrolareAct);
            }
        });

        renuntareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();
                int idActivitate = Integer.parseInt(idField.getText());
                String renuntare = UtilizatorRepository.renuntareActivitateCurs(idActivitate, email);
                JOptionPane.showMessageDialog(ActivitatiCurs.this, renuntare);
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
                String numeCurs = searchField.getText();

                String detaliiActivitati = UtilizatorRepository.vizualizareActivitatiStudent(email);
                detailsTextArea.setText(detaliiActivitati);
                detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                bottomPanel.setVisible(true);

                downloadActStudButton.setVisible(true); // Face vizibil butonul de descărcare
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ActivitatiCurs("hulubanteodora@yahoo.com"));
    }
    private void downloadActivitatiStudent(String content) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Alege locația pentru salvare");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fișiere de text (*.txt)", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setSelectedFile(new File("Activitati_" + System.currentTimeMillis() + ".txt"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".txt");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(content);
                JOptionPane.showMessageDialog(null, "Informațiile au fost salvate cu succes în " + fileToSave.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Eroare la salvarea informațiilor.", "Eroare", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}

