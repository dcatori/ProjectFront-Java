import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class CadastrarRegistro extends JFrame{

    private final JButton cadJButton = new JButton("Cadastrar");
    private final JLabel nomeCadastrarJLabel = new JLabel("Digite um nome: ");
    private final JLabel emailCadastrarJLabel = new JLabel("Digite um email: ");
    private final JLabel senhaCadastrarJLabel =  new JLabel("Digite uma senha: ");
    private final JTextField nomeCadastrarJTextField = new JTextField();
    private final JTextField emailCadastrarTextField = new JTextField();
    private final JPasswordField senhaCadastrarPasswordField = new JPasswordField();
    private final JLabel notificaçãoJLabel = new JLabel("Notificações");


    public CadastrarRegistro() {
        super("Cadastrar Registro");
        setLayout(new GridLayout(5, 3, 5, 5));


        JPanel linha1PJPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha5JPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        linha1PJPanel.add(nomeCadastrarJLabel);
        linha1PJPanel.add(nomeCadastrarJTextField);
        add(linha1PJPanel);

        linha2JPanel.add(emailCadastrarJLabel);
        linha2JPanel.add(emailCadastrarTextField);
        add(linha2JPanel);

        linha3JPanel.add(senhaCadastrarJLabel);
        linha3JPanel.add(senhaCadastrarPasswordField);
        add(linha3JPanel);

        linha4JPanel.add(new JLabel());
        linha4JPanel.add(cadJButton);
        add(linha4JPanel);

        linha5JPanel.add(notificaçãoJLabel);
        add(linha5JPanel);

        //add(nomeCadastrarJLabel);
        //add(nomeCadastrarJTextField);
        //add(new JLabel());
        

        //add(emailCadastrarJLabel);
        //add(emailCadastrarTextField);
        //add(new JLabel());

        //add(senhaCadastrarJLabel);
        //add(senhaCadastrarPasswordField);
        //add(new JLabel());
        

        //add(notificaçãoJLabel);
        //add(new JLabel());
        //add(cadJButton);
        

        setSize(500, 200);
        setVisible(true);

        

    }

    public static void main(String[] args) {
        CadastrarRegistro application = new CadastrarRegistro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}