package gui.model;

import model.Person;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> data;
    private final Map<Integer, Column> columns = new HashMap<>();
    {
        columns.put(0, new Column("id", "Id"));
        columns.put(1, new Column("name", "Name"));
        columns.put(2, new Column("ageCategory", "Age Category"));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column).getRepresentation();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = data.get(rowIndex);
        return getValueByColumnIndex(person, columnIndex);
    }

    private Object getValueByColumnIndex(Person person, int columnIndex) {
        String fieldName = columns.get(columnIndex).getName();
        Field field = null;
        try {
            field = person.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        if (field == null) {
            return null;
        }
        try {
            return field.get(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    class Column {
        private String name;
        private String representation;

        public Column(String name, String representation) {
            this.name = name;
            this.representation = representation;
        }

        public String getName() {
            return name;
        }

        public String getRepresentation() {
            return representation;
        }
    }
}
