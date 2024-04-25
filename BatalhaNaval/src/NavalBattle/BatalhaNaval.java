package NavalBattle;
import java.util.Scanner;
import static NavalBattle.AlocBarcos.barcoMetodo;

public class BatalhaNaval {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    char modo;
    char dificuldade;
    char modoAlocacao;
    char orientacao;

    String[][] tabuleiroJogador1 = new String[10][10];

    System.out.println("Bem vindo à Batalha Naval!\nSelecione seu modo de jogo: ");
    System.out.println("M - Multijogador \t\t S - SinglePlayer");

    do {
      modo = ler.next().charAt(0);
      switch (modo) {
        case 'M':
          System.out.println("Você selecionou o modo Multijogador, mas esta parte ainda não foi desenvolvida");
          break;
        case 'S':
          System.out.println("Você selecionou o modo SinglePlayer");
          System.out.println("Selecione a dificuldade: ");
          System.out.println("F - Fácil \t\t N - Normal");
          do {
            dificuldade = ler.next().charAt(0);
            switch (dificuldade) {
              case 'F':
                System.out.println("Você selecionou o modo fácil, os barcos inimigos atirarão de forma randômica");
                System.out.println("Selecione o modo de alocação:");
                System.out.println("M - Manual \t\t A - Automático");
                do {
                  modoAlocacao = ler.next().charAt(0);
                  switch (modoAlocacao) {
                    case 'M':
                      System.out.println("Você selecionou o modo manual");
                      System.out.println("Aqui está seu tabuleiro, onde você irá por seus barcos: ");
                      inicializarTabuleiro(tabuleiroJogador1, "?");
                      mostrarTabuleiro(tabuleiroJogador1);
                      barcoMetodo(ler, tabuleiroJogador1, 4, "Man 'O War", modoAlocacao);
                      barcoMetodo(ler, tabuleiroJogador1, 3, "Galeão", modoAlocacao);
                      barcoMetodo(ler, tabuleiroJogador1, 2, "Bergantim", modoAlocacao);
                      barcoMetodo(ler, tabuleiroJogador1, 1, "Chalupa", modoAlocacao);
                      break;
                    case 'A':
                      System.out.println("Você selecionou o modo Automático, mas esta parte ainda não foi desenvolvida.");
                      break;
                    default:
                      System.out.println("Digite um valor válido. (M, A)");
                  }
                } while (modoAlocacao != 'M' && modoAlocacao != 'A');
                break;
              case 'N':
                System.out.println("Você selecionou o modo normal");
                System.out.println("Selecione o modo de alocação:");
                System.out.println("M - Manual \t\t A - Automático");
                do {
                  modoAlocacao = ler.next().charAt(0);
                  switch (modoAlocacao) {
                    case 'M':
                      System.out.println("Você selecionou o modo manual");
                      System.out.println("Aqui está seu tabuleiro, onde você irá por seus barcos: ");
                      inicializarTabuleiro(tabuleiroJogador1, "?");
                      mostrarTabuleiro(tabuleiroJogador1);
                      barcoMetodo(ler, tabuleiroJogador1, 4, "Man 'O War", modoAlocacao);
                      barcoMetodo(ler, tabuleiroJogador1, 3, "Galeão", modoAlocacao);
                      barcoMetodo(ler, tabuleiroJogador1, 2, "Bergantim", modoAlocacao);
                      barcoMetodo(ler, tabuleiroJogador1, 1, "Chalupa", modoAlocacao);
                      break;
                    case 'A':
                      System.out.println("Você selecionou o modo Automático, mas esta parte ainda não foi desenvolvida.");
                      break;
                    default:
                      System.out.println("Digite um valor válido. (M, A)");
                  }
                } while (modoAlocacao != 'M' && modoAlocacao != 'A');
                break;
              default:
                System.out.println("Digite um valor válido. (F, N)");
            }
          } while (dificuldade != 'F' && dificuldade != 'N');
          break;
        default:
          System.out.println("Digite um valor válido. (M, S)");
      }
    } while (modo != 'M' && modo != 'S');
  }

  public static void inicializarTabuleiro(String[][] tabuleiro, String valorInicial) {
    for (int l = 0; l < tabuleiro.length; l++) {
      for (int c = 0; c < tabuleiro[l].length; c++) {
        tabuleiro[l][c] = valorInicial;
      }
    }
  }

  public static void mostrarTabuleiro(String[][] tabuleiro) {
    for (int l = 0; l < tabuleiro.length; l++) {
      for (int c = 0; c < tabuleiro[l].length; c++) {
        System.out.print(tabuleiro[l][c] + " ");
      }
      System.out.println();
    }
  }

  public static void receberOrientacao(char orientacao, char modoAlocacao) {
    if (modoAlocacao == 'M') {
      switch (orientacao) {
        case 'V':
          System.out.println("Seu barco está na orientação Vertical.");
          break;
        case 'H':
          System.out.println("H - Horizontal");
          break;
        default:
          System.out.println("Digite um valor válido. (V, H)");
      }
    }
  }

  public static int[] pedirCoordenadas(Scanner ler, int barcoTamanho, char orientacao, char modoAlocacao) {
    int[] coordenadas = new int[2];
    int limiteMapa = 10 - barcoTamanho;
    int linha = 0, coluna = 0;
    int limiteLinha;
    int limiteColuna;

    if (orientacao == 'V') {
      limiteLinha = limiteMapa;
    } else {
      limiteLinha = 9;
    }

    if (orientacao == 'H') {
      limiteColuna = limiteMapa;
    } else {
      limiteColuna = 9;
    }

    System.out.println("Limite de coordenadas para esse barco (0 - " + limiteMapa + orientacao + "), (0 - 9): ");

    if (modoAlocacao == 'M') {

      System.out.println("Digite a linha (l, 0 - " + limiteLinha + "): ");
      do {
        if (linha < 0 || linha > limiteLinha) {
          System.out.println("Linha inválida, tente novamente: ");
        }
        linha = ler.nextInt();
      } while (linha < 0 || linha > limiteLinha);

      System.out.println("Digite a coluna (c, 0 - " + limiteColuna + "): ");
      do {
        if (coluna < 0 || coluna > limiteColuna) {
          System.out.println("Coluna inválida, tente novamente: ");
        }
        coluna = ler.nextInt();
      } while (coluna < 0 || coluna > limiteColuna);
    }

    coordenadas[0] = linha;
    coordenadas[1] = coluna;
    return coordenadas;
  }
}
