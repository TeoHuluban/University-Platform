package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipUtilizator extends JFrame {

    public TipUtilizator() {
        setTitle("Selecteaza Tipul de Utilizator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 100);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton studentButton = new JButton("Student");
        JButton profesorButton = new JButton("Profesor");
        JButton administratorButton = new JButton("Administrator");
        studentButton.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit
        profesorButton.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit
        administratorButton.setFont(new Font("Arial", Font.BOLD, 12)); // Setează fontul dorit


        //studentButton.setBackground(new Color(67, 134, 204));
        //studentButton.setForeground(Color.WHITE);
        //studentButton.setFont(new Font("Arial", Font.BOLD, 12));

        //profesorButton.setBackground(new Color(67, 134, 204));
        //profesorButton.setForeground(Color.WHITE);
        //profesorButton.setFont(new Font("Arial", Font.BOLD, 12));

        //administratorButton.setBackground(new Color(67, 134, 204));
        //administratorButton.setForeground(Color.WHITE);
        //administratorButton.setFont(new Font("Arial", Font.BOLD, 12));

        add(studentButton);
        add(profesorButton);
        add(administratorButton);

        // Adăugăm ascultători de acțiuni pentru fiecare buton
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adaugă logica pentru acțiunea butonului Student
                //JOptionPane.showMessageDialog(TipUtilizator.this, "Ai selectat Student");
                dispose();
                new NewStudent().setVisible(true);
            }
        });

        profesorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adaugă logica pentru acțiunea butonului Profesor
                //JOptionPane.showMessageDialog(TipUtilizator.this, "Ai selectat Profesor");
                dispose();
                new NewProf().setVisible(true);
            }
        });

        administratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adaugă logica pentru acțiunea butonului Administrator
                //JOptionPane.showMessageDialog(TipUtilizator.this, "Ai selectat Administrator");
                dispose();
                new NewAdmin().setVisible(true);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TipUtilizator();
            }
        });
    }
}
