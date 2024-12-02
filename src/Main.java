import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogadores jogadores = new Jogadores();


        System.out.println("Qual vai ser o saldo bancario inicial dos jogadores: ");
        int saldoInicial = scan.nextInt();

        System.out.println("Você quer montar um tabuleiro personalizado? (s/n)");
        String condicao = scan.next();

        if (condicao.equals("n")){
            tabuleiro.adicionarCasa(1);
            tabuleiro.adicionarCasa(2);
            tabuleiro.adicionarCasa(3);
            tabuleiro.adicionarCasa(4);
            tabuleiro.adicionarCasa(5);
            tabuleiro.adicionarCasa(6);
            tabuleiro.adicionarCasa(7);
            tabuleiro.adicionarCasa(8);
            tabuleiro.adicionarCasa(9);
            tabuleiro.adicionarCasa(10);
        }
        while (true){
            System.out.println("1. Adicionar jogaro\n2. Listar jogadores\n3. Adicionar casa no tabuleiro\n4. Editar casa do tabuleiro" +
                    "\n5. Listar tabuleiro\n6. Iniciar jogo");
            int opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    jogadores.adicionarJogador(saldoInicial);
                    continue;

                case 2:
                    jogadores.listarJoagadores();
                    continue;

                case 3:
                    tabuleiro.adicionarCasa();
                    continue;

                case 4:
                    System.out.println("Qual casa você deseja editar:");
                    int posicao = scan.nextInt();
                    tabuleiro.editar(posicao);
                    continue;

                case 5:
                    tabuleiro.exibir();
                    continue;

                case 6:
                    boolean comecar = true;
                    if (tabuleiro.posicaoAtual < 9){
                        System.out.println("O tabuleiro não tem o número minimo de casas");
                        comecar = false;
                    } else if (tabuleiro.posicaoAtual > 41) {
                        System.out.println("O tabuleiro ultrapassa o número máximo de casas");
                        comecar = false;
                    }
                    if (jogadores.listaJogador.size() <=1){
                        System.out.println("Não tem o minimo de jogadores cadastrados");
                        comecar = false;
                    } else if (jogadores.listaJogador.size() > 10) {
                        System.out.println("O número de jogadores ultrapassa o limite máximo");
                        comecar = false;
                    }
                    if (comecar){
                        Jogar jogar = new Jogar(jogadores, tabuleiro);

                        jogar.iniciarJogo();

                    }
            }
        }













    }
}