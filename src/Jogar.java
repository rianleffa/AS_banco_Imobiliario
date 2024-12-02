import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Jogar {
    Scanner scan = new Scanner(System.in);
    public Tabuleiro tabuleiro;
    public List<Jogador> jogadores;
    public int numeroRodadas;
    public Random dado = new Random();
    public int salario;

    public Jogar(Jogadores lista, Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        this.jogadores = lista.listaJogador;
        for (int i = 0; i < lista.tamanhoLista(); i++) {
            jogadores.get(i).posicaoAtual = tabuleiro.inicio;
        }
        System.out.println("Qual vai ser o número de rodadeas limite: ");
        numeroRodadas = scan.nextInt();

        System.out.println("Qual vai ser o salario dos jogadores: ");
        salario = scan.nextInt();
    }

    //sorteia umm número aleatório, que é o número de casas que o jogador vai andar
    public int rolarDado(){
        return dado.nextInt(7);
    }

    //avançar casas no tabuleiro
    private void avancarTabuleiro(Jogador jogador, int numeroCasas){
        System.out.println("vez do "+ jogador.nome );
        System.out.println("Você vai andar "+ numeroCasas+ " casas");
        for (int i = 0; i < numeroCasas; i++) {
            jogador.posicaoAtual = jogador.posicaoAtual.proximo;
            if (jogador.posicaoAtual == tabuleiro.inicio){
                jogador.saldoBancario += salario;
                System.out.println("Você passou pela casa inicio e recebeu o seu salário");
            }
        }

        if (jogador.posicaoAtual.preco == 0 ){
            switch (jogador.posicaoAtual.nome){
                case "Imposto":
                    jogador.saldoBancario -= (jogador.saldoBancario/100) * 5;
                    System.out.println(jogador.nome + " pagou R$" + (jogador.saldoBancario/100) * 5 + " de imposto");
                    break;
                case "Restituição":
                    jogador.saldoBancario += (salario/100) *10;
                    System.out.println(jogador.nome + " recebeu R$"+ (salario/100) * 10 + " de restituição");
                    break;
            }
        } else if (jogador.posicaoAtual.situacao.equals("disponivel")) {
            System.out.println(jogador.posicaoAtual.nome + " está disponivel para compra\nVocê deseja comprar por R$"+ jogador.posicaoAtual.preco+"  (s/n)");
            String decisao = scan.next();
            if (decisao.equals("s")){
                if (jogador.saldoBancario < jogador.posicaoAtual.preco){
                    System.out.println("Você não tem dinheiro para comprar esse imóvel");
                }else {
                    jogador.saldoBancario -= jogador.posicaoAtual.preco;
                    jogador.posicaoAtual.dono = jogador;
                    jogador.posicaoAtual.situacao = "vendido";
                    System.out.println("Parabéns pela compra");
                }
            }
        }else {
            jogador.saldoBancario -= jogador.posicaoAtual.aluguel;
            jogador.posicaoAtual.dono.saldoBancario += jogador.posicaoAtual.aluguel;
            System.out.println("Você pagou R$"+ jogador.posicaoAtual.aluguel +" de aluguel para o/a" + jogador.posicaoAtual.dono.nome);
        }
        System.out.println("O jogador "+ jogador.nome +" tem R$"+ jogador.saldoBancario);
    }

    //onde o jogo acontece
    public void iniciarJogo(){
        for (int i = 0; i < numeroRodadas; i++) {
            System.out.println("Rodada " + i);

            for (int j = 0; j < jogadores.size(); j++) {

                avancarTabuleiro( jogadores.get(j),rolarDado());
                if(verificarFalido(jogadores.get(j))){
                    System.out.println("O jogador " + jogadores.get(j).nome+ " faliu e está fora do jogo");
                    jogadores.remove(j);
                }

                if (verificarFim()){
                    System.out.println("O jogador " + jogadores.get(0)+ " venceu");
                    break;
                }
                scan.next();

                clear();
            }
            if (verificarFim()){
                break;
            }

            posicaoFinal();
        }
    }

    //verifica se o jogador está falido
    public boolean verificarFalido(Jogador jogador){
        return jogador.saldoBancario <=0;

    }

    //verifica se resta apenas um jogador no jogo
    public boolean verificarFim(){
        return jogadores.size() == 1;
    }

    //ordena os jogadores por saldo bancario
    public void posicaoFinal(){
        jogadores.sort((p1, p2) -> Integer.compare(p2.saldoBancario, p1.saldoBancario));

        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println(i+1 + ". "+ jogadores.get(i).nome + " saldo R$"+ jogadores.get(i).saldoBancario );
        }
    }


//"limpa" o terminal
    private void clear(){
        for (int i = 0; i < 50; i++) { // Imprime 50 linhas em branco
            System.out.println();
        }
    }

}
