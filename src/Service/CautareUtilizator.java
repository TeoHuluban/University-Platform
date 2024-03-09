package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class CautareUtilizator extends JFrame {
    private JTextField numeField;
    private JTextField prenumeField;
    private JButton cautareButton;
    private JButton inapoiButton;
    private JTextArea detailsTextArea;

    private JLabel numeLabel;
    private JLabel prenumeLabel;
    private JLabel emailLabel;
    private JLabel cnpLabel;
    private JLabel adresaLabel;
    private JLabel telefonLabel;
    private JLabel ibanLabel;
    private JLabel nrContractLabel;

    private JTextField numeFieldEditabil;
    private JTextField prenumeFieldEditabil;
    private JTextField emailFieldEditabil;
    private JTextField cnpFieldEditabil;
    private JTextField adresaFieldEditabil;
    private JTextField telefonFieldEditabil;
    private JTextField ibanFieldEditabil;
    private JTextField nrContractFieldEditabil;
    private JButton actualizareButton;
    private JButton stergereButton;

    // Butoane radio pentru filtru
    private JRadioButton studentRadioButton;
    private JRadioButton profesorRadioButton;
    private JRadioButton adminRadioButton;

    public CautareUtilizator(String email) {
        setTitle("Cautare Utilizator");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email);
    }

    private void initUI(String admin_email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        numeField = new JTextField(20);
        prenumeField = new JTextField(20);
        cautareButton = new JButton("Cautare");
        inapoiButton = new JButton("Inapoi");
        detailsTextArea = new JTextArea();

        detailsTextArea.setVisible(false);

        panel.setLayout(new BorderLayout());
        studentRadioButton = new JRadioButton("Student");
        profesorRadioButton = new JRadioButton("Profesor");
        adminRadioButton = new JRadioButton("Administrator");

        ButtonGroup filterGroup = new ButtonGroup();
        filterGroup.add(studentRadioButton);
        filterGroup.add(profesorRadioButton);
        filterGroup.add(adminRadioButton);

        //studentRadioButton.setSelected(true);  // Selectăm implicit Student

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Nume: "));
        topPanel.add(numeField);
        topPanel.add(new JLabel("Prenume: "));
        topPanel.add(prenumeField);
        topPanel.add(cautareButton);
        topPanel.add(inapoiButton);
        topPanel.add(studentRadioButton);
        topPanel.add(profesorRadioButton);
        topPanel.add(adminRadioButton);


        panel.add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);


        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etichetele si campurile editabile vor fi ascunse initial
        numeLabel = new JLabel("Nume: ");
        numeLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        editPanel.add(numeLabel, gbc);

        numeFieldEditabil = new JTextField(20);
        numeFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(numeFieldEditabil, gbc);

        prenumeLabel = new JLabel("Prenume: ");
        prenumeLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        editPanel.add(prenumeLabel, gbc);

        prenumeFieldEditabil = new JTextField(20);
        prenumeFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(prenumeFieldEditabil, gbc);

        emailLabel = new JLabel("Email: ");
        emailLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        editPanel.add(emailLabel, gbc);

        emailFieldEditabil = new JTextField(20);
        emailFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(emailFieldEditabil, gbc);

        cnpLabel = new JLabel("CNP: ");
        cnpLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        editPanel.add(cnpLabel, gbc);

        cnpFieldEditabil = new JTextField(20);
        cnpFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(cnpFieldEditabil, gbc);

        adresaLabel = new JLabel("Adresa: ");
        adresaLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        editPanel.add(adresaLabel, gbc);

        adresaFieldEditabil = new JTextField(20);
        adresaFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(adresaFieldEditabil, gbc);

        telefonLabel = new JLabel("Telefon: ");
        telefonLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        editPanel.add(telefonLabel, gbc);

        telefonFieldEditabil = new JTextField(20);
        telefonFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(telefonFieldEditabil, gbc);

        ibanLabel = new JLabel("IBAN: ");
        ibanLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 6;
        editPanel.add(ibanLabel, gbc);

        ibanFieldEditabil = new JTextField(20);
        ibanFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(ibanFieldEditabil, gbc);

        nrContractLabel = new JLabel("Nr. Contract: ");
        nrContractLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        editPanel.add(nrContractLabel, gbc);

        nrContractFieldEditabil = new JTextField(20);
        nrContractFieldEditabil.setVisible(false);
        gbc.gridx = 1;
        editPanel.add(nrContractFieldEditabil, gbc);

        actualizareButton = new JButton("Actualizare");
        actualizareButton.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        editPanel.add(actualizareButton, gbc);

        stergereButton = new JButton("Stergere Utilizator");
        stergereButton.setVisible(false);
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        editPanel.add(stergereButton, gbc);

        panel.add(editPanel, BorderLayout.SOUTH);

        studentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filtru = 0;
                String rezultat = UtilizatorRepository.vizualizareUtilizatori(filtru);

                System.out.println(rezultat); // Mesaj de depanare
                detailsTextArea.setText(rezultat);
                detailsTextArea.setEditable(false);
                detailsTextArea.setVisible(true);
                detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

            }
        });

        profesorRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filtru = 1;
                String rezultat = UtilizatorRepository.vizualizareUtilizatori(filtru);
                setCampuriEditabileVizibile(false);

                detailsTextArea.setText(rezultat);
                detailsTextArea.setEditable(false);
                detailsTextArea.setVisible(true);
                detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

            }
        });

        adminRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filtru = 2;
                String rezultat = UtilizatorRepository.vizualizareUtilizatori(filtru);
                setCampuriEditabileVizibile(false);

                detailsTextArea.setText(rezultat);
                detailsTextArea.setEditable(false);
                detailsTextArea.setVisible(true);
                detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

            }
        });

        studentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filtru = 0;
                String rezultat = UtilizatorRepository.vizualizareUtilizatori(filtru);
                setCampuriEditabileVizibile(false);

                detailsTextArea.setText(rezultat);
                detailsTextArea.setEditable(false);
                detailsTextArea.setVisible(true);
                detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

            }
        });

        cautareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterGroup.clearSelection();
                String nume = numeField.getText();
                String prenume = prenumeField.getText();
                String detaliiUtilizator = UtilizatorRepository.cautareUtilizator(nume, prenume);

                if (detaliiUtilizator.equals("Nu s-au gasit detalii pentru utilizatorul specificat.")) {
                    JOptionPane.showMessageDialog(null, "Utilizator inexistent.", "Eroare", JOptionPane.ERROR_MESSAGE);
                    detailsTextArea.setVisible(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                    // Ascundem etichetele si campurile editabile
                    setCampuriEditabileVizibile(false);
                } else {
                    String[] detalii = UtilizatorRepository.datePersonale(detaliiUtilizator).split(",");

                    numeFieldEditabil.setText(detalii[0]);
                    prenumeFieldEditabil.setText(detalii[1]);
                    emailFieldEditabil.setText(detalii[2]);
                    cnpFieldEditabil.setText(detalii[3]);
                    adresaFieldEditabil.setText(detalii[4]);
                    telefonFieldEditabil.setText(detalii[5]);
                    ibanFieldEditabil.setText(detalii[6]);
                    nrContractFieldEditabil.setText(detalii[7]);

                    // Afiseaza datele in casutele editabile
                    afisareDateEditabile(detaliiUtilizator);
                    detailsTextArea.setVisible(false);
                    detailsTextArea.setText(UtilizatorRepository.vizualizareDatePersonale(detaliiUtilizator));
                    detailsTextArea.setEditable(false);
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                    // Facem etichetele si campurile editabile vizibile
                    setCampuriEditabileVizibile(true);
                }

            }
        });

        actualizareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = null;
                String cnp = null;
                String adresa = null;
                String telefon = null;
                String iban = null;
                String nume = null;
                String prenume = null;

                if(!numeFieldEditabil.getText().isEmpty())
                    nume = numeFieldEditabil.getText();
                if(!prenumeFieldEditabil.getText().isEmpty())
                    prenume = prenumeFieldEditabil.getText();
                if(!emailFieldEditabil.getText().isEmpty())
                    email = emailFieldEditabil.getText();
                if(!cnpFieldEditabil.getText().isEmpty())
                    cnp = cnpFieldEditabil.getText();
                if(!adresaFieldEditabil.getText().isEmpty())
                    adresa = adresaFieldEditabil.getText();
                if(!telefonFieldEditabil.getText().isEmpty())
                    telefon = telefonFieldEditabil.getText();
                if(!ibanFieldEditabil.getText().isEmpty())
                    iban = ibanFieldEditabil.getText();

                int nrContract = 0;
                if(nrContractFieldEditabil.getText()!=null)
                    nrContract = parseInt(nrContractFieldEditabil.getText());

                // Implementați logica de actualizare în baza de date
                String rezultatActualizare = UtilizatorRepository.actualizareDatePersonale(
                        admin_email, email, nume, prenume, cnp, adresa, telefon, iban, nrContract
                );

                JOptionPane.showMessageDialog(null, rezultatActualizare);
                // Ascundem etichetele si campurile editabile dupa actualizare
                setCampuriEditabileVizibile(false);
                // Reafișează detaliile actualizate în text area
                detailsTextArea.setText(UtilizatorRepository.vizualizareDatePersonale(email));

            }
        });


        stergereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numeField.getText();
                String prenume = prenumeField.getText();
                String detaliiUtilizator = UtilizatorRepository.cautareUtilizator(nume, prenume);
                String mesaj= UtilizatorRepository.stergereUtilizatorDupaEmail(admin_email, detaliiUtilizator);
                JOptionPane.showMessageDialog(null,mesaj);
                setCampuriEditabileVizibile(false);
                detailsTextArea.setVisible(false);
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsTextArea.setVisible(false);
                numeField.setText("");
                prenumeField.setText("");
                // Ascundem etichetele si campurile editabile cand se apasa pe butonul "Inapoi"
                setCampuriEditabileVizibile(false);
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Replace HomeAdmin with the appropriate class for navigation
                new HomeAdmin(admin_email).setVisible(true);
            }
        });

        setVisible(true);
    }

    private void afisareDateEditabile(String detaliiUtilizator) {
        // Implementați logic pentru afișarea datelor în câmpurile editabile
        // Această metodă trebuie să completeze valorile câmpurilor editabile
        // cu datele corespunzătoare obținute din detaliiUtilizator.
        // Exemplu:
        String[] detalii = detaliiUtilizator.split(", ");
        if (detalii.length >= 8) {
            numeFieldEditabil.setText(detalii[0]);
            prenumeFieldEditabil.setText(detalii[1]);
            emailFieldEditabil.setText(detalii[2]);
            cnpFieldEditabil.setText(detalii[3]);
            adresaFieldEditabil.setText(detalii[4]);
            telefonFieldEditabil.setText(detalii[5]);
            ibanFieldEditabil.setText(detalii[6]);
            nrContractFieldEditabil.setText(detalii[7]);
        }
    }

    private void setCampuriEditabileVizibile(boolean vizibile) {
        // Setam vizibilitatea etichetelor si campurilor editabile
        numeLabel.setVisible(vizibile);
        numeFieldEditabil.setVisible(vizibile);

        prenumeLabel.setVisible(vizibile);
        prenumeFieldEditabil.setVisible(vizibile);

        emailLabel.setVisible(false);
        emailFieldEditabil.setVisible(false);

        cnpLabel.setVisible(vizibile);
        cnpFieldEditabil.setVisible(vizibile);

        adresaLabel.setVisible(vizibile);
        adresaFieldEditabil.setVisible(vizibile);

        telefonLabel.setVisible(vizibile);
        telefonFieldEditabil.setVisible(vizibile);

        ibanLabel.setVisible(vizibile);
        ibanFieldEditabil.setVisible(vizibile);

        nrContractLabel.setVisible(vizibile);
        nrContractFieldEditabil.setVisible(vizibile);

        actualizareButton.setVisible(vizibile);
        stergereButton.setVisible(vizibile);
    }


    public static void main(String[] args) {
        new CautareUtilizator("popescudaniela@yahoo.com");
    }
}
