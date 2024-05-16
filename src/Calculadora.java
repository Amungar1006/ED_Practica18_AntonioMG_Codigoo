
public class Calculadora {

    private double ans;

    public double getAns() {
        return ans;
    }


    // Constructor
    public Calculadora() {
        ans = 0.0;  // memoria resultado anterior
    }



    // Método para realizar una Suma de dos numeros
    public double suma(double n1, double n2) {
        ans = n1 + n2;
        return ans;
    }

    // Sobrecarga Método suma para realizar una Suma sobre ans
    public double suma(double n1) {
        ans += n1;
        return ans;
    }


    // Método para realizar una Resta de dos numeros
    public double resta(double n1, double n2) {
        ans = n1 - n2;
        return ans;
    }

    // Sobrecarga Método Resta para realizar una Resta sobre ans
    public double resta(double n1) {
        ans -= n1;
        return ans;
    }


    // Método para realizar una Multiplicación de dos numeros
    public double multiplica(double n1, double n2) {
        ans = n1 * n2;
        return ans;
    }

    // Sobrecarga Método multiplica para realizar una Multiplicación sobre ans
    public double multiplica(double n1) {
        ans *= n1;
        return ans;
    }


    // Método para realizar una División de dos numeros
    public double divide(double n1, double n2) {
        if (n2 != 0) {
            ans = n1 / n2;
            return ans;
        } else {
            throw new ArithmeticException("No es válida la división entre 0");
        }
    }

    // Sobrecarga Método divide para realizar una División sobre ans
    public double divide(double n1) {
        if (n1 != 0) {
            ans /= n1;
            return ans;
        } else {
            throw new ArithmeticException("No es válida la división entre 0");
        }
    }


    // Metodo para borrar ans

    public void borrar() {
        ans = 0.0;
    }

}
