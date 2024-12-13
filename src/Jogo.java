import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Exibindo a mensagem de boas-vindas e explicação das regras
        mostrarBoasVindas();

        boolean continuarJogando = true;

        while (continuarJogando) {
            int pontosTotais = 0;
            int rodada = 1;

            int nivel = selecionarNivel(scanner);
            for (int i = 0; i < 3; i++) {
                System.out.println("Rodada " + (rodada++) + " de 3.");
                pontosTotais += jogarRodada(scanner, random, nivel);
            }

            System.out.println("Pontuação total após as rodadas: " + pontosTotais);
            continuarJogando = perguntarProximoPasso(scanner);
        }

        System.out.println("Obrigado por jogar, volte sempre!");
    }

    // Função para exibir a mensagem de boas-vindas e as regras do jogo
    public static void mostrarBoasVindas() {
        System.out.println("Bem-vindo ao Jogo da Adivinhação!");
        System.out.println("Neste jogo, o sistema vai sortear um número aleatório, e o objetivo é adivinhar qual é o número.");
        System.out.println("Você tem 3 tentativas por rodada para tentar acertar.");
        System.out.println("Você ganha pontos da seguinte forma:");
        System.out.println("- Se acertar o número, ganha 10 pontos.");
        System.out.println("- Se o seu palpite estiver 1 unidade acima ou abaixo do número sorteado, ganha 5 pontos.");
        System.out.println("- Se errar, não ganha pontos.");
        System.out.println("Escolha um nível de dificuldade e comece a jogar!");
        System.out.println("Vamos lá!\n");
    }

    // Função para selecionar o nível de dificuldade
    public static int selecionarNivel(Scanner scanner) {
        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1. Fácil (1 a 10)");
        System.out.println("2. Médio (1 a 50)");

        int nivel = scanner.nextInt();
        while (nivel < 1 || nivel > 2) {
            System.out.println("Escolha inválida. Tente novamente.");
            nivel = scanner.nextInt();
        }

        return nivel;
    }

    // Função para jogar uma rodada
    public static int jogarRodada(Scanner scanner, Random random, int nivel) {
        int numeroSorteado = sortearNumero(random, nivel);
        int pontos = 0;

        System.out.println("Tente adivinhar o número sorteado!");
        System.out.println("Dica: Digite o número e tecle Enter.");

        int palpite = scanner.nextInt();

        if (palpite == numeroSorteado) {
            System.out.println("Parabéns! Você acertou! Você ganhou 10 pontos.");
            pontos = 10;
        } else if (palpite == numeroSorteado - 1 || palpite == numeroSorteado + 1) {
            System.out.println("Quase lá! Você ganhou 5 pontos.");
            pontos = 5;
        } else {
            System.out.println("Errou! Nenhum ponto.");
        }

        System.out.println("Número sorteado era: " + numeroSorteado);
        return pontos;
    }

    // Função para sortear um número com base no nível de dificuldade
    public static int sortearNumero(Random random, int nivel) {
        int numeroSorteado = 0;
        if (nivel == 1) { // Nível fácil (1 a 10)
            numeroSorteado = random.nextInt(10) + 1;
        } else if (nivel == 2) { // Nível médio (1 a 50)
            numeroSorteado = random.nextInt(50) + 1;
        }
        return numeroSorteado;
    }

    // Função para perguntar ao usuário se deseja continuar jogando ou sair
    public static boolean perguntarProximoPasso(Scanner scanner) {
        System.out.println("Deseja continuar?");
        System.out.println("1. Continuar jogando");
        System.out.println("2. Sair");
        int opcao = scanner.nextInt();

        while (opcao < 1 || opcao > 2) {
            System.out.println("Opção inválida. Tente novamente.");
            opcao = scanner.nextInt();
        }

        if (opcao == 1) {
            return true;  // Continuar jogando
        } else {
            return false;  // Sair do jogo
        }
    }
}
