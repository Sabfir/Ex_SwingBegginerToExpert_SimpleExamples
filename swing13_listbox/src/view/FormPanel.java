package view;

import event.FormEvent;
import listener.FormListener;
import model.AgeCategory;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    JLabel nameLabel;
    JLabel occupationLabel;
    JTextField nameField;
    JTextField occupationField;
    JButton okBtn;
    FormListener formListener;
    JList<AgeCategory> ageCategories;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("Ok");
        ageCategories = new JList<>();
        ageCategories.setPreferredSize(new Dimension(115, 70));
        ageCategories.setBorder(BorderFactory.createEtchedBorder());
        DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
        ageModel.addElement(new AgeCategory(1, "Under 18"));
        ageModel.addElement(new AgeCategory(2, "19 to 60"));
        ageModel.addElement(new AgeCategory(3, "61 or over"));
        ageCategories.setModel(ageModel);
        ageCategories.setSelectedIndex(1);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formListener == null) {
                    return;
                }
                FormEvent event = new FormEvent(this, nameField.getText(), occupationField.getText(), ageCategories.getSelectedValue());
                formListener.formEventOccurred(event);
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        /// FIRST ROW ///
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        /// SECOND ROW ///
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        /// THIRD ROW ///
        gc.weightx = 2;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageCategories, gc);

        /// FORTH ROW ///
        gc.weightx = 20;
        gc.weighty = 20;

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}
