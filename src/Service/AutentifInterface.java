package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Repository.UtilizatorRepository;

public class AutentifInterface extends JFrame {
    private JTextField emailTextField;
    private JPasswordField parolaPasswordField;
    private JButton autentificareButton;
    private JButton utilizatorNouButton;

    public AutentifInterface() {
        initializeUI();
        setupListeners();
    }

    private void initializeUI() {
        setTitle("Formular de Autentificare");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null); // Centrare pe ecran

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margini între componentele panoului
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // Rânduri, coloane, spații între componente

        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Parola:");
        parolaPasswordField = new JPasswordField();
        autentificareButton = new JButton("Autentificare");
        utilizatorNouButton = new JButton("Utilizator Nou");
        autentificareButton.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit
        utilizatorNouButton.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit

        //autentificareButton.setBackground(new Color(67, 134, 204));
        //autentificareButton.setForeground(Color.WHITE);
        //autentificareButton.setFont(new Font("Arial", Font.BOLD, 12));

        //utilizatorNouButton.setBackground(new Color(67, 134, 204));
        //utilizatorNouButton.setForeground(Color.WHITE);
        //utilizatorNouButton.setFont(new Font("Arial", Font.BOLD, 12));

        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(passwordLabel);
        panel.add(parolaPasswordField);
        panel.add(new JLabel()); // Celula goală pentru a ocupa spațiu
        panel.add(autentificareButton);
        panel.add(new JLabel()); // Celula goală pentru a ocupa spațiu
        panel.add(utilizatorNouButton);

        add(panel);
        setLookAndFeel();

        setVisible(true);
    }

    private void setupListeners() {
        autentificareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                char[] password = parolaPasswordField.getPassword();
                UtilizatorRepository autentif = new UtilizatorRepository();
                if (autentif.autentificare(email, new String(password))!=0) {
                    JOptionPane.showMessageDialog(AutentifInterface.this, "Autentificare reusita!");
                    //instantiez cu constructorul din clasa homepage
                    dispose();
                    if(autentif.verificaTipUtilizator(email)== 0)
                        new HomeStudent(email).setVisible(true);
                    else if(autentif.verificaTipUtilizator(email)== 1)
                        new HomeProf(email).setVisible(true);
                    else if(autentif.verificaTipUtilizator(email)== 2)
                        new HomeAdmin(email).setVisible(true);
                    else if(autentif.verificaTipUtilizator(email)== 3)
                        new HomeSuperAdmin(email).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(AutentifInterface.this, "Autentificare esuata!");
                }
                System.out.println("Email: " + email);
                System.out.println("Parola: " + new String(password));
            }
        });

        utilizatorNouButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TipUtilizator().setVisible(true);
            }
        });
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutentifInterface();
            }
        });
    }
}































