import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    JLabel nameLabel;
    JLabel occupationLabel;
    JTextField nameField;
    JTextField occupationField;
    JButton okBtn;
    TextListener textListener;
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("Ok");

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textListener.perform("name: " + nameField.getText() + "\n");
                textListener.perform("occupation: " + occupationField.getText() + "\n");
            }
        });


        add(nameLabel);
        add(nameField);
        add(occupationLabel);
        add(occupationField);
        add(okBtn);



        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    public void setTextListener(TextListener textListener) {
        this.textListener = textListener;
    }
}
