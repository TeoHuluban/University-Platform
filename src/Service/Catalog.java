package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

import static java.lang.Integer.parseInt;

public class Catalog extends JFrame {
    private JLabel idLabel;
    private JLabel cursLabel;
    private JLabel semiLabel;
    private JLabel labLabel;
    private JButton filtreazaButton;
    private JButton adaugaNotaButton;
    private JButton inapoiButton;
    private  JButton downloadButton;
    private JTextArea detailsTextArea;
    private JTextField cursTextField;
    private JTextField idTextField;
    private JTextField notaCursTextField;
    private JTextField notaLabTextField;
    private JTextField notaSemiTextField;

    public Catalog(String email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        setTitle("Catalog");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        filtreazaButton = new JButton("Filtrează");
        inapoiButton = new JButton("Înapoi");
        detailsTextArea = new JTextArea();
        idTextField = new JTextField(10);
        notaCursTextField = new JTextField(10);
        notaLabTextField = new JTextField(10);
        notaSemiTextField = new JTextField(10);
        adaugaNotaButton = new JButton("Adaugă Notă");
        cursTextField = new JTextField(20);

        idLabel = new JLabel("Id Student:");
        cursLabel = new JLabel("Notă Curs:");
        semiLabel = new JLabel("Notă Seminar:");
        labLabel = new JLabel("Notă Laborator:");
        downloadButton = new JButton("Descarcă Catalog");

        detailsTextArea.setVisible(false);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Curs:"));
        topPanel.add(cursTextField);
        topPanel.add(filtreazaButton);
        topPanel.add(inapoiButton);

        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(idLabel);
        bottomPanel.add(idTextField);
        bottomPanel.add(cursLabel);
        bottomPanel.add(notaCursTextField);
        bottomPanel.add(semiLabel);
        bottomPanel.add(notaSemiTextField);
        bottomPanel.add(labLabel);
        bottomPanel.add(notaLabTextField);
        bottomPanel.add(adaugaNotaButton);
        bottomPanel.add(downloadButton);

        bottomPanel.setVisible(false); // Inițial ascuns

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = detailsTextArea.getText();
                downloadCatalogInformation(content);
            }
        });
        filtreazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String curs = cursTextField.getText();
                String studenti = UtilizatorRepository.studentiProfesoriLaCurs(email,curs);

                if (studenti.equals("Profesorul nu predă cursul specificat.")) {
                    JOptionPane.showMessageDialog(null, "Profesorul nu predă cursul specificat.", "Eroare", JOptionPane.ERROR_MESSAGE);
                } else {
                    int a= 0, b= 0, c= 0;
                    int[] v= UtilizatorRepository.tipActivitatiCurs(curs);
                    System.out.println(v[0]);
                    System.out.println(v[1]);
                    System.out.println(v[2]);
                    System.out.println("\n");

                    idTextField.setText("");
                    cursLabel.setVisible(true);
                    notaCursTextField.setVisible(true);
                    notaCursTextField.setText("");

                    semiLabel.setVisible(true);
                    notaSemiTextField.setVisible(true);
                    notaSemiTextField.setText("");

                    labLabel.setVisible(true);
                    notaLabTextField.setVisible(true);
                    notaLabTextField.setText("");

                    if (v[0]==0){
                            cursLabel.setVisible(false);
                            notaCursTextField.setVisible(false);
                        }
                    if (v[1]==0) {
                            semiLabel.setVisible(false);
                            notaSemiTextField.setVisible(false);
                        }
                    if (v[2]==0) {
                            labLabel.setVisible(false);
                            notaLabTextField.setVisible(false);
                        }

                    detailsTextArea.setVisible(true);
                    detailsTextArea.setText(studenti);
                    detailsTextArea.setEditable(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

                    bottomPanel.setVisible(true); // Face vizibile butoanele și fieldurile de jos
                }
            }
        });

        adaugaNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idStudent = 0;
                int curs = 0;
                int seminar = 0;
                int laborator = 0;

                String numeCurs = cursTextField.getText();
                idStudent = parseInt(idTextField.getText());

                int[] v= UtilizatorRepository.tipActivitatiCurs(numeCurs);

                if (v[0]==1) {
                    if (notaCursTextField.getText() != null)
                        curs = parseInt(notaCursTextField.getText());
                }
                if (v[1]==1){
                    if (notaSemiTextField.getText() != null)
                        seminar = parseInt(notaSemiTextField.getText());
                }
                if (v[2]==1){
                    if (notaLabTextField.getText() != null)
                        laborator = parseInt(notaLabTextField.getText());
                }
                JOptionPane.showMessageDialog(null, UtilizatorRepository.asignareNoteStudent(numeCurs, idStudent, curs, seminar, laborator));
            }
        });
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeProf(email).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Catalog("ivancosmina@yahoo.com").setVisible(true);
            }
        });
    }
    private void downloadCatalogInformation(String content) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Alege locația pentru salvare");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fișiere de text (*.txt)", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setSelectedFile(new File("Catalog_" + System.currentTimeMillis() + ".txt"));

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
