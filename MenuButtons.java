import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* [StartButtonListener.java]
* This is a class that is used to detect a button press
* @author Jayeong Lee, Mr. Mangat
* @version 1.0 2021/06/15
**/

public class MenuButtons implements ActionListener {  
  JFrame parentFrame;
  private int buttonOption; 
  //JPanel panel;
  
  
  /**
  * StartButtonListener constructor
  * @param parent, the JFrame of the Starting Frame
  * @param buttonOption, number that corresponds with the button pressed in the starting frame
  */
  public MenuButtons(JFrame parent, int buttonOption) { 
    this.buttonOption=buttonOption;
    parentFrame = parent;
  }

  /**
  * actionPerformed 
  * checks all interactions when a key is pressed
  * @param event, ActionEvent
  */
  public void actionPerformed(ActionEvent event) { 

    
    if (buttonOption == 1) { //Button 1 is enrollment system

    parentFrame.dispose();
    new EnrollmentSystem();

    } else if (buttonOption == 2) { //Button 2 is floor plan system


    } else if (buttonOption == 3) { //Button 3 is seating assignment system

      parentFrame.dispose();
      
    }else if(buttonOption == 4){
      parentFrame.dispose();
      new SystemManager();
    }
  }  
}

  
  


  
  
 