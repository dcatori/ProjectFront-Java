// Fig. 13.18: LinesRectsOvalsJPanel.java
// Drawing lines, rectangles and ovals.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

//import javafx.scene.text.Font;

public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);
      g.setColor(Color.ORANGE);
      g.setFont(new Font("Algerian", Font.BOLD, 20));
      g.drawString("Desafio", 150, 30);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.setFont(new Font("Algerian",Font.BOLD, 50));
      g.drawString("S", 35, 85);
      g.fillRect(100, 40, 90, 55);
      g.setColor(Color.ORANGE);
      g.setFont(new Font("Algerian",Font.BOLD, 50));
      g.drawString("E", 125, 85);
      
      
      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.setColor(Color.GRAY);
      g.drawString("N", 225, 85);
      g.setColor(Color.BLACK);
      g.drawRoundRect(290, 40, 90, 55, 20, 20);
      g.setFont(new Font("Algerian",Font.BOLD, 50));
      g.setColor(Color.GRAY);
      g.drawString("A", 315, 85);
      
      
      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.setColor(Color.GREEN);
      g.setFont(new Font("Algerian",Font.ITALIC, 50));
      g.drawString("C", 30, 145);
      g.fill3DRect(100, 100, 90, 55, false);
      g.setColor(Color.PINK);
      g.setFont(new Font("Algerian",Font.BOLD, 40));
      g.drawString("JA", 115, 140);
      
           
      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.setColor(Color.GRAY);
      g.setFont(new Font("Algerian",Font.BOLD, 40));
      g.drawString("VA", 210, 145);
      g.setColor(Color.MAGENTA);
      g.fillOval(290, 100, 90, 55);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Algerian",Font.BOLD, 50));  
      g.drawString("!!", 315, 140);  
        
      
   } 
} // end class LinesRectsOvalsJPanel


