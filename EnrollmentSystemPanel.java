import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.io.IOException;


/**
 * [EnrollmentSystemPanel.java]
 * 
 * @author 
 * @version 1.0 
**/

public class EnrollmentSystemPanel {

    private static ArrayList<Student> studentList = new ArrayList <Student>();
    private static JTable table;
    private static DefaultTableModel model;
    private static JScrollPane pane;

    public EnrollmentSystemPanel() {
          // create a table model and set a Column Identifiers to this model
          Object[] columns = { "Name", "ID", "Grade", "Friends", "Group"};

          model = new DefaultTableModel();
          //set columns header
          table = new JTable(model){
              @Override
              public boolean isCellEditable(int row, int column){
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

        generateJTable();
    }

    public void generateJTable() {
        // create JFrame and JTable
        JFrame frame = new JFrame();

        String[] groups = {"Game Development", "Web Development", "Competitive Programming"};
        

        // create JTextFields to hold the value
        JTextField textName = new JTextField();
        JTextField textID = new JTextField();
        JTextField textGrade = new JTextField();

       // JTextField textFriends = new JTextField();

        // create JButtons to add the action
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnBack = new JButton("Back");

        JLabel errorMessage = new JLabel();
        errorMessage.setForeground(Color.red);
        errorMessage.setFont(new Font("Calibri", Font.BOLD, 25));
        errorMessage.setBounds(460, 400, 300, 20);

        JLabel name = new JLabel("Name");
        JLabel ID = new JLabel("Student ID");
        JLabel grade = new JLabel("Grade");
        JLabel friends = new JLabel("Friends (Student ID)");
        JLabel groupText = new JLabel("Group");
        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.ITALIC, 15));
        name.setBounds(50, 205, 300, 25);
        ID.setForeground(Color.black);
        ID.setFont(new Font("Calibri", Font.ITALIC, 15));
        ID.setBounds(50, 260, 250, 25);
        grade.setForeground(Color.black);
        grade.setFont(new Font("Calibri", Font.ITALIC, 15));
        grade.setBounds(50, 315, 300, 25);
        friends.setForeground(Color.black);
        friends.setFont(new Font("Calibri", Font.ITALIC, 15));
        friends.setBounds(260, 205, 300, 25);
        groupText.setForeground(Color.black);
        groupText.setFont(new Font("Calibri", Font.ITALIC, 15));
        groupText.setBounds(460, 205, 300, 25);
    
        textName.setBounds(50, 230, 150, 25);
        textID.setBounds(50, 285, 150, 25);
        textGrade.setBounds(50, 340, 150, 25);

        JTextField friendPrefOne = new JTextField();
        JTextField friendPrefTwo = new JTextField();
        JTextField friendPrefThree = new JTextField();
        JComboBox<String> group = new JComboBox<String>(groups);

        friendPrefOne.setBounds(260, 230, 150, 25);
        friendPrefTwo.setBounds(260, 285, 150, 25);
        friendPrefThree.setBounds(260, 340, 150, 25);
        group.setBounds(460, 230, 175, 25);

        btnBack.setBounds(50, 400, 100, 25);
        btnAdd.setBounds(690, 230, 100, 25);
        btnUpdate.setBounds(690, 285, 100, 25);
        btnDelete.setBounds(690, 340, 100, 25);

        frame.setLayout(null);
        frame.add(pane);
        frame.add(friendPrefOne);
        frame.add(friendPrefTwo);
        frame.add(friendPrefThree);
        frame.add(group);
    

        // add JTextFields to the jframe
        frame.add(textName);
        frame.add(textID);
        frame.add(textGrade);
        frame.add(name);
        frame.add(ID);
        frame.add(grade);
        frame.add(friends);
        frame.add(groupText);
        frame.add(errorMessage);

        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnBack);

        // create an array of objects to set the row data
        Object[] data = new Object[5];
        // button add row - Clicked on Add Button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int friends[] = new int[3];
                    data[3] = "";
                    String friendList;
                    data[0] = textName.getText();
                    data[1] = Integer.valueOf(textID.getText());
                   
                    if(Integer.valueOf(textGrade.getText()) < 9 || Integer.valueOf(textGrade.getText()) > 12){
                        throw new IOException();
                    }else{

                        data[2] = Integer.valueOf(textGrade.getText());
                    }
            
                    data[3] =  (friendPrefOne.getText() + " " + friendPrefTwo.getText() + " " + friendPrefThree.getText());
                    data[4] = group.getSelectedItem();

                    if(!friendPrefOne.getText().equals("")){
                        friends[0] = Integer.valueOf(friendPrefOne.getText());

                    }else{
                        friends[0] = -1;
                        
                    }

                    if(!friendPrefTwo.getText().equals("")){
                        friends[1] = Integer.valueOf(friendPrefTwo.getText());

                    }else{
                        friends[1] = -1;
                       

                    }
                    if(!friendPrefThree.getText().equals("")){
                        friends[2] = Integer.valueOf(friendPrefThree.getText());

                    }else{
                        friends[2] = -1;
                    }



                    
                    textName.setText("");
                    textID.setText("");
                    textGrade.setText("");
                    friendPrefOne.setText("");
                    friendPrefTwo.setText("");
                    friendPrefThree.setText("");
                   // textFriends.setText("");
                    addStudent(data, friends);
                } catch (NumberFormatException a) {
          
                    errorMessage.setText("Invalid Input");
                    clearErrorMessage(errorMessage);
                }catch(IOException b){
    
                    errorMessage.setText("Invalid Grade");
                    clearErrorMessage(errorMessage);
                }
            }
        });

        // button remove row - Clicked on Delete Button
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();

                if (i >= 0) {
                    // remove a row from jtable
                 
                    removeStudent(i);
                    textName.setText("");
                    textID.setText("");
                    textGrade.setText("");
                    friendPrefOne.setText("");
                    friendPrefTwo.setText("");
                    friendPrefThree.setText("");
                  
                } else {
                    errorMessage.setText("Please select a valid row");
                    clearErrorMessage(errorMessage);
                }
            }
        });

        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // i = the index of the selected row
                int[] updatedFriends;
                int i = table.getSelectedRow();
                textName.setText(getValue(i, 0));
                textID.setText(getValue(i, 1));
                textGrade.setText(getValue(i, 2)); 
                group.setSelectedItem(getValue(i,4));

                updatedFriends = studentList.get(i).getFriendPreferences();

                if(updatedFriends[0] == -1){
                    friendPrefOne.setText("");
                }else {
                    friendPrefOne.setText(Integer.toString(updatedFriends[0]));
                }

                if(updatedFriends[1] == -1){
                    friendPrefTwo.setText("");
                }else{
                    friendPrefTwo.setText(Integer.toString(updatedFriends[1]));
                }

                if(updatedFriends[2] == -1){
                    friendPrefThree.setText("");
                }else{
                    friendPrefThree.setText(Integer.toString(updatedFriends[2]));
                }
            }
        });

        // button update row - Clicked on Update Button
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if (i >= 0) {
                    try {

                        int[] friends = new int[3];
                        
                        if(!friendPrefOne.getText().equals("")){
                            friends[0] = Integer.valueOf(friendPrefOne.getText());
                        }else{
                            friends[0] = -1;
                        }

                        if(!friendPrefTwo.getText().equals("")){
                            friends[1] = Integer.valueOf(friendPrefTwo.getText());
    
                        }else{
                            friends[1] = -1;
                        }
                        if(!friendPrefThree.getText().equals("")){
                            friends[2] = Integer.valueOf(friendPrefThree.getText());
    
                        }else{
                            friends[2] = -1;
                        }

                        data[0] = textName.getText();
                        data[1] = Integer.valueOf(textID.getText());
                        if(Integer.valueOf(textGrade.getText()) < 9 || Integer.valueOf(textGrade.getText()) > 12){
                            throw new IOException();
                        }else{
    
                            data[2] = Integer.valueOf(textGrade.getText());
                        }
                        data[4] = group.getSelectedItem(); 

                        data[3] = friendPrefOne.getText() + " " + friendPrefTwo.getText() + " " + friendPrefThree.getText();
                        updateStudent(i, data, friends);
                    } catch (NumberFormatException a) {
                        errorMessage.setText("Inccorect Inputs");
                        clearErrorMessage(errorMessage);
                    }catch(IOException b){
                        errorMessage.setText("Invalid Grade");
                        clearErrorMessage(errorMessage);
                    }
                } else {
                    errorMessage.setText("Please select a valid row");
                    clearErrorMessage(errorMessage);
                }
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new SystemManager();
            }
        });
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void clearErrorMessage(JLabel errorMessage) {
        //if you spam update error, the timer doesnt work
        Timer timer = new Timer(2500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorMessage.setText("");
            }
        });

        timer.start();
        timer.setRepeats(false);    
    }

    public static void displayStudents() {
        for (Student s: studentList) {
            System.out.println(s.getId());
        }
    }

    public static String getValue(int i, int j){
        return model.getValueAt(i, j).toString();
    }

    public static void removeStudent(int i) {
        studentList.remove(i);
        model.removeRow(i);
     
    }

    public static void updateStudent(int i, Object[] data, int[] friends) {
        String name = (String) data[0];
        int id = (int) data[1];
        int grade = (int) data[2];
        String group = (String) data[4];

        studentList.get(i).setName(name);
        studentList.get(i).setId(id);
        studentList.get(i).setGrade(grade);
        studentList.get(i).setGroup(group);
        studentList.get(i).setFriendPreferences(friends);
        
        model.setValueAt(data[0], i, 0);
        model.setValueAt(data[1], i, 1);
        model.setValueAt(data[2], i, 2);
        model.setValueAt(data[3], i, 3);
        model.setValueAt(data[4], i, 4);
    }



    public static void addStudent(Object[] data, int[] friends) {  

        model.addRow(data);
        String name = (String)data[0];
        int id = (int) data[1];
        int grade = (int) data[2];
        String group = (String) data[4];    
        studentList.add(new Student(name, id, grade, friends, group));
        
    }

    public ArrayList<Student> getStudentList(){
        return studentList;
    }
}