// Fig. 13.18: LinesRectsOvalsJPanel.java
// Drawing lines, rectangles and ovals.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;
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
      g.setFont(new Font("Arial", Font.BOLD, 22));
      g.drawString("Desafio", 150, 30);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.drawString("Senac", 15, 75);
      g.fillRect(100, 40, 90, 55);
      g.setColor(Color.ORANGE);
      g.drawString("Senac", 115, 75);
      
      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.setColor(Color.GRAY);
      g.drawString("Senac", 205, 75);
      g.setColor(Color.BLACK);
      g.drawRoundRect(290, 40, 90, 55, 20, 20);
      g.setColor(Color.GRAY);
      g.drawString("Senac", 300, 75);
      
      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.setColor(Color.GREEN);
      g.drawString("Senac", 10, 135);
      g.fill3DRect(100, 100, 90, 55, false);
      g.setColor(Color.PINK);
      g.drawString("Senac", 110, 135);
           
      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.setColor(Color.GRAY);
      g.drawString("Senac", 210, 135);
      g.setColor(Color.MAGENTA);
      g.fillOval(290, 100, 90, 55);
      g.setColor(Color.WHITE);
      g.drawString("Senac", 300, 135);      
      
   } 
} // end class LinesRectsOvalsJPanel

