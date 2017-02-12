package gui.view;

import gui.model.PersonTableModel;
import model.Person;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.List;

public class TablePanel extends JPanel {
    JTable table;
    PersonTableModel tableModel;

    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> data) {
        tableModel.setData(data);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
