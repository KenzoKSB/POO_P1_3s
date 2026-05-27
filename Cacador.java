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
    
    @Override
    void duelar(Personagem adversario){
        //se a mochila de quem começou o duelo estiver vazia, cancela o duelo
        if(mochila.size() == 0){
            System.out.println(nome + " não possui itens para duelar");
            return;
        }
        //se não, escolhe um item aleatorio do repertorio para o duelo
        String item = mochila.get(gerador.nextInt(mochila.size()));
        System.out.println(nome + " duelou usando: " + item);

        //se o adversario tiver, os dois perdem energia
        if(adversario.mochila.contains(item)){
            System.out.println("O adversario ja possui esse item!");
            energia--;
            adversario.energia--;
        } 
        else{ //se não, apenas o adversário perde, mas ganha um item novo
            System.out.println(adversario.nome + " perdeu o duelo e ganhou o item!");
            adversario.energia--;
            mochila.remove(item);
            adversario.mochila.add(item);
        }
    }
}