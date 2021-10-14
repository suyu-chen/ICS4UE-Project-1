/**
 * [Student.java]
 * Stores all student information
 * @author Alex, Nicholas, Samson
 * @version 1.0 
**/
public class Student{

    private String name;
    private int id;
    private int grade;
    int[] friendPreferences;
    String group;

    public Student(String name, int id, int grade, int[] friendPreferences, String group){
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.friendPreferences = friendPreferences;
        this.group = group;
    }

    
    
    /** getName
     * gets the name of the student
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** setName
     * sets the name of the student
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** getId
     * sets the id of the student
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** setId
     * sets the id of the student
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** getGrade
     * gets the grade of the student
     * @return int
     */
    public int getGrade() {
        return this.grade;
    }

    
    /** setGrade
     * sets the grade of the student
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    
    /** getFriendPreferences
     * gets the friendpreferences of the student
     * @return int[]
     */
    public int[] getFriendPreferences() {
        return this.friendPreferences;
    }

    
    /** setFriendPreferences
     * sets the friend preferences of the student
     * @param friendPreferences
     */
    public void setFriendPreferences(int[] friendPreferences) {
        this.friendPreferences = friendPreferences;
    }

    
    /** getGroup
     * gets the group of the student
     * @return String
     */
    public String getGroup() {
        return this.group;
    }

    
    /** setGroup
     * sets the group of the student
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

}