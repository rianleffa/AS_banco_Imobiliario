import java.util.Scanner;
public class NoCasa {
    public String nome;
    public int preco;
    public int aluguel;
    public NoCasa proximo;
    public String situacao;
    public Jogador dono;
    public int posicao;


    Scanner scan = new Scanner(System.in);

    //cadastrar casa inicio
    public NoCasa(String nome){
        this.nome = "inicio";
        preco = 0;
        aluguel = 0;
        proximo = null;
        situacao = null;
        dono = null;
        posicao = 0;
    }

    //cadastrar nova casa no tabuleiro
    public NoCasa(){
        System.out.println("Escolha um imóvel para colocar nessa casa");
        System.out.println("Lista imóveis:" );
        System.out.println("1. Casa do Bosque\n" + "2. Apartamento Central\n" + "3. Vila das Flores\n" + "4.Pousada da Praia\n" + "5. Mansão da Colina\n" + "6. Residência do Lago\n" + "7. Cobertura Diamante\n" + "8. Edifício Horizonte\n" + "9. Imposto\n"+ "10. Restituição");
        int imovel=  scan.nextInt();

        clear();
        switch (imovel){
            case 1:
                nome = "Casa do Bosque";
                preco = 200000;
                aluguel = 1100;
                situacao = "disponivel";
                break;

            case 2:
                nome = "Apartamento Central";
                preco = 350000;
                aluguel = 1800;
                situacao = "disponivel";
                break;

            case 3:
                nome = "Vila das Flores";
                preco = 400000;
                aluguel = 2200;
                situacao = "disponivel";
                break;

            case 4:
                nome = "Pousada da Praia";
                preco = 500000;
                aluguel = 2700;
                situacao = "disponivel";
                break;

            case 5:
                nome = "Mansão da Colina";
                preco = 600000;
                aluguel = 3300;
                situacao = "disponivel";
                break;

            case 6:
                nome = "Residência do Lago";
                preco = 450000;
                aluguel = 2500;
                situacao = "disponivel";
                break;

            case 7:
                nome = "Cobertura Diamante";
                preco = 700000;
                aluguel = 3700;
                situacao = "disponivel";
                break;

            case 8:
                nome = "Edifício Horizonte";
                preco = 550000;
                aluguel = 2900;
                situacao = "disponivel";
                break;

            case 9:
                nome = "Imposto";
                preco = 0;
                aluguel = 0;
                break;

            case 10:
                nome = "Restituição";
                preco = 0;
                aluguel = 0;
                break;
        }
        System.out.println("imóvel " + nome +" adicionado ao local");
        proximo = null;
    }

    //cadastro de casas automatico
    public NoCasa(int numero) {

        int imovel = numero;

        switch (imovel){
            case 1:
                nome = "Casa do Bosque";
                preco = 200000;
                aluguel = 1100;
                situacao = "disponivel";
                break;

            case 2:
                nome = "Apartamento Central";
                preco = 350000;
                aluguel = 1800;
                situacao = "disponivel";
                break;

            case 3:
                nome = "Vila das Flores";
                preco = 400000;
                aluguel = 2200;
                situacao = "disponivel";
                break;

            case 4:
                nome = "Pousada da Praia";
                preco = 500000;
                aluguel = 2700;
                situacao = "disponivel";
                break;

            case 5:
                nome = "Mansão da Colina";
                preco = 600000;
                aluguel = 3300;
                situacao = "disponivel";
                break;

            case 6:
                nome = "Residência do Lago";
                preco = 450000;
                aluguel = 2500;
                situacao = "disponivel";
                break;

            case 7:
                nome = "Cobertura Diamante";
                preco = 700000;
                aluguel = 3700;
                situacao = "disponivel";
                break;

            case 8:
                nome = "Edifício Horizonte";
                preco = 550000;
                aluguel = 2900;
                situacao = "disponivel";
                break;

            case 9:
                nome = "Imposto";
                preco = 0;
                aluguel = 0;
                situacao = "imposto";

                break;

            case 10:
                nome = "Restituição";
                preco = 0;
                aluguel = 0;
                situacao = "restituição";

                break;
        }
        System.out.println("imóvel " + nome + " adicionado ao local");
        proximo = null;
    }

    //alterar o imóvel de alguma casa
    public void alterarImovel(){
        System.out.println("Escolha um imóvel para colocar nessa casa");
        System.out.println("Lista imóveis:" );
        System.out.println("1. Casa do Bosque\n" + "2. Apartamento Central\n" + "3. Vila das Flores\n" + "4.Pousada da Praia\n" + "5. Mansão da Colina\n" + "6. Residência do Lago\n" + "7. Cobertura Diamante\n" + "8. Edifício Horizonte\n" + "9. Imposto\n"+ "10. Restituição");
        int imovel=  scan.nextInt();

        clear();
        switch (imovel){
            case 1:
                nome = "Casa do Bosque";
                preco = 200000;
                aluguel = 1100;
                situacao = "disponivel";
                break;

            case 2:
                nome = "Apartamento Central";
                preco = 350000;
                aluguel = 1800;
                situacao = "disponivel";
                break;

            case 3:
                nome = "Vila das Flores";
                preco = 400000;
                aluguel = 2200;
                situacao = "disponivel";
                break;

            case 4:
                nome = "Pousada da Praia";
                preco = 500000;
                aluguel = 2700;
                situacao = "disponivel";
                break;

            case 5:
                nome = "Mansão da Colina";
                preco = 600000;
                aluguel = 3300;
                situacao = "disponivel";
                break;

            case 6:
                nome = "Residência do Lago";
                preco = 450000;
                aluguel = 2500;
                situacao = "disponivel";
                break;

            case 7:
                nome = "Cobertura Diamante";
                preco = 700000;
                aluguel = 3700;
                situacao = "disponivel";
                break;

            case 8:
                nome = "Edifício Horizonte";
                preco = 550000;
                aluguel = 2900;
                situacao = "disponivel";
                break;

            case 9:
                nome = "imposto";
                preco = 0;
                aluguel = 0;
                situacao = "imposto";
                break;

            case 10:
                nome = "Restituição";
                preco = 0;
                aluguel = 0;
                situacao = "restituição";
                break;
        }
        System.out.println("imóvel " + nome +" adicionado ao local");
        proximo = null;
    }

    //função para "limpar terminal" dando varios enter
    private void clear(){
        for (int i = 0; i < 50; i++) { // Imprime 50 linhas em branco
            System.out.println();
        }
    }

}
