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

public class ActivitatiProfesor extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JButton inapoiButton;
    private JButton downloadButton; // Noul buton de descărcare
    private JTextArea detailsTextArea;

    public ActivitatiProfesor(String email) {
        setTitle("Activitati");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email);
    }

    private void initUI(String email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        searchField = new JTextField(20);
        searchButton = new JButton("Cautare");
        inapoiButton = new JButton("Inapoi");
        downloadButton = new JButton("Descarcă Activități"); // Noul buton de descărcare
        detailsTextArea = new JTextArea();

        detailsTextArea.setVisible(false);

        panel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(inapoiButton);
        topPanel.add(downloadButton);
        downloadButton.setVisible(false);
        panel.add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setVisible(false);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();

                String detaliiActivitati = UtilizatorRepository.vizualizareActivitatiProfesor(email, numeCurs);

                if (detaliiActivitati.equals("Nu aveti activități la acest curs.")) {
                    JOptionPane.showMessageDialog(null, "Nu aveti activități la acest curs.", "Eroare", JOptionPane.ERROR_MESSAGE);
                    detailsTextArea.setVisible(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                } else {
                    detailsTextArea.setText(detaliiActivitati);
                    detailsTextArea.setEditable(false);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                    bottomPanel.setVisible(true);
                    downloadButton.setVisible(true); // Face vizibil butonul de descărcare
                }
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeProf(email).setVisible(true);
            }
        });
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = detailsTextArea.getText();
                downloadActivitatiProfesor(content);
            }
        });

        setVisible(true);
    }

    private void downloadActivitatiProfesor(String content) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ActivitatiProfesor("ivancosmina@yahoo.com"));
    }
}
