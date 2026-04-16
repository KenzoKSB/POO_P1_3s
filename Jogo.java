import java.util.Random;
import java.util.ArrayList;

public class Jogo {
    public static void main(String[] args) throws InterruptedException {

        //cria o sujeito da classe personagem
        Personagem p1 = new Personagem();
        p1.nome = "Michel";

        //cria o segundo personagem
        Personagem p2 = new Personagem(3, 8, 8);
        p2.nome = "Tico Trovador";
        //nasce já sabendo uma música própria
        p2.repertorio.add(new Musica("Aerials Trovador"));

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

        //verifica sempre se já tem um campeão
        boolean campeao = false;

        //começa o loop
        while(true){

            if(p1.segueVivo()){
    
                //limita o gerador
                int acao = gerador.nextInt(1, 4); 

                switch(acao){

                    case 1:
                        p1.cacar();
                        break;

                    case 2:
                        p1.comer();
                        break;

                    case 3:
                        p1.dormir();
                        break;
                    }
                    //independente do que ele fizer, ele vai tentar aprender uma musica
                    p1.aprenderMusica(musicas);
                }

                //o controlador das ações do Tico
                if(p2.segueVivo()){
                    int chance = gerador.nextInt(1, 11);

                    switch(chance){
                        case 1, 2:
                            p2.cacar();
                            break;

                        case 3, 4:
                            p2.comer();
                            break;

                        case 5, 6, 7, 8, 9, 10:
                            p2.dormir();
                            break;
                    }

                p2.aprenderMusica(musicas);
            }

            //printa os aspectos e a mochila do personagem
            System.out.println(p1);
            System.out.println(p2);

            //sorteia quem chamará o duelo
            if(p1.segueVivo() && p2.segueVivo()){
                int quem = gerador.nextInt(2);

                if(quem == 0){
                    p1.duelar(p2);
                } 
                else{
                    p2.duelar(p1);
                }
            }

            //controla a morte do Michel e a vitória de Tico
            if(p1.segueVivo() == false && !campeao){
                System.out.println(p1.nome + " morreu!");
                System.out.println(p2.nome + " é o vencedor!");
                campeao = true;
            }

            //controla a morte de Tico e a vitória do Michel
            if(p2.segueVivo() == false && !campeao){
                System.out.println(p2.nome + " morreu!");
                System.out.println(p1.nome + " é o vencedor!");
                campeao = true;
            }

            //mostra status pós duelo
            System.out.println("-=-=-=-=-=-POS DUELO-=-=-=-=");
            System.out.println(p1);
            System.out.println(p2);

            //fica verificando se o personagem t[a vivo no loop
            if(!p1.segueVivo() && p2.segueVivo()){
                //se morreu, vai anunciar sua morte e mostrar seu inventario final
                System.out.println("***OS PERSONAGENS MORRERAM***");
                System.out.println("Inventario final do Michel: " + p1.mochila);
                System.out.println("Repertorio final do Michel: " + p1.repertorio); //novo print de morte, exibindo a lista de musicas
                //os prints da morte do segundo personagem
                System.out.println("Inventario final do Tico Trovador: " + p2.mochila);
                System.out.println("Repertorio final do Tico Trovador: " + p2.repertorio);
                break; // encerra o loop
            }

            System.out.println("**********************");
            Thread.sleep(5000);
        }
    }
}