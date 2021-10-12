import java.awt.Graphics;

public class Table {

    private int id;
    private int capacity;
    private int numStudents;
    private Student[] students;

    Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.numStudents = 0;
        this.students = new Student[capacity];
    }

    public boolean addStudent(Student student) {
        if (this.seatsRemaining() == 0) {
            return false;
        }
        this.students[this.numStudents++] = student;
        return true;
    }

    public boolean removeStudent(int id) {
        for (int i = 0; i < this.numStudents; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
            }
            // Shift students downwards in the array
            if (i > 0 && students[i - 1] == null) {
                students[i - 1] = students[i];
                students[i] = null;
            }
        }
        if (numStudents > 0 && students[numStudents - 1] == null) {
            numStudents--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.numStudents == 0;
    }

    public int seatsRemaining() {
        return this.capacity - this.numStudents;
    }

    public int getNumStudents() {
        return this.numStudents;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getID() {
        return this.id;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public void draw(Graphics g, int x, int y) {
        g.drawRect(x + 50, y + 50, 100, 100);
        for (int i = 0; i < this.getNumStudents(); i++) {
            g.drawString(Integer.toString(i + 1), x + 160, y * 200 + 70 + i * 20);
            g.drawString(students[i].getName(), x + 170, y * 200 + 70 + i * 20);
        }
    }
}
