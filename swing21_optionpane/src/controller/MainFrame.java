package controller;

import event.FormEvent;
import listener.FormListener;
import listener.TextListener;
import view.FormPanel;
import view.TextPanel;
import view.Toolbar;

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello World!");

        setLayout(new BorderLayout());

        setJMenuBar(createMenuBar());

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

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenu windowMenu = new JMenu("Window");

        JMenuItem exportItem = new JMenuItem("Export...");
        JMenuItem importItem = new JMenuItem("Import...");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit?", "Confirm exit",
                        JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    dispatchEvent(new WindowEvent(MainFrame.this, WindowEvent.WINDOW_CLOSING));
                }

            }
        });

        fileMenu.add(exportItem);
        fileMenu.add(importItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Show Form");
        showFormItem.setSelected(true);
        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem showFormItem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(showFormItem.isSelected());
            }
        });

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        return menuBar;
    }
}
