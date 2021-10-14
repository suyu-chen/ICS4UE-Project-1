import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Image;

/**
 * [SystemManager.java]
 * Manages the seating assignment, student enrollment and floor plan system
 * @author Alex, Nicholas, Samson
 * @version 1.0 
**/

public class SystemManager extends JFrame {
    public static EnrollmentSystemPanel enrollSys = new EnrollmentSystemPanel();
    public static FloorPlanSystem floorPlan = new FloorPlanSystem(new String[]{"intro", "contest", "web"});
    private Image csLogo;
    JFrame thisFrame;
   
    public static SeatingAssignmentSystem seatingPlan  = new SeatingAssignmentSystem();

    public SystemManager() {
        super("Seating Assignment Manager");
        this.thisFrame = this;
        JPanel mainPanel = new MainPanel();
        

        //configure the window  
        this.setSize(900, 500);
        this.setLocationRelativeTo(null); //start the frame in the center of the screen
        this.setResizable(false);

        //Create a JButton for the centerPanel
        JButton enrollButton = new JButton("Enrollment System");
        enrollButton.setPreferredSize(new Dimension(240, 50));
        enrollButton.setBackground(new Color(255, 255, 255));
        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                thisFrame.dispose();
                enrollSys.generateJTable();
            }
        });

        //Create a JButton for the centerPanel
        JButton instButton = new JButton("Floor Plan System");
        instButton.setPreferredSize(new Dimension(240, 50));
        instButton.setBackground(new Color(255, 255, 255));
        instButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                thisFrame.dispose();
                floorPlan = new FloorPlanSystem(new String[]{"intro", "contest", "web"});
                seatingPlan =  new SeatingAssignmentSystem();
                seatingPlan.arrangeStudents(floorPlan, enrollSys.getStudentList());
                floorPlan.displayTables();
            }
        });

        //Create a JButton for the centerPanel
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(240, 50));
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                 System.exit(0);
            }
        });

        mainPanel.add(enrollButton);
        mainPanel.add(instButton);
        mainPanel.add(exitButton);

        //add the main panel to the frame

        this.add(mainPanel);
        this.setVisible(true);
        this.requestFocusInWindow();
    }

    
    /**drawLogo 
     * draws the RHHS Computer Science Logo
     * @param g the graphics panel
     */
    public void drawLogo(Graphics g) {
        try {
            csLogo = ImageIO.read(new File("cslogo.png")).getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(csLogo, 300, 100, null);
    }

    class MainPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g); 
            setDoubleBuffered(true);
            drawLogo(g);
        }
    }

    class FloorPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g); 
            setDoubleBuffered(true);
        }
    }
    public static void main(String[] args) {
        new SystemManager();
    }
}