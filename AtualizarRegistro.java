import java.sql.*;
public class AtualizarRegistro {

    public static void main(String[] args) {
        
        try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlAtualizarRegistro = "update `db_teste`.`tbl_teste` set `email` = 'tortinho@hotmail.com' where `id` = 4"; 
            Statement stmSqlAtualizarRegistro = conexao.createStatement();
            
            //ResultSet resultado = stmSqlCriarBancoDeDados.executeQuery(strSqlCriarBandoDeDados);

            stmSqlAtualizarRegistro.addBatch(strSqlAtualizarRegistro);
            stmSqlAtualizarRegistro.executeBatch();
            stmSqlAtualizarRegistro.close();
            System.out.println("Registro atualizado com sucesso!");
        }catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        }
    }
}