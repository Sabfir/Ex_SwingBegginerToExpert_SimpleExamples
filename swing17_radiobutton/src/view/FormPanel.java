package view;

import event.FormEvent;
import listener.FormListener;
import model.AgeCategory;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    FormListener formListener;
    JTextField nameField;
    JTextField occupationField;
    JButton okButton;
    JList<AgeCategory> ageCategoriesList;
    JComboBox<String> employmentCombo;
    JCheckBox usCitizenCheck;
    JLabel taxIdLabel;
    JTextField taxIdField;
    JRadioButton maleRadio;
    JRadioButton femaleRadio;
    ButtonGroup genderBtnGroup;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameField = new JTextField(10);

        occupationField = new JTextField(10);

        okButton = new JButton("Ok");

        ageCategoriesList = new JList<>();
        ageCategoriesList.setPreferredSize(new Dimension(115, 70));
        ageCategoriesList.setBorder(BorderFactory.createEtchedBorder());
        DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
        ageModel.addElement(new AgeCategory(1, "Under 18"));
        ageModel.addElement(new AgeCategory(2, "19 to 60"));
        ageModel.addElement(new AgeCategory(3, "61 or over"));
        ageCategoriesList.setModel(ageModel);
        ageCategoriesList.setSelectedIndex(1);

        employmentCombo = new JComboBox<>();
        DefaultComboBoxModel<String> employmentModel = new DefaultComboBoxModel<>();
        employmentModel.addElement("employed");
        employmentModel.addElement("self-employed");
        employmentModel.addElement("unemployed");
        employmentCombo.setModel(employmentModel);
        employmentCombo.setSelectedIndex(0);

        usCitizenCheck = new JCheckBox();
        usCitizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taxIdLabel.setEnabled(usCitizenCheck.isSelected());
                taxIdField.setEnabled(usCitizenCheck.isSelected());
            }
        });

        taxIdLabel = new JLabel("Tax id: ");
        taxIdField = new JTextField(10);
        taxIdLabel.setEnabled(false);
        taxIdField.setEnabled(false);

        maleRadio = new JRadioButton("male");
        maleRadio.setActionCommand("male");
        maleRadio.setSelected(true);
        femaleRadio = new JRadioButton("female");
        genderBtnGroup = new ButtonGroup();
        femaleRadio.setActionCommand("female");
        genderBtnGroup.add(maleRadio);
        genderBtnGroup.add(femaleRadio);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formListener == null) {
                    return;
                }
                FormEvent event = new FormEvent(this, nameField.getText(), occupationField.getText(),
                        ageCategoriesList.getSelectedValue(), (String) employmentCombo.getSelectedItem(),
                        usCitizenCheck.isSelected(), taxIdField.getText(), genderBtnGroup.getSelection().getActionCommand());
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
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Name: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(nameField, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Occupation: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(occupationField, gc);

        /// NEXT ROW ///
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Age: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageCategoriesList, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Employment: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(employmentCombo, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("US citizen: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(usCitizenCheck, gc);

        /// NEXT ROW ///
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(taxIdLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(taxIdField, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Gender: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(maleRadio, gc);

        /// NEXT ROW ///
        gc.gridy++;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(femaleRadio, gc);

        /// NEXT ROW ///
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 20;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, gc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}
