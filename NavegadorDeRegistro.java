
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

    public static String[] proximoRegistro(String db, String tbl, String id) throws Exception {
        Connection conexao = null;
        PreparedStatement stmSqlproximoRegistro = null;
        ResultSet rstSqlproximoRegistro = null;

        try {
            conexao = MySQLConnector.conectar();
            int idPessoa = Integer.parseInt(id);
            String strSqlproximoRegistro = "SELECT * FROM `" + db + "`.`" + tbl + "` WHERE id > ? ORDER BY id ASC LIMIT 1;";
            stmSqlproximoRegistro = conexao.prepareStatement(strSqlproximoRegistro);
            stmSqlproximoRegistro.setInt(1, idPessoa);
            rstSqlproximoRegistro = stmSqlproximoRegistro.executeQuery();

            if (rstSqlproximoRegistro.next()) {
                String[] resultado = {
                    rstSqlproximoRegistro.getString("id"),
                    rstSqlproximoRegistro.getString("nome"),
                    rstSqlproximoRegistro.getString("email"),
                    rstSqlproximoRegistro.getString("senha"),};
                return resultado;
            } else {
                return null;
            }
        } finally {
            if (rstSqlproximoRegistro != null) {
                rstSqlproximoRegistro.close();
            }
            if (stmSqlproximoRegistro != null) {
                stmSqlproximoRegistro.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    public static String[] ultimoRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlUltimoRegistro = "select * from`" + db + "`.`" + tbl + "`ORDER BY id DESC LIMIT 1;";
        Statement stmSqlUltimoRegistro = conexao.createStatement();
        ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
        rstSqlUltimoRegistro.next();
        String[] resultado = {
            rstSqlUltimoRegistro.getString("id"),
            rstSqlUltimoRegistro.getString("nome"),
            rstSqlUltimoRegistro.getString("email"),
            rstSqlUltimoRegistro.getString("senha"),};

        stmSqlUltimoRegistro.close();
        return resultado;
    }

    public static String[] deletarRegistro(String db, String tbl, String id) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlexcluirRegistro = "delete from `db_teste`.`tbl_teste` where `id` = " + id + ";";
            Statement stmSqlexcluirRegistro = conexao.createStatement();
            stmSqlexcluirRegistro.addBatch(strSqlexcluirRegistro);
            stmSqlexcluirRegistro.executeBatch();
            stmSqlexcluirRegistro.close();
            
            String strSqlProximoRegistro = "select * from `" + db + "`.`" + tbl + "`  where `id` >= " + id + ";";
            Statement stmSqlProximoRegistro = conexao.createStatement();
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            rstSqlProximoRegistro.next();
            String[] resultado = {
                rstSqlProximoRegistro.getString("id"),
                rstSqlProximoRegistro.getString("nome"),
                rstSqlProximoRegistro.getString("email")
            };
            stmSqlProximoRegistro.close();
            return resultado;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static boolean atualizarRegistro(String db, String tbl, String id, String nome, String email, char[] senha) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlUltimoRegistro = "update `" + db + "`.`" + tbl + "` set `nome` = '" + nome + "', `email` = '" + email + "', `senha` = '" + String.valueOf(senha) + "' where `id` = " + id + ";";
            Statement stmSqlUltimoRegistro = conexao.createStatement();
            stmSqlUltimoRegistro.addBatch(strSqlUltimoRegistro);
            stmSqlUltimoRegistro.executeBatch();
            stmSqlUltimoRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    public static boolean cadastrarRegistro(String db, String tbl, String nome, String email, char[] senha) throws Exception {
       try {
        Connection conexao = MySQLConnector.conectar();
        String strSqlCadastrarRegistro = "insert into `" + db + "`.`" + tbl + "` (`nome`,`email`,`senha`) values ('" + nome + "','" + email + "','" + String.valueOf(senha) +"');";
        Statement stmSqlCadastrarRegistro = conexao.createStatement();
        stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
        stmSqlCadastrarRegistro.executeBatch();
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao inserir novo registro: " + e.getMessage());
        return false;
    }
}

}
