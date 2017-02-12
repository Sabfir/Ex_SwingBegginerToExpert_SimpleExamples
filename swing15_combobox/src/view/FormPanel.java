package view;

import event.FormEvent;
import listener.FormListener;
import model.AgeCategory;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    JTextField nameField;
    JTextField occupationField;
    JButton okBtn;
    FormListener formListener;
    JList<AgeCategory> ageCategories;
    JComboBox<String> employment;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

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

        employment = new JComboBox<>();
        DefaultComboBoxModel<String> employmentModel = new DefaultComboBoxModel<>();
        employmentModel.addElement("employed");
        employmentModel.addElement("self-employed");
        employmentModel.addElement("unemployed");
        employment.setModel(employmentModel);
        employment.setSelectedIndex(0);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formListener == null) {
                    return;
                }
                FormEvent event = new FormEvent(this, nameField.getText(), occupationField.getText(),
                        ageCategories.getSelectedValue(), (String) employment.getSelectedItem());
                formListener.formEventOccurred(event);
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;
        gc.gridy = 0;

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Name: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Occupation: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        /// NEXT ROW ///
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageCategories, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employment: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(employment, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 20;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}
