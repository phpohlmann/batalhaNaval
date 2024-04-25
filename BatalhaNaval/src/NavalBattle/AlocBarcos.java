package NavalBattle;
import java.util.Scanner;

import static NavalBattle.BatalhaNaval.*;
import static NavalBattle.ValidarPosicao.validarPosicoes;

public class AlocBarcos {

  public static void barcoMetodo(Scanner ler, String[][] tabuleiroJogador1, int tamanhoDoBarco, String nomeDoBarco, char modoAlocacao) {
    for (int a = 0; a < 5 - tamanhoDoBarco; a++) {
      if (modoAlocacao == 'M') {
        System.out.println("Barco sendo posicionado no momento: " + nomeDoBarco + " (" + tamanhoDoBarco + " Posições)");
        System.out.println("Agora você deve selecionar a orientação do barco, na Vertical (V) ou na Horizontal (H)");
        char orientacao;
        do {
          receberOrientacao(orientacao = ler.next().charAt(0), modoAlocacao);
        } while (orientacao != 'V' && orientacao != 'H');

        if (orientacao == 'V') {
          int[] coordenadas = pedirCoordenadas(ler, tamanhoDoBarco, 'V', 'M');
          int l = coordenadas[0];
          int c = coordenadas[1];
          validarPosicoes(l, c, tamanhoDoBarco, 'V', tabuleiroJogador1, ler);
          mostrarTabuleiro(tabuleiroJogador1);
        }

        if (orientacao == 'H') {
          int[] coordenadas = pedirCoordenadas(ler, tamanhoDoBarco, 'H', 'M');
          int l = coordenadas[0];
          int c = coordenadas[1];
          validarPosicoes(l, c, tamanhoDoBarco, 'H', tabuleiroJogador1, ler);
        }
      }
    }
  }
}
