import java.util.Comparator;

/**
 * StudentFriendComparator.java A Comparator that compares students based on the
 * number of friends
 * 
 * @author Suyu
 */
public class StudentFriendReverseComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        int s1Friends = getNumFriends(s1);
        int s2Friends = getNumFriends(s2);
        if (s1Friends < s2Friends) {
            return 1;
        } else if (s1Friends == s2Friends) {
            return 0;
        } else {
            return -1;
        }
    }

    private int getNumFriends(Student s) {
        int[] friends = s.getFriends();
        int numFriends = friends.length;
        for (int i = 0; i < friends.length; i++) {
            if (friends[i] == -1) {
                numFriends--;
            }
        }
        return numFriends;
    }
}
