// Fig. 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> namesJComboBox; // hold list names
   private final JLabel label; // displays selected name

   private static final String[] names = 
      {"Gustavo", "Gabriel", "Lucas", "Matheus", "Daniel", "Julio", "Angelo", "Enrique", "Germano", "Farias", "Douglas", "Rafael", "Felipe"};
   
   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // set frame layout     

      namesJComboBox = new JComboBox<String>(names); // set up JComboBox
      //imagesJComboBox.setMaximumRowCount(3); // display three rows

      add(namesJComboBox); // add combobox to JFrame
      label = new JLabel(names[0]); // display first name
      add(label); // add label to JFrame
      namesJComboBox.addItemListener(event -> { 
           if (event.getStateChange() == ItemEvent.SELECTED)
              label.setText(names[namesJComboBox.getSelectedIndex()]);
           }); // end call to addItemListener
   } // end ComboBoxFrame constructor
} // end class ComboBoxFrame


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
