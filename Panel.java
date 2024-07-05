import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class Panel extends JPanel{

    public  void paintComponent (Graphics graphics) {

        super.paintComponent(graphics);
        this.setBackground(Color.RED);


        graphics.setColor(new Color(0, 0, 255));
        graphics.fillRect(15, 25, 100, 20);
        graphics.drawString("SENAC", 130, 40);

        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(15, 50, 100, 20);
        graphics.drawString("Cursa de JAVA", 130, 65);

    }

    }
    

