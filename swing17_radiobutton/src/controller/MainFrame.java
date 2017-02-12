package controller;

import event.FormEvent;
import listener.FormListener;
import listener.TextListener;
import view.FormPanel;
import view.TextPanel;
import view.Toolbar;

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
                String name = event.getName();
                String occupation = event.getOccupation();
                String ageCategory = event.getAgeCategory().getId() + "(" + event.getAgeCategory().getName() + ")";
                String employment = event.getEmployment();
                String taxId = event.getUsCitizen() ? event.getTaxId() : "";
                String gender = event.getGender();
                textPanel.appendText(name + " : " + occupation + " : " + ageCategory + " : " + employment
                        + " : " + taxId + " : " + gender + "\n");
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
