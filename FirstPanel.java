import javax.swing.JFrame;

public class FirstPanel{
    public static void main(String[] args) {
        
        JFrame jf = new JFrame("FIRST PANEL");


        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        Panel panel =  new Panel();

        jf.add(panel);
        jf.setSize(300, 150);
        jf.setVisible(true);

    }
}