import java.awt.Checkbox;
import java.awt.GridLayout;
import javax.swing.*;


public class TelaLogin extends JFrame{

    private final JLabel loginJLabel = new JLabel("Login");
    private final JTextField loginTextField = new JTextField();
    private final JLabel senhaJLabel = new JLabel("Senha");
    private final JPasswordField senhaPasswordField = new JPasswordField();
    private final JButton entrarJButton = new JButton("Entrar");
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel notificacaoJLabel = new JLabel("Insira seu registro ou Faça um cadastro");
    private final Checkbox checkBox = new Checkbox("Aceite os termos");
    

    public TelaLogin(){

        super("Tela de Login");
        setLayout(new GridLayout(10, 1, 5, 5));

        JPanel linha1JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha5JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha6JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha7JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha8JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha9JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha10JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
       
        linha1JPanel.add(new JLabel());
        add(linha1JPanel);

        linha2JPanel.add(loginJLabel);
        add(linha2JPanel);

        linha3JPanel.add(loginTextField);
        add(linha3JPanel);

        //linha4JPanel.add(new JLabel());
        //add(linha4JPanel);

        linha5JPanel.add(senhaJLabel);
        add(linha5JPanel);

        linha6JPanel.add(senhaPasswordField);
        add(linha6JPanel);

        linha7JPanel.add(entrarJButton);
        linha7JPanel.add(cadastrarJButton);
        add(linha7JPanel);

        linha8JPanel.add(new JLabel());
        add(linha8JPanel);

        linha9JPanel.add(checkBox);
        add(linha9JPanel);

        linha10JPanel.add(notificacaoJLabel);
        add(linha10JPanel);

    
        setSize(300, 400);
        setVisible(true);

    }
    public static void main(String[] args) {
        TelaLogin application = new TelaLogin();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

  

}





