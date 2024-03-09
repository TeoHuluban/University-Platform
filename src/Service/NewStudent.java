package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Repository.UtilizatorRepository;

public class NewStudent extends JFrame {
    private JTextField emailTextField;
    private JPasswordField parolaPasswordField;
    private JTextField cnpTextField;
    private JTextField numeTextField;
    private JTextField prenumeTextField;
    private JTextField adresaTextField;
    private JTextField nrTelTextField;
    private JTextField nrContractTextField;
    private JTextField ibanTextField;
    private JTextField anStudiuTextField;
    private JTextField nrOreTextField;
    private JButton adaugaStudentButton;
    private JButton inapoiButton;

    public NewStudent() {
        initializeUI();
        setupListeners();
    }

    private void initializeUI() {
        setTitle("Adăugare Student Nou");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(13, 2, 10, 10));

        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();

        JLabel parolaLabel = new JLabel("Parola:");
        parolaPasswordField = new JPasswordField();

        JLabel cnpLabel = new JLabel("CNP:");
        cnpTextField = new JTextField();

        JLabel numeLabel = new JLabel("Nume:");
        numeTextField = new JTextField();

        JLabel prenumeLabel = new JLabel("Prenume:");
        prenumeTextField = new JTextField();

        JLabel adresaLabel = new JLabel("Adresa:");
        adresaTextField = new JTextField();

        JLabel nrTelLabel = new JLabel("Nr. Telefon:");
        nrTelTextField = new JTextField();

        JLabel nrContractLabel = new JLabel("Nr. Contract:");
        nrContractTextField = new JTextField();

        JLabel ibanLabel = new JLabel("IBAN:");
        ibanTextField = new JTextField();

        JLabel anStudiuLabel = new JLabel("An Studiu:");
        anStudiuTextField = new JTextField();

        JLabel nrOreLabel = new JLabel("Nr. Ore:");
        nrOreTextField = new JTextField();

        adaugaStudentButton = new JButton("Adaugă Student");
        //adaugaStudentButton.setBackground(new Color(67, 134, 204));
        //adaugaStudentButton.setForeground(Color.WHITE);
        //adaugaStudentButton.setFont(new Font("Arial", Font.BOLD, 12));

        inapoiButton = new JButton("Înapoi");
        //inapoiButton.setBackground(new Color(67, 134, 204));
        //inapoiButton.setForeground(Color.WHITE);
        //inapoiButton.setFont(new Font("Arial", Font.BOLD, 12));

        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(parolaLabel);
        panel.add(parolaPasswordField);
        panel.add(cnpLabel);
        panel.add(cnpTextField);
        panel.add(numeLabel);
        panel.add(numeTextField);
        panel.add(prenumeLabel);
        panel.add(prenumeTextField);
        panel.add(adresaLabel);
        panel.add(adresaTextField);
        panel.add(nrTelLabel);
        panel.add(nrTelTextField);
        panel.add(nrContractLabel);
        panel.add(nrContractTextField);
        panel.add(ibanLabel);
        panel.add(ibanTextField);
        panel.add(anStudiuLabel);
        panel.add(anStudiuTextField);
        panel.add(nrOreLabel);
        panel.add(nrOreTextField);
        panel.add(new JLabel()); // Celulă goală pentru a ocupa spațiu
        panel.add(adaugaStudentButton);
        panel.add(new JLabel()); // Celulă goală pentru a ocupa spațiu
        panel.add(inapoiButton);

        add(panel);
        setVisible(true);
    }

    private void setupListeners() {
        adaugaStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String parola = new String(parolaPasswordField.getPassword());
                String cnp = cnpTextField.getText();
                String nume = numeTextField.getText();
                String prenume = prenumeTextField.getText();
                String adresa = adresaTextField.getText();
                String nrTel = nrTelTextField.getText();
                int nrContract = Integer.parseInt(nrContractTextField.getText());
                String iban = ibanTextField.getText();
                int anStudiu = Integer.parseInt(anStudiuTextField.getText());
                int nrOre = Integer.parseInt(nrOreTextField.getText());

                // Adaugă student folosind metoda din UtilizatorRepository
                int rez = UtilizatorRepository.adaugareStudent(email, parola, cnp, nume, prenume, adresa, nrTel, nrContract, iban, anStudiu, nrOre);

                // Poți adăuga o notificare că studentul a fost adăugat cu succes sau altă logică necesară
                if(rez==-1)
                    JOptionPane.showMessageDialog(NewStudent.this, "Studentul exista deja!");
                else
                    JOptionPane.showMessageDialog(NewStudent.this, "Student adăugat cu succes!");

                dispose();
                new HomeStudent(email).setVisible(true);
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
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(67, 134, 204));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adaugă logica dorită pentru acțiunea butonului
            }
        });
        return button;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewStudent();
            }
        });
    }
}
