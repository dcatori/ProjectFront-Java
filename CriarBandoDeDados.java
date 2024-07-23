import java.sql.*;;
public class CriarBandoDeDados {

    public static void main(String[] args) {
        
        try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlCriarBandoDeDados = "create database `db_teste`;";
            Statement stmSqlCriarBancoDeDados = conexao.createStatement();
            
            //ResultSet resultado = stmSqlCriarBancoDeDados.executeQuery(strSqlCriarBandoDeDados);

            stmSqlCriarBancoDeDados.addBatch(strSqlCriarBandoDeDados);
            stmSqlCriarBancoDeDados.executeBatch();

            stmSqlCriarBancoDeDados.close();
            System.out.println("Banco de dados criado com sucesso!");
        }catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        }
    }

}
