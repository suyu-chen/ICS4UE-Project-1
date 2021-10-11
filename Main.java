/* Main.java  
 * @author Dhruv, Alex, Suyu
 * @version October 11, 2021
 * Main program for testing.
 */

import java.util.ArrayList;
import java.util.Random;

class Main {

    static int studentNum = 500;
    static int numberOfStudentsToTest = 500;

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        // testing students
        for (int i = 0; i < numberOfStudentsToTest; i++) {
            students.add(generateRandomStudent());
        }
        students.add(new Student("friend1", 999, 9, "web", new int[] { 998, 997, 996 }));
        students.add(new Student("friend2", 998, 9, "web", new int[] { 999, 995, 996 }));
        students.add(new Student("friend3", 997, 9, "web", new int[] { 995, 994, 998 }));
        students.add(new Student("friend4", 996, 9, "web", new int[] { 997, 995, 994 }));
        students.add(new Student("friend5", 995, 9, "web", new int[] { 998, 998, 998 }));
        students.add(new Student("friend6", 994, 9, "web", new int[] { 999, 998, 996 }));

        // stuff
        FloorPlanSystem floorPlanSystem = new FloorPlanSystem();
        SeatingAssignmentSystem seatingAssignmentSystem = new SeatingAssignmentSystem();
        seatingAssignmentSystem.arrangeStudents(floorPlanSystem, students, 4);

        floorPlanSystem.printFloorPlan();

    }

    // test method (really bad code form)
    static public Student generateRandomStudent() {
        Random random = new Random();

        int grade = random.nextInt(4) + 9;
        studentNum++;
        int id = studentNum;

        final String[] groupNames = { "intro", "contest", "web" };
        String group = groupNames[random.nextInt(3)];

        int numFriends = random.nextInt(2) + 2;
        int[] friends = new int[3];

        for (int i = 0; i < 3; i++) {
            if (i < numFriends) {
                friends[i] = 500 + random.nextInt(+numberOfStudentsToTest + 3);
            } else {
                friends[i] = -1;
            }

        }
        return new Student(id + "/" + grade + "/" + group, id, grade, group, friends);

    }
}
