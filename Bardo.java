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
    
    @Override
    void duelar(Personagem adversario){
        //se o repertorio de quem começou o duelo for vazio, cancela o duelo
        if(repertorio.size() == 0){
             System.out.println(nome + " não tem musicas para duelar");
             return;
        }
        //se não, escolhe uma musica aleatoria do repertorio para o duelo
        Musica musica = repertorio.get(gerador.nextInt(repertorio.size()));
        System.out.println(nome + " iniciou um duelo musical: " + musica);

        //se o adversario conhecer, os dois perdem energia
        if(adversario.repertorio.contains(musica)){
            System.out.println("Ambos conhecem essa musica!");
            energia--;
            adversario.energia--;
        } 
        else{ 
            System.out.println(adversario.nome + " não conhece essa musica, foi derrotado!");
            adversario.energia--;
            adversario.repertorio.add(musica);
        }
    }
}