import java.util.Random;
import java.util.ArrayList;

public class Jogo {
    public static void main(String[] args) throws InterruptedException {

        //cria o sujeito da classe personagem
        Personagem p = new Personagem();
        p.nome = "Michel";

        //cria gerador para o switch case
        Random gerador = new Random();

        //cria a lista das musicas
        ArrayList<Musica> musicas = new ArrayList<>();
        //os elementos da lista de musica
        musicas.add(new Musica("Jeremy"));
        musicas.add(new Musica("Stairway to Heaven"));
        musicas.add(new Musica("Numb"));
        musicas.add(new Musica("Dream On"));
        musicas.add(new Musica("Black"));
        musicas.add(new Musica("Smells Like Teen Spirit"));
        musicas.add(new Musica("Californication"));
        musicas.add(new Musica("In the End"));
        musicas.add(new Musica("Highway to Hell"));
        musicas.add(new Musica("Fear of the Dark"));

        //começa o loop
        while(true){
    
        //limita o gerador
        int acao = gerador.nextInt(1, 4); 

        switch(acao){

            case 1:
                p.cacar();
                break;

            case 2:
                p.comer();
                break;

            case 3:
                p.dormir();
                break;
            }
            //independente do que ele fizer, ele vai tentar aprender uma musica
            p.aprenderMusica(musicas);

            //printa os aspectos e a mochila do personagem
            System.out.println(p);

            //fica verificando se o personagem t[a vivo no loop
            if(!p.segueVivo()){
                //se morreu, vai anunciar sua morte e mostrar seu inventario final
                System.out.println("***O PERSONAGEM MORREU***");
                System.out.println("Inventario final: " + p.mochila);
                System.out.println("Repertorio final: " + p.repertorio); //novo print de morte, exibindo a lista de musicas
                break; // encerra o loop
            }

            System.out.println("**********************");
            Thread.sleep(5000);
        }
    }
}