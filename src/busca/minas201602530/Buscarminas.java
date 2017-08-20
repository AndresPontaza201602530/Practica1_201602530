
package busca.minas201602530;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Andres201602530
 */
public class Buscarminas {
    


    public static char[][] matriz = new char[17][31];
    public static char[][] matriz2 = new char[17][31];
    public static int filas = 0;
    public static int columnas = 0;
    public static int minas = 0;
    public static int fi1 = 0;
    public static int fi2 = 0;
    public static int win = 0;
    public static boolean fipartida = false;
    public static boolean debug = false;
    public static int count = 0;
    public static boolean fi = false;

   

        public static void Menu() throws IOException {        
        System.out.println("");
        System.out.println("");
        System.out.println("");    
        System.out.println("                        ANDRES EDUARDO PONTAZA MURALLES");
        System.out.println("                                  201602530");
        System.out.println("                              IPC1 A PRACTICA 1 ");
        System.out.println("                                  BUSCAMINAS!");
        System.out.println("                                       ,--.!");
        System.out.println("                                     _/   -*-");
        System.out.println("                                   ,d08b. '|`");
        System.out.println("                                   0088MM  ");
        System.out.println("                                   `9MMP'");
        System.in.read();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(""); //Presentacion inicial    
        
        Scanner sc = new Scanner(System.in);
        System.out.println("**********************************************************************");
        System.out.println("                             BUSCAMINAS                                ");
        System.out.println("**********************************************************************");
        System.out.println(                               "Menu:");
        System.out.println("                1. Jugar Modo Principiante");
        System.out.println("                2. Jugar Modo Intermedio");
        System.out.println("                3. Jugar Modo Experto");
        System.out.println("                4. Salir");
        System.out.println("");
        System.out.print("  Selecciona una opción [1-4]: ");
        int opcion = sc.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                filas = 5;
                columnas = 5;
                minas = 4;
                win = (4 * 4) - 4;
                break;
            case 2:
                filas = 7;
                columnas = 7;
                minas = 8;
                win = (6 * 6) - 8;
                break;
            case 3:
                filas = 9;
                columnas = 9;
                minas = 12;
                win = (8 * 8) - 12;
                break;
            case 4:
                fi = true;
                System.exit(0);
                break;
            default:
                System.out.println("Introduce una opción valida!!");
                System.exit(0);
                break;
        }
    }
        public static void imprTablero(int length, int length0, char[][] matriz) {
        System.out.println("                            Matriz de juego ⊙▂⊙");
        for (int i = 1; i < length; i++) {
            if (i == 1) {
                System.out.println("**********************************************************************");
            }
            System.out.printf("%4s", i + " ");
            for (int j = 1; j < length0; j++) {
                System.out.printf("%s", "|" + matriz[i][j] + "|");
            }
            if (i == length - 1) {
                System.out.println("");
                for (int j = 1; j < columnas; j++) {
                    if (j == 1) {
                        System.out.print("    ");
                    }
                    System.out.printf("%3s", j + " ");
                }
            }
            System.out.println("");
        }
        
    }
 public static int randNumero(int sup) {
        Random rnd = new Random();
        int num = (int) (Math.random() * sup);
        return num;
    }

    
    public static void iniciaTablero() {
        for (int l = 1; l < filas; l++) {
            for (int m = 1; m < columnas; m++) {
                matriz2[l][m] = 'X';
            }
        }
        for (int l = 1; l < filas; l++) {
            for (int m = 1; m < columnas; m++) {
                matriz[l][m] = 'X';
            }
        }
    }

public static void intrMinas() {
        boolean full = false;
        int i = 0;
        out:
        while (i <= minas) {
            for (int j = 1; j < filas; j++) {
                for (int k = 1; k < columnas; k++) {
                    int mina = randNumero(columnas);
                    if ((k == mina) && (matriz[j][k] == 'X') && (j != fi1 && k != fi2)) {
                        matriz[j][k] = '*';
                        ++i;
                        if (i == minas) {
                            break out;
                        }
                    }
                }
            }
        }
    }

 public static void checkMinas() {
        int count = 0;
        for (int n = 2; n <= matriz.length - 2; ++n) {
            for (int o = 2; o <= matriz[0].length - 2; ++o) {
                count = 0;
                if ((matriz[n + 1][o + 1] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n - 1][o - 1] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n - 1][o + 1] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n + 1][o - 1] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n - 1][o] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n + 1][o] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n][o + 1] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if ((matriz[n][o - 1] == '*') && (matriz[n][o] == 'X')) {
                    ++count;
                }
                if (matriz[n][o] == 'X') {
                    if (count > 0) {
                        matriz[n][o] = Integer.toString(count).charAt(0);
                    } else if (count == 0) {
                        matriz[n][o] = Integer.toString(count).charAt(0);
                    }
                }
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == 'X') {
                    matriz[i][j] = Integer.toString(0).charAt(0);
                }
            }
        }
    }

 public static void introMovim() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("Introduce tu movimiento!");
            System.out.print("Introduce la fila ");
            fi1 = sc.nextInt();
            System.out.print("Introduce la columna ");
            fi2 = sc.nextInt();
            System.out.println("");
            valid = (fi1 < filas && fi2 < columnas) && (fi1 > 0 && fi2 > 0);
        }
    }
 public static void Destapa(int casilla, int casilla2) {
        int casillorg = fi1;
        int casill2org = fi2;
        if (casilla > filas - 1 || casilla < 0 || casilla2 > columnas - 1 || casilla2 < 0) {
            return;
        }
        if (matriz[casillorg][casill2org] == '*') {
            fipartida = true;
        
       
        System.out.println("                             _.-^^---....,,--");
        System.out.println("                         _--                  --_");
        System.out.println("                       <          BOOM!!!        >)");
        System.out.println("                       |        GAMEOVER!!!       |");
        System.out.println("                       \\._                   _./");
        System.out.println("                            ```--. . , ; .--'''");
        System.out.println("                                 | |   |");
        System.out.println("                              .-=||  | |=-.");
        System.out.println("                               -=#$%&%$#=-'");
        System.out.println("                                 | ;  :|");
        System.out.println("                          ____.,-#%&$@%#&#~,._____ ");
        System.out.println("");
        } else if (matriz[casilla][casilla2] == '0') {
            if (matriz2[casilla][casilla2] != matriz[casilla][casilla2]) {
                matriz2[casilla][casilla2] = matriz[casilla][casilla2];
                ++count;
                Destapa(casilla + 1, casilla2);
                Destapa(casilla, casilla2 + 1);
                Destapa(casilla + 1, casilla2 + 1);
            }
            if (casilla > filas - 1 || casilla < 0 || casilla2 > columnas - 1 || casilla2 < 0) {
                Destapa(casilla, casilla2 - 1);
                Destapa(casilla - 1, casilla2);
                Destapa(casilla - 1, casilla2 - 1);
                Destapa(casilla - 1, casilla2 + 1);
                Destapa(casilla + 1, casilla2 - 1);
            }
        } else if ((matriz[casilla][casilla2] > '0')) {
            if (matriz2[casilla][casilla2] != matriz[casilla][casilla2]) {
                matriz2[casilla][casilla2] = matriz[casilla][casilla2];
                ++count;
            }
        }
        if (count == win) {
            System.out.println("Has ganado!!!");
            fipartida = true;
        }
    }

  
public static void main(String[] args) throws IOException {
        
        while (!fi) {
            count = 0;
            fipartida = false;
            Menu();
            iniciaTablero();
            System.out.println("**********************************************************************");
            imprTablero(filas, columnas, matriz2);
            System.out.println("**********************************************************************");
            System.out.println("");
            System.out.println("                               OPCON:");
            System.out.println("                            Voltear: V");
            System.out.println("                            Reiniar: R");
            System.out.println("                             Salir:  S");
            Scanner teclado = new Scanner (System.in);
            System.out.println("Ingresar opcoión: ");
            char opcion2 = teclado.next().charAt(0); 
            switch (opcion2) {
 
        case 'V':
        introMovim();
            intrMinas();
            checkMinas();
            Destapa(fi1, fi2);
            while (!fipartida) {
                if (debug) {
                    imprTablero(filas, columnas, matriz);
                    System.out.println("");
                }
                imprTablero(filas, columnas, matriz2);
                System.out.println("");
                System.out.println("");
                introMovim();
                Destapa(fi1, fi2);
            }
        break;
        case 'v':
        introMovim();
            intrMinas();
            checkMinas();
            Destapa(fi1, fi2);
            while (!fipartida) {
                if (debug) {
                    imprTablero(filas, columnas, matriz);
                    System.out.println("");
                }
                imprTablero(filas, columnas, matriz2);
                System.out.println("");
                System.out.println("");
                introMovim();
                Destapa(fi1, fi2);
            }
        break;
 
        case 'R':
        //Reiniciar
        break;
        case 'r':       
        break;
        
        case 's':
        System.out.println("Gracias por jugar buscaminas!");
        System.exit(0);
        break;
        
        case 'S': 
        System.out.println("Gracias por jugar buscaminas!");
        System.exit(0);
        break;
        
        default:
        System.out.println("Introduce una opción valida!!");
        System.exit(0); 
                            }
            
        }

    }
}

