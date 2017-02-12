import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello World!");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();
        toolbar.setTextListener(new TextListener() {
            @Override
            public void perform(String text) {
                textPanel.appendText(text);
            }
        });
        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccurred(FormEvent event) {
                textPanel.appendText(event.getName() + ": " + event.getOccupation() + "\n");
            }
        });

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }
}
