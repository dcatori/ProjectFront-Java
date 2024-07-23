import java.sql.*;;
public class InserirRegistro {

    public static void main(String[] args) {
        
        try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlInserirRegistro = "insert into `db_teste`.`tbl_teste` (`nome`, `email`, `senha`) values ('Teste', 'teste@gmail.com', 'senhaTeste');";
            Statement stmSqlInserirRegistro = conexao.createStatement();
            
            //ResultSet resultado = stmSqlCriarBancoDeDados.executeQuery(strSqlCriarBandoDeDados);

            stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
            stmSqlInserirRegistro.executeBatch();
            stmSqlInserirRegistro.close();
            System.out.println("Registro inserido com sucesso!");
        }catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        }
    }

}
