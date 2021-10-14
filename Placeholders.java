/*
 * Placeholders.java
 * 
 * @author Dhruv, Alex, Suyu
 * 
 * @version October 11, 2021 Placeholders for testing the seating assignment
 * system.
 */

/**
 * Table This class is for the Table, possessing table data such as the
 * capacity, name, etc.
 * 
 * @param capacity  (int) - the table's capacity
 * @param tableName (String) - the name of the table
 */
// class Table {

// private String tableName;
// private int capacity;
// private int remainingCapacity;
// private Student[] studentList;
// private int id;

// /**
// * Table constructor
// * Constructor method for the Table class.
// * @param capacity (int) - the table's capacity
// * @param tableName (String) - the name of the table
// */
// public Table(int id, int capacity, String tableName) {
// this.id = id;
// this.capacity = capacity;
// this.remainingCapacity = capacity;

// //The list of students in the table, to be operated on using addStudent,
// isEmpty, and the getStudentList getter.
// this.studentList = new Student[capacity];

// this.tableName = tableName;
// }

// /**
// * boolean addStudent
// * Adds a student to a table, if there is capacity.
// * @param student (Student) - the Student object to add.
// * @return (Boolean) - true if the student has been added, false if there is
// no capacity.
// */
// public boolean addStudent(Student student) {

// //Iterate through the studdentList, checking if there is capacity (if
// studentList[i] is empty, meaning there is a slot)
// for (int i = 0; i < studentList.length; i++) {
// if (studentList[i] == null) {
// studentList[i] = student;
// remainingCapacity--; //Subtract from the remaining capacity
// return true;
// }
// }
// return false;
// }

// public int getID(){
// return id;
// }

// /**
// * boolean isEmpty
// * Checks if the table is empty.
// * @return (Boolean) - true if table is empty, false if the table is not.
// */
// public boolean isEmpty() {
// boolean empty = true;

// //Iterate through the studentList to check if any element is not empty (not
// null)
// for (int i = 0; i < studentList.length; i++) {
// if (studentList[i] != null) {
// empty = false;
// break;
// }
// }

// return empty;
// }

// /**
// * String getTableName - Getter method
// * @return this.tableName (String) - name of the table
// */
// public String getTableName() {
// return this.tableName;
// }

// /**
// * int getCapacity - Getter method
// * @return this.capacity (int) - total capacity
// */
// public int getCapacity() {
// return this.capacity;
// }

// /**
// * int getStudentList - Getter method
// * @return this.studentList (Student[]) - list of students in the table
// */
// public Student[] getStudentList() {
// return this.studentList;
// }

// /**
// * int getRemainingCapacity - Getter method
// * @return this.remainingCapacity (int) - remaining capacity
// */
// public int getRemainingCapacity() {
// return this.remainingCapacity;
// }

// /**
// * int toString
// * Table representer
// * @return Name " " Capacity (String) representation of the table in the
// format Name " " Capacity (e.g. Name 3)
// */
// public String toString() {
// return this.tableName + " " + remainingCapacity;
// }

// }

// /**
// * Student
// * This class is for the Student, possessing Student data such as name, grade,
// etc.
// * @param name (String) - name of the student
// * @param id (int) - student ID
// * @param grade (int) - the student's grade
// * @param group (String) - their group of interest (Contest, WebDev, or Intro)
// * @param friends (int[]) - an integer Array of their friend preferences
// */
// class Student {

// private String name;
// private int id;
// private int grade;
// private int[] friendPreferences;
// private String group;

// /**
// * Student constructor
// * Constructor method for the Student class.
// * @param name (String) - name of the student
// * @param id (int) - student ID
// * @param grade (int) - the student's grade
// * @param group (String) - their group of interest (Contest, WebDev, or Intro)
// * @param friends (int[]) - an integer Array of their friend preferences
// */
// public Student(String name, int id, int grade, String group, int[] friends) {
// this.name = name;
// this.id = id;
// this.grade = grade;
// this.friendPreferences = friends;
// this.group = group;
// }

// /**
// * String getName - Getter method
// * @return this.name (String) - student's name
// */
// public String getName() {
// return this.name;
// }

// /**
// * String getGroup - Getter method
// * @return this.group (String) - student's interest
// */
// public String getGroup() {
// return this.group;
// }

// /**
// * String getId - Getter method
// * @return this.id (int) - student's ID
// */
// public int getId() {
// return this.id;
// }

// /**
// * String getGrade - Getter method
// * @return this.grade (int) - student's grade
// */
// public int getGrade() {
// return this.grade;
// }

// /**
// * String getFriends - Getter method
// * @return this.friendPreferences (int[]) - student's friend preferences
// */
// public int[] getFriends() {
// return this.friendPreferences;
// }

// /**
// * String toString
// * Student representer
// * @return Name Friends Preferences (String) - representation of the Student
// in the format Name Friends Capacity (e.g. Name: X,Y,Z)
// */
// public String toString() {
// return this.name + ", friends: " + Arrays.toString(friendPreferences);
// }

// }

/**
 * FloorPlanSystem This class is for the floorPlanSystem, representing the
 * Tables and students graphically
 */
// class FloorPlanSystem {

// //New ArrayList for the tables
// ArrayList<Table> tables = new ArrayList<Table>();
// int capacity = 4;

// /**
// * FloorPlanSystem constructor
// * Constructor method for the FloorPlanSystem class.
// */
// public FloorPlanSystem() {
// }

// public int getCapacity(){
// return capacity;
// }

// /**
// * String getTables - Getter method
// * @return tables (ArrayList<Table>) - ArrayList for tables
// */
// public ArrayList<Table> getTables() {
// return tables;
// }

// /**
// * String getTables - Getter method
// * @return tables (ArrayList<Table>) - ArrayList for tables
// */
// public void addTable(Table table) {
// tables.add(table);
// }

// /**
// * void printFloorPlan
// * Graphically prints out the Floor Plan referencing ArrayList tables and the
// list of students
// */
// public void printFloorPlan() {

// System.out.println("The Floor Plan!\n");

// for (int i = 0; i < tables.size(); i++) {

// System.out.println(tables.get(i).getTableName() + "\n");

// for (int j = 0; j < tables.get(i).getStudentList().length; j++) {
// System.out.println(tables.get(i).getStudentList()[j]);
// }

// System.out.println("\n");

// }
// }

// }
