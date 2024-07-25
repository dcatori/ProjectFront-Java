import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EditarCadastro extends JFrame {

    private final JTextField idTextField = new JTextField();
    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailTextField = new JTextField();
    private final JTextField senhaTextField = new JTextField();
    private final JLabel idJLabel = new JLabel("ID:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações:");
    private final JButton atualizarJButton = new JButton("✓");
    private final JButton primeiroRegistroJButton = new JButton("<<");
    private final JButton registroAnteriorJButton = new JButton("<");
    private final JButton proximoRegistroJButton = new JButton(">");
    private final JButton ultimoRegistroJButton = new JButton(">>");

    public EditarCadastro() {

        super("Editar Cadastro");
        setLayout(new GridLayout(6, 4, 5, 5));

        add(idJLabel);
        add(idTextField);
        add(atualizarJButton);
        add(new JLabel());

        add(nomeJLabel);
        add(nomeTextField);
        add(new JLabel());
        add(new JLabel());

        add(emailJLabel);
        add(emailTextField);
        add(new JLabel());
        add(new JLabel());

        add(senhaJLabel);
        add(senhaTextField);
        add(new JLabel());
        add(new JLabel());
       
        idTextField.setEditable(false);
        atualizarJButton.setEnabled(false);
        atualizarJButton.setToolTipText("Atualizar cadastro");
        
        atualizarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String nome;
               
                try{
                   nome = nomeTextField.getText();
                   // aqui vamos incluir a ação de cadastrar no bando de dados
                    InserirRegistro.cadastrar("db_teste", "tbl_teste", "nome", nome);
                    notificacaoJLabel.setText("Cadastro com sucesso");
                } catch(NumberFormatException ex){
                   System.out.println("Digite alguma coisa.");
                   return;
                } 
            }
        }
         ); 
    
        add(primeiroRegistroJButton);
        add(registroAnteriorJButton);
        add(proximoRegistroJButton);
        add(ultimoRegistroJButton);
        add(notificacaoJLabel);

        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        EditarCadastro application = new EditarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
