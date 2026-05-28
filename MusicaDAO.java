import java.sql.ResultSet;
import java.util.ArrayList;

public class MusicaDAO { //classe responsavel para acessar o banco de dados

    public ArrayList<Musica> listar() throws Exception{

        ArrayList<Musica> musicas = new ArrayList<>();
        //Definir o comando SQL
        var sql = "SELECT * FROM tb_musica"; //envia comando ao postgresql

        try(
            //Estabelecer uma conexão com O SGBD
            var conexao = ConnectionFactory.obterConexao(); 
            //Preparar o comando
            var ps = conexao.prepareStatement(sql); //objeto que executa SQL no banco.
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                var titulo = rs.getString("titulo");
                Musica musica = new Musica(titulo);
                musicas.add(musica);
            }
        }
        return musicas;
    }
}