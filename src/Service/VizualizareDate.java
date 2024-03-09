package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Repository.UtilizatorRepository;

public class VizualizareDate extends JFrame {

    public VizualizareDate(String email) {
        setTitle("Vizualizare Date");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);  // Face JTextArea nelaborabilă
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Apelăm metoda din UtilizatorRepository pentru a obține datele
        String rezultat = UtilizatorRepository.vizualizareDatePersonale(email);

        // Afișăm rezultatul în textArea
        textArea.setText(rezultat);
        JButton backButton = createStyledButton("Inapoi");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UtilizatorRepository autentif = new UtilizatorRepository();
                if(autentif.verificaTipUtilizator(email)== 0)
                    new HomeStudent(email).setVisible(true);
                else if(autentif.verificaTipUtilizator(email)== 1)
                    new HomeProf(email).setVisible(true);
                else if(autentif.verificaTipUtilizator(email)== 2)
                    new HomeAdmin(email).setVisible(true);
                else if(autentif.verificaTipUtilizator(email)== 3)
                    new HomeSuperAdmin(email).setVisible(true);

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        // button.setForeground(Color.WHITE);
        // button.setBackground(new Color(67, 134, 204));
        // button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return button;
    }

}
