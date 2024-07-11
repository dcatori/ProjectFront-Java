// Fig. 13.11: FontJPanel.java
// Display strings in different fonts and colors.
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FontJPanel extends JPanel
{
   // display Strings in different fonts and colors
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      
      g.setColor(Color.PINK);
      g.fillRect(20, 40, 100, 50);
      g.setColor(Color.BLUE);
      g.setFont(new Font("Arial",Font.ITALIC, 22));
      g.drawString("Senac", 22, 70);
      

    
     

      
   } 
} // end class FontJPanel
