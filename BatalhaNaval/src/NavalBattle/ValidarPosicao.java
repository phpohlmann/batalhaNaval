package NavalBattle;
import java.util.Scanner;
import static NavalBattle.BatalhaNaval.pedirCoordenadas;

public class ValidarPosicao {
  public static void validarPosicoes(int l, int c, int barcoTamanho, char orientacao, String[][] tabuleiroJogador1, Scanner ler) {
    boolean posicaoValida = true;

    if (orientacao == 'V') {
      for (int i = 0; i < barcoTamanho; i++) {
        if (tabuleiroJogador1[l + i][c].equals("X") || tabuleiroJogador1[l + i][c].equals("0")) {
          System.out.println("Posição inválida, por favor insira novas coordenadas para esta parte do barco:");
          posicaoValida = false;
          break;
        }
      }

      if (!posicaoValida) {
        int[] novasCoordenadas = pedirCoordenadas(ler, barcoTamanho, 'V', 'M');
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
        int[] novasCoordenadas = pedirCoordenadas(ler, barcoTamanho, 'H', 'M');
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
