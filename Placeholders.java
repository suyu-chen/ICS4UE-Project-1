import java.util.ArrayList;
import java.util.Arrays;

class Table {

    private String tableName;
    private int capacity;
    private int remainingCapacity;
    private Student[] studentList;

    public Table(int capacity, String tableName) {
        this.capacity = capacity;
        this.remainingCapacity = capacity;
        this.studentList = new Student[capacity];
        this.tableName = tableName;
    }

    public boolean addStudent(Student student) {

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                remainingCapacity--;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        boolean empty = true;

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                empty = false;
                break;
            }
        }

        return empty;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Student[] getStudentList() {
        return this.studentList;
    }

    public int getRemainingCapacity() {
        return this.remainingCapacity;
    }

    public String toString() {
        return this.tableName + " " + remainingCapacity;
    }

}

class Student {

    private String name;
    private int id;
    private int grade;
    private int[] friendPreferences;
    private String group;

    // Constructor
    public Student(String name, int id, int grade, String group, int[] friends) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.friendPreferences = friends;
        this.group = group;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return this.id;
    }

    public int getGrade() {
        return this.grade;
    }

    public int[] getFriends() {
        return this.friendPreferences;
    }

    public String toString() {
        return this.name + ", friends: " + Arrays.toString(friendPreferences);
    }

}

class FloorPlanSystem {

    public FloorPlanSystem() {

    }

    ArrayList<Table> tables = new ArrayList<Table>();

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void printFloorPlan() {

        System.out.println("The Floor Plan!\n");

        for (int i = 0; i < tables.size(); i++) {

            System.out.println(tables.get(i).getTableName() + "\n");

            for (int j = 0; j < tables.get(i).getStudentList().length; j++) {
                System.out.println(tables.get(i).getStudentList()[j]);
            }

            System.out.println("\n");

        }
    }

}