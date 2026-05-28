import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String usuario = "postgres";
    private static String senha = "123456";
    private static String host = "localhost";
    private static String port = "5432";
    private static String db = "jogo_db";

    //Método que cria e devolve uma conexão.
    public static Connection obterConexao(){

        try{
            //força o Java a carregar o driver JDBC do PostgreSQL, estava dando erro de carregamento
            Class.forName("org.postgresql.Driver");
            //string de conexão
            var s = String.format(
                    "jdbc:postgresql://%s:%s/%s",
                    host, port, db
            );

            Connection conexao =
                    DriverManager.getConnection( //tenta conectar ao postgresql
                            s, usuario, senha
                    );
            return conexao;

        } catch(Exception e){ //tratamento de erros
            e.printStackTrace(); //mostra o tipo de erro no terminal
            return null;
        }
    }
}