package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeSuperAdmin extends JFrame {
    private JButton deautentificareButton;
    private JButton vizualizareDatePersonaleButton;
    private JButton cautareUtilizatoriButton;
    private JButton cautareCursButton;
    public HomeSuperAdmin(String email) {
        setTitle("Home Super Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        initializeUI();
        setupListeners(email);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        deautentificareButton = createStyledButton("Deautentificare");
        vizualizareDatePersonaleButton = createStyledButton("Vizualizare Date");
        cautareUtilizatoriButton = createStyledButton("Cautare Utilizatori");
        cautareCursButton = createStyledButton("Cautare Curs");

        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(deautentificareButton)
                        .addComponent(vizualizareDatePersonaleButton)
                        .addComponent(cautareUtilizatoriButton)
                        .addComponent(cautareCursButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(deautentificareButton)
                .addComponent(vizualizareDatePersonaleButton)
                .addComponent(cautareUtilizatoriButton)
                .addComponent(cautareCursButton));
    }

    private void setupListeners(String email) {
        deautentificareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AutentifInterface().setVisible(true);
            }
        });

        vizualizareDatePersonaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VizualizareDate(email);
            }
        });

        cautareUtilizatoriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CautareUtilizator(email).setVisible(true);            }
        });
        cautareCursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CautareCurs(email).setVisible(true);
            }
        });

    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit

        return button;
    }

    public static void main(String[] args) {
        new HomeSuperAdmin("friedjuliana@yahoo.com");
    }

}
