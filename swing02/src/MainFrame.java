import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextArea textArea;
    private JButton btn;

    public MainFrame() {
        super("Hello World!");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        btn = new JButton("Click me!");

        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }
}
