package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SituatieScolara extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JButton inapoiButton;
    private JButton inrolareButton;
    private JButton renuntareButton;
    private JButton noteButton;
    private JTextArea detailsTextArea;

    public SituatieScolara(String email) {
        setTitle("Situatie Scolara");
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
        inrolareButton = new JButton("Inrolare");
        renuntareButton = new JButton("Renuntare");
        noteButton = new JButton("Note");
        detailsTextArea = new JTextArea();

        inrolareButton.setVisible(false);
        renuntareButton.setVisible(false);
        noteButton.setVisible(false);
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
        bottomPanel.add(inrolareButton);
        bottomPanel.add(renuntareButton);
        bottomPanel.add(noteButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();
                String detaliiCurs = UtilizatorRepository.vizualizareDetaliiCurs(numeCurs);

                if (detaliiCurs.equals("Nu s-au gasit detalii pentru cursul specificat.")) {
                    JOptionPane.showMessageDialog(null, "Curs inexistent.", "Eroare", JOptionPane.ERROR_MESSAGE);
                    inrolareButton.setVisible(false);
                    renuntareButton.setVisible(false);
                    noteButton.setVisible(false);
                    detailsTextArea.setVisible(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                } else {
                    detailsTextArea.setText(detaliiCurs);
                    detailsTextArea.setEditable(false);
                    inrolareButton.setVisible(true);
                    renuntareButton.setVisible(true);
                    noteButton.setVisible(true);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                }
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inrolareButton.setVisible(false);
                renuntareButton.setVisible(false);
                noteButton.setVisible(false);
                detailsTextArea.setVisible(false);
                searchField.setText("");
            }
        });

        inrolareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();
                int inrolareCurs = UtilizatorRepository.inrolareCurs(email, numeCurs);
                if(inrolareCurs==0)
                    JOptionPane.showMessageDialog(SituatieScolara.this, "Deja inrolat!");
                else if(inrolareCurs==1)
                    JOptionPane.showMessageDialog(SituatieScolara.this, "Numar maxim de studenti atins!");
                else
                    JOptionPane.showMessageDialog(SituatieScolara.this, "Inrolare reusita!");
            }
        });

        renuntareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();
                int renuntareCurs = UtilizatorRepository.renuntareCurs(email, numeCurs);
                if(renuntareCurs==2)
                    JOptionPane.showMessageDialog(SituatieScolara.this, "Renuntare reusita!");
                else
                    JOptionPane.showMessageDialog(SituatieScolara.this, "Nu sunteti inrolat la acest curs!");
            }
        });

        noteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeCurs = searchField.getText();
                new Note(email, numeCurs).setVisible(true);
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeStudent(email).setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SituatieScolara("hulubanteodora@yahoo.com");
            }
        });
    }
}
