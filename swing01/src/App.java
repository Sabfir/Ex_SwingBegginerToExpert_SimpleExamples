import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Hello World!");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(600, 500);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
