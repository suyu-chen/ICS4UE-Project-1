// /* Main.java  
//  * @author Dhruv, Alex, Suyu
//  * @version October 11, 2021
//  * Main program for testing.
//  */

import java.util.Random;
import java.util.Arrays;

// /**
// * Main class
// * Contains tester methods
// */
class Test {

    static int studentNum = 100;
    static int numberOfStudentsToTest = 100;

    /**
     * generateRandomStudent Test method to generate random students
     * 
     * @return Student - the randomly generated Student
     */
    static public Object[] generateRandomStudent() {
        Random random = new Random();

        int grade = random.nextInt(4) + 9;
        studentNum++;
        int id = studentNum;

        final String[] groupNames = { "intro", "contest", "web" };
        String group = groupNames[random.nextInt(3)];

        // Generate random friends
        int numFriends = random.nextInt(2) + 2;
        int[] friends = new int[3];

        for (int i = 0; i < 3; i++) {
            if (i < numFriends) {
                friends[i] = 500 + random.nextInt(+numberOfStudentsToTest + 3);
            } else {
                friends[i] = -1;
            }

        }

        // Return Student object
        return new Object[] { id + "/" + grade + "/" + group, id, grade, Arrays.toString(friends).substring(1,Arrays.toString(friends).length()-1), group , friends};
    }
}
