import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Jogadores {
    Scanner scan = new Scanner(System.in);
    ArrayList<Jogador> listaJogador;
    Random dado = new Random();

    public Jogadores(){
        listaJogador = new ArrayList<>();
    }

//    adicionar novo jogador
    public void adicionarJogador(int saldoInicial){
        System.out.println("Digite o nome do jogador ");
        String nomeJogador = scan.next();

        Jogador novoJogador = new Jogador(nomeJogador, saldoInicial);
        int tamanho = tamanhoLista();
        if (tamanho >= 6 ){
            System.out.println("A lista já etá cheia");
            return;
        }
        listaJogador.add(novoJogador);
    }

//    listar jogadores
    public void listarJoagadores(){
        for (int i = 0; i < tamanhoLista(); i++) {
            System.out.println(listaJogador.get(i).nome);
        }
    }


    public int tamanhoLista(){
        return listaJogador.size();
    }



}
