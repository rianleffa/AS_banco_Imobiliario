public class Jogador {
    public String nome;
    public int saldoBancario;
    public NoCasa posicaoAtual;

    public Jogador(String nome, int saldoInicial){
        this.nome = nome;
        this.saldoBancario = saldoInicial;
        this.posicaoAtual = null;
    }

}
