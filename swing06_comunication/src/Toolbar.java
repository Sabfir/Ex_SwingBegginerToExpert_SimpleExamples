import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener{
    private JButton helloButton;
    private JButton goodByeButton;
    private TextPanel textPanel;

    public Toolbar() {
        helloButton = new JButton("Hello!");
        goodByeButton = new JButton("Goodbye!");

        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.equals(helloButton)) {
            textPanel.appendText("Hello\n");
        } else {
            textPanel.appendText("Goodbye\n");
        }
    }
}
