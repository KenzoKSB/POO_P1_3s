import java.util.ArrayList;

public class Bardo extends Personagem {

    Bardo(int energia, int fome, int sono) {
        super(energia, fome, sono);
    }

    @Override
    void realizarAcaoAleatoria(ArrayList<Musica> playlist) {
        //limita o gerador, 1 a 11
        int chance = gerador.nextInt(1, 11);

        switch (chance) {
            case 1, 2:
                cacar();
                break;

            case 3, 4:
                comer();
                break;

            case 5, 6, 7, 8, 9, 10:
                dormir();
                break;
        }
        // sempre tenta aprender música
        aprenderMusica(playlist);
    }
    
}