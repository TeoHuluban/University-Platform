package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProf extends JFrame {

    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JTextField cnpTextField;
    private JTextField numeTextField;
    private JTextField prenumeTextField;
    private JTextField adresaTextField;
    private JTextField nrTelTextField;
    private JTextField nrContractTextField;
    private JTextField ibanTextField;
    private JTextField nrMinOreTextField;
    private JTextField nrMaxOreTextField;
    private JTextField departamentTextField;
    private JButton adaugaButton;
    private JButton inapoiButton;

    public NewProf() {
        initializeUI();
        setupListeners();
    }

    private void initializeUI() {
        setTitle("Adaugare Profesor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(14, 2, 10, 10));

        emailTextField = new JTextField();
        passwordField = new JPasswordField();
        cnpTextField = new JTextField();
        numeTextField = new JTextField();
        prenumeTextField = new JTextField();
        adresaTextField = new JTextField();
        nrTelTextField = new JTextField();
        nrContractTextField = new JTextField();
        ibanTextField = new JTextField();
        nrMinOreTextField = new JTextField();
        nrMaxOreTextField = new JTextField();
        departamentTextField = new JTextField();
        adaugaButton = new JButton("Adauga Profesor");
        inapoiButton = new JButton("Înapoi");
        //inapoiButton.setBackground(new Color(67, 134, 204));
        //inapoiButton.setForeground(Color.WHITE);
        //inapoiButton.setFont(new Font("Arial", Font.BOLD, 12));

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailTextField);
        formPanel.add(new JLabel("Parola:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("CNP:"));
        formPanel.add(cnpTextField);
        formPanel.add(new JLabel("Nume:"));
        formPanel.add(numeTextField);
        formPanel.add(new JLabel("Prenume:"));
        formPanel.add(prenumeTextField);
        formPanel.add(new JLabel("Adresa:"));
        formPanel.add(adresaTextField);
        formPanel.add(new JLabel("Nr. Tel:"));
        formPanel.add(nrTelTextField);
        formPanel.add(new JLabel("Nr. Contract:"));
        formPanel.add(nrContractTextField);
        formPanel.add(new JLabel("IBAN:"));
        formPanel.add(ibanTextField);
        formPanel.add(new JLabel("Nr. Min Ore:"));
        formPanel.add(nrMinOreTextField);
        formPanel.add(new JLabel("Nr. Max Ore:"));
        formPanel.add(nrMaxOreTextField);
        formPanel.add(new JLabel("Departament:"));
        formPanel.add(departamentTextField);
        formPanel.add(new JLabel());  // Celula goală pentru a ocupa spațiu
        formPanel.add(adaugaButton);
        formPanel.add(new JLabel());  // Celula goală pentru a ocupa spațiu
        formPanel.add(inapoiButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupListeners() {
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugaProfesor();
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AutentifInterface().setVisible(true);
            }
        });
    }

    private void adaugaProfesor() {
        // Obțineți valorile din câmpuri
        String email = emailTextField.getText();
        String parola = new String(passwordField.getPassword());
        String cnp = cnpTextField.getText();
        String nume = numeTextField.getText();
        String prenume = prenumeTextField.getText();
        String adresa = adresaTextField.getText();
        String nrTel = nrTelTextField.getText();
        int nrContract = Integer.parseInt(nrContractTextField.getText());
        String iban = ibanTextField.getText();
        int nrMinOre = Integer.parseInt(nrMinOreTextField.getText());
        int nrMaxOre = Integer.parseInt(nrMaxOreTextField.getText());
        String departament = departamentTextField.getText();

        // Apelați metoda din repository pentru adăugarea profesorului în baza de date
        int rez = UtilizatorRepository.adaugareProfesor(email, parola, cnp, nume, prenume, adresa, nrTel, nrContract, iban, nrMinOre, nrMaxOre, departament);

        // Afiseaza un mesaj de succes
        if(rez==-1)
            JOptionPane.showMessageDialog(NewProf.this, "Profesorul exista deja!");
        else
            JOptionPane.showMessageDialog(NewProf.this, "Profesorul adăugat cu succes!");

        // Închide fereastra curentă
        dispose();
        new HomeProf(email).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewProf();
            }
        });
    }
}
