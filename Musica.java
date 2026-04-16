public class Musica {
    private String titulo;

    //cria o aspecto titulo para a musica
    public Musica(String titulo){
        //construtor
        this.titulo = titulo;
    }

    //getter
    public String getTitulo(){
        return titulo;
    }

    //controla como a musica vai ser exibida, com o titulo
    @Override
    public String toString(){
        return titulo;
    }
}
