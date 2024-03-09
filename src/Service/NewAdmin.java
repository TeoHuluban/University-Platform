package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAdmin extends JFrame {

    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JTextField cnpTextField;
    private JTextField numeTextField;
    private JTextField prenumeTextField;
    private JTextField adresaTextField;
    private JTextField nrTelTextField;
    private JTextField nrContractTextField;
    private JTextField ibanTextField;
    private JCheckBox superAdminCheckBox;
    private JButton adaugaButton;
    private JButton inapoiButton;

    public NewAdmin() {
        initializeUI();
        setupListeners();
    }

    private void initializeUI() {
        setTitle("Adaugare Administrator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(12, 2, 10, 10));

        emailTextField = new JTextField();
        passwordField = new JPasswordField();
        cnpTextField = new JTextField();
        numeTextField = new JTextField();
        prenumeTextField = new JTextField();
        adresaTextField = new JTextField();
        nrTelTextField = new JTextField();
        nrContractTextField = new JTextField();
        ibanTextField = new JTextField();
        superAdminCheckBox = new JCheckBox("Super Admin");
        adaugaButton = new JButton("Adauga Administrator");
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
        formPanel.add(new JLabel()); // Celula goală pentru a ocupa spațiu
        formPanel.add(superAdminCheckBox);
        formPanel.add(new JLabel()); // Celula goală pentru a ocupa spațiu
        formPanel.add(adaugaButton);
        formPanel.add(new JLabel()); // Celula goală pentru a ocupa spațiu
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
                adaugaAdministrator();
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

    private void adaugaAdministrator() {
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
        boolean superAdmin = superAdminCheckBox.isSelected();

        // Apelați metoda din repository pentru adăugarea administratorului în baza de date
        int rez = UtilizatorRepository.adaugareAdministrator(email, parola, cnp, nume, prenume, adresa, nrTel, nrContract, iban, superAdmin);

        // Afiseaza un mesaj de succes
        if(rez==-1)
            JOptionPane.showMessageDialog(NewAdmin.this, "Administratorul exista deja!");
        else
            JOptionPane.showMessageDialog(NewAdmin.this, "Administrator adăugat cu succes!");

        // Închide fereastra curentă
        dispose();
        new HomeAdmin(email).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewAdmin();
            }
        });
    }
}
