public class Tabuleiro {
    public NoCasa inicio;
    public NoCasa fim;
    public int posicaoAtual;


    public Tabuleiro() {
        NoCasa primeiraCasa = new NoCasa("inicio");
        this.inicio = primeiraCasa;
        inicio.situacao = "inicio";
        fim = primeiraCasa;
        posicaoAtual = 1;
    }

//    adicionandp nova casa ao tabuleiro
    public void adicionarCasa() {
        NoCasa novoNo = new NoCasa();
        novoNo.posicao = posicaoAtual;
        posicaoAtual++;
        fim.proximo = novoNo;
        fim = novoNo;
        fim.proximo = inicio;
    }

    //metodo para adicionar casas automaticamento
    public void adicionarCasa(int valor) {
        NoCasa novoNo = new NoCasa(valor);
        novoNo.posicao = posicaoAtual;
        posicaoAtual++;
        fim.proximo = novoNo;
        fim = novoNo;
        fim.proximo = inicio;
    }

    //exibir casas do tabuleiro
    public void exibir() {
        if (inicio == null) {
            System.out.println("lista vazia");
            return;
        }
        int x = 0;
        NoCasa atual = inicio;
        if (atual.proximo == null) {
            System.out.println(atual.nome);
        } else {
            do {
                x++;
                System.out.println(x + ". " + atual.nome);
                atual = atual.proximo;
            }
            while (atual != inicio);
        }
    }

    //remover casa do tabuleiro
    public void removerPorPosicao(int posicao) {
        NoCasa posicaoAtual = inicio;
        NoCasa noAnterior = null;

        if (inicio.proximo == null) {
            System.out.println("A lista está vázia");
            return;
        }
        if (posicao == 1) {
            System.out.println("A casa inicio não pode ser removida");
            return;
        } else {
            for (int i = 2; i <= posicao - 1; i++) {
                noAnterior = posicaoAtual;

                posicaoAtual = posicaoAtual.proximo;
            }
            if (posicaoAtual == fim) {
                fim = noAnterior;
                fim.proximo = inicio;
                System.out.println("elemento da lista removido");
            } else {
                noAnterior.proximo = posicaoAtual.proximo;

            }
        }

    }

//trocar algum imóvel de alguma casa
    public void editar(int posicao) {
        NoCasa posicaoAtual = inicio;
        if (inicio.proximo == null) {
            System.out.println("A lista está vázia");
            return;
        }
        if (posicao == 1) {
            System.out.println("A casa inicio não pode ser alterada");
            return;
        } else {
            for (int i = 2; i <= posicao - 1; i++) {
                posicaoAtual = posicaoAtual.proximo;
            }
            if (posicaoAtual == inicio) {
                System.out.println("A casa inicio não pode ser alterada");
                return;
            } else {
                NoCasa proximo =  posicaoAtual.proximo;
                posicaoAtual.alterarImovel();
                posicaoAtual.proximo = proximo;
            }
        }
    }
}
