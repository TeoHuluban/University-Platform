package Service;

import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class Procentaje extends JFrame {

    private JLabel cursLabel;
    private JLabel semiLabel;
    private JLabel labLabel;
    private JButton filtreazaButton;
    private JButton adaugaProcentButton;
    private JButton inapoiButton;
    private JTextArea detailsTextArea;
    private JTextField cursTextField;
    private JTextField notaCursTextField;
    private JTextField notaLabTextField;
    private JTextField notaSemiTextField;

    public Procentaje(String email) {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        setTitle("Procentaje");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        filtreazaButton = new JButton("Caută");
        inapoiButton = new JButton("Înapoi");
        detailsTextArea = new JTextArea();

        notaCursTextField = new JTextField(10);
        notaLabTextField = new JTextField(10);
        notaSemiTextField = new JTextField(10);
        adaugaProcentButton = new JButton("Adaugă Procente");
        cursTextField = new JTextField(20);


        cursLabel = new JLabel("Procent Curs:");
        semiLabel = new JLabel("Procent Seminar:");
        labLabel = new JLabel("Procent Laborator:");

        detailsTextArea.setVisible(false);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Curs:"));
        topPanel.add(cursTextField);
        topPanel.add(filtreazaButton);
        topPanel.add(inapoiButton);

        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(cursLabel);
        bottomPanel.add(notaCursTextField);
        bottomPanel.add(semiLabel);
        bottomPanel.add(notaSemiTextField);
        bottomPanel.add(labLabel);
        bottomPanel.add(notaLabTextField);
        bottomPanel.add(adaugaProcentButton);

        bottomPanel.setVisible(false); // Inițial ascuns

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);




        filtreazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a= 0, b= 0, c= 0;
                String curs = cursTextField.getText();
                int[] v= UtilizatorRepository.tipActivitatiCurs(curs);
                if(v[0]==0 && v[1]==0 && v[2]==0)
                {
                    adaugaProcentButton.setVisible(false);
                    detailsTextArea.setText("Nu predati acest curs!");

                    detailsTextArea.setVisible(true);
                    detailsTextArea.setEditable(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                }
                else
                {
                    adaugaProcentButton.setVisible(true);
                    detailsTextArea.setText("Inserati procentajele mai jos");
                    detailsTextArea.setVisible(true);
                    detailsTextArea.setEditable(false);
                    detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
                }
                cursLabel.setVisible(true);
                notaCursTextField.setVisible(true);
                notaCursTextField.setText("");

                semiLabel.setVisible(true);
                notaSemiTextField.setVisible(true);
                notaSemiTextField.setText("");

                labLabel.setVisible(true);
                notaLabTextField.setVisible(true);
                notaLabTextField.setText("");

                if (v[0]==0){
                    cursLabel.setVisible(false);
                    notaCursTextField.setVisible(false);

                }
                if (v[1]==0) {
                    semiLabel.setVisible(false);
                    notaSemiTextField.setVisible(false);

                }
                if (v[2]==0) {
                    labLabel.setVisible(false);
                    notaLabTextField.setVisible(false);

                }


                bottomPanel.setVisible(true);

            }
        });

        adaugaProcentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a= 0, b= 0, c= 0;
                String curs = cursTextField.getText();
                int[] v= UtilizatorRepository.tipActivitatiCurs(curs);

                if (v[0] ==1 ){
                    a= parseInt(notaCursTextField.getText());
                }
                if (v[1] == 1) {
                    b= parseInt(notaSemiTextField.getText());
                }
                if (v[2]==1) {
                    c= parseInt(notaLabTextField.getText());
                }


                String rezultat= UtilizatorRepository.adaugaProcentaj(curs,email,a,b,c);

                JOptionPane.showMessageDialog(null, rezultat);

            }
        });
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeProf(email).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Procentaje("ivancosmina@yahoo.com").setVisible(true);
            }
        });
    }
}
