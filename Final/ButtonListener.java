import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * [ButtonListener.java]
 * 
 * @author
 * @version 1.0
 **/

public class ButtonListener implements ActionListener {
  JFrame parentFrame;
  private int buttonOption;
  // JPanel panel;

  /**
   * StartButtonListener constructor
   * 
   * @param parent,       the JFrame of the Starting Frame
   * @param buttonOption, number that corresponds with the button pressed in the
   *                      starting frame
   */
  public ButtonListener(JFrame parent, int buttonOption) {
    this.buttonOption = buttonOption;
    parentFrame = parent;
  }

  /**
   * actionPerformed checks all interactions when a key is pressed
   * 
   * @param event, ActionEvent
   */
  public void actionPerformed(ActionEvent event) {

    if (buttonOption == 1) { // Button 1 is enrollment system

      // parentFrame.getContentPane().removeAll();
      // parentFrame.add(panel);
      // parentFrame.setVisible(true);
      parentFrame.dispose();

    } else if (buttonOption == 2) { // Button 2 is floor plan system

    } else if (buttonOption == 3) { // Button 3 is seating assignment system
      System.exit(0);
    }
  }
}