import java.util.Scanner;

public class BatalhaNaval {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    char modo;
    char dificuldade;
    char modoAlocacao;
    char orientacao;

    String[][] tabuleiroJogador1 = new String[10][10];
    String[][] tabuleiroJogador2 = new String[10][10];
    String[][] mapaJogador1 = new String[10][10];
    String[][] mapaJogador2 = new String[10][10];

    int[] barcos = {4, 3, 2, 1};

    inicializarTabuleiro(tabuleiroJogador2, " ");
    inicializarTabuleiro(mapaJogador1, "?");
    inicializarTabuleiro(mapaJogador2, "?");

    System.out.println("Bem vindo à Batalha Naval!\nSelecione seu modo de jogo: ");
    System.out.println("M - Multijogador \t\t S - SinglePlayer");

    do {
      modo = ler.next().charAt(0);
      switch (modo) {
        case 'M':
          System.out.println("Multiplayer");
          break;
        case 'S':
          System.out.println("Você selecionou o modo SinglePlayer");
          System.out.println("Selecione a dificuldade: ");
          System.out.println("F - Fácil \t\t N - Normal");
          do {
            dificuldade = ler.next().charAt(0);
            switch (dificuldade) {
              case 'F':
                System.out.println("Você selecionou o modo fácil");
                System.out.println("Selecione o modo de alocação:");
                System.out.println("M - Manual \t\t A - Automático");
                do {
                  modoAlocacao = ler.next().charAt(0);
                  switch (modoAlocacao) {
                    case 'M':
                      System.out.println("Você selecionou o modo manual");

                      break;
                    case 'A':
                      System.out.println("Vocé selecionou o modo automático");
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
                      barco4Posicoes(ler, tabuleiroJogador1);
//                      barco3Posicoes(ler);
//                      barco2Posicoes(ler);
//                      barco1Posicoes(ler);
                      break;
                    case 'A':
                      System.out.println("Você selecionou o modo automático");
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

  public static void receberOrientacao(char orientacao) {
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

  public static void barco4Posicoes(Scanner ler, String[][] tabuleiroJogador1) {
    for (int a = 0; a < 4; a++) {
      System.out.println("Agora você deve selecionar a orientação do barco, na Vertical (V) ou na Horizontal (H)");
      char orientacao;
      do {
        receberOrientacao(orientacao = ler.next().charAt(0));
      } while (orientacao != 'V' && orientacao != 'H');

      if (orientacao == 'V') {
        int[] coordenadas = pedirCoordenadas(ler, 4, 'V');
        int l = coordenadas[0];
        int c = coordenadas[1];

        validarPosicoes(l, c, 4, 'V', tabuleiroJogador1, ler);
        mostrarTabuleiro(tabuleiroJogador1);

      }

      if (orientacao == 'H') {
        int[] coordenadas = pedirCoordenadas(ler, 4, 'H');
        int l = coordenadas[0];
        int c = coordenadas[1];
        validarPosicoes(l, c, 4, 'H', tabuleiroJogador1, ler);
        mostrarTabuleiro(tabuleiroJogador1);

      }
    }
  }

  public static void barco3Posicoes(Scanner ler) {
    System.out.println("Agora você deve selecionar novamente a orientação do barco, na Vertical (V) ou na Horizontal (H)");
    char orientacao;
    do {
      receberOrientacao(orientacao = ler.next().charAt(0));
    } while (orientacao != 'V' && orientacao != 'H');
  }

  public static void barco2Posicoes(Scanner ler) {
    System.out.println("Agora você deve selecionar novamente a orientação do barco, na Vertical (V) ou na Horizontal (H)");
    char orientacao;
    do {
      receberOrientacao(orientacao = ler.next().charAt(0));
    } while (orientacao != 'V' && orientacao != 'H');
  }

  public static void barco1Posicoes(Scanner ler) {
    System.out.println("Agora você deve selecionar novamente a orientação do barco, na Vertical (V) ou na Horizontal (H)");
    char orientacao;
    do {
      receberOrientacao(orientacao = ler.next().charAt(0));
    } while (orientacao != 'V' && orientacao != 'H');
  }


  public static int[] pedirCoordenadas(Scanner ler, int barcoTamanho, char orientacao) {
//    System.out.println("Olá");
    int[] coordenadas = new int[2];
    int limiteMapa = 10 - barcoTamanho;
    int linha = 0, coluna = 0;

    int limiteLinha;
    if (orientacao == 'V') {
      limiteLinha = limiteMapa;
    } else {
      limiteLinha = 9;
    }

    int limiteColuna;
    if (orientacao == 'H') {
      limiteColuna = limiteMapa;
    } else {
      limiteColuna = 9;
    }

    System.out.println("Limite de coordenadas para esse barco (0 - " + limiteMapa + orientacao + "), (0 - 9): ");

    // Pedir a entrada da linha
    System.out.println("Digite a linha (l, 0 - " + limiteLinha + "): ");
    do {
      if (linha < 0 || linha > limiteLinha) {
        System.out.println("Linha inválida, tente novamente: ");
      }
      linha = ler.nextInt();
    } while (linha < 0 || linha > limiteLinha);

    // Pedir a entrada da coluna
    System.out.println("Digite a coluna (c, 0 - " + limiteColuna + "): ");
    do {
      if (coluna < 0 || coluna > limiteColuna) {
        System.out.println("Coluna inválida, tente novamente: ");
      }
      coluna = ler.nextInt();
    } while (coluna < 0 || coluna > limiteColuna);

    coordenadas[0] = linha;
    coordenadas[1] = coluna;
    return coordenadas;
  }


  public static void validarPosicoes(int l, int c, int barcoTamanho, char orientacao, String[][] tabuleiroJogador1, Scanner ler) {
    boolean posicaoValida = true;

    if (orientacao == 'V') {
      for (int i = 0; i < barcoTamanho; i++) {
        if (tabuleiroJogador1[l + i][c].equals("X") || tabuleiroJogador1[l + i][c].equals("0")) {
          System.out.println("Posição inválida, por favor insira novas coordenadas para esta parte do barco:");
          posicaoValida = false;
          break; // Sair do loop assim que uma posição inválida for encontrada
        }
      }

      if (!posicaoValida) {
        int[] novasCoordenadas = pedirCoordenadas(ler, barcoTamanho, 'V');
        l = novasCoordenadas[0];
        c = novasCoordenadas[1];
        validarPosicoes(l, c, barcoTamanho, orientacao, tabuleiroJogador1, ler);
      } else {
        int zeroSuperior = l - 1;
        int zeroInferior = l + barcoTamanho;

        for (int i = 0; i < barcoTamanho; i++) {
          tabuleiroJogador1[l + i][c] = "X";
        }
        if (c - 1 != -1) {
          for (int i = 0; i < barcoTamanho; i++) {
            tabuleiroJogador1[l + i][c - 1] = "0";
          }
        }
        if (c + 1 != 10) {
          for (int i = 0; i < barcoTamanho; i++) {
            tabuleiroJogador1[l + i][c + 1] = "0";
          }
        }
        if (zeroSuperior != -1) {
          tabuleiroJogador1[zeroSuperior][c] = "0";
        }
        if (zeroInferior != 10) {
          tabuleiroJogador1[zeroInferior][c] = "0";
        }
      }
    } else {
      for (int i = 0; i < barcoTamanho; i++) {
        if (tabuleiroJogador1[l][c + i].equals("X") || tabuleiroJogador1[l][c + i].equals("0")) {
          System.out.println("Posição inválida, por favor insira novas coordenadas para esta parte do barco:");
          posicaoValida = false;
          break;
        }
      }

      if (!posicaoValida) {
        int[] novasCoordenadas = pedirCoordenadas(ler, barcoTamanho, 'H');
        l = novasCoordenadas[0];
        c = novasCoordenadas[1];
        validarPosicoes(l, c, barcoTamanho, orientacao, tabuleiroJogador1, ler);
      } else {
        int zeroEsquerda = c - 1;
        int zeroDireita = c + barcoTamanho;

        for (int i = 0; i < barcoTamanho; i++) {
          tabuleiroJogador1[l][c + i] = "X";
        }
        if (l - 1 != -1) {
          for (int i = 0; i < barcoTamanho; i++) {
            tabuleiroJogador1[l - 1][c + i] = "0";
          }
        }
        if (l + 1 != 10) {
          for (int i = 0; i < barcoTamanho; i++) {
            tabuleiroJogador1[l + 1][c + i] = "0";
          }
        }
        if (zeroEsquerda != -1) {
          tabuleiroJogador1[l][zeroEsquerda] = "0";
        }
        if (zeroDireita != 10) {
          tabuleiroJogador1[l][zeroDireita] = "0";
        }
      }
    }
  }


}
