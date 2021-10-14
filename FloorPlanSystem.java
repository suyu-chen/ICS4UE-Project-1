/******* Graphics and GUI imports *******/
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

/******* Keyboard imports *******/
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/******* Mouse imports *******/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/******* Utility imports *******/
import java.util.ArrayList;
import java.util.Random;

/**
 * This class manages a list of Table objects. It creates an
 * interactive JFrame that allows the user the manage the
 * floor plan of the tables.
 * 
 * @author Edison Du
 * @author Peter Gu
 * @author Jeffrey Xu
 */
public class FloorPlanSystem {

    /***** Window Dimensions *****/
    private final int FRAME_WIDTH = 1300;
    private final int FRAME_HEIGHT = 760;

    /***** Graphics Related ******/
    private final int GRID_SQUARE_SIZE = 30;
    private final int MAX_RGB = 255;
    private final int LEGEND_X_POSITION = 1120;
    private final int LEGEND_Y_POSITION = 30;
    private final int MOUSE_X_OFFSET = -10;
    private final int MOUSE_Y_OFFSET = -30;
    private final int EXIT_BUTTON_X = GRID_SQUARE_SIZE;
    private final int EXIT_BUTTON_Y = GRID_SQUARE_SIZE * 21;
    private final int EXIT_BUTTON_WIDTH = GRID_SQUARE_SIZE*5;
    private final int EXIT_BUTTON_HEIGHT = GRID_SQUARE_SIZE*2;
    private final int TABLE_HELPER_X = FRAME_WIDTH-440;
    private final int TABLE_HELPER_Y = FRAME_HEIGHT-220;
    private final Color BUTTON_COLOR = new Color(125, 125, 255);

    /***** Camera Shift *****/
    private int offsetX = 0;
    private int offsetY = 0;

    /***** Program Logic ******/
    private int numTables;
    private int numGroups;
    private String[] groups;
    private Color[] groupColors;
    private ArrayList<Table> tableList;

    /***** Table Movement *****/
    private int selectedTable;
    private int selectedTableX, selectedTableY;
    private boolean selected;
    
    /***** Utility ******/
    private Random random = new Random();
    
    /**
     * Constructs a new floor plan system with a list of Table objects.
     * @param groups The different groups that the tables belong to
     */
    public FloorPlanSystem(String[] groups) {
        this.groups = groups;
        this.numGroups = groups.length;
        tableList = new ArrayList<Table>();
        groupColors = new Color[numGroups];
        selectedTable = -1;
        
        // Assign colors associated with each group
        for (int i = 0; i < numGroups; i++) {
            int r = random.nextInt(MAX_RGB/2) + MAX_RGB/2;
            int g = random.nextInt(MAX_RGB/2) + MAX_RGB/2;
            int b = random.nextInt(MAX_RGB/2) + MAX_RGB/2;
            groupColors[i] = new Color(r, g, b);
        }
    }

    /**
     * Creates an interactive JFrame used to display all the
     * tables and allows the user to move them around.
     */
    public void displayTables() {
        FloorPlanFrame floorPlanFrame = new FloorPlanFrame();
    }

    /**
     * Adds a table object to the floor plan's list of tables.
     * @param table the table object to add
     * @param groupName the group associated with the table
     * @return whether the table was succesfully added
     */
    public boolean addTable(Table table, String groupName) {
        for (int i = 0; i < numGroups; i++) {
            if (groups[i].equals(groupName)) {

                table.setColor(groupColors[i]);
                table.setGroup(groupName);
                tableList.add(table);
                numTables++;

                // Reset the table layout to accommodate for the new table
                rearrangeTables();
                return true;
            }
        }
        // If none of the groups match the group name, the table is not added
        return false;
    }
    
    /**
     * Removes a table object from the floor plan's list of tables.
     * @param id the id of the table to remove
     * @return whether the table exists and was succesfully removed
     */
    public boolean removeTable(int id) {
        for (int i = 0; i < numTables; i++) {
            if (tableList.get(i).getId() == id) {
                tableList.remove(i);
                numTables--;  
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an arraylist containing the list of tables.
     * @return the arraylist containing the list of tables
     */
    public ArrayList<Table> getTableList() {
    
        return this.tableList;
    }

    /**
     * Rearranges all the tables into a grid formation in the floor 
     * plan layout.
     */
    private void rearrangeTables() {
        int currentRow = GRID_SQUARE_SIZE;
        int currentColumn = GRID_SQUARE_SIZE;

        for (int i = 0; i < numTables; i++) {
            
            tableList.get(i).setX(currentColumn);
            tableList.get(i).setY(currentRow);
            
            /**
             *  Make sure that the table moves onto the next row of the grid
             *  when it reaches the end of the JFrame window.
             */
            currentColumn += Table.WIDTH + GRID_SQUARE_SIZE;
            if (currentColumn + GRID_SQUARE_SIZE >= FRAME_WIDTH) {
                currentColumn = GRID_SQUARE_SIZE;
                currentRow += Table.HEIGHT + GRID_SQUARE_SIZE;
            }
        }
    }

    private class FloorPlanFrame extends JFrame {

        FloorPlanFrame() {
            super("Floor Plan System");

            // Basic initialization
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            this.setResizable(false);
            this.requestFocusInWindow();
            this.setVisible(true);   

            // Add panel
            this.add(new FloorPlanPanel());

            // Add listeners
            this.addKeyListener(new KeyEventListener());    
            this.addMouseListener(new MouseEventListener());  
            this.addMouseMotionListener(new MouseMotionEventListener());
        
            // Create thread
            Thread t = new Thread(new Runnable(){     
                public void run() { 
                    animate();
                }
            }); 
              
            t.start();  
        }
        
        private void animate() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted");
                    e.printStackTrace();
                }
                this.repaint();
            }
        }
        
        // Inner class for JPanel
        private class FloorPlanPanel extends JPanel {

            public void paintComponent(Graphics g) {
                setDoubleBuffered(true);

                // Draw grid lines
                g.setColor(new Color(200, 200, 200));
                for (int i = 0; i < FRAME_WIDTH; i += GRID_SQUARE_SIZE) {
                    g.drawLine(i, 0, i, FRAME_HEIGHT);
                }
                for (int i = 0; i < FRAME_HEIGHT; i += GRID_SQUARE_SIZE) {
                    g.drawLine(0, i, FRAME_WIDTH, i);
                }

                // Draw tables
                for (int i = 0; i < numTables; i++) {
                    if (i != selectedTable) {
                        tableList.get(i).draw(g, offsetX, offsetY);
                    }
                }

                // Draw table hover helper
                if (selected) {
                    tableList.get(selectedTable).drawTransparent(g, offsetX, offsetY);    
                    tableList.get(selectedTable).drawInformation(g, TABLE_HELPER_X, TABLE_HELPER_Y);
                }

                // Draw color legend for groups
                g.setColor(new Color(255, 255, 255, 130));
                g.fillRect(LEGEND_X_POSITION, LEGEND_Y_POSITION, GRID_SQUARE_SIZE * 4, GRID_SQUARE_SIZE * 4);
                g.setColor(Color.black);
                g.drawRect(LEGEND_X_POSITION, LEGEND_Y_POSITION, GRID_SQUARE_SIZE * 4, GRID_SQUARE_SIZE * 4);
                
                for (int i = 0; i < numGroups; i++) {
                    int labelX = LEGEND_X_POSITION+15;
                    int labelY = i * GRID_SQUARE_SIZE + LEGEND_Y_POSITION+15;
                    g.setColor(groupColors[i]);
                    g.fillRect(labelX, labelY, GRID_SQUARE_SIZE, GRID_SQUARE_SIZE);
                    g.setColor(Color.black);
                    g.drawRect(labelX, labelY, GRID_SQUARE_SIZE, GRID_SQUARE_SIZE);
                    g.drawString(groups[i], labelX + GRID_SQUARE_SIZE + 15, labelY + 20);
                }

                // Draw button
                g.setColor(BUTTON_COLOR);
                g.fillRect(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
                g.setColor(Color.black);
                g.drawRect(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
                g.drawString("Back", EXIT_BUTTON_X + 25, EXIT_BUTTON_Y + 25);

            }
        }

        // Key listener
        private class KeyEventListener implements KeyListener {
            public void keyPressed (KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    FloorPlanFrame.this.dispose()
                    ;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    offsetX -= GRID_SQUARE_SIZE;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    offsetX += GRID_SQUARE_SIZE;
                } else if (e.getKeyCode() == KeyEvent.VK_UP){
                    offsetY += GRID_SQUARE_SIZE;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    offsetY -= GRID_SQUARE_SIZE;
                }
            }
            public void keyReleased (KeyEvent e) {}
            public void keyTyped (KeyEvent e) {}
        }

        // Mouse listener
        private class MouseEventListener implements MouseListener {
            public void mousePressed (MouseEvent e) {
                
                // Instatiate mouse coordinates 
                int mouseX = e.getX() + MOUSE_X_OFFSET;
                int mouseY = e.getY() + MOUSE_Y_OFFSET;

                // Dispose the frame if exit button is pressed
                if ( (mouseX >= EXIT_BUTTON_X) && (mouseX <= EXIT_BUTTON_X + EXIT_BUTTON_WIDTH) ) {
                    if ( (mouseY >= EXIT_BUTTON_Y) && (mouseY <= EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT) ) {
                        new SystemManager();
                        FloorPlanFrame.this.dispose();
                      
                    }
                }

                // Move table
                if (!selected){
                    mouseX -= offsetX;
                    mouseY -= offsetY;
                    // Checking for which table is currently being cclicked
                    for (int i = 0; i < numTables; i++) {
                        Table t = tableList.get(i);
                        if (t.checkOverlap(mouseX, mouseY)){ // Check collision
                            selectedTable = i;
                            selectedTableX = t.getX();
                            selectedTableY = t.getY();
                            selected = true;
                        }
                    }
                }
            }
            public void mouseReleased (MouseEvent e) {
                
                // Instatiate mouse coordinates 
                int mouseX = e.getX() + MOUSE_X_OFFSET - offsetX;
                int mouseY = e.getY() + MOUSE_Y_OFFSET - offsetY;

                // Instatiate closest rectangle corner coordinates
                int newTableX = ((mouseX - Table.WIDTH/2)/GRID_SQUARE_SIZE)*GRID_SQUARE_SIZE;
                int newTableY = ((mouseY - Table.HEIGHT/2)/GRID_SQUARE_SIZE)*GRID_SQUARE_SIZE;
                
                // Check if table can be moved to new location
                if (selected){
                    boolean notOverlap = true;
                    // Check all tables for collision
                    for (int i = 0; i < numTables; i++){
                        if (i != selectedTable){
                            Table t = tableList.get(i);
                            Rectangle tableA = new Rectangle(newTableX, newTableY, Table.WIDTH, Table.HEIGHT);
                            Rectangle tableB = new Rectangle(t.getX(), t.getY(), Table.WIDTH, Table.HEIGHT);
                            if (tableA.intersects(tableB)){
                                notOverlap = false;
                                break;
                            }
                        }
                    }
                    // If no collision, move to new location
                    if (notOverlap){
                        tableList.get(selectedTable).setX(newTableX);
                        tableList.get(selectedTable).setY(newTableY);
                    } else { // Otherwise, return to old position
                        tableList.get(selectedTable).setX(selectedTableX);
                        tableList.get(selectedTable).setY(selectedTableY);
                    }
                    selected = false;
                    selectedTable = -1;
                    selectedTableX = 0;
                    selectedTableY = 0;
                }
            }
            public void mouseClicked (MouseEvent e) {}
            public void mouseEntered (MouseEvent e) {}
            public void mouseExited (MouseEvent e) {}
        }

        // Mouse motion listener
        private class MouseMotionEventListener implements MouseMotionListener {
            public void mouseDragged (MouseEvent e) {
                
                // Instatiate mouse coordinates 
                int mouseX = e.getX() + MOUSE_X_OFFSET - offsetX;
                int mouseY = e.getY() + MOUSE_Y_OFFSET - offsetY;
                
                // If there is a table being moved, adjust its coordinates in relation to the mouse
                if (selected){
                    tableList.get(selectedTable).setX(mouseX - Table.WIDTH/2);
                    tableList.get(selectedTable).setY(mouseY - Table.HEIGHT/2);
                }
            }
            public void mouseMoved (MouseEvent e) {}
        }
    }
}