import java.util.ArrayList;

public class Cacador extends Personagem {

    @Override
    void realizarAcaoAleatoria(ArrayList<Musica> playlist) {
        //limita o gerador, 1 a 3
        int acao = gerador.nextInt(1, 4);

        switch (acao) {

            case 1:
                cacar();
                break;

            case 2:
                comer();
                break;

            case 3:
                dormir();
                break;
        }
        //independente do que ele fizer, ele vai tentar aprender uma musica
        aprenderMusica(playlist);
    }
    
}