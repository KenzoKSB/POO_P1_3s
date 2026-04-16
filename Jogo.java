import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws InterruptedException {

        //cria o sujeito da classe personagem
        Personagem p = new Personagem();
        p.nome = "Michel";

        //cria gerador para o switch case
        Random gerador = new Random();

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

            //printa os aspectos e a mochila do personagem
            System.out.println(p);
            System.out.println("**********************");
            Thread.sleep(5000);
        }
    }
}