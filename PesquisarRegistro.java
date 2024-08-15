import java.sql.*;;

public class PesquisarRegistro {

    public static void main(String[] args) {
        
        try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisarRegistro = "select * from `db_teste`.`tbl_teste` where `nome` = 'Teste';";
            Statement stmSqlPesquisarRegistro = conexao.createStatement();
            ResultSet resultado = stmSqlPesquisarRegistro.executeQuery(strSqlPesquisarRegistro);
            while (resultado.next()) {
                System.out.println(resultado.getString("email"));
            }
            System.out.println("Pesquisa realizada com sucesso!");
        }catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        }
    }

}
