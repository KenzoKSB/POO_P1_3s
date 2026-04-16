import java.util.ArrayList;
import java.util.Random;

public class Personagem {
    String nome;
    private int energia;
    private int fome;
    private int sono;
    ArrayList<String> mochila = new ArrayList<>();
   
    //padrão dos aspectos pra um personagem
    Personagem(){
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
    }

    Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }


    //controla tudo da função de caçar
    void cacar(){
        if(energia >= 2){
            //se ele tiver energia, ele consegue caçar e gasta 2 de energia
            System.out.printf("%s caçando\n", nome);
            energia -= 2;
            
            //em caso de sucesso, item para a mochila
            String[] itens = {"pena", "couro", "osso", "presa", "garra"};
            Random gerador = new Random();
            String item = itens[gerador.nextInt(itens.length)];
            mochila.add(item);
        
        }
        else{
            //sem energia, não caça
            System.out.printf("%s sem energia para caçar\n", nome);
        }
        
        //tentou caçar de qualquer jeito, então fica com mais sono e fome
        // fome +=1 fome++ ++fome
        if (fome < 10) fome = fome + 1;
        // sono = sono + 1 > 10 ? sono : sono + 1;
        sono = sono == 10 ? sono : sono + 1;
    }

    //controla tudo na função comer
    //método comer
    void comer(){
        if(fome >= 1){
            //se tiver fome, come, diminui a fome e aumenta a energia
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        }
        else{
            //se não tiver fome, não come
            System.out.println(nome + " sem fome");
        }
    }

    //controla tudo da função dormir
    //método dormir
    void dormir(){
        if(sono >= 1){
            //se ele tiver com sono, dorme, diminuindo o sono e ganhando energia
            System.out.print(nome + " dormindo\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        }
        else{
            //se não tiver sono, não dorme
            System.out.println(nome + " sem sono");
        }
    }

    //controla a impressão dos status do personagem e da mochila dele, agora com a musica incluida
    public String toString(){  
        return String.format(
            "%s: e:%d, f:%d, s:%d, mochila:%s",
            nome, energia, fome, sono, mochila);
    }

    //usa o boolean pra ter uma resposta binaria pra saber se o personagem continua vivo
    boolean vivo = true;  
    boolean segueVivo(){
    return energia > 0;
    }
}
