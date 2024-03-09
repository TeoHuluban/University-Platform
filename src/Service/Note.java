package Service;
import Repository.UtilizatorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Note extends JFrame {

    private JTable noteTable;
    private JButton afisareNoteButton;

    public Note(String email, String numeCurs) {
        setTitle("Afișare Note Student");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI(email, numeCurs);
    }

    private void initUI(String email, String numeCurs) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);

        JTextArea notesArea = new JTextArea();
        notesArea.setEditable(false);
        notesArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(notesArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        afisareNoteButton = createStyledButton("Inchide");
        mainPanel.add(afisareNoteButton, BorderLayout.SOUTH);

        afisareNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afiseazaNote(email, numeCurs, notesArea);
            }
        });

        // Afișează notele direct la crearea ferestrei
        afiseazaNote(email, numeCurs, notesArea);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void afiseazaNote(String email, String numeCurs, JTextArea notesArea) {
        UtilizatorRepository.calculareNotaFinala(email, numeCurs);

        String rezultat = UtilizatorRepository.afisareNoteStudent(email, numeCurs);

        // Ensure that there are note values to add
        if (rezultat.startsWith("Nota")) {
            StringBuilder notesText = new StringBuilder();

            String[] noteParts = rezultat.split("\n");

            // Skip the header line
            for (int i = 0; i < noteParts.length; i++) {
                String[] noteValues = noteParts[i].split(": ");
                notesText.append(noteValues[0]).append(": ").append(noteValues[1]).append("\n");
            }

            notesArea.setText(notesText.toString());
        } else {
            notesArea.setText(rezultat);
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Adăugați acțiunea dorită pentru butonul "Înapoi"
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Note("hulubanteodora@yahoo.com", "Baze de date"));
    }
}
