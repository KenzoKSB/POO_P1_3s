import java.util.Random;
import java.util.ArrayList;

public class Jogo {
    public static void main(String[] args) throws Exception {

        //cria o sujeito da classe personagem
        Personagem p1 = new Cacador();
        p1.nome = "Michel";

        //cria o segundo personagem
        Personagem p2 = new Bardo(3, 8, 8);
        p2.nome = "Tico Trovador";
        //nasce já sabendo uma música própria
        p2.repertorio.add(new Musica("Aerials Trovador"));

        //cria gerador para o switch case
        Random gerador = new Random();

        MusicaDAO dao = new MusicaDAO(); //chama a classe responsavel pelo SGBD
        ArrayList<Musica> musicas = dao.listar();

        //verifica sempre se já tem um campeão
        boolean campeao = false;

        //começa o loop
        while(true){

            if (p1.segueVivo()) {
                p1.realizarAcaoAleatoria(musicas); //realiza o metodo sem saber o tipo de personagem
            }

            if (p2.segueVivo()) {
                p2.realizarAcaoAleatoria(musicas); //agora com o bardo
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
            if(!p1.segueVivo() && !p2.segueVivo()){
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