import Service.AutentifInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AutentifInterface login = new AutentifInterface();
                login.setSize(300, 200);
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        });
    }
}

