package gui.view;

import listener.TextListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener{
    private JButton helloButton;
    private JButton goodByeButton;
    private TextListener textListener;

    public Toolbar() {
        helloButton = new JButton("Hello!");
        goodByeButton = new JButton("Goodbye!");

        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);

        setBorder(BorderFactory.createEtchedBorder());
    }

    public void setTextListener(TextListener textListener) {
        this.textListener = textListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textListener == null) {
            return;
        }
        JButton button = (JButton) e.getSource();
        if (button.equals(helloButton)) {
            textListener.perform("Hello\n");
        } else if (button.equals(goodByeButton)) {
            textListener.perform("Goodbye\n");
        }
    }
}
