package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeProf extends JFrame {
    private JButton deautentificareButton;
    private JButton vizualizareDatePersonaleButton;
    private JButton programareActivitatiButton;
    private JButton catalogButton;
    private JButton procentajeButton;
    private JButton vizualizareActivitatiButton;

    public HomeProf(String email) {
        setTitle("Home Profesor");
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
        programareActivitatiButton = createStyledButton("Programare Activitati");
        catalogButton = createStyledButton("Catalog");
        procentajeButton= createStyledButton("Procentaje Curs");
        vizualizareActivitatiButton = createStyledButton("Vizualizare Activitati");

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(deautentificareButton)
                .addComponent(vizualizareDatePersonaleButton)
                .addComponent(programareActivitatiButton)
                .addComponent(vizualizareActivitatiButton)
                .addComponent(catalogButton)
                .addComponent(procentajeButton));


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(deautentificareButton)
                .addComponent(vizualizareDatePersonaleButton)
                .addComponent(programareActivitatiButton)
                .addComponent(vizualizareActivitatiButton)
                .addComponent(catalogButton)
                .addComponent(procentajeButton));

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

        programareActivitatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdaugareActivitatiProf(email).setVisible(true);
            }
        });

        catalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Catalog(email).setVisible(true);
            }
        });

        procentajeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Procentaje(email).setVisible(true);
            }
        });

        vizualizareActivitatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ActivitatiProfesor(email).setVisible(true);
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeProf("ivancosmina@yahoo.com");
            }
        });
    }
}























