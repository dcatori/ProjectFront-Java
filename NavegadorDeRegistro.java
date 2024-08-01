
import java.sql.*;

public class NavegadorDeRegistro {

    public static String[] primeiroRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlPrimeiroRegistro = "select * from`" + db + "`.`" + tbl + "` order by id;";
        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet rstSqlPrimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlPrimeiroRegistro);
        rstSqlPrimeiroRegistro.next();
        String[] resultado = {
            rstSqlPrimeiroRegistro.getString("id"),
            rstSqlPrimeiroRegistro.getString("nome"),
            rstSqlPrimeiroRegistro.getString("email"),
            rstSqlPrimeiroRegistro.getString("senha"),};

        stmSqlPrimeiroRegistro.close();
        return resultado;
    }

  
    public static String[] pesquisarRegistro(String db, String tbl, String id) throws Exception {
        Connection conexao = null;
        PreparedStatement stmSqlpesquisarRegistro = null;
        ResultSet rstSqlpesquisarRegistro = null;

        try {
            conexao = MySQLConnector.conectar();
            int idPessoa = Integer.parseInt(id);
            String strSqlproximoRegistro = "SELECT * FROM `" + db + "`.`" + tbl + "` WHERE id > ? ORDER BY id ASC LIMIT 1;";
            stmSqlpesquisarRegistro = conexao.prepareStatement(strSqlproximoRegistro);
            stmSqlpesquisarRegistro.setInt(1, idPessoa);
            rstSqlpesquisarRegistro = stmSqlpesquisarRegistro.executeQuery();

            if (rstSqlpesquisarRegistro.next()) {
                String[] resultado = {
                    rstSqlpesquisarRegistro.getString("id"),
                    rstSqlpesquisarRegistro.getString("nome"),
                    rstSqlpesquisarRegistro.getString("email"),
                    rstSqlpesquisarRegistro.getString("senha"),};
                return resultado;
            } else {
                return null;
            }
        } finally {
            if (rstSqlpesquisarRegistro != null) {
                rstSqlpesquisarRegistro.close();
            }
            if (stmSqlpesquisarRegistro != null) {
                stmSqlpesquisarRegistro.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    public static String[] registroAnterior(String db, String tbl, String id) throws Exception {
        Connection conexao = null;
        PreparedStatement stmSqlRegistroAnterior = null;
        ResultSet rstSqlRegistroAnterior = null;

        try {
            conexao = MySQLConnector.conectar();
            int idPessoa = Integer.parseInt(id);

            String strSqlRegistroAnterior = "SELECT * FROM `" + db + "`.`" + tbl + "` WHERE id < ? ORDER BY id DESC LIMIT 1;";
            stmSqlRegistroAnterior = conexao.prepareStatement(strSqlRegistroAnterior);
            stmSqlRegistroAnterior.setInt(1, idPessoa);
            rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery();

            if (rstSqlRegistroAnterior.next()) {
                String[] resultado = {
                    rstSqlRegistroAnterior.getString("id"),
                    rstSqlRegistroAnterior.getString("nome"),
                    rstSqlRegistroAnterior.getString("email"),
                    rstSqlRegistroAnterior.getString("senha")
                };
                return resultado;
            } else {
                return null;
            }
        } finally {
            if (rstSqlRegistroAnterior != null) {
                rstSqlRegistroAnterior.close();
            }
            if (stmSqlRegistroAnterior != null) {
                stmSqlRegistroAnterior.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    
    public static boolean excluirRegistro(String db, String tbl, String id) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlexcluirRegistro = "delete from `db_teste`.`tbl_teste` where `id` = " + id + ";";
            Statement stmSqlexcluirRegistro = conexao.createStatement();
            stmSqlexcluirRegistro.addBatch(strSqlexcluirRegistro);
            stmSqlexcluirRegistro.executeBatch();
            System.out.println(strSqlexcluirRegistro);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
