/**
 * [Student.java]
 * 
 * @author 
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

    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int[] getFriendPreferences() {
        return this.friendPreferences;
    }

    public void setFriendPreferences(int[] friendPreferences) {
        this.friendPreferences = friendPreferences;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    

    

}