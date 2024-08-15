import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;

public class EditarCadastro extends JFrame {

    private final JTextField idTextField = new JTextField();
    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailTextField = new JTextField();
    private final JPasswordField senhaPasswordField = new JPasswordField();
    private final JLabel idJLabel = new JLabel("ID:");
    private final JLabel nomeJLabel = new JLabel("Digite o nome:");
    private final JLabel emailJLabel = new JLabel("Digite o email:");
    private final JLabel senhaJLabel = new JLabel("Digite a senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações:");
    private final JButton atualizarJButton = new JButton("✓");

    
    private final JButton primeiroRegistroJButton = new JButton("<<");
    private final JButton registroAnteriorJButton = new JButton("<");
    private final JButton proximoRegistroJButton = new JButton(">");
    private final JButton ultimoRegistroJButton = new JButton(">>");
    private final JButton deletarRegistroButton = new JButton("♺");

    private final JButton novoJButton = new JButton("+");
    private final JButton verJButton = new JButton("🔎");
    private final JButton editarJButton = new JButton("✐");
   
    
    public EditarCadastro() {

        super("Editar Cadastro");
        setLayout(new GridLayout(6, 4, 5, 5));

        add(idJLabel);
        add(idTextField);
        add(atualizarJButton);
        add(deletarRegistroButton);

        add(nomeJLabel);
        add(nomeTextField);
        add(new JLabel());
        add(novoJButton);

        add(emailJLabel);
        add(emailTextField);
        add(new JLabel());
        add(editarJButton);

        add(senhaJLabel);
        add(senhaPasswordField);
        add(new JLabel());
        add(verJButton);

        add(primeiroRegistroJButton);
        add(registroAnteriorJButton);
        add(proximoRegistroJButton);
        add(ultimoRegistroJButton);

        add(notificacaoJLabel);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        setSize(500, 200);
        setVisible(true);

        idTextField.setEditable(false);
        idTextField.setToolTipText("Não pode ser mudado!");
        atualizarJButton.setEnabled(false);
        atualizarJButton.setToolTipText("Atualizar cadastro");
        primeiroRegistroJButton.setToolTipText("Primeiro registro");
        registroAnteriorJButton.setToolTipText("Registro anterior");
        proximoRegistroJButton.setToolTipText("Próximo registro");
        ultimoRegistroJButton.setToolTipText("Último registro");
        verJButton.setToolTipText("Pesquisar Registro");
        editarJButton.setToolTipText("Editar Registro");
        novoJButton.setToolTipText("Novo Registro");
        deletarRegistroButton.setToolTipText("Deletar Registro");


        editarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean atualizou = false;
                    if (idTextField.getText().trim().equals("")) {
                        try {
                            atualizou = NavegadorDeRegistro.inserirNovoRegistro("db_teste", "tbl_teste", "nomeTextField", "emailTextField", "senhaPasswordField");
                            novoJButton.setEnabled(true);
                            verJButton.setEnabled(true);
                            editarJButton.setEnabled(false);

                            String[] resultado = NavegadorDeRegistro.ultimoRegistro("db_teste", "tbl_teste");
                            idTextField.setText(resultado[0]);
                            nomeTextField.setText(resultado[1]);
                            strNome = nomeTextField.getText();
                            emailTextField.setText(resultado[2]);
                            strEmail = emailTextField.getText();
                            editarJButton.setEnabled(false);
                            proximoRegistroJButton.setEnabled(false);
                            ultimoRegistroJButton.setEnabled(false);
                            registroAnteriorJButton.setEnabled(true);
                            ultimoRegistroJButton.setEnabled(true);
                            notificacaoJLabel.setText("Cadastro inserido com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Ops! Deu ruim, veja o erro: " + e);
                            notificacaoJLabel.setText("Deu ruim o cadastro...");
                        }
                    } else {
                        try {
                            atualizou = NavegadorDeRegistro.atualizarRegistro("db_teste", "tbl_teste", idTextField.getText(), nomeTextField.getText(), emailTextField.getText(), senhaPasswordField.getPassword());
                            notificacaoJLabel.setText("Cadastro atualizado com sucesso!");
                            editarJButton.setEnabled(false);
                        } catch (Exception e) {
                            System.out.println("Ops! Deu ruim, veja o erro: " + e);
                            notificacaoJLabel.setText("Deu ruim atualizar o cadastro...");
                        }
                    }
                }
            }
        );

        primeiroRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                carregarPrimeiroRegistro();
                novoJButton.setEnabled(true);
            }
        });

        proximoRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String[] resultado;
                try {
                    String idAtual = idTextField.getText();
                    resultado = NavegadorDeRegistro.proximoRegistro("db_teste", "tbl_teste", idAtual);

                    if (resultado != null) {
                        notificacaoJLabel.setText("Próximo registro posicionado com sucesso");
                        idTextField.setText(resultado[0]);
                        nomeTextField.setText(resultado[1]);
                        emailTextField.setText(resultado[2]);
                        senhaPasswordField.setText(resultado[3]);
                        atualizarJButton.setEnabled(false);
                        primeiroRegistroJButton.setEnabled(true);
                        registroAnteriorJButton.setEnabled(true);
                        novoJButton.setEnabled(false);
                    } else {
                        notificacaoJLabel.setText("Nenhum próximo registro encontrado.");
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
                    resultado = NavegadorDeRegistro.registroAnterior("db_teste", "tbl_teste", idAtual);

                    if (resultado != null) {
                        notificacaoJLabel.setText("Registro anterior posicionado com sucesso");
                        idTextField.setText(resultado[0]);
                        nomeTextField.setText(resultado[1]);
                        emailTextField.setText(resultado[2]);
                        senhaPasswordField.setText(resultado[3]);
                        atualizarJButton.setEnabled(false);
                        novoJButton.setEnabled(false);
                    } else {
                        notificacaoJLabel.setText("Nenhum registro anterior encontrado.");
                    }
                } catch (Exception e) {
                    System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o anterior. Veja o erro: " + e);
                }
            }
        });

        ultimoRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String[] resultado;
                try {
                    resultado = NavegadorDeRegistro.ultimoRegistro("db_teste", "tbl_teste");
                    notificacaoJLabel.setText("Último registro posicionado com sucesso");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    atualizarJButton.setEnabled(false);
                    primeiroRegistroJButton.setEnabled(true);
                    proximoRegistroJButton.setEnabled(false);
                    registroAnteriorJButton.setEnabled(true);
                    ultimoRegistroJButton.setEnabled(false);
                    verJButton.setEnabled(true);
                    novoJButton.setEnabled(false);

                } catch (Exception e) {
                    System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
                }
            }
        });

        deletarRegistroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    Connection conexao = MySQLConnector.conectar();
                    String strSqlExcluirRegistro = "delete from `db_teste`.`tbl_teste` where `id` = " + idTextField.getText() + ";";
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

        
        carregarPrimeiroRegistro();
    }

    public void carregarPrimeiroRegistro() {
        try {
            String[] resultado = NavegadorDeRegistro.primeiroRegistro("db_teste", "tbl_teste");

            if (resultado != null) {
                idTextField.setText(resultado[0]);
                nomeTextField.setText(resultado[1]);
                emailTextField.setText(resultado[2]);
                senhaPasswordField.setText(resultado[3]);
                notificacaoJLabel.setText("Primeiro registro carregado com sucesso.");
                primeiroRegistroJButton.setEnabled(false);
                registroAnteriorJButton.setEnabled(false);
                proximoRegistroJButton.setEnabled(true);
                ultimoRegistroJButton.setEnabled(true);
            } else {
                notificacaoJLabel.setText("Nenhum registro encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao carregar o primeiro registro. Veja o erro: " + e);
        }
    

    novoJButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            String[] resultado;
            try {
                resultado = NavegadorDeRegistro.inserirNovoRegistro("db_teste", "tbl_teste", nomeTextField.getText(), emailTextField.getText(), senhaPasswordField.getPassword());
                notificacaoJLabel.setText("Novo registro posicionado com sucesso");
                idTextField.setText("");
                nomeTextField.setText("");
                emailTextField.setText("");
                senhaPasswordField.setText("");
                atualizarJButton.setEnabled(false);
                primeiroRegistroJButton.setEnabled(false);
                proximoRegistroJButton.setEnabled(false);
                registroAnteriorJButton.setEnabled(false);
                ultimoRegistroJButton.setEnabled(false);
                atualizarJButton.setEnabled(true);
                deletarRegistroButton.setEnabled(true);
                editarJButton.setEnabled(false);
                verJButton.setEnabled(false);

                nomeTextField.requestFocus();
            } catch (Exception e) {
                System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
            }
        }
    }
    );
 }
    public static void main(String[] args) {
        EditarCadastro application = new EditarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


