package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeStudent extends JFrame {
    private JButton deautentificareButton;
    private JButton vizualizareDatePersonaleButton;
    private JButton situatieScolaraButton;
    private JButton vizualizareActivitatiButton;
    private JButton grupuriStudiuButton;

    public HomeStudent(String email) {
        setTitle("Home Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        initializeUI();
        setupListeners(email);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        deautentificareButton = createStyledButton("Deautentificare");
        vizualizareDatePersonaleButton = createStyledButton("Vizualizare Date");
        situatieScolaraButton = createStyledButton("Situatie Scolara");
        vizualizareActivitatiButton = createStyledButton("Vizualizare Activitati");
        grupuriStudiuButton = createStyledButton("Grupuri de Studiu");

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(deautentificareButton)
                .addComponent(vizualizareDatePersonaleButton)
                .addComponent(situatieScolaraButton)
                .addComponent(vizualizareActivitatiButton)
                .addComponent(grupuriStudiuButton));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(deautentificareButton)
                .addComponent(vizualizareDatePersonaleButton)
                .addComponent(situatieScolaraButton)
                .addComponent(vizualizareActivitatiButton)
                .addComponent(grupuriStudiuButton));

        add(panel);
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
                new VizualizareDate(email).setVisible(true);
            }
        });


        situatieScolaraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SituatieScolara(email).setVisible(true);

            }
        });

        vizualizareActivitatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ActivitatiCurs(email).setVisible(true);
            }
        });

        grupuriStudiuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GrupuriStudiu(email).setVisible(true);
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        //button.setForeground(Color.WHITE);
        //button.setBackground(new Color(67, 134, 204));
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
                new HomeStudent("hulubanteodora@yahoo.com");
            }
        });
    }
}
