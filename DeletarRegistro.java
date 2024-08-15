import java.sql.*;
public class DeletarRegistro {

    public static void main(String[] args) {
        
        try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlDeletarRegistro = "delete from `db_teste`.`tbl_teste` where `id` = '4';";
            Statement stmSqlDeletarRegistro = conexao.createStatement();
            
            //ResultSet resultado = stmSqlCriarBancoDeDados.executeQuery(strSqlCriarBandoDeDados);

            stmSqlDeletarRegistro.addBatch(strSqlDeletarRegistro);
            stmSqlDeletarRegistro.executeBatch();
            stmSqlDeletarRegistro.close();
            System.out.println("Registro deletado com sucesso!");
        }catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        }
    }
}