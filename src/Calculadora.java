import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean bucle = true;

        while(bucle){

            System.out.println("\n-----------------------------");
            System.out.println("-        CALCULADORA        -");
            System.out.println("-----------------------------");
            System.out.println("-  1. Suma                  -");
            System.out.println("-  2. Resta                 -");
            System.out.println("-  3. Multiplicación        -");
            System.out.println("-  4. División              -");
            System.out.println("-  5. Salir                 -");
            System.out.println("-----------------------------");
            System.out.println("Seleccione opción: ");
            int opt = sc.nextInt();

            // Bucle opción no valida, hasta que sea válida
            while(opt < 1 || opt > 5){
                System.out.println("\n¡¡Opción no valida!!");
                System.out.println("Seleccione opción de nuevo: ");
                opt = sc.nextInt();
            }
            double n1 = 0, n2=0;
            if(opt<5){
                System.out.println("\nNúmero 1: ");
                n1 = sc.nextDouble();
                System.out.println("Número 2: ");
                n2 = sc.nextDouble();
            }

            switch(opt){
                case 1:
                    System.out.println("\nResultado: " + suma(n1, n2) +"\n\n");
                    break;
                case 2:
                    System.out.println("\nResultado: " + resta(n1, n2) +"\n\n");
                    break;
                case 3:
                    System.out.println("\nResultado: " + multiplica(n1, n2) +"\n\n");
                    break;
                case 4:
                    System.out.println("\nResultado: " + divide(n1, n2) +"\n\n");
                    break;
                case 5:
                    bucle = false;
                    break;
            }
        }
        sc.close();

    }



    // Método para realizar una Suma
    public static double suma(double n1, double n2) {
        return n1 + n2;
    }

    // Método para realizar una Resta
    public static double resta(double n1, double n2) {
        return n1 - n2;
    }

    // Método para realizar una Multiplicación
    public static double multiplica(double n1, double n2) {
        return n1 * n2;
    }

    // Método para realizar una División
    public static double divide(double n1, double n2) {
        if (n2 != 0) {
            return n1 / n2;
        } else {
            throw new ArithmeticException("No es válida la división entre 0");
        }
    }


}
