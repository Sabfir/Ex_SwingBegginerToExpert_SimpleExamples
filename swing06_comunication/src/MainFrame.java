import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private TextPanel textPanel;

    public MainFrame() {
        super("Hello World!");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        toolbar.setTextPanel(textPanel);

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }
}
