import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;

/**
 * [EnrollmentSystem.java]
 * 
 * @author
 * @version 1.0
 **/

public class EnrollmentSystem {

    private static ArrayList<Student> studentList = new ArrayList<Student>();
    public JTable table;
    private DefaultTableModel model;
    private JScrollPane pane;

    public EnrollmentSystem() {
        // create a table model and set a Column Identifiers to this model
        Object[] columns = { "Name", "ID", "Grade", "Friends", "Group" };

        this.model = new DefaultTableModel();
        // set columns header
        this.table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setColumnIdentifiers(columns);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setForeground(Color.black);
        Font font = new Font("Calibri", Font.ITALIC, 15);

        table.setFont(font);
        table.setRowHeight(20);
        pane = new JScrollPane(table);
        pane.setBounds(0, 0, 900, 200);

        // TODO remove after testing
        for (int i = 0; i < 100; i++) {
            this.addStudent(Main.generateRandomStudent(), (int[]) Main.generateRandomStudent()[5]);

        }
    }

    public JScrollPane getPane() {
        return pane;
    }

    public int getRow() {
        return table.getSelectedRow();
    }

    public String getValue(int i, int j) {
        return model.getValueAt(i, j).toString();
    }

    public void updateStudent(int i, Object[] data) {
        String name = (String) data[0];
        int id = (int) data[1];
        int grade = (int) data[2];
        String group = (String) data[4];

        studentList.get(i).setName(name);
        studentList.get(i).setId(id);
        studentList.get(i).setGrade(grade);
        studentList.get(i).setGroup(group);

        model.setValueAt(data[0], i, 0);
        model.setValueAt(data[1], i, 1);
        model.setValueAt(data[2], i, 2);
        model.setValueAt(data[3], i, 3);
        model.setValueAt(data[4], i, 4);
    }

    public void removeStudent(int i) {
        studentList.remove(i);
        model.removeRow(i);
        // for(int i = 0; i < studentList.size(); i++){
        // if(studentList.get(i).getId() == id){
        // studentList.remove(i);
        // }
        // }
    }

    public void addStudent(Object[] data, int[] friends) {

        model.addRow(data);

        String name = (String) data[0];
        int id = (int) data[1];
        int grade = (int) data[2];
        String group = (String) data[4];

        // for(Student s: studentList){
        // int i = 0;

        // if(s.getName().equals()){

        // friends[i] = s;
        // i++;

        // }

        // }

        studentList.add(new Student(name, id, grade, friends, group));

    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public String[] getStudentNames() {

        String[] studentNames = new String[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            studentNames[i] = studentList.get(i).getName();
        }

        return studentNames;

    }

}
