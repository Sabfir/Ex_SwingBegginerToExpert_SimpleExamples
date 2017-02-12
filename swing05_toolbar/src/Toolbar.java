import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Toolbar extends JPanel {
    private JButton helloButton;
    private JButton goodByeButton;

    public Toolbar() {
        helloButton = new JButton("Hello!");
        goodByeButton = new JButton("Good bye!");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);
    }
}
