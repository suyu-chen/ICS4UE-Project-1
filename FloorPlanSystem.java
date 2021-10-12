import java.awt.Graphics;
import java.util.ArrayList;

public class FloorPlanSystem {
    private ArrayList<ArrayList<Table>> tableList;
    private final String[] GROUP_NAMES = { "intro", "contest", "web" };
    private final int NUM_GROUPS = 3;

    // private final int e

    public FloorPlanSystem() {
        // tableList = new ArrayList<ArrayList<Table>>(NUM_GROUPS);
        tableList = new ArrayList<ArrayList<Table>>();
        for (int i = 0; i < NUM_GROUPS; i++) {
            tableList.add(new ArrayList<Table>());
        }
    }

    public void displayTables(Graphics g) {

        int xPosition = 50;

        for (int i = 0; i < NUM_GROUPS; i++) {
            int curCol = 0, curRow = 0;

            for (Table t : tableList.get(i)) {
                t.draw(g, xPosition + curCol * 200, curRow * 200);
                curCol = (curCol + 1) % 2;
                // curCol ^= 0;
                if (curCol == 0)
                    curRow++;
            }

            g.drawString(GROUP_NAMES[i], xPosition + 50, 10);
            xPosition += 600;
        }
    }

    public boolean addTable(Table table, String groupName) {
        for (int i = 0; i < NUM_GROUPS; i++) {
            if (GROUP_NAMES[i].equals(groupName)) {
                tableList.get(i).add(table);
                return true;
            }
        }
        return false;
    }

    public boolean removeTable(int id) {
        for (int i = 0; i < NUM_GROUPS; i++) {
            for (int j = tableList.get(i).size() - 1; j >= 0; j--) {
                if (tableList.get(i).get(j).getID() == id) {
                    tableList.get(i).remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Table>> getTableList() {
        return this.tableList;
    }
}