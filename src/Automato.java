import java.util.Scanner;

public class Automato {

    private static char ultimoCaractereValido;
    private static int[] contagem;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cadeia;

        while (true) {
            System.out.println("Insira a cadeia e aperte 'Enter' (ou digite 'x' para encerrar): \n");

            cadeia = scanner.nextLine();

            if(cadeia.equals("x")) break;

            if(computarCadeia(cadeia)) {
                System.out.println("Cadeia aceita!\n");
            }
            else {
                System.out.println("Cadeia rejeitada!\n");
            }
        }

        scanner.close();
    }

    private static boolean computarCadeia(String cadeia){
        if(cadeia.length() == 0) {
            return true;
        }

        ultimoCaractereValido = 'a';
        contagem = new int[3];

        for(int i =0; i < cadeia.length(); i++) {
            char caractere = cadeia.charAt(i);

            if(!caractereValido(caractere)) {
                return false;
            }

            contagem[caractere - 'a']++;
        }

        return (contagem[0] == contagem[1]) || ((contagem[0] == contagem[2]));
    }

    private static boolean caractereValido(char caractere) {
        if((caractere == 'a' || caractere == 'b' || caractere == 'c') &&
                caractere >= ultimoCaractereValido) {

            ultimoCaractereValido = caractere;
            return true;
        }

        return false;
    }



}