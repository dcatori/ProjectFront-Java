import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;

public class ExcluirRegistro extends JFrame{

    private final JTextField idTextField = new JTextField();
    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailTextField = new JTextField();
    private final JPasswordField senhaPasswordField = new JPasswordField();
    private final JLabel idJLabel = new JLabel("ID:");
    private final JLabel nomeJLabel = new JLabel("Digite o nome:");
    private final JLabel emailJLabel = new JLabel("Digite o email:");
    private final JLabel senhaJLabel = new JLabel("Digite a senha:");
    private final JButton primeiroRegistroJButton = new JButton(">");
    private final JButton pesquisarRegistroJButton = new JButton(">>");
    private final JButton registroAnteriorJButton = new JButton("<<");
    private final JButton excluirRegistroButton = new JButton("Excluir");

    public ExcluirRegistro(){
        super("Cadastro");

        setLayout(new GridLayout(5, 4, 5, 5));

        add(idJLabel);
        add(idTextField);
        add(new JLabel());
        add(excluirRegistroButton);

        add(nomeJLabel);
        add(nomeTextField);
        add(new JLabel());
        add(new JLabel());

        add(emailJLabel);
        add(emailTextField);
        add(new JLabel());
        add(new JLabel());

        add(senhaJLabel);
        add(senhaPasswordField);
        add(new JLabel());
        add(new JLabel());

        add(primeiroRegistroJButton);
        add(pesquisarRegistroJButton);
        add(registroAnteriorJButton);
        add(new JLabel());

        setSize(500, 200);
        setVisible(true);

        idTextField.setEditable(false);

        
        primeiroRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                carregarPrimeiroRegistro();
            }
        });

        pesquisarRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String[] resultado;
                try {
                    String idAtual = idTextField.getText();
                    resultado = NavegadorDeRegistro.pesquisarRegistro("db_aulateste", "tbl_teste", idAtual);

                    if (resultado != null) {
                        idTextField.setText(resultado[0]);
                        nomeTextField.setText(resultado[1]);
                        emailTextField.setText(resultado[2]);
                        senhaPasswordField.setText(resultado[3]);
                        
                    } else {
                    }
                } catch (Exception e) {
                    System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o próximo. Veja o erro: " + e);
                }
            }
        });

        registroAnteriorJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String[] resultado;
                try {
                    String idAtual = idTextField.getText();
                    resultado = NavegadorDeRegistro.registroAnterior("db_aulateste", "tbl_teste", idAtual);

                    if (resultado != null) {
                        idTextField.setText(resultado[0]);
                        nomeTextField.setText(resultado[1]);
                        emailTextField.setText(resultado[2]);
                        senhaPasswordField.setText(resultado[3]);
                        
                    } else {
                        
                    }
                } catch (Exception e) {
                    System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o anterior. Veja o erro: " + e);
                }
            }
        });

        excluirRegistroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    Connection conexao = MySQLConnector.conectar();
                    String strSqlExcluirRegistro = "delete from `db_aulateste`.`tbl_teste` where `id` = " + idTextField.getText() + ";";
                    Statement stmSqlExcluirRegistro = conexao.createStatement();
                    stmSqlExcluirRegistro.addBatch(strSqlExcluirRegistro);
                    stmSqlExcluirRegistro.executeBatch();
                    stmSqlExcluirRegistro.close();
                    System.out.println("Registro deletado com sucesso! (query: " + strSqlExcluirRegistro + ")");
                } catch (Exception e) {
                    System.out.println("Ops! Ocorreu o erro: " + e);
                }
              }
        });
    }

        public void carregarPrimeiroRegistro() {
            try {
                String[] resultado = NavegadorDeRegistro.primeiroRegistro("db_aulateste", "tbl_teste");
    
                if (resultado != null) {
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(false);
                    pesquisarRegistroJButton.setEnabled(true);
                    
                } else {
                    //notificacaoJLabel.setText("Nenhum registro encontrado.");
                }
            } catch (Exception e) {
                System.out.println("Ops! Ocorreu algum erro ao carregar o primeiro registro. Veja o erro: " + e);
            }

    }
    public static void main(String[] args) {
        ExcluirRegistro application = new ExcluirRegistro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

